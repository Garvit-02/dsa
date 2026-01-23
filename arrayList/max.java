package arrayList;
import java.util.ArrayList;

public class max {
    public static void main(String[] args) {
        ArrayList<Integer>List = new ArrayList<>();
        List.add(2);
        List.add(1);
        List.add(5);
        List.add(4);
        List.add(3);

        Integer max = Integer.MIN_VALUE;
        for(int i=0;i<List.size();i++){
            if(List.get(i)>max){
                max = List.get(i);
            }
        }
        System.out.println("Max no is : "+max);
    }
}
