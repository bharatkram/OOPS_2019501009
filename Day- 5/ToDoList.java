import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;

public final class ToDoList {

    /**
     * field to store the tasks to be done.
     */
    private ToDo[] list;

    /**
     * field to know the number of tasks that are stored.
     */
    private int size;

    ToDoList() {
        final int limit = 0;
        list = new ToDo[limit];
        size = 0;
    }

    /**
     * function to add a task that has to be done.
     *
     * @param work the details of the task.
     */
    public void addWork(final ToDo work) {
        list[size++] = work;
    }

    /**
     * function to change the status of a task based on the name given
     * to the given second parameter.
     *
     * @param name the name of the task to be searched for.
     * @param status the new status of the task.
     */
    public void changeStatus(final String name, final String status) {
        for (int i = 0; i < size; i++) {
            if (list[i].getName().equals(name)) {
                list[i].status = status;
                break;
            }
        }
    }

    /**
     * function to remove the task from the list based on the name given.
     *
     * @param name the name of the task that has to be removed.
     */
    public void remove(final String name) {
        for (int i = 0; i < size; i++) {
            if (list[i].getName().equals(name)) {
                for (int j = i; j < size - 1; j++) {
                    list[j] = list[j + 1];
                }
                list[size--] = null;
            }
        }
    }

    /**
     * function to display the tasks present in the list.
     */
    public void displayWorks() {
        for (int i = 0; i < size; i++) {
            System.out.println("Name: " + list[i].getName() + "\nDescription: "
                    + list[i].getDescription() + "\nDue-Date: "
                    + list[i].getDate() + "\nStatus: " + list[i].getStatus()
                    + "\n");
        }
    }

    /**
     * the main function.
     *
     * @param args the arguments for the main function.
     */
    public static void main(final String[] args) {
        ToDoList list = new ToDoList();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        list.addWork(new ToDo("Assignment-1", "String Times",
                    LocalDate.of(2019, Month.OCTOBER, 10), "Finished"));
        list.addWork(new ToDo("Assignment-2", "Front Times",
                    LocalDate.of(2019, Month.OCTOBER, 11), "Finished"));
        list.addWork(new ToDo("Assignment-3", "Squares",
                    LocalDate.of(2019, Month.OCTOBER, 12), "Not Finished"));
        list.addWork(new ToDo("Assignment-4", "String Handling",
                    LocalDate.of(2019, Month.OCTOBER, 13), "Not Finished"));

        list.remove("Assignment-1");

        list.changeStatus("Assignment-4", "Finished");

        list.displayWorks();
    }
}
