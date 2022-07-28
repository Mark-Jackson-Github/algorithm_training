package com.mark.zuoshen.stack_queue;

import java.util.Queue;
import java.util.Stack;

/**
 * 由两个栈组成的队列
 *
 * 编写一个类，用两个栈实现队列，支持队列的基本操作(add,poll,peek)；
 *
 * 思路：
 *  * 栈的特性是先进后出，队列的特性是先进先出；
 *  * 因此使用两个栈进行队列的改造；
 *      栈1进行入栈操作，入栈完成后，将数据再转存到栈2；
 *      栈2负责出栈操作，这样的配合就可以实现先进先出的操作
 *
 *      栈1                栈2
 *      5                   1
 *      4                   2
 *      3                   3
 *      2                   4
 *      1                   5
 *
 *
 */
public class TwoStackQueue {

    private Stack<Integer> stackpush;
    private Stack<Integer> stackPop;

    public TwoStackQueue(){
        stackPop = new Stack<Integer>();
        stackpush = new Stack<Integer>();
    }

    //push栈向pop栈倒入数据
    private void pushPop(){
        if (stackPop.isEmpty()){
            while (!stackpush.empty()){
                stackPop.push(stackpush.pop());
            }
        }
    }

    public void add(int pushInt){
        stackpush.push(pushInt);
        pushPop();
    }

    public int poll(){
        if (stackPop.isEmpty() && stackpush.isEmpty()){
            throw new RuntimeException("Queue is Empty!");
        }
        pushPop();
        return stackPop.pop();
    }
    public int peek(){
        if (stackPop.empty() && stackpush.empty()){
            throw new RuntimeException("Queue is Empty");
        }
        pushPop();
        return stackPop.peek();
    }

}
