class Solution {
    boolean hasArrayTwoCandidates(int arr[], int n, int sum) {
        // STORING ELEMENTS AND THEIR INDEXES IN A HASHMAP
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int idx = 0 ; idx < n ; idx++)
            hm.put(arr[idx], idx);
            
        for(int idx = 0 ; idx < n ; idx++)
            if( hm.containsKey(sum - arr[idx]) 
                && hm.get(sum - arr[idx]) != idx)
                return true;
                
        return false;
    }
}