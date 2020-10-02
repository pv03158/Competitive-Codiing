import java.util.*;

public class QueueAtTheSchool {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int t = scn.nextInt();
        ArrayList<Integer> posOfBoys = new ArrayList<>();
        char queue[] = new char[n];
        
        scn.nextLine();         // removing buffer
        String str = scn.nextLine();
        // taking input from user
        for(int idx = 0 ; idx < n ; idx++ ) {
            char ch = str.charAt(idx);
            queue[idx] = ch;
            if(ch == 'B')
                posOfBoys.add(idx);
        }

        // processing output
        while(t-- > 0) {
            for(int idx = 0 ; idx < posOfBoys.size() ; idx++) {
                int pos = posOfBoys.get(idx);
                if(pos + 1 < n && queue[pos + 1] == 'G') {
                    queue[pos] = 'G';
                    queue[pos + 1] = 'B';
                    posOfBoys.set(idx, pos + 1);
                }
            }
        }

        // producing output
        for(int idx = 0 ; idx < n ; idx++)
            System.out.print(queue[idx]);
    }
}