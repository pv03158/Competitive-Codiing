// APPROACH -- 1
class Solution {
    public int largestRectangleArea(int[] arr) {
        
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        
        // MAX-AREA VARIABLE
        int maxarea = 0;
        
        // ITERATING OVER THE ELEMENTS
        for(int idx = 0 ; idx < arr.length ; idx++) {
            while( stack.peek() != -1 && arr[stack.peek()] >= arr[idx] ) {
                int ele = stack.pop();
                int area = (idx - stack.peek() - 1) * arr[ele];
                maxarea = Math.max(maxarea, area);
            }
            
            stack.push(idx);
        }
        
        // DEALING WITH LEFT OUT ELEMENTS OF STACK
        while(stack.size() != 1) {
            int ele = stack.pop();
            int area = (arr.length - stack.peek() - 1) * arr[ele];
            maxarea = Math.max(maxarea, area);
        }
        
        // RETURNING OUTPUT
        return maxarea;
    }
}

// APPROACH -- 2
class Solution {
    public int largestRectangleArea(int[] heights) {
        
        // FINDING NEXT SMALLER ON RIGHT
        Stack<Integer> stack = new Stack<>();
        int nsr[] = new int[ heights.length ];
        Arrays.fill(nsr, heights.length);
        
        for(int idx = 0 ; idx < heights.length ; idx++) {
            while(stack.size() != 0 && heights[stack.peek()] > heights[idx])
                nsr[stack.pop()] = idx;
            stack.push(idx);
        }
        
        // FINDING NEXT SMALLER ON LEFT
        stack = new Stack<>();
        int nsl[] = new int[ heights.length ];
        Arrays.fill(nsl, -1);
        
        for(int idx = heights.length - 1; idx >= 0 ; idx--) {
            while(stack.size() != 0 && heights[stack.peek()] > heights[idx])
                nsl[stack.pop()] = idx;
            stack.push(idx);
        }
        
        // FINDING WIDTH OF RECTANGLE
        int width[] = new int[ heights.length ];
        for(int idx = 0 ; idx < heights.length ; idx++) 
            width[idx] = nsr[idx] - nsl[idx] - 1;
        
        // FINDING MAX AREA RECTANGLE
        int maxarea = 0;
        for(int idx = 0 ; idx < heights.length ; idx++)
            maxarea = Math.max(maxarea, width[idx] * heights[idx] );
        
        return maxarea;
    }
}