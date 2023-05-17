package com.javarush.jira.bugtracking;

import com.javarush.jira.AbstractControllerTest;
import com.javarush.jira.bugtracking.internal.model.Task;
import com.javarush.jira.bugtracking.internal.repository.TaskRepository;
import com.javarush.jira.common.error.NotFoundException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class TaskServiceTest extends AbstractControllerTest {

    @Autowired
    TaskRepository taskRepository;
    @Autowired
    TaskService taskService;

    @Test
    void addTags(){
        Set<String> tags = Set.of("tag1","tag2");
        taskService.addTagsToTask(tags,2L);
        Task task = this.taskRepository.getExisted(2L);
        assertEquals(tags,task.getTags());
    }

    @Test
    void addShortTagAndCatchAnnotationException(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<String> tags = Set.of("1");
        taskService.addTagsToTask(tags,2L);
        Task task = taskRepository.getExisted(2);
        Set<ConstraintViolation<Task>> violations = validator.validate(task);
        assertFalse(violations.isEmpty());

    }

    @Test
    void checkWrongId(){
        Set<String> tags = Set.of("tag1","tag2");
        assertThrows(NotFoundException.class,() -> {taskService.addTagsToTask(tags,1L);});
    }
}