package com.microservises.nota.client;

import com.microservises.nota.dto.StudentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "msvc-student", url = "localhost:8090/api/student")
public interface StudentClient {
    @GetMapping("/{id}")
    StudentDto findById(@PathVariable("id") String id);
}
