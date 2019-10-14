/**
 * This class implements all the methods of the SocialNetrorkInterface 
 * You are free to add your own behaviours to this class.
 * @author Siva Sankar
 * @author Bharat Ram Koppu
 */

import java.util.Arrays;

public class SocialNetwork {

    /**
     * users indicates the actual users in the network
     */
    User[] users;

    /**
     * The size indicates the numebr of users in the network
     */
    int size;

    /**
     * Initializes the default values of the social network.
     */
    public SocialNetwork() {
        // Your code goes here
        users = new User[20];
        size = 0;
    }

    /**
     * This method takes the string as a parameter which is used
     * to create a network. do nothing if the string is empty.
     *
     * @param str to be used to create a network.
     */
    public void createDataStructure(String str) {
        // Your code goes here
        if (str == "" || str == null) {
            return;
        }
        // first split is to get one line at a time.
        // each line contains name of user and his connections.
        String[] usersList = str.split(";");
        // iterating line by line
        for (String userString: usersList) {
            // second split is to separate the name of user and his connections
            String[] uAndc = userString.split(" is connected to ");
            // System.out.println(uAndc[0] + "\n" + uAndc[1] + "\n");

            // this is to check if the user already is present in the list.
            // if not, we add him/her to the list.
            User result = null;
            boolean flag = true;
            if (size == 0) {
                users[size] = new User(uAndc[0]);
                result = users[size++];
            } else {
                for (User user: users) {
                    if (user.getUserName().equals(uAndc[0])) {
                        result = user;
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    users[size] = new User(uAndc[0]);
                    result = users[size];
                    size += 1;
                }
            }

            // third split is to separate the users connections.
            String[] connections = uAndc[1].split(",");
            // iterating to get one connection at a time.
            for (String connection : connections) {
                // checking if the connection is present in the list.
                // if not, we add him/her to the list.
                // and then, we add him/her to the connections list.
                flag = true;
                for (int i = 0; i < size; i++) {
                    if (users[i].getUserName().equals(connection)) {
                        flag = false;
                        result.setConnections(users[i]);
                        break;
                    }
                }
                if (flag) {
                    users[size] = new User(connection);
                    result.setConnections(users[size]);
                    size += 1;
                }
            }
        }
        return;
    }

    private boolean searchUser(User user) {
        for (int i = 0; i < size; i++) {
            if (user.equals(users[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * Please don't modify the follwoing code.
     * This method returns the User based on the userName.
     * 
     * @param userName the string to be used to search for the user.
     * @return the User object based on the userName. 
     * Returns null otherwise
     */
    public User getUser(String userName) {
        for (int i = 0; i < size; i++) {
            if (userName.equals(users[i].getUserName())) {
                return users[i];
            }
        }
        return null;
    }

    /**
     * This method adds a new User (object) that is passed as 
     * argument to the social network if the user is not currently 
     * on the social network.
     * @param userA to be added to the social network.
     */
    public void addUser(User userA) {
        // Your code goes here
        for (int i = 0; i < size; i++) {
            if(users[i].getUserName().equals(userA.getUserName())) {
                return;
            }
        }
        users[size++] = userA;
    }

    /**
     * This method takes two users (objects) as arguments and 
     * connects them on the network. userA and userB are 
     * the users that are passed as parameters to this function, 
     * then add userB to userA’s connections
     * 
     * Note: Both userA and userB should be there on the network.
     * if anyone of them are not on the network, then do nothing.
     * 
     * @param userA the userB is to be added to userA connections
     * @param userB to be added to userA connections
     */
    public void addConnection(User userA, User userB) {
        // Your code goes here
        boolean flagA = false, flagB = false;
        for (int i = 0; i < size; i++) {
            if (users[i].equals(userA)) {
                flagA = true;
            } else if (users[i].equals(userB)) {
                flagB = true;
            }
        }
        if (flagA && flagB) {
            userA.setConnections(userB);
        }
    }

    /**
     * This method takes a user object as an argument that returns the 
     * connections of this user. Return null if the user is not in 
     * the network.
     * 
     * @param userA the user object used to return the 
     * connections of this user.
     * 
     * @return the list of connections of userA. otherwise return null
     */
    public User[] getConnections(User userA) {
        // Your code goes here
        for (int i = 0; i < size; i++) {
            if (users[i].equals(userA)) {
                return users[i].getConnections();
            }
        }
        return null;
    }

    /**
     * This method returns the common connections of userA and userB.
     * Note: both userA and userB should be on the network. if anyone 
     * of them is not in the network, then return null
     * 
     * @param userA the first user
     * @param userB the second user
     * 
     * @return the common connections of both userA and userB if they 
     * both are in the network, otherwise return null
     */
    public User[] getCommonConnections(User userA, User userB) {
        // Your code goes here
        boolean flagA = false, flagB = false;
        User[] consA = null, consB = null;
        int sizeA = 0, sizeB = 0;
        for (int i = 0; i < size; i++) {
            if (users[i].equals(userA)) {
                flagA = true;
                consA = users[i].getConnections();
                for (int k = 0; k < consA.length; k++) {
                    if (consA[k] == null) {
                        break;
                    }
                    sizeA += 1;
                }
            } else if (users[i].equals(userB)) {
                flagB = true;
                consB = users[i].getConnections();
                for (int k = 0; k < consB.length; k++) {
                    if (consB[k] == null) {
                        break;
                    }
                    sizeB += 1;
                }
            }
        }
        for (int i = 0; i < sizeA; i++) {
            // System.out.println(consA[i].getUserName());
        }
        if (flagA && flagB) {
            User[] common = new User[10];
            int commonSize = 0;
            for (int i = 0; i < sizeA; i++) {
                for (int j = 0; j < sizeB; j++) {
                    if (consA[i].equals(consB[j])) {
                        common[commonSize++] = consA[i];
                        break;
                    }
                }
            }
            return common;
        }
        return null;
    }

    /**
     * This reutrns the String version of the social network.
     * 
     * @return the String version of the network, return an empty string
     * if there are no users in the network.
     */
    public String toString() {
        if (this.size == 0) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        int i = 0;
        for (i = 0; i < size-1; i++) {
            sb.append(users[i] + "\n");
        }
        sb.append(users[i]);
        return sb.toString();
    }
}