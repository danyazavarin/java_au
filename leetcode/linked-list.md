# Linked List

+ [Reverse Linked List](#reverse-linked-list)
+ [Middle of the Linked List](#middle-of-the-linked-list)
+ [Palindrome Linked List](#palindrome-linked-list)


## Reverse Linked List

https://leetcode.com/problems/reverse-linked-list/

<details><summary>Test Cases</summary>

```java
import org.junit.jupiter.api.Assertions;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {
    private Solution sol;

    @BeforeEach
    void setSolution() {
        sol = new Solution();
    }

    @Test
    void testReverseLinkedList(){
        ListNode expected = buildLinkedList(List.of(-1, 0, 1, 2, 3));
        sol = sol.reverseList(buildLinkedList(List.of(3, 2, 1, 0, -1)));
        assertEquals(expected, sol);
    }
    
    @Test
    void testNullHead(){
        ListNode head = null;
        assertEquals(null, sol.reverseList(head));
    }
    
    private ListNode buildLinkedList(List<Integer> src){
        ListNode node = null;
        ListNode prev = null;
        for (int i = src.size() - 1; i >= 0; i--) {
            node = new ListNode(src.get(i), prev);
            prev = node;
        }
        return node;
    }
}
```

```java
import java.util.Objects;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode listNode = (ListNode) o;
        return val == listNode.val && Objects.equals(next, listNode.next);
    }
}
```

</details>

```java
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode nxt;
        ListNode prev = null;

        while (head != null) {
            nxt = head.next;
            head.next = prev;
            prev = head;
            head = nxt;
        }
        return prev;
    }
}
```


## Middle of the Linked List

https://leetcode.com/problems/middle-of-the-linked-list/

<details><summary>Test Cases</summary>

```java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest{
    private Solution sol;
    
    @BeforeEach
    void setSolution(){
        sol = new Solution();
    }
    
    @Test
    void testNullHead(){
        assertNull(sol.middleNode(null));
    }
    
    @Test
    void testMiddleNode(){
        ListNode expected = buildLinkedList(List.of(3, 4, 5));
        ListNode lst = buildLinkedList(List.of(1, 2, 3, 4, 5));
        assertEquals(expected, sol.middleNode(lst));
    }
    
    @Test
    void testDoubleMidNodes(){
        ListNode expected = buildLinkedList(List.of(3, 4));
        ListNode lst = buildLinkedList(List.of(1, 2, 3, 4));
        assertEquals(expected, sol.middleNode(lst));
    }
    
    private ListNode buildLinkedList(List<Integer> src){
        ListNode node = null;
        ListNode prev = null;
        for (int i = source.size() - 1; i >= 0; i--) {
            node = new ListNode(source.get(i), prev);
            prev = node;
        }
        return node;
    }
}
```

``` java
import java.util.Objects;

public class ListNode {
    int val;
    ListNode next;
    
    ListNode(int val) { 
        this.val = val;
    }
    
    ListNode(int val, ListNode next) { 
        this.val = val;
        this.next = next;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode listNode = (ListNode) o;
        return val == listNode.val && Objects.equals(next, listNode.next);
    }
}
```

</details>


```java
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slw = head;
        ListNode tmp = head;

        while (tmp != null && tmp.next != null) {
            slw = slw.next;
            tmp = tmp.next.next;
        }
        return slw;
    }
}
```


## Palindrome Linked List

https://leetcode.com/problems/palindrome-linked-list/

<details><summary>Test Cases</summary>

```java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest{
    private Solution sol;
    
    @BeforeEach
    void setSolution(){
        sol = new Solution();
    }
    
    @Test
    void testEmptyList(){
        assertTrue(sol.isPalindrome(buildLinkedList(List.of())));
    }
    
    @Test
    void testIsPalindrome(){
        ListNode lst = buildLinkedList(List.of(1, 2, 3, 2, 1));
        assertTrue(sol.isPalindrome(lst));
    }
    
    @Test
    void testIsNotPalindrome(){
        ListNode lst = buildLinkedList(List.of(1, 2, 3, 2, 2));
        assertFalse(sol.isPalindrome(lst));
    }
    
    private ListNode buildLinkedList(List<Integer> src){
        ListNode node = null;
        ListNode prev = null;
        for (int i = source.size() - 1; i >= 0; i--) {
            node = new ListNode(source.get(i), prev);
            prev = node;
        }
        return node;
    }
}
```

``` java
import java.util.Objects;
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode listNode = (ListNode) o;
        return val == listNode.val && Objects.equals(next, listNode.next);
    }
}
```

</details>


```java
class Solution {
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    private ListNode middleNode(ListNode head) {
        ListNode slw = head;
        ListNode tmp = head;

        while (tmp != null && tmp.next != null) {
            slw = slw.next;
            tmp = tmp.next.next;
        }
        return slw;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode input = head;
        ListNode reversed = reverse(middleNode(head));
        while (reversed != null) {
            if (input.val != reversed.val)
                return false;
            input = input.next;
            reversed = reversed.next;
        }
        return true;
    }
}
```