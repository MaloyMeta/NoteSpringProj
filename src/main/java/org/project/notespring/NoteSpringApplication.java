package org.project.notespring;

import org.project.notespring.note.Note;
import org.project.notespring.note.NoteService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NoteSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(NoteSpringApplication.class, args);
		NoteService noteService = new NoteService();
		Note noteFirst = new Note();
		noteFirst.setTitle("Money");
		noteFirst.setContent("Vadik 12000, Dima 15000");

		Note noteSecond = new Note();
		noteSecond.setTitle("Health");
		noteSecond.setContent("Menovazin 15mg, Analgin 10mg");

		noteService.add(noteFirst);
		noteService.add(noteSecond);
		System.out.println(noteService.listAll());

	}

}
