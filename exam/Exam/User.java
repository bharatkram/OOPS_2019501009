import java.util.*;

public class User {
    private String userName;
    private int noOfConnections;
    private String[] connections;

    User(String s, String[] f) {
        userName = s;
        connections = f;
        noOfConnections = f.length;
    }

    User() {
        userName = "";
        noOfConnections = 0;
        connections = new String[10];
    }

    public void setUserName(String s) {
        userName = s;
    }

    public String getUserName() {
        return userName;
    }

    public void add(String u) {
        if(noOfConnections == connections.length) {
            connections = Arrays.copyOf(connections, connections.length+10);
        }
        connections[noOfConnections++] = u;
    }

    public int noOfConnections() {
        return noOfConnections;
    }

    public String[] connectionsList() {
        return connections;
    }
}