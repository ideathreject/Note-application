package com.goit.Note.service;

import com.goit.Note.dto.NoteCreateRequest;
import com.goit.Note.dto.NoteResponse;
import com.goit.Note.entity.Note;

import java.util.List;
import java.util.Optional;

public interface NoteService {
    NoteResponse create(NoteCreateRequest noteCreateRequest);

    Optional<Note> getById(Long id);

    List<Note> getAll();

    void delete(Long id);

    Note update(Long id, Note note);
}
