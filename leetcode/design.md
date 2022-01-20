# Design

+ [Implement Stack using Queues](#implement-stack-using-queues)
+ [Implement Queue using Stacks](#implement-queue-using-stacks)
+ [Min Stack](#min-stack)


## Implement Stack using Queues

https://leetcode.com/problems/implement-stack-using-queues/

<details><summary>Test Cases</summary>

``` java
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class TestMyStack{
    
    @Test
    void top() {
        var lst = createRandomLst(10);
        var stack = createMyStackFromLst(lst);
        Collections.reverse(lst);
        for (var value: lst) {
            assertEquals(value, stack.top());
            stack.pop();
        }
    }
    
    @Test
    void pushPop() {
        var lst = createRandomLst(10);
        var stack = createMyStackFromLst(lst);
        Collections.reverse(lst);
        for (var value: lst) {
            assertEquals(value, stacl.pop());
        }
    }
    
    @Test
    void empty() {
        var stack = createMyStackFromLst(List.of());
        assertTrue(stack.empty());
    }
    
    @Test
    void nonEmpty() {
        var stack = createMyStackFromLst(createRandomLst(5));
        assertFalse(stack.empty());
    }
    
    private MyStack createMyStackFromLst(List<Integer> lst){
        var stack = new MyStack();
        for (var value: lst) {
            stack.push(value);
        }
        return stack;
    }
    
    private ArrayList<Integer> createRandomLst(int size){
        var lst = new ArrayList<Integer>();
        for(int i = 0; i < size; i++){
            lst.add((int)(Math.random() * 10));
        }
        return lst;
    }
}
```

</details>


```java
class MyStack{
    Deque<Integer> stack;

    public MyStack(){
        stack=new ArrayDeque<>();
    }

    public void push(int x){
        stack.push(x);
    }

    public int pop(){
        return stack.pop();
    }

    public int top(){
        return stack.peek();
    }

    public boolean empty(){
        return stack.isEmpty();
    }
}
```

## Implement Queue using Stacks

https://leetcode.com/problems/implement-queue-using-stacks/

<details><summary>Test Cases</summary>

``` java 
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class MyQueueTest {

    @Test
    void testMyQueue() {
        var queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.pop();
        List<Integer> lst = Arrays.asList(2, 3);
        ArrayDeque<Integer> expected = new ArrayDeque<>(list);
        Arrays.equals(expected.toArray(), queue.queue.toArray());
    }
}
```

</details>


``` java
class MyQueue {
    Deque<Integer> queue;
    
    public MyQueue() {
        queue = new ArrayDeque<>();
    }
    
    public void push(int x) {
        queue.addLast(x);
    }
    
    public int pop() {
        return queue.pop();
    }
    
    public int peek() {
        return queue.peek();
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}
```

## Min Stack

https://leetcode.com/problems/min-stack/

<details><summary>Test Cases</summary>

``` java 
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class MinStackTest {

    @Test
    void testGetMin() {
        var testLst = new ArrayList<Integer>();
        testLst.addAll(List.of(4, 2, 3, 1, 4));
        var stack = createMinStackFromList(testLst);
        assertEquals(stack.getMin(), testLst.stream().min((o1, o2) -> o1.compareTo(o2)).get());
    }
    
    @Test
    void pushAndGetTopAndPop() {
        var testLst = new ArrayList<Integer>();
        testLst.addAll(List.of(1, 2, 3, 4));
        var stack = createMinStackFromList(testLst);
        Collections.reverse(testLst);
        for (var expectedValue: testLst) {
            assertEquals(expectedValue, stack.top());
            stack.pop();
        }
    }

    
    private MinStack createMinStackFromList(List<Integer> lst){
        var stack = new MinStack();
        for (var val: lst) {
            stack.push(val);
        }
        return stack;
    }
}
```

</details>


``` java
class MinStack {
    private class Node{
        int val;
        int min;
        Node next;
        
        private Node(int val, int min){
            this.val = val;
            this.min = min;
            this.next = null;
        }
    }

    private Node topValue;
    
    public MinStack() {
        topValue = null;
    }
    
    public void push(int val) {
        if (topValue == null) {
            topValue = new Node(val, val);
        }
        else {
            Node newValue = new Node(val, Math.min(topValue.min, val));
            newValue.next = topValue;
            topValue = newValue;
        }
    }
    
    public void pop() {
        topValue = topValue.next;
    }
    
    public int top() {
        return topValue.val;
    }
    
    public int getMin() {
        return topValue.min;
    }
}
```
