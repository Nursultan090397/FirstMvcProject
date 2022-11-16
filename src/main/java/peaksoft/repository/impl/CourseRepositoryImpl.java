package peaksoft.repository.impl;

import org.springframework.stereotype.Repository;
import peaksoft.model.Company;
import peaksoft.model.Course;
import peaksoft.repository.CourseRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public class CourseRepositoryImpl implements CourseRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Course> getAllCourses() {
        return entityManager
                .createQuery("select c from Course c", Course.class)
                .getResultList();
    }

    @Override
    public void addCourse(Long id,Course course) {
        Company company = entityManager.find(Company.class,id);
        company.addCourse(course);
        course.setCompany(company);
        entityManager.merge(course);

    }

    @Override
    public Course getCourseById(Long id) {
        return entityManager.find(Course.class,id);
    }

    @Override
    public void updateCourse(Course course, Long id) {
        Course courseN = entityManager.find(Course.class,id);
        courseN.setCourseName(courseN.getCourseName());
        courseN.setDuration(course.getDuration());
        entityManager.merge(courseN);

    }

    @Override
    public void removeCourse(Long id) {
        entityManager.remove(entityManager.find(Course.class,id));

    }
}
