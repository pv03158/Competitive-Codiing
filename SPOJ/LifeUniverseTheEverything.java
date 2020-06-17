import java.util.*;

public class LifeUniverseTheEverything {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        while(true) {
            int num = scn.nextInt();
            if(num == 42)
                break;
            else
                System.out.println(num);
        }
    }
}