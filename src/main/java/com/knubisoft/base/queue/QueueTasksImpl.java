package com.knubisoft.base.queue;

import com.knubisoft.base.queue.car.Car;

import java.lang.reflect.Array;
import java.util.*;

public class QueueTasksImpl implements QueueTasks {

    @Override
    public Queue<Integer> reverseQueueUsingRecursion(Queue<Integer> queue)
    {
        if (queue.isEmpty()){
            return queue;
        }
        int current = queue.poll();
        reverseQueueUsingRecursion(queue);
        queue.add(current);

        return queue;
    }

    @Override
    public Queue<Integer> reverseFirstKElementsOfQueue(Queue<Integer> queue, int k) {


        int n = queue.size();
        // remove first k elements of queue and push in stack
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < k; i++) {
            int curr = queue.poll();
            stack.push(curr);
        }

        // Pop out elements from stack and add to the end of the queue
        while (!stack.isEmpty()) {
            int curr = stack.pop();
            queue.add(curr);
        }
        // Remove first (n - k) elements of the queue and add them to the end
        for (int i = 0; i < n - k; i++) {
            int curr = queue.poll();
            queue.add(curr);
        }
        // Print the elements of the queue
        for (Integer i : queue) {
            System.out.print(i + " ");
        }
        return queue;
    }

    @Override
    public Queue<Integer> sortQueueOfInt(Queue<Integer> queue) {
        ArrayList<Integer> temp = new ArrayList<>();
        while (queue.isEmpty() == false){
            temp.add(queue.peek());
            queue.poll();
        }
        Collections.sort(temp);
        for (int i = 0; i < temp.size(); i++){
            queue.add(temp.get(i));
        }
        return queue;
    }

    @Override
    public boolean validParentheses(String parentheses) {
        Stack<Character> st = new Stack<Character>();
        for(int i = 0; i < parentheses.length(); i++)
        {
            if ((parentheses.charAt(i) == '(') || (parentheses.charAt(i) == '[') || (parentheses.charAt(i) == '{'))
                st.push(parentheses.charAt(i));
            else
            {
                if (st.empty()) return false;
                if ((parentheses.charAt(i) == ')') && (st.peek() != '(')) return false;
                if ((parentheses.charAt(i) == ']') && (st.peek() != '[')) return false;
                if ((parentheses.charAt(i) == '}') && (st.peek() != '{')) return false;
                st.pop();
            }
        }
        return st.empty();
    }

    @Override
    public PriorityQueue<Car> implementPriorityQueueThroughComparator(List<Car> cars) {
        return null;
    }

}
