

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
        list.addWork(new ToDo("Assignment-1", "String Times", "10/10/2019", "Finished"));
        list.addWork(new ToDo("Assignment-2", "Front Times", "11/10/2019", "Finished"));
        list.addWork(new ToDo("Assignment-3", "Squares", "12/10/2019", "Not Finished"));
        list.addWork(new ToDo("Assignment-4", "String Handling", "13/10/2019", "Not Finished"));

        list.remove("Assignment-1");

        list.changeStatus("Assignment-4", "Finished");

        list.displayWorks();
    }
}
