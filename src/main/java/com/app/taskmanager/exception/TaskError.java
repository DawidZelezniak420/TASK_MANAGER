package com.app.taskmanager.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TaskError {
    TASK_ALREADY_EXISTS("Task with such name already exists!"),
    TASKS_LIMIT_REACHED("Your tasks limit has been reached!");

    private final String errorMessage;

}
