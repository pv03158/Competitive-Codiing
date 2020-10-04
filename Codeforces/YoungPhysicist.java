import java.util.*;

public class YoungPhysicist {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        // taking input from user
        int n = scn.nextInt();
        int arr[][] = new int[n][3];
        for(int i = 0 ; i < n ; i++) 
            for(int j = 0 ; j < 3 ; j++)
                arr[i][j] = scn.nextInt();

        // processing result
        int res[] = new int[3];
        for(int j = 0 ; j < 3 ; j++) 
            for(int i = 0 ; i < n ; i++)
                res[j] += arr[i][j];

        for(int idx = 0 ; idx < 3 ; idx++) {
            if(res[idx] != 0) {
                System.out.println("NO");
                return;
            }
        }
        
        System.out.println("YES");
    }
}