import java.util.Scanner;
import java.util.Vector;
import java.util.Iterator;

public class EndOfFile{
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        Vector array = new Vector();
        while (true){
            System.out.println(input.hasNextLine());
            if (input.hasNext())
                array.add(input.nextLine());
            else
                break;
        }
        Iterator itr = array.iterator();
        int count = 1;
        while ( itr.hasNext() ){
            System.out.println( count + " " + itr.next() );
            count += 1;
        }
        input.close();
    }
}