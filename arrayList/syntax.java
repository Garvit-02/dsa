package arrayList;
import java.util.ArrayList;

public class syntax {
    public static void main(String[] args) {
        ArrayList<Integer>List = new ArrayList<>();
        ArrayList<String>List2 = new ArrayList<>();
        List.add(1);
        List.add(2);
        List2.add("Hello");
        List2.add("World");
        System.out.println(List);
        System.out.println(List2);

        System.out.println(List.get(0));
        System.out.println(List2.get(1));
        

        List.remove(0);
        List2.remove(1);
        System.out.println(List);
        System.out.println(List2);

        List.set(2,5);
        List2.set(0,"JAva");
        System.out.println(List);
        System.out.println(List2);

        System.out.println(List.size());

        
    }
}
