package kauanluc.taskerium.command;

import kauanluc.taskerium.mapper.TaskMapper;
import kauanluc.taskerium.model.Task;

import java.io.IOException;
import java.util.List;

public class Add {
    public static void add(String description) throws IOException {
        List<Task> tasks = TaskMapper.jsonToTaskList();
        Integer id = tasks.isEmpty() ? 1 : tasks.get(tasks.size() - 1).getId() + 1;

        Task task = new Task(
                description
        );

        task.setId(id);

        tasks.add(task);

        TaskMapper.writeTasksToJson(
                tasks
        );

        System.out.printf("Task '%s' added successfully (ID: %d) %n", task.getDescription(), task.getId());
    }
}
