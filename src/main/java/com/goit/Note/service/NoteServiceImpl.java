package com.goit.Note.service;

import com.goit.Note.dto.NoteCreateRequest;
import com.goit.Note.dto.NoteResponse;
import com.goit.Note.entity.Note;
import com.goit.Note.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class NoteServiceImpl implements NoteService {
    private final NoteRepository noteRepository;

    @Override
    public NoteResponse create(NoteCreateRequest noteCreateRequest){
        Note noteResponse = new Note();
        noteResponse.setDescription(noteCreateRequest.getDescription());
        noteResponse.setTopic(noteCreateRequest.getTopic());
        noteResponse.setDeadLine(noteCreateRequest.getDeadLine());
        noteResponse.setCreatedAt(LocalDateTime.now());
        Note savedNote = noteRepository.save(noteResponse);
        NoteResponse noteResponse1 = new NoteResponse();
        noteResponse1.setId(savedNote.getId());
        noteResponse1.setTopic(savedNote.getTopic());
        noteResponse1.setDescription(savedNote.getDescription());
        noteResponse1.setCreatedAt(savedNote.getCreatedAt());
        noteResponse1.setDeadLine(savedNote.getDeadLine());
        return noteResponse1;
    }

    @Override
    public Optional<Note> getById(Long id) {
        return noteRepository.findById(id);
    }

    @Override
    public List<Note> getAll() {
        return noteRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        noteRepository.deleteById(id);
    }

    @Override
    public Note update(Long id, Note note) {
        Optional<Note> optionalNote = noteRepository.findById(id);
        if (optionalNote.isPresent()) {
            Note existingNote = optionalNote.get();
            existingNote.setTopic(existingNote.getTopic());
            existingNote.setDescription(existingNote.getDescription());
            existingNote.setCreatedAt(existingNote.getCreatedAt());
            existingNote.setDeadLine(existingNote.getDeadLine());
            return noteRepository.save(existingNote);
        } else {
            throw new RuntimeException("Cannot find note " + id);
        }
    }
}
