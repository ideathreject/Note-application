package com.goit.Note.service;

import com.goit.Note.entity.Note;
import com.goit.Note.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class NoteServiceImpl implements NoteService {
    private final NoteRepository noteRepository;
    @Override
    public Note create(Note note){
        return noteRepository.save(note);
    }
    @Override
    public Optional<Note> getById(Long id){
        return noteRepository.findById(id);
    }
    @Override
    public List<Note> getAll(){
        return noteRepository.findAll();
    }
    @Override
    public void delete(Long id){
        noteRepository.deleteById(id);
    }
    @Override
    public Note update(Long id, Note note){
        Optional<Note> optionalNote = noteRepository.findById(id);
        if (optionalNote.isPresent()) {
            Note existingNote = optionalNote.get();
            existingNote.setTopic(existingNote.getTopic());
            existingNote.setDescription(existingNote.getDescription());
            existingNote.setCreatedAt(existingNote.getCreatedAt());
            existingNote.setDeadLine(existingNote.getDeadLine());
            return noteRepository.save(existingNote);
        } else {
            throw new RuntimeException("Cannot find note "+id);
        }
    }
}
