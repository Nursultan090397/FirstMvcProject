package peaksoft.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class Instructor {
    @Id
    @SequenceGenerator(name = "instructor_seq",
            sequenceName = "instructor_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "instructor_seq")

    private Long id;

    private String firstName;

    private String lastName;

    private int phoneNumber;

    private String email;

    private String specialization;

    /*@ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH},fetch = FetchType.EAGER)
    private Course course;*/

}
