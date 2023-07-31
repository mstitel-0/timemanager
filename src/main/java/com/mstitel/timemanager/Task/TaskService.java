package com.mstitel.timemanager.Task;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public  List<Task> allTasks(){
        return taskRepository.findAll();
    }

    public Optional<Task> singleTask(ObjectId id){
        return taskRepository.findById(id);
    }

    public void updateTask(Task updatedTask) throws Exception {
        Task taskToUpdate = taskRepository.findById(updatedTask.getId()).orElseThrow(()->new Exception("Task is not found"));
        taskToUpdate.setName(updatedTask.getName());
        taskToUpdate.setTimeToComplete(updatedTask.getTimeToComplete());
    }

    public void addTask(Task task){
        taskRepository.save(task);
    }
    public void deleteTask(ObjectId id){
        taskRepository.deleteById(id);
    }
}