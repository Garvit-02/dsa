package Recursion;

public class Duplicate {
    public static void removeDuplicates(int idx,String str,StringBuilder newStr,boolean map[]){
        if(idx == str.length()){
            System.out.println(newStr);
            return;
        }

        char currChar = str.charAt(idx);
        if(map[currChar-'a'] == true){
            //duplicate
            removeDuplicates(idx+1, str, newStr, map);
        }
        else{
            removeDuplicates(idx+1, str, newStr.append(str), map);
        }
    }
    public static void main(String[] args) {
        String str ="garrrviiittguptaa";
        removeDuplicates(0, str, new StringBuilder(str), null);
    }
}