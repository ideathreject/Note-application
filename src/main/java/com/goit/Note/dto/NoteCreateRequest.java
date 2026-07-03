package com.goit.Note.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@NoArgsConstructor
@Getter
@Setter
public class NoteCreateRequest {
    private String topic;
    private String description;
    private LocalDateTime deadLine;
}
