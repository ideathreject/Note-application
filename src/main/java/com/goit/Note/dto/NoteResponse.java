package com.goit.Note.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class NoteResponse {
    private Long id;
    private String topic;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime deadLine;
}
