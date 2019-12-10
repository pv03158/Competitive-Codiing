import java.util.Scanner;
import java.io.FileWriter;
import java.lang.reflect.Array;
import java.io.File;
import java.util.Collections;;

public class Sorting{
    // declaring global variables
    static int arr[] = new int[100000000];
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
        private void heapify(int array[],int lb, int ub){
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

        private void merge(int array[], int lb, int mid , int ub){
            int l_array[] = new int[mid-lb + 1];
            int r_array[] = new int[ub-mid];
            // creating a copy of array elements into two differnt sub arrays
            for ( int i = 0 ; i < mid-lb+1 ; i++ )
                l_array[i] = array[lb + i];
            for ( int i = 0 ; i < ub-mid ; i++ )
                r_array[i] = array[mid + i + 1];
            // merging these two subarrays into one
            int i = 0;
            int j = 0;
            int k = lb;
            while(i < mid - lb + 1 && j < ub - mid)
                array[k++] = (l_array[i] < r_array[j]) ? l_array[i++] : r_array[j++];
            // inserting leftout elements
            for ( ; i < mid-lb+1 ; i++ )
                array[k++] = l_array[i];
            for ( ; j < ub-mid ; j++ )
                array[k++] = r_array[j];
        }

        public void mergeSort(int array[], int lb, int ub){
            if ( lb < ub ){
                int mid = (lb + ub) / 2;

                mergeSort(array, lb, mid);
                mergeSort(array, mid+1, ub);
                merge(array, lb, mid, ub);
            }
        }

        private int partition(int array[], int lb, int ub){
            int pivot = ub;
            int i = lb - 1;
            // separting those elements which are smaller & larger than pivot
            for ( int j = lb; j < ub ; j++  ){
                if( array[j] < array[pivot]){
                    i += 1;
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
            // swapping pivot in between its smaller and larger elements
            int tmp = array[i+1];
            array[i+1] = array[pivot];
            array[pivot] = tmp;
            // returning the position the pivot position
            return i+1;
        }

        public void quickSort(int array[], int lb, int ub){
            if (lb < ub){
                int median = partition(array, lb, ub);
                quickSort(array, lb, median - 1);
                quickSort(array, median + 1, ub);
            }
        }
    }
   // driver function
    public static void main(String args[]) throws Exception{
        readFile("Cluster.txt");
        Sort sort = new Sort();
        // sort.heapSort(arr, 0, size - 1);
        // writeFile("Heap-Sorted-Cluster.txt");
        // sort.mergeSort(arr, 0, size - 1);
        // writeFile("Merge-Sorted-Cluster.txt");
        sort.quickSort(arr, 0, size - 1);
        writeFile("Quick-Sorted-Cluster.txt");
    }
}