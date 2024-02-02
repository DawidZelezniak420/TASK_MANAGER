package com.app.taskmanager.repository;

import com.app.taskmanager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    boolean existsByTaskName(String taskName);

}
