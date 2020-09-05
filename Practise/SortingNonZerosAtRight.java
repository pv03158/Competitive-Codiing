import java.util.Arrays;

public class SortingNonZerosAtRight {
    public static void main(String[] args) {
        int arr[] = {0, 0, 0, 1, 3, 0, 0};

        int i = arr.length - 1;
        while(i > 0) {
            if(arr[i] != 0 )
                i--;
            else {
                int j = i - 1;
                while(j>= 0 && arr[j] == 0 ) 
                    j--;

                if(j != -1) {
                    arr[i] = arr[j];
                    arr[j] = 0;
                    i--;    
                }
                else {
                    break;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
