package repository;

import java.util.List;

import com.example.model.Student;

public interface StudentRepositoryCustom {
	List<Student> findByFirstName(String firstName);

	List<Student> findByLastName(String lastName);

	List<Student> findByAgeGreaterThan(int age);
}
