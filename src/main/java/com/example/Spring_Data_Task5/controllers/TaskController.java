package com.example.Spring_Data_Task5.controllers;
import com.example.Spring_Data_Task5.domain.Task;
import com.example.Spring_Data_Task5.domain.TaskStatus;
import com.example.Spring_Data_Task5.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
public class TaskController {

    private final TaskRepository taskRepository;

    @GetMapping
    public List<Task> getAllTask(){ return taskRepository.findAll(); }

    @PostMapping
    public Task addTask(@RequestBody Task task){
        task.setLocalDateTime(LocalDateTime.now());
        return taskRepository.save(task);
    }

    @GetMapping("/status/{status}")
    public List<Task> getTaskByStatus(@PathVariable TaskStatus status){return taskRepository.findByStatus(status);}

    @PutMapping("/{id}")
    public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task task){
        Task task1 = taskRepository.findById(id).orElse(null);
        if (task1 != null){
            task1.setStatus(task.getStatus());
            return taskRepository.save(task1);
        }else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteTasks(@PathVariable Long id) { taskRepository.deleteById(id);}

}
