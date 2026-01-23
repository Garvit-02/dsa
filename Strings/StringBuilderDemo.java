package Strings;

public class StringBuilderDemo {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("");
        for(char ch='a'; ch<='z'; ch++){
            sb.append(ch);
        }
        System.out.println(sb);
    }
}

//this code TC[O(26)] is less bcz here we du not again and again new string here we add to previous one & TC for normal method O(n*26)
