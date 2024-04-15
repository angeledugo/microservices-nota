package com.microservises.nota.http.response;


import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class NotaResponse {

    private Long id;
    private String student;
    private String teacher;
    private String name;
    private Integer valor;
}
