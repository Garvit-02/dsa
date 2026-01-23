public class mergeSort {
    public class Node{
        int data;
        Node next;

        public Node(int data){
            this.data =data;
            this.next =null;
        }
    }
    public Node head;
    public Node tail;
    public int size;

    public void addFirst(int data){ //O(1)
        //step1-create a new node
        Node newNode = new Node(data);
        size++;

        if(head == null){
            head = tail = newNode;
            return;
        }

        //step2- newnode is next
        newNode.next = head;

        //step3
        head = newNode;
    }

    public void addLast(int data){ //O(1)
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next=newNode;
        tail = newNode;
    }

    public void print(){ //O(1)
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    //merge sort in ll
    private Node getMid(Node head){
        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private Node merge(Node head1,Node head2){
        Node mergedLL = new Node(-1);
        Node temp =mergedLL;

        while(head1 != null && head2 != null){
            if(head1.data <= head2.data){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }
            else{
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        while(head1 != null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while(head2 != null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        return mergedLL.next;
    }
    public Node mergeSort(Node head){
        //basecase
        if(head == null || head.next == null){
            return head;
        }
        //Find mid
        Node mid = getMid(head);
        //left&right half
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);
        //merge
        return merge(newLeft,newRight);
    }

    public static void main(String[] args) {
        mergeSort ll = new mergeSort();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addFirst(5);

        ll.print();
        ll.head = ll.mergeSort(ll.head);
        ll.print();
    }
}
