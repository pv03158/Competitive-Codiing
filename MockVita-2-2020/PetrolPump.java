import java.util.*;

public class PetrolPump {
    public static void main(String args[]) {
        // taking input from cli
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        String QtyOfPetrol[] = str.split(" ");
        int length = QtyOfPetrol.length;

        // processing output
        int QtyOfPetrolInt[] = new int[length];
        for(int idx = 0 ; idx < length ; idx++)
            QtyOfPetrolInt[idx] = Integer.valueOf(QtyOfPetrol[idx]);

        int res = MaxTimeTaken(QtyOfPetrolInt, 0 , 0);
        // displaying output
        System.out.println( res );
        scn.close();
    }

    public static int MaxTimeTaken(int[] arr, int sum0 , int sum1 ) {
        if(arr.length == 0) {
            return Math.max(sum0, sum1);
        }

        int val = arr[0];
        arr = Arrays.copyOfRange(arr, 1, arr.length);
        return Math.min( MaxTimeTaken( arr, sum0 + val , sum1), MaxTimeTaken( arr, sum0 , sum1 + val) );
    }
}