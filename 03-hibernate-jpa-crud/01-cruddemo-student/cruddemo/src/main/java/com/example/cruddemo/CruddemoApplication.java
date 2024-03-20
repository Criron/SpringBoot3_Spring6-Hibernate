package com.example.cruddemo;

import com.example.cruddemo.dao.StudentDAO;
import com.example.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

		return runner -> {
			//createStudent(studentDAO);

			createMultipleStudents(studentDAO);

			//readStudent(studentDAO);

			//queryForStudents(studentDAO);

			//queryForStudentsByLastName(studentDAO);

			//updateStudent(studentDAO);

			//deleteStudent(studentDAO);

			//deleteAllStudents(studentDAO);


		};

	}

	private void deleteAllStudents(StudentDAO studentDAO) {

		System.out.println("Deleting all students!");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted rows: " + numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {

		int studentId = 3;
		System.out.println("Deleting student with id: " + studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		// retrieve student based on id
		int studentId=1;
		System.out.println("Getting student with id" +studentId);
		Student myStudent = studentDAO.findById(studentId);

		//	change first name
		System.out.println("Updating student");
		myStudent.setFirstName("Scooby");

		// update
		studentDAO.update(myStudent);

		//	display updated student
		System.out.println("Updated student: " + myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findByLastName("Doe");

		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {

		// get a list of students
		List<Student> theStudents = studentDAO.findAll();

		//display list of students
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}

	}

	private void readStudent(StudentDAO studentDAO) {

		// create a student object
		System.out.println("Creating new student");
		Student tempStudent = new Student("idwja", "iadjwa", "email");

		//save the student
		System.out.println("Saving");
		studentDAO.save(tempStudent);

		//display if of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved student. id: " + theId);

		//retrieve student based on the id
		System.out.println("Retrieving student with id " + theId);
		Student myStudent = studentDAO.findById(theId);

		//display student
		System.out.println("Found the student: " +myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		//create multiple students
		System.out.println("Creating 3 student objects...");
		Student tempStudent1 = new Student("John", "Doe", "john@email.com");
		Student tempStudent2 = new Student("Mary", "Doe", "mary@email.com");
		Student tempStudent3 = new Student("Bodaa", "Doe", "dwa@email.com");

		//save the student objects
		System.out.println("Saving the students...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

		//display id of the saved students
		System.out.println("Saved students. Generated ids " + tempStudent1.getId() + tempStudent2.getId() + tempStudent3.getId());
	}

	private void createStudent(StudentDAO studentDAO) {

		// create the student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Paul", "Doe", "paul@email.com");

		//save the student object
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		//display id of the saved student
		System.out.println("Saved student. Generated id " + tempStudent.getId());

	}
}
