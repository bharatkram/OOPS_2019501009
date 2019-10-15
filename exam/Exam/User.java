import java.util.*;

public class User {

    String name;
    User[] connections;
    int number;

    User() {
        name = "testing";
        connections = new User[10];
        number = 0;
    }

    User(String name) {
        this.name = name;
        connections = new User[10];
        number = 0;
    }

    User(String name, User[] connections) {
        this.name = name;
        if (connections == null) {
            this.connections = new User[10];
            number = 0;
        } else {
            number = connections.length;
            this.connections = connections;
        }
    }

    public void setUserName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return name;
    }

    public void setConnections(User user) {
        connections[number++] = user;
    }

    public User[] getConnections() {
        return connections;
    }

    public String toString() {
        if (connections[0] == null) {
            return name + " : ";
        }
        int pos = number;
        String conString = "[";
        for (int i = 0; i < number; i++) {
            if (connections[i + 1] == null) {
                pos = i;
                break;
            }
            conString += connections[i].getUserName() + ", ";
        }
        conString += connections[pos].getUserName() + "]";
        return name + " : " + conString;
    }
}
