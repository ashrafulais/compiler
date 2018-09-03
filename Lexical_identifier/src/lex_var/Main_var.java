package lex_var;
import java.util.Scanner;

public class Main_var {
    
    public static int digitCheck(char c) {
        return (c>='0' && c<='9') ?1:0;
    }
    
    public static int charCheck(char c) {
        return (c=='_' || (c>='A' && c<='Z') || (c>='a' && c<='z')) ?1:0;
    }
    public static int lexemeCheck(String s) {
        int l, i, f=0;
        l = s.length();
        
        for(i=0; i<l; i++) {
            if(i==0 && charCheck(s.charAt(i)) == 1) {
                f=1;
            }
            else if(i>0 && (charCheck(s.charAt(i)) == 1 || digitCheck(s.charAt(i)) == 1)) {
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
        
        System.out.println("Enter a variable name: ");
        s = sc.nextLine();
        //s = "_9sam";
        f = lexemeCheck(s);
        
        if(f == 1) {
            System.out.println("Valid Identifier");
        }
        else if(f == 0){
            System.out.println("Invalid Identifier");
        }
    }
    
}
