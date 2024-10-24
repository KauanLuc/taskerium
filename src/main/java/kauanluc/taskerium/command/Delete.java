package kauanluc.taskerium.command;

import kauanluc.taskerium.mapper.TaskMapper;
import kauanluc.taskerium.model.Task;

import java.io.IOException;
import java.util.List;

public class Delete {
    public static void delete(Integer id) throws IOException {
        List<Task> tasks = TaskMapper.jsonToTaskList();
        boolean notFound = true;

        for (int i = 0; i < tasks.size(); i++) {
            if(tasks.get(i).getId().equals(id)) {
                tasks.remove(i);
                notFound = false;
                break;
            }
        }

        if(!notFound) {
            TaskMapper.writeTasksToJson(tasks);
            System.out.printf("Task with id %d deleted successfully%n", id);
        } else {
            System.out.printf("Task with id %d not found%n", id);
        }
    }
}
