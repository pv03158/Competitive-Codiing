import java.util.*;

public class JugglingLetters {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();

        while(t-- > 0) {
            int n = scn.nextInt();
            scn.nextLine();
            String[] arr = new String[n];
            for(int idx = 0 ; idx < n; idx++) 
                arr[idx] = scn.nextLine();

            HashMap<Character, Integer> hm = new HashMap<>();
            for(int idx = 0 ; idx < n ; idx++ ) {
                String str = arr[idx];
                for(int index = 0 ; index < str.length(); index++) {
                    char key = str.charAt(index);
                    if(hm.containsKey(key)) 
                        hm.put(key, hm.get(key) + 1);
                    else
                        hm.put(key, 1);
                }
            }

            boolean flag = true;
            for(Character key : hm.keySet()) {
                if( hm.get(key) % n != 0) {
                    flag = false;
                    break;
                }
            }

            if(flag)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}