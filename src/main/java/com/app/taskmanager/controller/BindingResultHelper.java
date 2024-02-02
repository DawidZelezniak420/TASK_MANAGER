package com.app.taskmanager.controller;

import com.app.taskmanager.exception.ErrorInfo;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

import static com.app.taskmanager.controller.FrontControllerConstants.ERROR_INFO_ATTRIBUTE;

class BindingResultHelper {

     public static ModelAndView addErrorsToView(BindingResult bindingResult, ModelAndView modelAndView) {
        if (bindingResult.hasErrors()) {
            List<ErrorInfo> errorInfos = bindingResult.getAllErrors()
                    .stream()
                    .map(ObjectError::getDefaultMessage)
                    .map(ErrorInfo::new)
                    .collect(Collectors.toList());

            return modelAndView.addObject(ERROR_INFO_ATTRIBUTE, errorInfos);
        }
        return null;
    }
}
