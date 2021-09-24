package hu.flowacademy.questionsanswers;

import hu.flowacademy.questionsanswers.entities.Student;
import hu.flowacademy.questionsanswers.repositories.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class QuestionsanswersApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuestionsanswersApplication.class, args);
	}

	// Init data loader (CommandLineRunner)
	@Bean
	CommandLineRunner runner(StudentRepository studentRepository) {
		// args: parancssori paraméterek
		return (args) -> {
			Student student1 = Student.builder().firstName("Harry").lastName("Potter").phoneNumber("+36305555555").build();
			Student student2 = Student.builder().firstName("Ron").lastName("Weasley").phoneNumber("+36316666666").build();
			studentRepository.saveAll(List.of(student1, student2));
		};
	}
}
