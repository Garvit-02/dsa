import java.util.LinkedList; //JCF

class linList{
    public static void main(String[] args) {
        //create
        LinkedList<Integer> ll = new LinkedList<>();

        //add elements
        ll.addLast(1);
        ll.addLast(2);
        ll.addFirst(0); // 0->1->2
        System.out.println(ll);

        //remove elements
        ll.removeLast();
        ll.removeFirst();
        System.out.println(ll);

    }
}
