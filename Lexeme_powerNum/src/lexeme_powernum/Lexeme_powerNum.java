package lexeme_powernum;
import java.util.Scanner;

public class Lexeme_powerNum {
    
    //Dot, digit or ^+ checking functions
    public static int digitCheck(char c) {
        return (c>='0' && c<='9') ?1:0;
    }
    public static int dotCheck(char c) {
        return c=='.'?1:0;
    }
    public static int pmCheck(char c) {
        return (c=='^'?1:(c=='-'?2:-1));
    }
    
    //Checking the number
    public static int lexemeCheck(String s) {
        int l, i, f=0, pwr=0, minus=0, dot=0;
        l = s.length();
        //LOGIC: xx^xx : both side of ^
        for(i=0; i<l; i++) {
            
            //POWER SIGN
            if(i>0 && pmCheck(s.charAt(i))==1 && pwr<1) pwr=1;
            
            //INT FLOAT NUM CHECK
            if(pwr==0) {
                if(digitCheck(s.charAt(i)) == 1) f=1;
                else if(dot<2 && dotCheck(s.charAt(i)) == 1) dot++;
                else return 0;
            }
            
            //AFTER POWER > MINUS OR INT FLOAT CHECK
            else if(pwr==1) {
                if(pmCheck(s.charAt(i))==2) {
                    if(minus<0) minus=1;
                    else return 0;
                }
                else if(digitCheck(s.charAt(i)) == 1) f=1;
                else if(dot<3 && dotCheck(s.charAt(i)) == 1) dot++;
                else return 0;
            }
            else return 0;
        }
        return 1;
    }
    
    public static void main(String[] args) {
        int f;
        String s;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter a power number: ");
        s = sc.nextLine();
        //s = "_9sam";
        f = lexemeCheck(s);
        
        if(f == 1) {
            System.out.println("Valid number");
        }
        else if(f == 0){
            System.out.println("Invalid number");
        }
    }
    
}
