package edu.mum.cs.cs425.studentmgmt;
import edu.mum.cs.cs425.studentmgmt.model.Classroom;
import edu.mum.cs.cs425.studentmgmt.model.Student;
import edu.mum.cs.cs425.studentmgmt.model.Transcript;
import edu.mum.cs.cs425.studentmgmt.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class MyStudentMgmtApp2Application implements CommandLineRunner {

	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(MyStudentMgmtApp2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LocalDate date = LocalDate.of(2019, 5, 24);
		Student student1 = new Student(1,"000-61-0001","Anna", "Lynn","Smith", 3.45, date);
		Transcript transcript1 = new Transcript(1,"BS Computer Science");
		Classroom classroom1 = new Classroom(1, "McLaughlin building", "M105");
		student1.setTranscript(transcript1);
		transcript1.setStudent(student1);
		student1.setClassroom(classroom1);

		classroom1.setStudents(Arrays.asList(student1));

		System.out.println("Saving student object with transcript");
		studentRepository.save(student1);
		System.out.println("Student student object with transcript saved");
	}
}
