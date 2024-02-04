package com.app.taskmanager;

import com.app.taskmanager.model.Task;
import com.app.taskmanager.repository.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class TaskManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskManagerApplication.class, args);
    }


    //generate sample values
   @Bean
    public CommandLineRunner commandLineRunner(TaskRepository taskRepository) {
        return args ->
        {
            for (int i = 0; i < 99; i++) {
                Task build = Task.builder()
                        .taskName("task " + i)
                        .description("description" + i)
                        .createdAt(LocalDateTime.now())
                        .status(Task.Status.ACTIVE)
                        .priority(i % 2 == 0 ? Task.Priority.LOW : i % 3 == 0 ? Task.Priority.INTERMEDIATE : Task.Priority.HIGH)
                        .build();
                taskRepository.save(build);
            }
        };


    }
}

