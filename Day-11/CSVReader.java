/**
 * Given a CSV file, we will read the data from the CSV file and parses each
 * line of the file. See the operations that are performed after reading the
 * file.
 *
 * @author Siva Sankar
 * @author Nemnous
 */

public class CSVReader {

    /**
     * field to store the information in textfile according to rows.
     */
    private String[] dataFrame;

    /**
     * This function is used to read the given csv File This uses functions
     * from the ReadCSVFile class.
     *
     * @param fileName - name of the given csv file
     */
    public void readCSV(final String fileName) {
        dataFrame = ReadCSVFile.readFile(fileName);
    }

    /**
     * The number of rows in the given data frame. Note: This shouldn't include
     * the coloumn labels.
     *
     * @return -1 if the Data set is empty
     */
    public int rowCount() {
        // Your code goes here....
        if (dataFrame.length > 0) {
            return dataFrame.length - 1;
        }
        return -1;
    }

    /**
     * This method returns the count of coloumns in a data Frame.
     * @return the count of columns in the dataset and -1 otherwise.
     */
    public int fieldCount() {
        // Your code goes here....
        if (dataFrame.length > 0) {
            String[] columns = dataFrame[0].split(",");
            return columns.length;
        }
        return -1;
    }

    /**
     * This method returns the name of the column based on the index
     * passed as a parameter.
     *
     * @param index index of the coloumn starting from 1.
     * @return the column name based on the index and null otherwise.
     */
    public String getFieldName(final int index) {
        // Your code goes here....
        if (index >= 0 && index < fieldCount()) {
            if (dataFrame.length > 0) {
                String[] columns = dataFrame[0].split(",");
                return columns[index - 1];
            }
        }
        return null;
    }


    /**
     * This method returns the row (array of values) based on the parameter
     * passed to the method.
     *
     * @param rowNumber given the Row of the row indexing from 1. Exclude the
     * column header row.
     *
     * @return the string array containing the contents of the entire row.
     */
    public String[] getRow(final int rowNumber) {
        // Your code goes here....
        if (dataFrame.length == 0 || rowNumber < 0 || rowNumber
                > dataFrame.length) {
            return null;
        }
        return dataFrame[rowNumber].split(",");
    }

    /**
     * This method returns the rows (String array) based on fromIndex and
     * toIndex.
     * The fromIndex and toIndex should be in the range of the dataset lengths.
     *
     * @param fromIndex given from index
     * @param toIndex   given to index
     * @return String array containing the rows starting from the fromindex
     *         to the toindex. Append the entire row to the string array
     *         comma separated.
     */
    public String[] getRows(final int fromIndex, final int toIndex) {
        // Your code goes here....
        int len = 0;
        if (dataFrame.length == 0 || fromIndex < 0 || toIndex
                > dataFrame.length || fromIndex > toIndex) {
            return null;
        }
        String[] rows = new String[toIndex - fromIndex];
        for (int i = fromIndex; i < toIndex; i++) {
            rows[len++] = dataFrame[i];
        }
        return rows;
    }

    /**
     * This method returns the column values based on particular column index.
     *
     * @param index index of the column
     * @return all the values of the column as a string array
     */
    public String[] getColumnValues(final int index) {
        // Your code goes here....
        if (rowCount() < 0) {
            return null;
        }
        String[] nof = new String[rowCount()];
        for (int i = 1; i <= rowCount(); i++) {
            nof[i - 1] = dataFrame[i].split(",")[index];
        }
        return nof;
    }
}
