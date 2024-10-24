package kauanluc.taskerium.enums;

public enum StatusTask {
    TODO("To-do"),
    IN_PROGRESS("In progress"),
    DONE("Done");

    private String status;

    StatusTask(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
