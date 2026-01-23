package arrayList;
import java.util.ArrayList;

public class reverse {
    public static void main(String[] args) {
        ArrayList<Integer>List = new ArrayList<>();
        List.add(1);
        List.add(2);
        List.add(3);
        List.add(4);
        List.add(5);

        for (int i = List.size() - 1; i >= 0; i--) { // Start from the last index and decrement
            System.out.print(List.get(i) + " ");
        }
        System.out.println();
    }
}
