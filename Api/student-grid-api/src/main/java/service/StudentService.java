
package service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Student;

import repository.StudentRepository;

@Service
public class StudentService {
	@Autowired

	private final StudentRepository studentRepository;

	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public Student createStudent(Student student) {
		if (student.getName() == null || student.getName().isEmpty()) {
			throw new IllegalArgumentException("Student name cannot be empty");
		}
		return studentRepository.save(student);
	}

	public List<Student> getAllStudents() {

		return studentRepository.findAll();
	}

	public Student getStudentById(long id) {
		return studentRepository.findById(id).orElse(null);
	}

	public void updateStudent(Student student) {
		if (student.getId() == 0) {
			throw new IllegalArgumentException("Invalid student ID");
		}
		studentRepository.save(student);
	}

	public void deleteStudent(long id) {
		Optional<Student> studentOptional = studentRepository.findById(id);
		if (studentOptional.isEmpty()) {
			throw new IllegalArgumentException("Student not found");
		}

		Student student = studentOptional.get();
		studentRepository.deleteById(id);
	}


}
