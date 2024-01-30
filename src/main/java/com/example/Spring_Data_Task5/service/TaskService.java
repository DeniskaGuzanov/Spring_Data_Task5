package com.example.Spring_Data_Task5.service;


import com.example.Spring_Data_Task5.domain.Task;
import com.example.Spring_Data_Task5.domain.TaskStatus;
import com.example.Spring_Data_Task5.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public List<Task> getAllTasks(){
        return taskRepository.findAll();}

    public Optional<Task> getTaskById(Long id){
        return taskRepository.findById(id);}

    public Task createTask(Task task) {
        return taskRepository.save(task);}

    public Task updateTask(Task taskDetails, Long id){
        Optional<Task> optionalBook = taskRepository.findById(id);
        if (optionalBook.isPresent()){
            Task task = optionalBook.get();
            task.setDescription(taskDetails.getDescription());
            task.setLocalDateTime(taskDetails.getLocalDateTime());

            return taskRepository.save(task);
        }else {
            throw new IllegalArgumentException("Book not found with id: ");
        }
    }

    public void deleteById(Long id){
        taskRepository.deleteById(id);}
}
