class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int median = (nums1.length + nums2.length) / 2;
        int arr[] = new int[median + 1];
        
        int pos1 = 0;
        int pos2 = 0;
        int idx = 0;
        
        while( idx <= median && pos1 < nums1.length && pos2 < nums2.length) {
            if(nums1[pos1] > nums2[pos2])
                arr[idx++] = nums2[pos2++];
                
            else
                arr[idx++] = nums1[pos1++];
        }
            
        
        while( idx <= median && pos1 < nums1.length )
                arr[idx++] = nums1[pos1++];
            
        while( idx <= median && pos2 < nums2.length)
                arr[idx++] = nums2[pos2++];
        
        
        if( (nums1.length + nums2.length) % 2 != 0 )
            return (double) arr[median];
        
        else 
            return (double) (arr[median] + arr[median - 1]) / 2;
            
    }
}