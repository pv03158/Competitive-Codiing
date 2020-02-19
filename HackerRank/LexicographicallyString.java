import java.util.Scanner;

public class LexicographicallyString{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String a = scn.next(), b = scn.next();
        // printing sum of their lengths
        System.out.println( a.length()+b.length() );
        if(a.charAt(0) <= b.charAt(0))
            System.out.println("No");
        else
            System.out.println("Yes");
        System.out.println( a.substring(0,1).toUpperCase()+a.substring(1) + " " + b.substring(0,1).toUpperCase()+b.substring(1) );
    }
}