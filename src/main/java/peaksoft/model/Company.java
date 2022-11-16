package peaksoft.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class Company {
    @Id
    @SequenceGenerator(name = "company_seq",
            sequenceName = "company_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "company_seq")

    private Long id;

    private String companyName;

    private String locatedCountry;

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY,mappedBy = "company")
    private List<Course> courses = new ArrayList<>();

    public void addCourse(Course course1){
        if (courses==null){
            courses=new ArrayList<>();
        }
        courses.add(course1);
    }


}
