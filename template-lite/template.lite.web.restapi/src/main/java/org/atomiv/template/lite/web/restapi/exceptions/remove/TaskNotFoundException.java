package org.atomiv.template.lite.web.restapi.exceptions.remove;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Unknown task")
public class TaskNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

//    private long taskId;

//        public TaskNotFoundException(long taskId) {
//        this.taskId = taskId;
//    }

    public TaskNotFoundException(String message) {
        super(message);
    }

    public TaskNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    //    public long getTaskId() {
//        return taskId;
//    }
}