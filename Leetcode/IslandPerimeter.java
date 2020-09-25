// APPROACH -- 1
class Solution {
    public int islandPerimeter(int[][] arr) {
        int land = 0;
        int edge = 0;
        
        int m = arr.length;
        int n = arr[0].length;
        
        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j++) {
                if(arr[i][j] == 1) {
                    land ++;
                    if(i > 0 && arr[i-1][j] == 1)
                        edge ++;
                    if(j > 0 && arr[i][j-1] == 1)
                        edge ++;
                }
            }
        }
        
        return land*4 - edge*2;
    }
}

// APPROACH -- 2
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