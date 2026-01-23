package Strings;

public class Strings {
    public static String SubString(String str1,int si,int ei){
        String substr ="";
        for(int i=si; i<ei; i++){
            substr += str1.charAt(i);
        }

        return substr;
    }

    public static void main(String[] args) {
        String str1= "garvit";
        String str2= "garvit";
        // String str2 = new String("garvit");

        if(str1.equals(str2)){
            System.out.println("Strings are same");
        }
        else{
            System.out.println("Strings are not same");
        }

        // // SubString
        System.out.println(SubString(str1, 0, 5));
        str1.substring(0, 5);
        System.out.println(str1.substring(1, 5));
    }
}
