import java.util.Scanner;

public class javaStrings{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();

        System.out.println(a.length() + b.length());
        if(a.charAt(0) > b.charAt(0))
            System.out.println("Yes");
        else
            System.out.println("No");
        System.out.println(a + " " + b);
    }
}