package kauanluc.taskerium.command;

import kauanluc.taskerium.enums.StatusTask;
import kauanluc.taskerium.mapper.TaskMapper;
import kauanluc.taskerium.model.Task;

import java.io.IOException;

public class List {
    public static void list() throws IOException {
        java.util.List<Task> tasks = TaskMapper.jsonToTaskList();

        if(tasks.isEmpty()) {
            System.out.println(
                    "Your task list is Empty\n" +
                    "run: add <Task to save>, to save your tasks and view them"
            );
        } else {
            System.out.printf("%2S %-20S %4S %12S %20S\n", "id", "description", "status", "created", "updated");
            for (Task task : tasks) {
                System.out.printf(
                        "%2d %-20S %-11S %-20S %12S\n",
                        task.getId(),
                        task.getDescription(),
                        task.getStatus().getStatus(),
                        task.getCreatedAt().toString().substring(0, 16).replace("-", "/").replace("T", "-"),
                        task.getUpdatedAt().toString().substring(0, 16).replace("-", "/").replace("T", "-")
                );
            }
        }
    }

    public static void listDone() throws IOException {
        java.util.List<Task> tasks = TaskMapper.jsonToTaskList();

        if(tasks.isEmpty()) {
            System.out.println(
                    "Your task list is Empty\n" +
                    "run: add <Task to save>, to save your tasks and view them"
            );
        } else {
            System.out.printf("%2S %-20S %4S %12S %20S\n", "id", "description", "status", "created", "updated");
            for(Task task : tasks) {
                if(task.getStatus().equals(StatusTask.DONE)) {
                    System.out.printf(
                            "%2d %-20S %-11S %-20S %12S\n",
                            task.getId(),
                            task.getDescription(),
                            task.getStatus(),
                            task.getCreatedAt().toString().substring(0, 16).replace("-", "/").replace("T", "-"),
                            task.getUpdatedAt().toString().substring(0, 16).replace("-", "/").replace("T", "-")
                    );
                }
            }
        }
    }

    public static void listTodo() throws IOException {
        java.util.List<Task> tasks = TaskMapper.jsonToTaskList();

        if(tasks.isEmpty()) {
            System.out.println(
                    "Your task list is Empty\n" +
                    "run: add <Task to save>, to save your tasks and view them"
            );
        } else {
            System.out.printf("%2S %-20S %4S %12S %20S\n", "id", "description", "status", "created", "updated");
            for(Task task : tasks) {
                if(task.getStatus().equals(StatusTask.TODO)) {
                    System.out.printf(
                            "%2d %-20S %-11S %-20S %12S\n",
                            task.getId(),
                            task.getDescription(),
                            task.getStatus().getStatus(),
                            task.getCreatedAt().toString().substring(0, 16).replace("-", "/").replace("T", "-"),
                            task.getUpdatedAt().toString().substring(0, 16).replace("-", "/").replace("T", "-")
                    );
                }
            }
        }
    }

    public static void listInProgress() throws IOException {
        java.util.List<Task> tasks = TaskMapper.jsonToTaskList();

        if(tasks.isEmpty()) {
            System.out.println(
                    "Your task list is Empty\n" +
                    "run: add <Task to save>, to save your tasks and view them"
            );
        } else {
            System.out.printf("%2S %-20S %4S %12S %20S\n", "id", "description", "status", "created", "updated");
            for(Task task : tasks) {
                if(task.getStatus().equals(StatusTask.IN_PROGRESS)) {
                    System.out.printf(
                            "%2d %-20S %-11S %-20S %12S\n",
                            task.getId(),
                            task.getDescription(),
                            task.getStatus().getStatus(),
                            task.getCreatedAt().toString().substring(0, 16).replace("-", "/").replace("T", "-"),
                            task.getUpdatedAt().toString().substring(0, 16).replace("-", "/").replace("T", "-")
                    );
                }
            }
        }
    }
}
