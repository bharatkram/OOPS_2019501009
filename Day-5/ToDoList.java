import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;

public final class ToDoList {

    ToDo[] list;
    int size;

    ToDoList() {
        list = new ToDo[10];
        size = 0;
    }

    public void addWork(ToDo work) {
        list[size++] = work;
    }

    public void changeStatus(String name, String status) {
        for (int i = 0; i < size; i++) {
            if (list[i].getName().equals(name)) {
                list[i].status = status;
                break;
            }
        }
    }

    public void remove(String name) {
        for (int i = 0; i < size; i++) {
            if (list[i].getName().equals(name)) {
                for (int j = i; j < size - 1; j++) {
                    list[j] = list[j+1];
                }
                list[size--] = null;
            }
        }
    }

    public void displayWorks() {
        for (int i = 0; i < size; i++) {
            System.out.println("Name: " + list[i].getName() + "\nDescription: "
                    + list[i].getDescription() + "\nDue-Date: "
                    + list[i].getDate() + "\nStatus: " + list[i].getStatus()
                    + "\n");
        }
    }

    public static void main(String[] args) {
        ToDoList list = new ToDoList();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        list.addWork(new ToDo("Assignment-1", "String Times", LocalDate.of(2019,Month.OCTOBER,10), "Finished"));
        list.addWork(new ToDo("Assignment-2", "Front Times", LocalDate.of(2019,Month.OCTOBER,11), "Finished"));
        list.addWork(new ToDo("Assignment-3", "Squares", LocalDate.of(2019,Month.OCTOBER,12), "Not Finished"));
        list.addWork(new ToDo("Assignment-4", "String Handling", LocalDate.of(2019,Month.OCTOBER,13), "Not Finished"));

        list.remove("Assignment-1");

        list.changeStatus("Assignment-4", "Finished");

        list.displayWorks();
    }
}
