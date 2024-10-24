package kauanluc.taskerium.command;

import kauanluc.taskerium.enums.StatusTask;
import kauanluc.taskerium.mapper.TaskMapper;
import kauanluc.taskerium.model.Task;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public class MarkInProgress {
    public static void inProgress(Integer id) throws IOException {
        List<Task> tasks = TaskMapper.jsonToTaskList();
        boolean notFound = true;

        for (Task task : tasks) {
            if(task.getId().equals(id)) {
                task.setStatus(StatusTask.IN_PROGRESS);
                task.setUpdatedAt(LocalDateTime.now());
                notFound = false;
                break;
            }
        }

        if(!notFound) {
            TaskMapper.writeTasksToJson(tasks);
            System.out.printf("Task with id %d marked in progress%n", id);
        } else {
            System.out.printf("Task with id %d not found%n", id);
        }
    }
}
