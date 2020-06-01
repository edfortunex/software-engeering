package edu.mum.cs.cs425.studentmgmt;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.mum.cs.cs425.studentmgmt.model.Classroom;
import edu.mum.cs.cs425.studentmgmt.model.Student;
import edu.mum.cs.cs425.studentmgmt.model.Transcript;
import edu.mum.cs.cs425.studentmgmt.repository.ClassroomRepository;
import edu.mum.cs.cs425.studentmgmt.repository.StudentRepository;
import edu.mum.cs.cs425.studentmgmt.repository.TranscriptRepository;

@SpringBootApplication
public class MyStudentMgmtAppApplication implements CommandLineRunner {

	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private ClassroomRepository classroomRepository;
	@Autowired
	private TranscriptRepository transcriptRepository;

	public static void main(String[] args) {
		SpringApplication.run(MyStudentMgmtAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Transcript t1 = new Transcript(1L, "BS Computer Science");
		Transcript savedT1 = saveTranscript(t1);

		Classroom c1 = new Classroom(1L, "McLaughlin building", "M105");
		Classroom savedC1 = saveClassroom(c1);

		Student s1 = new Student(1L, "000-61-0001", "Anna", "Lynn", "Smith", 3.45, LocalDate.of(2019, 5, 24), t1, c1);
		Student savedS1 = saveStudent(s1);

		System.out.println(savedT1);
		System.out.println(savedC1);
		System.out.println(savedS1);
	}

	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	public Transcript saveTranscript(Transcript transcript) {
		return transcriptRepository.save(transcript);
	}

	public Classroom saveClassroom(Classroom classroom) {
		return classroomRepository.save(classroom);
	}

}
