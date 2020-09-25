class Solution {
    public int islandPerimeter(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0)
                return 0;
        
        int m = grid.length;
        int n = grid[0].length;
        
        int peri = 0;
        boolean state = false;  // FALSE SIGNIFIES WE ARE IN WATER & TRUE WE ARE ON LAND
        // ITERATING FROM TOP TO BOTTOM
        for(int j = 0; j < n ; j++) {
            state = false;
            for(int i = 0 ; i < m ; i++) {
                if(!state && grid[i][j] == 1) {
                    state = true;
                    peri ++;
                }
                else if(state && grid[i][j] == 0) {
                    state = false;
                    peri ++;
                }
                if(state && i == m - 1) {
                    state = false;
                    peri++;
                }
            }
        }
        
        // ITERATING FROM LEFT TO RIGHT
        for(int i = 0; i < m ; i++) {
            state = false;
            for(int j = 0 ; j < n ; j++) {
                if(!state && grid[i][j] == 1) {
                    state = true;
                    peri ++;
                }
                else if(state && grid[i][j] == 0) {
                    state = false;
                    peri ++;
                }
                if(state && j == n - 1) {
                    state = false;
                    peri++;
                }
            }
        }
        
        return peri;
    }
}