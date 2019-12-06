import java.util.Scanner;

public class datatypes{
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int numberOfTestCases = input.nextInt();
        String array[] = new String[numberOfTestCases];
        // taking input test cases
        input.nextLine();   // clearing input buffer
        for ( int i = 0 ; i < numberOfTestCases ; i++ )
            array[i] = input.nextLine();
        for ( int i = 0 ; i < numberOfTestCases ; i++ ){
            try {
                Long tmp = Long.parseLong(array[i]);
                System.out.println(array[i] + " can be fitted in:");
                if ( tmp >= -128 && tmp <= 127 )
                    System.out.println("* byte");
                if ( tmp >= -32768 && tmp <= 32767 )
                    System.out.println("* short");
                if ( tmp >= -2147483648 && tmp <= 2147483647 )
                    System.out.println("* int");
                if ( tmp >= -9223372036854775808L && tmp <= 9223372036854775807L )
                    System.out.println("* long");
            } catch (Exception e) {
                System.out.println(array[i] + " can't be fitted anywhere.");
            }
        }
        input.close();
    }
}