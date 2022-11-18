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
public class Course {
    @Id
    @SequenceGenerator(name = "course_seq",
            sequenceName = "course_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "course_seq")

    private Long id;

    private String courseName;

    private int duration;

    private String description;


    @ManyToOne(cascade = {MERGE, CascadeType.DETACH, CascadeType.REFRESH},
            fetch = FetchType.EAGER)
    private Company company;

    /*@ManyToMany(cascade = {PERSIST,MERGE,REFRESH,DETACH}, fetch = FetchType.LAZY,mappedBy = "course")
  private List<Group> groups;

    public void addGroups(Group group){
        if (groups==null){
            groups=new ArrayList<>();
        }
        groups.add(group);
    }*/

/*    @OneToMany(cascade = ALL, fetch = FetchType.LAZY,mappedBy = "course")
    private List<peaksoft.model.Instructor> instructors = new ArrayList<>();*/

  /*  @OneToMany(cascade = ALL, fetch = FetchType.LAZY,mappedBy = "course")
    private List<Lesson> lessons = new ArrayList<>();*/


}
