import java.util.*;

public class strobogrammaticNumbers {
    public static boolean isStrobogrammatic(String s, Map<Character, Character> map){
        int i=0,
            j = s.length()-1;

        while(i<=j){
            char c1 = s.charAt(i);
            char c2 = s.charAt(j);

            if(!map.containsKey(c1) || map.get(c1) != c2){
                return false;
            }else{
                i++;
                j--;
            }
        }
        return true;
    }
    public static void main(String args[]){
        String s = "198861";
        Map<Character, Character> map = new HashMap<>();

        map.put('0', '0');
        map.put('1', '1');
        map.put('8', '8');
        map.put('9', '6');
        map.put('6', '9');

        System.out.println(isStrobogrammatic(s, map));
    }
}
