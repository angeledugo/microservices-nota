package com.microservises.nota.controller;

import com.microservises.nota.dto.NotaDto;
import com.microservises.nota.entities.Nota;
import com.microservises.nota.http.response.NotaResponse;
import com.microservises.nota.service.INotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/nota")
public class NotaController {
    @Autowired
    private INotaService notaService;


    @GetMapping("/all")
    public ResponseEntity<?> listStudent() {
        return ResponseEntity.ok(notaService.findAllData());
    }

    @GetMapping("/search-my-notas/{idStudent}")
    public ResponseEntity<?> findByIdStudent(@PathVariable Long idStudent) {
        return ResponseEntity.ok(notaService.findByIdStudent(idStudent));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(notaService.findById(id));

    }


    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveTeacher(@RequestBody NotaDto notaDto) {
        System.out.println(notaDto);
        notaService.save(notaDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {

        notaService.delete(id);

    }

    @PutMapping("/{id}")
    public Nota update(@PathVariable Long id,@RequestBody Nota nota) {
        System.out.println(nota);
        return notaService.update(nota, id);
    }

}
