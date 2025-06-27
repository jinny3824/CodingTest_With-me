import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        //배열에 문자열 삽입
        char [] arr = new char[a.length()];
        
           for (int i = 0; i < a.length(); i++) {            
               
               
            arr[i] = a.charAt(i);
               
               if(Character.isLowerCase(arr[i])) {arr[i] = Character.toUpperCase(arr[i]);}
               
               else {arr[i] = Character.toLowerCase(arr[i]);}
                  
           
           }
        
        System.out.print(arr);
        
    }
}