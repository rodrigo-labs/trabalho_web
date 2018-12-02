package br.unisul.controlePatrimonio.transfer;

import br.unisul.controlePatrimonio.departament.Departament;
import br.unisul.controlePatrimonio.patrimony.Patrimony;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transfers")
public class Transfer {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date transferDate;

    @ManyToOne
    @JoinColumn(name = "patrimony_id")
    private Patrimony patrimony;

    @ManyToOne
    @JoinColumn(name = "departement_initial")
    private Departament departamentInitial;

    @ManyToOne
    @JoinColumn(name = "departement_destination")
    private Departament departamentDestination;


    public Transfer() {
    }

    public Transfer(Date transferDate, Patrimony patrimony, Departament departamentInitial, Departament departamentDestination) {
        this.transferDate = transferDate;
        this.patrimony = patrimony;
        this.departamentInitial = departamentInitial;
        this.departamentDestination = departamentDestination;
    }

    public Transfer(Long id,Date transferDate, Patrimony patrimony, Departament departamentInitial, Departament departamentDestination) {
        this.id = id;
        this.transferDate = transferDate;
        this.patrimony = patrimony;
        this.departamentInitial = departamentInitial;
        this.departamentDestination = departamentDestination;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(Date transferDate) {
        this.transferDate = transferDate;
    }

    public Patrimony getPatrimony() {
        return patrimony;
    }

    public void setPatrimony(Patrimony patrimony) {
        this.patrimony = patrimony;
    }

    public Departament getDepartamentInitial() {
        return departamentInitial;
    }

    public void setDepartamentInitial(Departament departamentInitial) {
        this.departamentInitial = departamentInitial;
    }

    public Departament getDepartamentDestination() {
        return departamentDestination;
    }

    public void setDepartamentDestination(Departament departamentDestination) {
        this.departamentDestination = departamentDestination;
    }
}
