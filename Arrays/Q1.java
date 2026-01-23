public class Q1 {
    public static int Samenum(int num[]){
        for(int i=0; i<num.length; i++){
            if(num[i] >=2){
                return false;
            }
            return true;
        }
    }
    public static void main(String[] args) {
        int num ={1,2,3,1};
        Samenum(num);

        
    }
}
