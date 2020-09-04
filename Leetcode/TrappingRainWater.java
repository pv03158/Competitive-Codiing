class Solution {
    public int trap(int[] height) {
        // MANAGING CORNER CASES
        if(height.length <= 2 )
            return 0;
       
        // FINDING NEXT GREATEST ELEMENT ON LEFT
        int ngl[] = new int[height.length];
        int greatest = 0;
        for(int idx = 0 ; idx < height.length ; idx++) {
            ngl[idx] = greatest;
            greatest = Math.max(greatest, height[idx]);
        }
        
        // FINDING NEXT GREATES ELEMENT ON RIGHT
        int ngr[] = new int[height.length];
        greatest = 0;
        for(int idx = height.length - 1; idx >= 0 ; idx--) {
            ngr[idx] = greatest;
            greatest = Math.max(greatest, height[idx]);
        }
        
        int counter = 0;
        int localcounter = 0;
        // FINDING TOTAL WATER COLLECTED
        for(int idx = 0 ; idx < height.length ; idx++)  {
            localcounter = Math.min(ngl[idx], ngr[idx]) - height[idx];
            counter += (localcounter > 0) ? localcounter : 0;
        }
        
        return counter;
    }
}