package org.project.notespring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class NoteSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(NoteSpringApplication.class, args);
		System.out.println(new BCryptPasswordEncoder().encode("jdbcDefault"));

	}

}
