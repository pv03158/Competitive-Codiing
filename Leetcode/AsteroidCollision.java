class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        // MANAGING CORNER CASES
        if(asteroids.length == 0 || asteroids.length == 1)
            return asteroids;
        
        Stack<Integer> stack = new Stack<>();
        for(int idx = 0; idx < asteroids.length ; idx++) {
            // ENCOUNTER WHEN THERE'S AN SMALLER ELEMENT ON STACK PEEK
            while(stack.size() != 0 
                  && asteroids[stack.peek()] > 0 && asteroids[idx] < 0
                  && Math.abs(asteroids[stack.peek()]) < Math.abs(asteroids[idx]))
                stack.pop();
            
            // ENCOUNTERS WHEN STACK DOESN'T HAVE ANYTHING, SO IT DOESN'T MATTER WHETHER
            // ITS A POSTIIVE ASTEROID OR NEGATIVE ONE
            if(stack.size() == 0) 
                stack.push(idx);
            
            // ENCOUNTERS WHEN NO COLLISION TAKES PLACE
            // I.E (1). -,- (2) -, + (3) +,+
            else if(asteroids[stack.peek()] < 0 || asteroids[stack.peek()] > 0 && asteroids[idx] > 0)
                stack.push(idx);
            
            // ENCOUNTERS WHEN THERE'S AN EQUAL SIZE ELEMENT ON STACK PEEK
            else if( stack.size() != 0 && -asteroids[stack.peek()] == asteroids[idx])
                stack.pop();
        }
        
        int ans[] = new int[stack.size()];
        for(int idx = ans.length - 1 ; idx >= 0 ; idx--)
            ans[idx] = asteroids[stack.pop()];
        
        return ans;
        
    }
}