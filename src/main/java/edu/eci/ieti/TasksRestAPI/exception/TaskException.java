package edu.eci.ieti.TasksRestAPI.exception;

public class TaskException extends Exception {

    public static final String CREATE_TASK_EXCEPTION = "The task has already been created.";
    public static final String TASK_DOESNT_EXIST = "The task does not exist.";
    public static final String INVALID_STATUS = "The valid status are: TODO, DOING, REVIEW and DONE ";
    
    public TaskException(String message) {
        super(message);
    }
}
