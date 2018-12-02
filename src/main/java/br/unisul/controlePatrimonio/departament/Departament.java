package br.unisul.controlePatrimonio.departament;

import br.unisul.controlePatrimonio.patrimony.Patrimony;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "departaments")
public class Departament {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department")
    private List<Patrimony> patrimonies;


    public Departament() {
    }

    public Departament(String name, List<Patrimony> patrimonies) {
        this.name = name;
        this.patrimonies = patrimonies;
    }

    public Departament(Long id, String name, List<Patrimony> patrimonies) {
        this.id = id;
        this.name = name;
        this.patrimonies = patrimonies;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Patrimony> getPatrimonies() {
        return patrimonies;
    }

    public void setPatrimonies(List<Patrimony> patrimonies) {
        this.patrimonies = patrimonies;
    }
}
