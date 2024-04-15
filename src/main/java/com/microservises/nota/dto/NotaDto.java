package com.microservises.nota.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotaDto {
    private String name;
    private String teacher_id;
    private String student_id;
    private Integer valor;
}
