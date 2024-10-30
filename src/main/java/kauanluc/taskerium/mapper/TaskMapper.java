package kauanluc.taskerium.mapper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.databind.ObjectMapper;
import kauanluc.taskerium.model.Task;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class TaskMapper {
    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final File FILE = new File("/usr/share/taskerium/taskerium-tasks.json");

    static {
        MAPPER.registerModule(new JavaTimeModule());
    }

    public static void writeTasksToJson(List<Task> tasks) throws IOException {
        MAPPER.writeValue(FILE, tasks);
    }

    public static List<Task> jsonToTaskList() throws IOException {
        return MAPPER.readValue(FILE, new TypeReference<List<Task>>() {});
    }
}

