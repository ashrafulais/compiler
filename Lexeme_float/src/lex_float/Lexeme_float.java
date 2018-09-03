package lex_float;
import java.util.Scanner;

public class Lexeme_float {
    
    public static int digitCheck(char c) {
        return (c>='0' && c<='9') ?1:0;
    }
    public static int dotCheck(char c) {
        return c=='.'?1:0;
    }
    public static int lexemeCheck(String s) {
        int l, i, f=0, c=0;
        l = s.length();
        
        for(i=0; i<l; i++) {
            if(i==0) {
                if(digitCheck(s.charAt(i)) == 1) {
                    f=1;
                }
                else if(c<1 && dotCheck(s.charAt(i)) == 1) {
                    c=1;
                }
            }
            else if(i>0) {
                if(c<1 && dotCheck(s.charAt(i)) == 1) {
                    c=1;
                } else if(digitCheck(s.charAt(i)) == 1) {
                    f=1;
                } else
                    return 0;
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
        
        System.out.println("Enter a float number: ");
        s = sc.nextLine();
        //s = "_9sam";
        f = lexemeCheck(s);
        
        if(f == 1) {
            System.out.println("Valid float number");
        }
        else if(f == 0){
            System.out.println("Invalid float number");
        }
    }
    
}
