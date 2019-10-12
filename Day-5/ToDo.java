import java.util.Objects;
import java.time.LocalDate;

public final class ToDo {
    
    String name;
    String description;
    LocalDate dueDate;
    String status;

    ToDo(String name, String description, LocalDate dueDate, String status) {
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDate() {
        return dueDate;
    }

    public String getStatus() {
        return status;
    }
}
