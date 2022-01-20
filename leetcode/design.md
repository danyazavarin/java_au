# Design

+ [Min Stack](#min-stack)


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
