package com.app.taskmanager.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

import static com.app.taskmanager.model.TaskEntityConstants.*;

@Entity
@Data
@AllArgsConstructor
@Builder
public class Task implements Comparable<Task> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;

    @NotBlank(message = TASK_NAME_NOT_BLANK_INFO)
    @Size(min = 3, max = 50, message = TASK_NAME_SIZE_INFO)
    private String taskName;

    @NotEmpty(message = DESCRIPTION_INFO)
    @Size(max = 200, message = DESCRIPTION_SIZE_INFO)
    private String description;

    @Enumerated(EnumType.STRING)
    @NotNull(message = PRIORITY_INFO)
    private Priority priority;

    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private Status status;

    public Task() {
        status = Status.ACTIVE;
    }

    // at first compare tasks by priority , if priorities are the same
    // compare by task name
    @Override
    public int compareTo(Task o) {
        if (this.priority.getPriorityScore() > o.priority.getPriorityScore()) {
            return -1;
        }
        if (this.priority.getPriorityScore() < o.priority.getPriorityScore()) {
            return 1;
        }
        return this.taskName.compareToIgnoreCase(o.taskName);
    }

    @Getter
    public enum Priority {
        LOW(1),
        INTERMEDIATE(2),
        HIGH(3);

        private final int priorityScore;

        Priority(int priorityScore) {
            this.priorityScore = priorityScore;
        }
    }

    public enum Status {
        ACTIVE, FINISHED
    }
}
