import java.util.Scanner;

public class AreaOfParallelogram{
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int b = input.nextInt();
        int h = input.nextInt();
        if ( b*h < 0 )
            System.out.println("java.lang.Exception: Breadth and height must be positive");
        else
            System.out.println( b*h );
        input.close();
    }
}