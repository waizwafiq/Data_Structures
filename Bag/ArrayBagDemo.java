import java.util.Arrays;

public class ArrayBagDemo {

    private static void testAdd(BagInterface<String> aBag, String[] content) {
        for(String i: content)
            aBag.add(i);
    }

    private static void displayBag(BagInterface<String> aBag) {
        System.out.println("Number of entries: " + aBag.getCurrentSize());
        System.out.println(Arrays.toString(aBag.toArray()));
    }

    public static void main(String[] args) {
        ArrayBag<String> bag1 = new ArrayBag<>();
        ArrayBag<String> bag2 = new ArrayBag<>();

        String[] contentsOfBag1 = {"A", "A", "B", "A", "C", "A"};
        String[] contentsOfBag2 = {"A", "B", "A", "C", "B", "C", "D", "anotherstring"};

        testAdd(bag1,contentsOfBag1);
        testAdd(bag2,contentsOfBag2);

        displayBag(bag1);
        displayBag(bag2);

        BagInterface<String> bag3 = bag1.union(bag2);
        BagInterface<String> bag4 = bag1.intersection(bag2);
        BagInterface<String> bag5 = bag1.difference(bag2);

        displayBag(bag3);
        displayBag(bag4);
        displayBag(bag5);
    }
}
