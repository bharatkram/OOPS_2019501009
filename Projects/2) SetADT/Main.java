class Main {

    /**
     * main function.
     *
     * @param args main function parameters.
     */
    public static void main(final String[] args) {
        System.out.println("Creation of Interger sets");
        Set<Integer> iSObj = new Set<Integer>();
        OrderedSet<Integer> iOsObj = new OrderedSet<Integer>();

        iSObj.add(5);
        iSObj.add(3);
        iSObj.add(1);
        iSObj.add(4);
        iSObj.add(3);


        iOsObj.add(4);
        iOsObj.add(2);
        iOsObj.add(6);
        iOsObj.add(8);
        iOsObj.add(3);

        Integer[] arr = {1, 2, 3};
        iSObj.addAll(arr);
        iOsObj.addAll(arr);

        System.out.println("Elements present in the set: " + iSObj);
        System.out.println("Elements present in the ordered set: " + iOsObj);

        System.out.println("Union: " + iOsObj.union(iSObj));
        System.out.println("Intersection: " + iOsObj.intersection(iSObj));

        System.out.println("\nCreation of String sets");
        Set<String> sSObj = new Set<String>();
        OrderedSet<String> sOsObj = new OrderedSet<String>();

        sSObj.add("a");
        sSObj.add("x");
        sSObj.add("u");
        sSObj.add("i");
        sSObj.add("e");
        sSObj.add("j");

        sOsObj.add("a");
        sOsObj.add("x");
        sOsObj.add("y");
        sOsObj.add("i");
        sOsObj.add("t");
        sOsObj.add("f");

        String[] sArr = {"c", "a", "x"};
        sSObj.addAll(sArr);
        sOsObj.addAll(sArr);

        System.out.println("Elements present in the set: " + sSObj);
        System.out.println("Elements present in the ordered set: " + sOsObj);

        System.out.println("Union: " + sOsObj.union(sSObj));
        System.out.println("Intersection: " + sOsObj.intersection(sSObj));

    }
}
