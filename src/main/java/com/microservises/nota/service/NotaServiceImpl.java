package com.microservises.nota.service;

import com.microservises.nota.client.TeacherClient;
import com.microservises.nota.client.StudentClient;
import com.microservises.nota.dto.NotaDto;
import com.microservises.nota.dto.StudentDto;
import com.microservises.nota.dto.TeacherDto;
import com.microservises.nota.entities.Nota;
import com.microservises.nota.http.response.NotaConNombreReponse;
import com.microservises.nota.http.response.NotaResponse;
import com.microservises.nota.persistence.INotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotaServiceImpl implements INotaService {

    @Autowired
    private INotaRepository notaRepository;

    @Autowired
    private TeacherClient teacherClient;

    @Autowired
    private StudentClient studentClient;

    @Override
    public List<Nota> findAll() {
        return (List<Nota>) notaRepository.findAll();
    }

    @Override
    public NotaResponse findById(Long id) {
        Nota nota = notaRepository.findById(id).orElseThrow();


        return NotaResponse.builder()
                .id(nota.getId())
                .name(nota.getName())
                .valor(nota.getValor())
                .teacher(nota.getTeacherId())
                .student(nota.getStudentId())
                .build();
    }

    @Override
    public void save(NotaDto notaDto) {
        Nota nota = new Nota();
        nota.setName(notaDto.getName());
        nota.setValor(notaDto.getValor());
        nota.setTeacherId(notaDto.getTeacher_id());
        nota.setStudentId(notaDto.getStudent_id());

        notaRepository.save(nota);
    }


    @Override
    public List<Nota> findByIdStudent(Long id) {
        return notaRepository.findAllByIdStudent(id);
    }

    @Override
    public List<NotaConNombreReponse> findAllData() {
        List<Nota> notas = (List<Nota>) notaRepository.findAll();
        List<NotaConNombreReponse> response = new ArrayList<>();


        for (Nota nota : notas) {
            StudentDto student = studentClient.findById(nota.getStudentId());

            TeacherDto teacher = teacherClient.searchMyTeacher(nota.getTeacherId());

            NotaConNombreReponse notaResponse = new NotaConNombreReponse();
            notaResponse.setStudent(student.getName());
            notaResponse.setTeacher(teacher.getName());
            notaResponse.setId(nota.getId());
            notaResponse.setName(nota.getName());
            notaResponse.setValor(nota.getValor());

            response.add(notaResponse);

        }

        return response;
    }

    @Override
    public void delete(Long id) {
        notaRepository.deleteById(id);
    }

    @Override
    public Nota update(Nota nota, Long id) {
        Nota updateNota = notaRepository.findById(id).orElse(new Nota());
        updateNota.setName(nota.getName());
        updateNota.setValor(nota.getValor());
        updateNota.setStudentId(nota.getStudentId());
        updateNota.setTeacherId(nota.getTeacherId());
        return notaRepository.save(updateNota);
    }

}
