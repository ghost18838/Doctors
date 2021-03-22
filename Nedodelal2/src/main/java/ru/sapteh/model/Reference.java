package ru.sapteh.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reference")
public class Reference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReferences;
    @NonNull
    @Column(name = "Date_of_reference")
    private Date dateOfReferences;
    @Column
    @NonNull
    private String diagnosis;
    @NonNull
    @Column
    private int cost;


    @ManyToOne()
    @JoinColumn(name = "pacients_id")
    private Pacient pacient;

    @Override
    public String toString() {
        return "Reference{" +
                "idreferences=" + idReferences +
                ", dateOfReferences=" + dateOfReferences +
                ", diagnosis='" + diagnosis + '\'' +
                ", cost=" + cost +
                ", pacient=" + pacient +
                '}';
    }
}
