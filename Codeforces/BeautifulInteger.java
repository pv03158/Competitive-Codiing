import java.util.Scanner;
import java.lang.StringBuffer;

public class BeautifulInteger{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        StringBuffer num = new StringBuffer(String.valueOf( sc.nextInt()));
        
        for(int i = 0 ; i < num.length() - k ; i++){
            num.replace(i+k,i+k+1, String.valueOf(num.charAt(i)));
        }
        for(int i = num.length() - k ; i >= 0 ; i--){
            num.replace(i+k,i+k+1, String.valueOf(num.charAt(i)));
        }
    }
}