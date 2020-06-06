/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cuong.hq
 */
public class StackArray {
    
    public static void main(String[] args) {
        StackArray stack = new StackArray(4);
        System.out.println(stack.push(1));
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.push(2));
        System.out.println(stack.push(5));
        System.out.println(stack);
        System.out.println(stack.push(2));
        System.out.println(stack.push(5));
        System.out.println(stack.push(10));
        System.out.println(stack);
        System.out.println(stack.isFull());
        System.out.println(stack.peek());
        System.out.println(stack.isFull());
        System.out.println(stack.pop());
        System.out.println(stack);
    }

    int[] items;
    int top;
    int size;

    static final int DEFAULT_STACK_CAPACITY = 8;

    public StackArray() {
        init(DEFAULT_STACK_CAPACITY);
    }

    public StackArray(int size) {
        init(size);
    }

    public void init(int size) {
        this.size = size;
        items = new int[size];
        top = -1;
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == size - 1);
    }

    public boolean push(int v) {
        if (isFull()) {
            return false;
        }

        top += 1;
        items[top] = v;
        return true;
    }

    public int pop() {
        if (isEmpty()) {
            return -1;
        }
        int result = items[top];
        items[top] = 0;
        top -= 1;
        return result;
    }

    public int peek() {
        if (isEmpty()) {
            return -1;
        }
        return items[top];
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "Empty";
        }

        String results = "";
        for (int i = 0; i <= top; i += 1) {
            results = results.concat(items[i] + " ");
        }
        return results;
    }
}
