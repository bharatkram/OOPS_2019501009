/**
 * This class implements all the methods of the SocialNetrorkInterface 
 * You are free to add your own behaviours to this class.
 * 
 * @author Siva Sankar
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
        // TODO
        // Your code goes here
        users = new User[10];
        size = 0;
    }

    /**
     * This method takes the string as a parameter which is used
     * to create a network. do nothing if the string is empty.
     * 
     * @param str to be used to create a network.
     */
    public void createDataStructure(String str) {
        // TODO
        // Your code goes here
        if (str == null) {
            return;
        }

        String[] details = null;
        String[] followers;
        String[] usersArray = str.split(";");
        for (int i = 0; i < usersArray.length; i++) {
                details = usersArray[i].split(" is connected to ");
                // users[size] = details[0];
                // users[size].setUserName(details[0]);
                followers = details[1].split(",");
                for (int j = 0; j < followers.length; j++) {
                    System.out.println(followers[j]);
                    users[size].add(followers[j]);
                }
            size++;
            
        }
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
        // TODO
        // Your code goes here
        if (size == users.length) {
            users = Arrays.copyOf(users, users.length+10);
        }

        boolean flag = false;
        for (int i = 0; i < size; i++) {
            if (userA.equals(users[i])) {
                flag = true;
                break;
            }
        }
        if(!flag) {
            users[size++] = userA;
        }
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
        // TODO
        // Your code goes here
        boolean flagA = false;
        boolean flagB = false;

        for (int i = 0; i < size; i++) {
            if (users[i].equals(userA)) {
                flagA = true;
            }
        }

        for (int i = 0; i < size; i++) {
            if (users[i].equals(userB)) {
                flagB = true;
            }
        }

        if (flagA && flagB) {
            userA.add(userB.getUserName());
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
        // TODO
        // Your code goes here

        // User[] connectionUsers = new User[20];
        // int count = 0;
        // String[] connections = new String[20];

        // for (int i = 0; i < size; i++) {
        //     if (users[i].equals(userA)) {
        //         connections = users[i].connectionsList();
        //     }
        // }
        // for (int i = 0; i < connections.length; i++) {
        //     for (int j = 0; j < size; j++) {
        //         if (users[j].getUserName().equals(connections[i])) {
        //             connectionUsers[count++] = users[j];
        //         }
        //     }
        // }
        // return connectionUsers;

        User[] list = new User[20];
        int count = 0;
        String[] stringList = new String[20];

        stringList = userA.connectionsList();
        if (stringList != null) {
            for (int i = 0; i < stringList.length; i++) {
                for (int j = 0; j < size; j++) {
                    if (stringList[i].equals(users[j].getUserName())) {
                        list[count++] = users[i];
                    }
                }
            }
        }
        return list;
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
        // TODO
        // Your code goes here

    //     User[] commonUsers = new User[20];
    //     int count = 0;

    //     boolean flagA = false;
    //     boolean flagB = false;
    //     for (int i = 0; i < size; i++) {
    //         if (flagA && flagB)
    //             break;
    //         if (users[i].equals(userA)) {
    //             flagA = true;
    //         }
    //         else if (users[i].equals(userB)) {
    //             flagB = true;
    //         }
    //     }

    //     if (flagA && flagB) {
    //         String[] conA = userA.connectionsList();
    //         String[] conB = userB.connectionsList();
    //         String[] common = new String[20];
    //         int commonSize = 0;

    //         for (int i = 0; i < userA.noOfConnections(); i++) {
    //             for (int j = 0; j < userB.noOfConnections(); j++) {
    //                 if (conA[i].equals(conB[j])) {
    //                     common[commonSize++] = userA.getUserName();
    //                     break;
    //                 }
    //             }
    //         }
    //         for (int i =0; i < common.length; i++) {
    //             for (int j = 0; j < users.length; j++) {
    //                 if (users[j].getUserName().equals(common[i])) {
    //                     commonUsers[count++] = users[j];
    //                 }
    //             }
    //         }
    //         return commonUsers;
    //     }
    //     return null;
        
        String[] listA = userA.connectionsList();
        String[] listB = userB.connectionsList();
        String[] commonList = new String[20];
        int count = 0;
        User[] common = new User[20];
        int c = 0;

        for (int i = 0; i < listA.length; i++) {
            for (int j = 0; j < listB.length; j++) {
                if (listA[i].equals(listB[j])) {
                    commonList[count++] = listA[i];
                }
            }
        }
        for (int i = 0; i < commonList.length; i++) {
            for (int j = 0; j < size; j++) {
                if (commonList[i].equals(users[j].getUserName())) {
                    common[c++] = users[j];
                }
            }
        }
        return common;
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