import java.util.*;

public class Swayamwar {
    public static void main(String args[]) {
        // taking input
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.nextLine();
        Queue<Character> bride = new ArrayDeque<>();
        Queue<Character> groom = new ArrayDeque<>();

        String str = scn.nextLine();
        for(int idx = 0 ; idx < n ; idx++)
            bride.add(str.charAt(idx));

        str = scn.nextLine();
        for(int idx = 0 ; idx < n ; idx++)
            groom.add(str.charAt(idx));

        // processing output
        int retryCount = 0;
        while(retryCount != groom.size() && groom.size() > 0) {
            if(bride.peek() != groom.peek()) {
                groom.add(groom.remove());
                retryCount += 1;
            }
            else {
                bride.remove();
                groom.remove();
                retryCount = 0;
            }
        }

        // displaying output
        System.out.println(groom.size());
        scn.close();
    }
}