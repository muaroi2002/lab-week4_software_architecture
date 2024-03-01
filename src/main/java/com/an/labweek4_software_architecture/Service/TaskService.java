package com.an.labweek4_software_architecture.Service;

import com.an.labweek4_software_architecture.Repository.TaskRepository;
import com.an.labweek4_software_architecture.entity.Task;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Cacheable("tasks")
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Cacheable(value = "task", key = "#id")
    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @CacheEvict(value = "task", key = "#id")
    public Task updateTask(Long id, Task task) {
        return taskRepository.save(task);
    }

    @CacheEvict(value = "task", key = "#id")
    public void deleteTaskById(Long id) {
        taskRepository.deleteById(id);
    }
}