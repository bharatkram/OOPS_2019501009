public class Patron {

    /**
     * field to store the name of the person.
     */
    private String name;

    /**
     * field to store the mobile number of the person.
     */
    private String mobileNumber;

    Patron(final String name, final String mobileNumber) {
        this.name = name;
        this.mobileNumber = mobileNumber;
    }

    /**
     * function to get the name of the person stored.
     *
     * @return the name of the person.
     */
    public String getName() {
        return name;
    }

    /**
     * function to get the mobile number of the person.
     *
     * @return the mobile number of the person.
     */
    public String getMobileNumber() {
        return mobileNumber;
    }
}
