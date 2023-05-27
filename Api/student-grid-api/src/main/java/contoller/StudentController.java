package contoller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Student;

import repository.StudentRepository;
import service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	@Autowired
	private final StudentService ss;
	@Autowired
	private StudentRepository studentRepository;

	public StudentController(StudentService ss) {
		super();
		this.ss = ss;
	}
	
	@GetMapping(value = "/id")
	public ResponseEntity<Student> getStudentById(@PathVariable int id) {
		Student st = ss.getStudentById(id);
		if (st == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(st);
	}

	@PostMapping("")
	public ResponseEntity<Student> createStudent(@RequestBody Student student) {
		if (student.getName() == null || student.getName().isEmpty()) {
			return ResponseEntity.badRequest().build();
		}
		Student createdStudent = ss.createStudent(student);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
	}

	@PutMapping(value = "/id")
	public Student updateStudent(Student student) {
		Student existingStudent = studentRepository.findById(student.getId());
		if (existingStudent == null) {
			return null;
		}

		if (student.getName() == null || student.getName().isEmpty()) {
			return null;
		}

		existingStudent.setName(student.getName());
		existingStudent.setId(student.getId());
		studentRepository.save(existingStudent);
		return existingStudent;
	}




	@DeleteMapping(value = "/id")
	public boolean deleteStudent(long id) {
		Optional<Student> optionalStudent = studentRepository.findById(id);
		if (optionalStudent.isPresent()) {
			studentRepository.deleteById(id);
			return true;
		}
		return false;
	}



}
