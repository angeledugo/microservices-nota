package com.microservises.nota.service;

import com.microservises.nota.dto.NotaDto;
import com.microservises.nota.entities.Nota;
import com.microservises.nota.http.response.NotaConNombreReponse;
import com.microservises.nota.http.response.NotaResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface INotaService {

    List<Nota> findAll();
    NotaResponse findById(Long id);
    void save(NotaDto notaDto);
    List<Nota> findByIdStudent(Long id);
    void delete(Long id);
    Nota update(Nota nota, Long id);
    List<NotaConNombreReponse> findAllData();
}
