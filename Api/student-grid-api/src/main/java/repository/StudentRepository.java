package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	Student findById(int id);

	List<Student> findByFirstName(String firstName);

	List<Student> findByLastName(String lastName);

	List<Student> findByAgeGreaterThan(int age);
}
