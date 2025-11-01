package GraphStackAndQueues.DailyTemperatures;

import java.util.Stack;

public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<Integer>();
        int[] result = new int[temperatures.length];

        for(int i = 0; i < temperatures.length; i++){
            while(!stack.empty() && temperatures[stack.peek()] < temperatures[i]){
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }
        return result;
    }
}
