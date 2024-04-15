package com.microservises.nota.client;

import com.microservises.nota.dto.TeacherDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "msvc-teacher", url = "localhost:9090/api/teacher")
public interface TeacherClient {
    @GetMapping("/search-my-teacher/{id}")
    TeacherDto searchMyTeacher(@PathVariable String id);
}
