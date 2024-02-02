package com.app.taskmanager.service;

import com.app.taskmanager.model.Task;

import java.util.List;


public interface TaskService {

    Task getTaskById(Long taskId);

    List<Task> getSortedTasks();

    void addTask(Task task);

    void deleteTask(Long taskId);

    void updateTask(Task task, Long taskId);

    long numberOfTasksUserCanAdd();
}
