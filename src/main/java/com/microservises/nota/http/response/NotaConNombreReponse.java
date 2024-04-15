package com.microservises.nota.http.response;

import com.microservises.nota.dto.NotaDto;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class NotaConNombreReponse {

    private Long id;
    private String student;
    private String teacher;
    private String name;
    private Integer valor;
}
