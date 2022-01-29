package edu.eci.ieti.TasksRestAPI.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import edu.eci.ieti.TasksRestAPI.data.Task;
import edu.eci.ieti.TasksRestAPI.exception.TaskException;
import edu.eci.ieti.TasksRestAPI.service.TaskService;

@Service
public class TaskServiceHashMap implements TaskService{

    HashMap<String, Task> tasksMap = new HashMap<>();
    private static final AtomicInteger generatedId = new AtomicInteger(0);
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");  
    
    @Override
    public Task create(Task task) throws TaskException {
        for(Task savedTask : tasksMap.values()) {
            if (savedTask.equals(task)){
                throw new TaskException(TaskException.CREATE_TASK_EXCEPTION);
            }
        }
        task.setId(generatedId.incrementAndGet() + "");
        task.setCreated(formatCurrentDateToString());
        tasksMap.put(task.getId(), task);
        
        return task;
    }

    @Override
    public Task findById(String id) throws TaskException {
        Task task = tasksMap.get(id);
        if (task == null) throw new TaskException(TaskException.TASK_DOESNT_EXIST);

        return tasksMap.get(id);
    }

    @Override
    public List<Task> getAll() {

        return new ArrayList<>(tasksMap.values());
    }

    @Override
    public boolean deleteById(String id) {
        int numberOfTasksBeforeOperation = tasksMap.size();
        tasksMap.remove(id);
        return numberOfTasksBeforeOperation != tasksMap.size();
    }

    @Override
    public Task update(Task task, String id) throws TaskException {
        Task updatedTask = null;
        if(tasksMap.containsKey(id)){
            Task unupdatedTask = tasksMap.get(id);
            task.setId(id);
            task.setCreated(unupdatedTask.getCreated());
            tasksMap.put(id, task);
            updatedTask = task;
        } else{throw new TaskException(TaskException.TASK_DOESNT_EXIST);}

        return updatedTask;
    }
    
    private String formatCurrentDateToString(){

        return dtf.format(LocalDateTime.now()).toString();
    }
}
