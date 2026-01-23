import arrayList.reverse;

class linkList{
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data =data;
            this.next =null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;
    
    //Add first element in linked list
    public void addFirst(int data){ //O(1)
        //step1-create a new node
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            // newNode;
            return;
        }

        //step2- newnode is next
        newNode.next = head;

        //step3
        head = newNode;
    }

    //Add last element in linked list
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
        //If we don't use use below condition then at place of LL is empty we get null
        // if(head == null){
        //     System.out.println("LL is empty");
        //     return;
        // }

        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    //Add element at any index in linked list
    public void add(int idx,int data) { //O(n)
        if(idx == 0){
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;

        while( i<=idx-1 ){
            temp = temp.next;
            i++;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }
    
    //remove element from ll
    public int removeFirst(){// O(1)
        if(size == 0){
            System.out.println("ll is empty");
            return Integer.MIN_VALUE;
        }
        else if(size == 1) {
            int val = head.data;
            head = tail = null;
            size =0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;

    }
    public int removeLast(){
        if(size == 0){
            System.out.println("ll is empty");
            return Integer.MIN_VALUE;
        }
        else if(size == 1){
            int val = head.data;
            head = tail = null;
            size =0;
            return val;
        }

        //prev : i= size-2
        Node prev = head;
        for(int i=0;i<size-2;i++){
            prev = prev.next;
        }

        int val = prev.next.data;//tail.data
        prev.next = null;
        prev = tail;
        size--;
        return val;
    }
    
    //iterative search in ll
    public int irtSearch(int key){//O(n)
        Node temp = head;
        int i=0;

        while(temp != null){
            if(temp.data == key){
                return i;
            }
            temp = temp.next;
            i++;
        }

        return -1;
    }
    
    //recursive search in ll
    public int helper(Node head,int key){ //O(n) & O(n)
        if(head == null){
            return -1;
        }
        if(head.data == key){
            return 0;
        }

        int idx =helper(head.next, key);
        if(idx == -1){
            return -1;
        }

        return idx+1;
    }
    public int recSearch(int key){
        return helper(head, key);
    }

    // Reverse linked list
    public void reverseList(){
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while(curr!=null){
            next = curr.next;
            curr.next =prev;
            prev =curr;
            curr=next;
        }
        head = prev;
    }
    
    //middle of ll
    public Node middle(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node slow = head;
        Node fast =head;

        while( fast !=null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //Delete middle node in ll
    public Node deleteMiddle(Node head) {
        //Middle node
        Node slow = head;
        Node fast =head;

        while( fast !=null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //delete midle node
        Node prev =null;
        Node curr =slow;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next =prev;
            prev = curr;
            curr = next;
        }
        return prev; //returning the new head of the reversed list
    }

    //Remove nth mode from end of ll
    public Node removeNnode(Node head,int n){
        //Brute force approach , O(2n) time and O(1) space


        //Optimized approach , O(n) time and O(1) space
        if(head == null || head.next == null || n <= 0){
            return null; //if list is empty or n is invalid
        }
        Node dummy = new Node(-1);
        dummy.next = head;
        Node fast = dummy;
        Node slow = dummy;

        for(int i =1;i<=n;i++){
            fast = fast.next;
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return dummy.next;
    }

    //Check ll is palindromic or not
    public boolean isPalindrome(Node head) {
        //find mid
        Node slow =head , fast =head;
        while( fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;

        //reverse a linklisNode prev =null;
        Node prev = null;
        Node curr =mid;
        Node next;

        while( curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev;
        Node left = head;

        //Check right & left half
        while(right !=null){
            if(right.data !=left.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }

    //Detech a loop/Cycle in ll
    public static boolean isCycle(){
        Node slow = head,fast = head;
        while(fast != null && fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }

    //Remove a cycle/loop in ll
    public static void removeCycle(){
        //detect a cycle
        Node slow =head,fast =head;
        boolean cycle =false;
        while(fast != null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                cycle = true;
                break;
            }
        }

        if(cycle ==false){
            return ;
        }
        //find last node of cycle
        slow =head;
        Node prev = null;//last node
        while( slow!=fast){
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        //point lastnode to null
        prev.next =null;
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

    //Zid-Zag in ll
    private Node Mid(Node head){
        Node slow = head;
        Node fast = fast.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    public Node ZigZag(Node head){
        //midNode
        int mid = Mid(head);
        //reverse
    }
    public static void main(String[] args){
        linkList ll = new linkList();
        ll.print();
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(4);
        ll.addLast(5);
        ll.add(2, 9);

        ll.print();

        // System.out.println(size);
        // ll.removeFirst();
        // ll.print();
        // ll.removeLast();
        // ll.print();
        // System.out.println(size);

        // System.out.println(ll.irtSearch(3));
        // System.out.println(ll.irtSearch(10));
        // System.out.println(ll.recSearch(3));
        // System.out.println(ll.recSearch(10));
    //     ll.deleteMiddle();
    //     ll.print();

        // ll for detect a loop/cycle
        // head = new Node(1);
        // Node temp = new Node(2);
        // head.next = temp;
        // head.next.next = new Node(3);
        // head.next.next.next = temp;
        // // 1->2->3->2

        // System.out.println(isCycle());
        // removeCycle();
        // System.out.println(isCycle());

        //merge sort in ll
        // linkList ll = new linkList();
        // ll.addFirst(1);
        // ll.addFirst(2);
        // ll.addFirst(3);
        // ll.addFirst(4);
        // ll.addFirst(5);

        // // ll.print();
        // // ll.head = ll.mergeSort(ll.head);
        // // ll.print();

        // //removeNth node from end of ll
        // ll.print();
        // ll.removeNnode(ll.head, 4);
        // ll.print();
    }
}