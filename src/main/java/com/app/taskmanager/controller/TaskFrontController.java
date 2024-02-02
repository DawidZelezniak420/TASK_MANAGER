package com.app.taskmanager.controller;

import com.app.taskmanager.exception.ErrorInfo;
import com.app.taskmanager.exception.TaskException;
import com.app.taskmanager.model.Task;
import com.app.taskmanager.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static com.app.taskmanager.controller.FrontControllerConstants.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/To/Do")
class TaskFrontController {

    private final TaskService taskService;

    @GetMapping("/list/tasks/")
    public ModelAndView showTasks() {
        ModelAndView modelAndView = new ModelAndView(TASK_LIST_FORM);
        List<Task> allTasks = taskService.getSortedTasks();
        modelAndView.addObject(TASKS_ATTRIBUTE, allTasks);
        return modelAndView;
    }


    @GetMapping("/add/tasks/form/")
    public ModelAndView addTaskForm() {
        ModelAndView modelAndView = new ModelAndView(ADD_TASK_FORM);
        long tasksNumber = taskService.numberOfTasksUserCanAdd();
        Task task = new Task();
        modelAndView.addObject(TASKS_NUMBER_ATTRIBUTE, tasksNumber);
        modelAndView.addObject(TASK_ATTRIBUTE, task);
        return modelAndView;
    }

    @PostMapping("/save/tasks/")
    public ModelAndView saveTask(@ModelAttribute(TASK_ATTRIBUTE) @Valid Task task, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView(ADD_TASK_FORM);
        addTasksNumberUserCanAddToView(modelAndView);
        ModelAndView errors = BindingResultHelper.addErrorsToView(bindingResult, modelAndView);
        if (errors != null) {
            return errors;
        }
        try {
            taskService.addTask(task);
            modelAndView.addObject(INFO_ATTRIBUTE, INFO_TASK_ADDED);
            addTasksNumberUserCanAddToView(modelAndView);
        } catch (TaskException ex) {
            modelAndView.addObject(ERROR_INFO_ATTRIBUTE, new ErrorInfo(ex.getTaskError().getErrorMessage()));
        }
        return modelAndView;
    }

    private void addTasksNumberUserCanAddToView(ModelAndView modelAndView) {
        modelAndView.addObject(TASKS_NUMBER_ATTRIBUTE, taskService.numberOfTasksUserCanAdd());
    }

    @GetMapping("/update/tasks/form/")
    public ModelAndView showUpdateForm(@RequestParam Long taskId) {
        ModelAndView modelAndView = new ModelAndView(UPDATE_TASK_FORM);
        Task task = taskService.getTaskById(taskId);
        modelAndView.addObject(TASK_ATTRIBUTE, task);
        return modelAndView;
    }

    @PostMapping("/update/tasks/")
    public ModelAndView updateTask(@ModelAttribute(TASK_ATTRIBUTE) @Valid Task task,
                                   BindingResult bindingResult, @RequestParam Long taskId) {
        ModelAndView modelAndView = new ModelAndView(UPDATE_TASK_FORM);
        ModelAndView errors = BindingResultHelper.addErrorsToView(bindingResult, modelAndView);
        if (errors != null) return errors;
        try {
            taskService.updateTask(task, taskId);
            modelAndView.addObject(INFO_ATTRIBUTE, INFO_TASK_UPDATED);
        } catch (TaskException ex) {
            modelAndView.addObject(ERROR_INFO_ATTRIBUTE, new ErrorInfo(ex.getTaskError().getErrorMessage()));
        }
        return modelAndView;
    }

    @GetMapping("/delete/tasks/")
    public String deleteTask(@RequestParam Long taskId) {
        taskService.deleteTask(taskId);
        return REDIRECT_TASK_LIST;
    }

    @GetMapping("/show/tasks/info/")
    public ModelAndView showTaskInfo(@RequestParam Long taskId) {
        ModelAndView modelAndView = new ModelAndView(TASK_INFO_FORM);
        Task taskById = taskService.getTaskById(taskId);
        modelAndView.addObject(TASK_ATTRIBUTE, taskById);
        return modelAndView;
    }

}
