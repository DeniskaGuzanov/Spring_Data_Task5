package com.example.Spring_Data_Task5.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String description;

    private LocalDateTime localDateTime;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    public Task() {
    }


}

