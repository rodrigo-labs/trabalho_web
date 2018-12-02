package br.unisul.controlePatrimonio.patrimony;

import br.unisul.controlePatrimonio.departament.Departament;
import br.unisul.controlePatrimonio.transfer.Transfer;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "patrimonies")
public class Patrimony {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String description;

    @Column
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date acquisitionDate;

    @ManyToOne
    @JoinColumn(name = "departament_id")
    private Departament department;

    @Column
    private ConservationState conservationState;

    @Column
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patrimony")
    private List<Transfer> transfers;


    public Patrimony() {
    }

    public Patrimony(String description, Date acquisitionDate, Departament department, ConservationState conservationState, List<Transfer> transfers) {
        this.description = description;
        this.acquisitionDate = acquisitionDate;
        this.department = department;
        this.conservationState = conservationState;
        this.transfers = transfers;
    }

    public Patrimony(Long id, String description, Date acquisitionDate, Departament department, ConservationState conservationState, List<Transfer> transfers) {
        this.id = id;
        this.description = description;
        this.acquisitionDate = acquisitionDate;
        this.department = department;
        this.conservationState = conservationState;
        this.transfers = transfers;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getAcquisitionDate() {
        return acquisitionDate;
    }

    public void setAcquisitionDate(Date acquisitionDate) {
        this.acquisitionDate = acquisitionDate;
    }

    public Departament getDepartment() {
        return department;
    }

    public void setDepartment(Departament department) {
        this.department = department;
    }

    public ConservationState getConservationState() {
        return conservationState;
    }

    public void setConservationState(ConservationState conservationState) {
        this.conservationState = conservationState;
    }

    public List<Transfer> getTransfers() {
        return transfers;
    }

    public void setTransfers(List<Transfer> transfers) {
        this.transfers = transfers;
    }
}
