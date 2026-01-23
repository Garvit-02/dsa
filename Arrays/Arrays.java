// import java.util.*;

class Arrays{
    public static void update(int marks[],int nonChangable){
        nonChangable = 10;
        for( int i=0; i< marks.length;i++){   // this loop is very use in arrays 
            marks[i] = marks[i]+1;
        }
    }

    public static int LinearSearch(int numbers[],int key){
        for(int i=0; i<numbers.length ; i++){
            if(numbers[i] == key){
                return i;
            }
        }
        return -1;
    }

    public static int getLargest(int numbers[]){
        int Largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;

        for(int i=0; i<numbers.length; i++){
            if(Largest < numbers[i]){
                Largest = numbers[i];
            }
            if(smallest > numbers[i]){
                smallest = numbers[i];
            }
        }
        System.out.println("Smallest no. is:"+ smallest);
        return Largest;
    }

    public static int BinarySearch(int numbers[],int key){
        int start=0;
        int end= numbers.length-1;
        
        while (start <= end) {
            int mid =(start+end)/2;

            //Compare mid & key values
            if(numbers[mid] == key){
                return mid;
            }
            if (numbers[mid] < key) {
                start = numbers[mid]+1;
            }
            else{
                end = numbers[mid] -1;
            }
        }
        return -1;
    }

    public static void Reverse(int numbers[]){
        int first = 0;
        int last = numbers.length-1;

        //swap
            while (first<last) {
            int temp=numbers[last];
            numbers[last]=numbers[first];
            numbers[first]=temp;
    
            first++;
            last--;
        }     
            
    }

    public static void main (String args[]){
        
        //int marks[] = new int[100];
        //length of array
        // System.out.print("length of array = " + marks.length);

        // input,output,update
        // Scanner sc = new Scanner(System.in);
        // marks[0]= sc.nextInt();
        // marks[1]= sc.nextInt();
        // marks[2]= sc.nextInt();
        // System.out.println("marks of physics:" + marks[0]);
        // System.out.println("marks of chem:" + marks[1]);
        // System.out.println("marks of math:" + marks[2]);

        // marks[1]= 100;
        // marks[2]= marks[2] + 1;
        // System.out.println("marks of chem:" + marks[1]);
        // System.out.println("marks of math:" + marks[2]);
        

       // call by referance(arrguments) 
          int marks[] = {97,98,99};
          int nonChangable =5;
          update(marks,nonChangable);
          System.out.println(nonChangable);

        //   for(int i=0;i< marks.length;i++){
        //    System.out.print(marks[i] + " ");
        //   }
        //   System.out.println();

       //LinearSearch
    //    int numbers[] = {5,6,10,11,14,25,16};
    //    int key = 20;

    //    int indexvalue = LinearSearch(numbers,key);
    //    if( indexvalue == -1){
    //     System.out.println("not found");
    //    }
    //    else{
    //    System.out.println("index value is:"+ indexvalue);
    //   }

      // Largest Value
    //   int numbers[] = {1,2,6,3,5};
    //   System.out.println("Largest no is:" + getLargest(numbers));

      //Binary Search
    //   int numbers[] = {5,6,10,11,14,25,16};
    //   int key = 25; 

    //   System.out.println("Index no is:" + BinarySearch(numbers, key));

    //Reverse Array
    // int numbers[] = {5,6,10,11,14,25,16};
    // System.out.println("normal arrays: ");
    // for(int i=0; i< numbers.length;i++){
    //     System.out.print(numbers[i]+" ");
    // }
    // System.out.println();

    // Reverse(numbers);
    // System.out.println("Reverse Arrays");
    // for(int i=0; i< numbers.length;i++){
    //     System.out.print(numbers[i]+" ");
    // }
    // System.out.println();
    }
}