import java.util.Scanner;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.lang.StringBuffer;

public class ExpressionFormatting{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        StringBuffer str = new StringBuffer(sc.nextLine());
        for( int i = 0; i < str.length(); i++){
            if( str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '*' || str.charAt(i) == '/' ){
                str.insert(i, " ");
                str.insert(i+2, " ");
                i += 2;
            }
        }
        System.out.println(str);
        sc.close();
    }
}