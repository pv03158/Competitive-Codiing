import java.util.Scanner;
import java.io.FileWriter;
import java.lang.reflect.Array;
import java.io.File;
import java.util.Collections;;

public class Sorting{
    // declaring global variables
    static int arr[] = new int[10000000];
    static int size = 0;

   // declaring global functions
    private static void readFile(String fileName) throws Exception{
        File inputFile = new File(fileName);
        Scanner fin = new Scanner(inputFile);
        while(fin.hasNextLine()){
            arr[size++] = Integer.parseInt(fin.nextLine());
        }
        fin.close();
    }

    private static void writeFile(String fileName) throws Exception{
        File outputFile = new File(fileName);
        FileWriter fout = new FileWriter(outputFile);
        for( int i = 0; i < size ; i++ )
            fout.write( String.valueOf(arr[i]) + "\n" );
        fout.close();
    }

    public static class Sort{
        public void heapify(int array[],int lb, int ub){
            int largest = lb;
            int l_child = 2*lb + 1;
            int r_child = 2*lb + 2;
            largest = ( l_child < ub && arr[l_child] > arr[largest]) ? l_child : largest;
            largest = ( r_child < ub && arr[r_child] > arr[largest])? r_child : largest;
            if ( largest != lb ){
                int tmp = arr[lb];
                arr[lb] = arr[largest];
                arr[largest] = tmp;
                heapify(array, largest, ub);
            }
        }

        public void heapSort(int array[], int lb, int ub){
            // creating max heap of array elements
            for ( int i = (ub-1)/2 ; i >= lb ; i-- )
                heapify(array, i, ub);
            // removing elements from max heap and store back in the last postion
            for ( int i = 0 ; i <= ub ; i++ ){
                int tmp = arr[0];
                arr[0] = arr[ub - i];
                arr[ub - i] = tmp;
                heapify(array, 0, ub - i);
            }
        }
    }
   // driver function
    public static void main(String args[]) throws Exception{
        readFile("Cluster.txt");
        Sort sort = new Sort();
        sort.heapSort(arr, 0, size - 1);
        writeFile("Sorted-Cluster.txt");
    }
}