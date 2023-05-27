package repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.example.model.Student;

public class StudentRepositoryImpl implements StudentRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Student> findByFirstName(String firstName) {
		TypedQuery<Student> query = entityManager.createQuery("SELECT s FROM Student s WHERE s.firstName = :firstName",
				Student.class);
		query.setParameter("firstName", firstName);
		return query.getResultList();
	}

	@Override
	public List<Student> findByLastName(String lastName) {
		TypedQuery<Student> query = entityManager.createQuery("SELECT s FROM Student s WHERE s.lastName = :lastName",
				Student.class);
		query.setParameter("lastName", lastName);
		return query.getResultList();
	}

	@Override
	public List<Student> findByAgeGreaterThan(int age) {
		TypedQuery<Student> query = entityManager.createQuery("SELECT s FROM Student s WHERE s.age > :age",
				Student.class);
		query.setParameter("age", age);
		return query.getResultList();
	}

}
