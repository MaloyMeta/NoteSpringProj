package org.project.notespring.note;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class NoteService {
    private final Map<Long, Note> notes = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public List<Note> listAll(){
        return new ArrayList<>(notes.values());
    }

    public Note add(Note note){
        long id = idGenerator.getAndIncrement();
        note.setId(id);
        notes.put(id, note);
        return note;
    }

    public void deleteById(long id){
        if(!notes.containsKey(id)){
            throw new NoSuchElementException("id is invalid: " + notes.get(id));
            }
        notes.remove(id);
        }

    public void update(Note note){
        if(!notes.containsKey(note.getId())){
            throw new NoSuchElementException("id is invalid: " + notes.get(note.getId()));
        }
        Note existingNote = notes.get(note.getId());
        existingNote.setTitle(note.getTitle());
        existingNote.setContent(note.getContent());
    }

    public Note getById(long id){
        Note note = notes.get(id);
        if(note == null){
            throw new NoSuchElementException("id is invalid: " + id);
        }
        return  note;
    }

}


