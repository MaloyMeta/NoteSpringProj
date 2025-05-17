package org.project.notespring.note;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@RequiredArgsConstructor
@Service
public class NoteService {
    private final NoteRepository noteRepository;

    public List<Note> listAll(){
        return noteRepository.findAll();
    }

    public Note add(Note note){
       return noteRepository.save(note);
    }

    public void deleteById(long id){
            if(noteRepository.existsById(id)){
                noteRepository.deleteById(id);
            }
            else throw new NoSuchElementException("id not found: " + id);
        }

    public void update(Note note){
            noteRepository.save(note);
    }

    public Note getById(long id){
        return noteRepository.findById(id).get();
    }

}


