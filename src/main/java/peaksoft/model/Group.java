package peaksoft.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.LAZY;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "pk_group")
public class Group {
    @Id
    @SequenceGenerator(name = "group_seq",
            sequenceName = "group_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "group_seq")

    private Long id;

    private String groupName;

    private LocalDate dateOfStart;

    private String image;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, REFRESH},fetch = LAZY)
    @JoinTable (name = "courses and groups",
            joinColumns = @JoinColumn (name = "course_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn (name = "group_id", referencedColumnName = "id"))
    private List<Course> courses = new ArrayList<>();
/*
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH,CascadeType.REMOVE}, fetch = LAZY,mappedBy = "group")
    private List<Student> students = new ArrayList<>();*/
}
