import java.util.Scanner;

public class FieldTrip {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++) 
            arr[i] = scn.nextInt();

        System.out.println(isGroupPossible(arr,0,0,new boolean[n]));
    }

    public static boolean isGroupPossible(int[] arr,int idx,int groupLength, boolean status[]) {
        //base condition
        if(idx == arr.length)
            return true;


        // checking whether element isnt already placed
        int counter = 0;
        if( !status[idx] ) {
            // creating group
            for(int i=0;i<arr.length;i++){
                if(arr[idx] == arr[i] && idx != i) {
                    counter += 1;
                    status[idx] = true;
                    status[i] = true;
                }
            }
            // for zeroth case
            if(idx == 0)
                groupLength = counter;
            // checking whether group length != counter
            if(groupLength != counter)
                return false;
        }
        boolean isPossible = true;
        //placing rest elements
        isPossible = isGroupPossible(arr, idx+1, groupLength, status);
        return isPossible;
    }
}