package edu.eci.ieti.TasksRestAPI.service;

import java.util.List;

import edu.eci.ieti.TasksRestAPI.data.Task;
import edu.eci.ieti.TasksRestAPI.exception.TaskException;

public interface TaskService {
    
    Task create( Task task ) throws TaskException;

    Task findById( String id ) throws TaskException;
    
    List<Task> getAll();

    boolean deleteById( String id );

    Task update( Task task, String id ) throws TaskException;
}
