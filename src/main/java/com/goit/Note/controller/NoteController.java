package com.goit.Note.controller;

import com.goit.Note.entity.Note;
import com.goit.Note.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/notes")
public class NoteController {
    private final NoteService noteService;

    @GetMapping
    public List<Note> getAll() {
        return noteService.getAll();
    }
    @PostMapping
    public Note create(@RequestBody Note note){
        return noteService.create(note);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        noteService.delete(id);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Note> getById(@PathVariable Long id){
        Optional<Note> optionalNote = noteService.getById(id);
        if (optionalNote.isPresent()){
            return ResponseEntity.ok(optionalNote.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Note> update(@PathVariable Long id, @RequestBody Note note){
       return ResponseEntity.ok(noteService.update(id, note));
    }
}
