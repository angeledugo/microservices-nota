package com.microservises.nota.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@Table(name = "notas")
@AllArgsConstructor
@NoArgsConstructor
public class Nota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(name="teacher_id")
    private String teacherId;
    @Column(name="student_id")
    private String studentId;
    private Integer valor;

}
