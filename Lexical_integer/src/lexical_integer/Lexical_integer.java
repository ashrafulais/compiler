
package lexical_integer;

import java.util.Scanner;

public class Lexical_integer {
    
    public static int digitCheck(char c) {
        return (c>='0' && c<='9') ?1:0;
    }
    
    public static int lexemeCheck(String s) {
        int l, i, f=0, minus=0;
        l = s.length();
        
        for(i=0; i<l; i++) {
            if(i==0 && s.charAt(i)=='-') minus=1;
            else if(digitCheck(s.charAt(i)) == 1 && s.charAt(i)!='-' && minus<=0) {
                f=1;
            }
            else
                return 0;
        }
        
        return 1;
    }
    
    public static void main(String[] args) {
        int f;
        String s;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter an integer number: ");
        s = sc.nextLine();
        //s = "_9sam";
        f = lexemeCheck(s);
        
        if(f == 1) {
            System.out.println("Valid Integer");
        }
        else if(f == 0){
            System.out.println("Invalid Integer");
        }
    }
    
}
