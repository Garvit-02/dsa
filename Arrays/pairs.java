class Arrays{
    public static void pairs(int numbers[]){
        int tp=0;

        for(int i=0;i<numbers.length;i++){
            int curr = numbers[i];
            for(int j=i+1;j<numbers.length;j++){  // here we showed make sure that when initialize in 2nd loop we initialize from j=i+1 not j=i bcz we should not calculate pair with same elements like 5,5 or 6,6 or more               
                System.out.print("("+ curr +","+ numbers[j]+ ")");
                tp++;
            }
            System.out.println();
        }
        System.out.println("Total no. of pairs are: "+ tp);
    }
    public static void main(String args[]){
        //pairs in an arrays
        int numbers[] = {5,6,10,11,14,25,16};
        pairs(numbers);
    }
}