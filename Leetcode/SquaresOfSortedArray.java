class Solution {
    public int[] sortedSquares(int[] arr) {
      
        // USING TWO POINTER APPROACH TO SOLVE THE PROBLEM
        // AS SQUARE OF LARGEST NUMBER IN +VE SIDE
        // AND SQUARE OF SMALLEST NUMBER IN -VE SIDE ARE THE
        // HEAVIEST ONES, SO ITERATING FROM THE LAST & FIRST INDEX
        
        int i = 0, j = arr.length - 1;
        int ans[] = new int[arr.length];
        int pos = arr.length - 1;
        
        while(i <= j) 
            ans[pos--] = (Math.abs(arr[i]) >= Math.abs(arr[j]) )
                        ? arr[i] * arr[i++] : arr[j] * arr[j--];
        
        return ans;
    }
}