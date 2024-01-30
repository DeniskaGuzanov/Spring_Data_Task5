package com.example.Spring_Data_Task5.repository;

import com.example.Spring_Data_Task5.domain.Task;
import com.example.Spring_Data_Task5.domain.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByStatus(TaskStatus status);
}
