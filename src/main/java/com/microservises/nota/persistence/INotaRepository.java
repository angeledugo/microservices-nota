package com.microservises.nota.persistence;

import com.microservises.nota.entities.Nota;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface INotaRepository extends CrudRepository<Nota, Long> {
    @Query("SELECT n FROM Nota n WHERE n.studentId = :id")
    List<Nota> findAllByIdStudent(Long id);

}
