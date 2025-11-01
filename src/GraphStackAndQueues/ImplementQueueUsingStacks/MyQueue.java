package GraphStackAndQueues.ImplementQueueUsingStacks;

import java.util.Stack;

class MyQueue {

    private Stack<Integer> stack1 = new Stack<Integer>();
    private Stack stack2 = new Stack<Integer>();

    public MyQueue() {

    }

    public void push(int x) {

        if(stack1.empty() && stack2.empty()){
            stack2.push(x);
        }else {
            while(!(stack2.empty())){
                stack1.push((int)stack2.pop());
            }
            stack2.push(x);
            while(!(stack1.empty())){
                stack2.push((int)stack1.pop());
            }
        }

    }

    public int pop() {
        if(!stack2.empty()){
            return (int)stack2.pop();
        }
        return 0;
    }

    public int peek() {
        if(!stack2.empty()){
            return (int) stack2.peek();
        }
        return 0;
    }

    public boolean empty() {
        return stack2.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
