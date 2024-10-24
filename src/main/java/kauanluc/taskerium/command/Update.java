package kauanluc.taskerium.command;

import kauanluc.taskerium.mapper.TaskMapper;
import kauanluc.taskerium.model.Task;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public class Update {
    public static void update(Integer id, String description) throws IOException {
        List<Task> tasks = TaskMapper.jsonToTaskList();
        boolean notFound = true;

        for (Task task : tasks) {
            if(task.getId().equals(id)) {
                task.setDescription(description);
                task.setUpdatedAt(LocalDateTime.now());
                notFound = false;
                break;
            }
        }

        if(!notFound) {
            TaskMapper.writeTasksToJson(tasks);
            System.out.printf("Task with id %d updated successfully%n", id);
        } else {
            System.out.printf("Task with id %d not found%n", id);
        }
    }
}
