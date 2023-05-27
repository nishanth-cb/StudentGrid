package service;

import java.util.List;

import com.example.model.Student;

public interface StudentServiceImpl {
	List<Student> getAllStudents();

	Student getStudentById(long id);

	Student createStudent(Student student);

	void updateStudent(Student student);

	void deleteStudent(long id);
}
