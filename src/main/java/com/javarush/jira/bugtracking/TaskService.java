package com.javarush.jira.bugtracking;

import com.javarush.jira.bugtracking.internal.mapper.TaskMapper;
import com.javarush.jira.bugtracking.internal.model.Task;
import com.javarush.jira.bugtracking.internal.repository.TaskRepository;
import com.javarush.jira.bugtracking.to.TaskTo;
import jakarta.validation.constraints.Size;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Set;

@Service
public class TaskService extends BugtrackingService<Task, TaskTo, TaskRepository> {
    public TaskService(TaskRepository repository, TaskMapper mapper) {
        super(repository, mapper);
    }

    public List<TaskTo> getAll() {
        return mapper.toToList(repository.getAll());
    }

    public void addTagsToTask(Set<@Size(min = 2, max = 32) String> tags, Long id){
        Task task = repository.getExisted(id);
        if (!tags.isEmpty()) {
            task.getTags().addAll(tags);
            repository.save(task);
        }
    }
}
