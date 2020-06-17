import java.util.*;

public class DreamMoonLikesColoring {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int arr[] = new int[m];
        for(int i=0;i<m;i++)
            arr[i] = scn.nextInt();

        printColoredCells(n,m,0,arr,new int[m]);
    }

    public static void printColoredCells(int n,int m, int idx,int arr[],int p[]){
        if(idx == arr.length) {
            // printing result
            for(int i=0;i<p.length;i++)
                System.out.print(p[i]+" ");
            System.out.println();
            return;
        }

        for(int i=1;i<=n-arr[idx]+1;i++) {
            for(int j=i-1;j<i+arr[idx]-1 && j < p.length ;j++) {
                p[j] = idx;
            }
            printColoredCells(n,m,idx+1,arr,p);
        }
    }
}