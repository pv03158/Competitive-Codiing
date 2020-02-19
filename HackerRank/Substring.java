import java.util.Scanner;

public class Substring{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int start = scn.nextInt(), end = scn.nextInt();
        System.out.println( str.substring(start,end) );
    }
}