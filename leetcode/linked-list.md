# Linked List

+ [Reverse Linked List](#reverse-linked-list)


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