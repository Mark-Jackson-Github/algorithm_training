package com.mark.zuoshen.stack_queue;

import java.util.Stack;

/**
 * 第一题目：实现一个特殊栈，在实现栈的基本功能上，再实现返回栈中最小元素的操作。
 *
 * 要求：
 *  1. pop、push、getMin操作的时间复杂度都是O(1);
 *  2. 设计的栈类型可以使用现成的栈结构。
 *
 * 思路：
 *  1.实现基础的栈功能；
 *  2.在这个基础的功能上，采用双栈策略，实现返回最小值的操作：
 *      * 具体就是入栈操作的时候栈1按照次序存放栈元素；
 *      * 与此同时，栈2用于存放和栈1比较的元素，每次比较当前压入和栈2栈顶元素进行比较,
 *        也就是栈1元素小于栈2栈顶元素的时候才压入栈1的元素到栈2
 *  【3，2，6，5，1】
 *
 *    栈1                       栈2
 *    1                          1
 *    5                          不操作
 *    6                          不操作
 *    2                          2
 *    3                          3
 */
public class getMin1 {

    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public getMin1(){
        this.stackData = new Stack<Integer>();
        this.stackMin = new Stack<Integer>();
    }

    public void push(int newNum){
        if (this.stackMin.isEmpty()){
            this.stackMin.push(newNum);
        }else if (newNum <= this.getmin()){
            this.stackMin.push(newNum);
        }
        this.stackData.push(newNum);
    }

    public int pop(){
        if (this.stackData.isEmpty()){
            throw new RuntimeException("you stack is empty!");
        }
        int value = this.stackData.pop();
        if (value == this.getmin()){
            this.stackMin.pop();
        }
        return value;
    }

    public int getmin(){
        if (this.stackMin.isEmpty()){
            throw new RuntimeException("you stack is empty!");
        }
        return this.stackMin.peek();
    }
}
