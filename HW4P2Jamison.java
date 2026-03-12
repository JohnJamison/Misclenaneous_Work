public class HW4P2Jamison {
    public static void main(String[] args) {
        SortedList mySortedList = new SortedList();


        mySortedList.add(500);
        mySortedList.add(100);
        mySortedList.add(900);
        mySortedList.add(400);
        mySortedList.add(200);

        System.out.println("Printing SortedList contents using a for-each loop:");

        for (Integer value : mySortedList) {
            System.out.println("Value: " + value);
        }
    }
}