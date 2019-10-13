import java.time.LocalDate;

public final class ToDo {

    /**
     * field to store the name of the task.
     */
    private String name;

    /**
     * field to store the description of the task.
     */
    private String description;

    /**
     * field to store the duedate of the task.
     */
    private LocalDate dueDate;

    /**
     * field to store the status of the task.
     */
    private String status;

    ToDo(final String name, final String description, final LocalDate dueDate,
                        final String status) {
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
        this.status = status;
    }

    /**
     * function to get the name of the task.
     *
     * @return the name of the task.
     */
    public String getName() {
        return name;
    }

    /**
     * function to get the description of the task.
     *
     * @return the description of the task.
     */
    public String getDescription() {
        return description;
    }

    /**
     * function to get the due date of the task.
     *
     * @return the duedate of the task.
     */
    public LocalDate getDate() {
        return dueDate;
    }

    /**
     * function to get the status of the task.
     *
     * @return the status of the task.
     */
    public String getStatus() {
        return status;
    }
}
