package org.project.notespring.note;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/note")
public class NoteController {

    private final NoteService noteService;

    @GetMapping("/list")
    public String listAll(Model model){
        model.addAttribute("notes", noteService.listAll());
        return "note-list";
    }

    @PostMapping("/delete")
    public String deleteById(@RequestParam("id") long id, Model model) throws Exception{
       noteService.deleteById(id);
       return "redirect:/note/list";
    }

    @GetMapping("/edit")
    public String editForm(@RequestParam("id") long id, Model model){
        Note note = noteService.getById(id);
        model.addAttribute("note", note);
        return "note-edit";
    }

    @PostMapping("/edit")
    public String editFormSubmit(@RequestParam("id") long id,
                               @RequestParam("title") String title,
                               @RequestParam("content") String content){
        Note note = noteService.getById(id);
        note.setTitle(title);
        note.setContent(content);
        noteService.update(note);
        return "redirect:/note/list";
    }

    @PostMapping("/add")
    public String add(@RequestParam String title, @RequestParam String content) {
       Note note = new Note();
       note.setTitle(title);
       note.setContent(content);
       noteService.add(note);
        return "redirect:/note/list";
    }
}
