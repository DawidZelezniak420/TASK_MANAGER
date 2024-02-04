package com.app.taskmanager.service;

import com.app.taskmanager.exception.TaskError;
import com.app.taskmanager.exception.TaskException;
import com.app.taskmanager.model.Task;
import com.app.taskmanager.repository.TaskRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    // here you can change the limit of tasks
    private static final int TASKS_LIMIT = 100;
    private static final int NO_SPACE = 0;

    private final TaskRepository taskRepository;

    public Task getTaskById(Long taskId) {
        return taskRepository.findById(taskId)
                .orElseThrow();
    }

    public List<Task> getSortedTasks() {
        return taskRepository.findAll()
                .stream()
                .sorted()
                .toList();
    }

    @Transactional
    public void addTask(Task task) {
        if (numberOfTasksUserCanAdd() <= NO_SPACE) {
            throw new TaskException(TaskError.TASKS_LIMIT_REACHED);
        }
        if (taskRepository.existsByTaskName(task.getTaskName())) {
            throw new TaskException(TaskError.TASK_ALREADY_EXISTS);
        }
        task.setCreatedAt(LocalDateTime.now());
        taskRepository.save(task);
    }

    @Transactional
    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }

    // check if such task name exists in database before update , then set task parameters
    @Transactional
    public void updateTask(Task task, Long taskId) {
        Task taskFromDb = getTaskById(taskId);
        if (!taskFromDb.getTaskName().equals(task.getTaskName())
                && taskRepository.existsByTaskName(task.getTaskName())) {
            throw new TaskException(TaskError.TASK_ALREADY_EXISTS);
        }
        setTaskParams(taskFromDb, task);
        taskRepository.save(taskFromDb);
    }

    public long numberOfTasksUserCanAdd() {
        return TASKS_LIMIT - taskRepository.count();
    }


    private void setTaskParams(Task taskFromDb, Task task) {
        taskFromDb.setTaskName(task.getTaskName());
        taskFromDb.setDescription(task.getDescription());
        taskFromDb.setPriority(task.getPriority());
        taskFromDb.setStatus(task.getStatus());
    }
}
