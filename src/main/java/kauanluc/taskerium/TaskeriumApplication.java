package kauanluc.taskerium;

import kauanluc.taskerium.command.*;

public class TaskeriumApplication {
    public static void main(String[] args) throws Exception {
        final String VERSION = "v1.0.0";

        if (args.length < 1 || args.length > 3) {
            System.out.println(
                """
                usage: taskerium <tag> + <args>
                
                These are the TASKERIUM commands:
                
                add              | To add a task to your task list
                update           | To update a task from your task list
                delete           | To delete a task from your task list
                mark-in-progress | To mark a task as in-progress
                mark-done        | To mark a task as done
                list             | To show your task list
                list done        | To show your tasks marked as done
                list todo        | To show your tasks marked as to-do
                list in-progress | To show your tasks marked as in-progress
                -v               | To show project version
                """
            );
        } else {
            String command = args[0];

            label:
            switch(command) {
                case "add":
                    if(args.length != 2) {
                        System.out.println(
                                "The tag 'add' must be only 1 arg\n" +
                                "add <description>"
                        );
                        break;
                    }

                    Add.add(args[1]);
                    break;

                case "update":
                    if(args.length != 3) {
                        System.out.println(
                                "The tag 'update' must be 2 args\n" +
                                "update <task id> <new description>"
                        );
                        break;
                    }

                    Update.update(Integer.valueOf(args[1]), args[2]);
                    break;

                case "delete":
                    if(args.length != 2) {
                        System.out.println(
                                "The tag 'delete' must be only 1 arg\n" +
                                "delete <task id>"
                        );
                        break;
                    }

                    Delete.delete(Integer.valueOf(args[1]));
                    break;

                case "mark-in-progress":
                    if(args.length != 2) {
                        System.out.println(
                                "The tag 'mark-in-progress' must be only 1 arg\n" +
                                "mark-in-progress <task id>"
                        );
                        break;
                    }

                    MarkInProgress.inProgress(Integer.valueOf(args[1]));
                    break;

                case "mark-done":
                    if(args.length != 2) {
                        System.out.println(
                                "The tag 'mark-done' must be only 1 arg\n" +
                                "mark-done <task id>"
                        );
                        break;
                    }

                    MarkDone.done(Integer.valueOf(args[1]));
                    break;

                case "list":
                    if(args.length == 1) {
                        List.list();
                    } else {
                        switch(args[1]) {
                            case "done":
                                List.listDone();
                                break label;
                            case "todo":
                                List.listTodo();
                                break label;
                            case "in-progress":
                                List.listInProgress();
                                break label;
                        }
                    }
                    break;

                case "-v":
                    System.out.println(VERSION);
                    break;

                default:
                    System.out.println("Unknown command: " + command);
            }
        }
    }
}
