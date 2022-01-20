# Linked List

+ [Reverse Linked List](#reverse-linked-list)
+ [Middle of the Linked List](#middle-of-the-linked-list)
+ [Palindrome Linked List](#palindrome-linked-list)
+ [Merge Two Sorted Lists](#merge-two-sorted-lists)
+ [Intersection of Two Linked Lists](#intersection-of-two-linked-lists)
+ [Sort List](#sort-list)

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


## Merge Two Sorted Lists


https://leetcode.com/problems/merge-two-sorted-lists/

<details><summary>Test Cases</summary>

```java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.converter.ConvertWith;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    private Solution sol;

    @BeforeEach
    void setSolution() {
        sol = new Solution();
    }

    @Test
    void testMergeOneList() {
        ListNode lst = buildLinkedList(List.of(1, 3, 5));
        ListNode expected = buildLinkedList(List.of(1, 3, 5));
        assertEquals(expected, sol.mergeTwoLists(null, list));
    }

    @Test
    void testMergeTwoListsDifferentLength() {
        ListNode lst_1 = buildLinkedList(List.of(1, 2));
        ListNode lst_2 = buildLinkedList(List.of(1, 3, 5));
        ListNode expected = buildLinkedList(List.of(1, 1, 2, 3, 5));
        assertEquals(expected, sol.mergeTwoLists(lst_1, lst_2));
    }

    @Test
    void testMergeTwoListsSameLength() {
        ListNode lst_1 = buildLinkedList(List.of(1, 3, 5));
        ListNode lst_2 = buildLinkedList(List.of(2, 4, 6));
        ListNode expected = buildLinkedList(List.of(1, 2, 3, 4, 5, 6));
        assertEquals(expected, sol.mergeTwoLists(lst_1, lst_2));
    }

    @Test
    void testMergeEquals(){
        ListNode lst_1 = buildLinkedList(List.of(1, 2));
        ListNode lst_2 = buildLinkedList(List.of(1, 2));
        ListNode expected = buildLinkedList(List.of(1, 1, 2, 2));
        assertEquals(expected, sol.mergeTwoLists(lst_1, lst_2));
    }

    private ListNode buildLinkedList(List<Integer> source) {
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode new_lst = new ListNode();
        ListNode res = new_lst;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                new_lst.next = list1;
                list1 = list1.next;
            } else {
                new_lst.next = list2;
                list2 = list2.next;
            }
            new_lst = new_lst.next;
        }

        if (list1 == null) {
            new_lst.next = list2;
        }

        if (list2 == null) {
            new_lst.next = list1;
        }

        return res.next;
    }
}
```


## Intersection of Two Linked Lists

https://leetcode.com/problems/intersection-of-two-linked-lists/

<details><summary>Test Cases</summary>

```java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.converter.ConvertWith;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
private Solution sol;

    @BeforeEach
    void setSolution() {
        sol = new Solution();
    }

    @Test
    void testGetEmptyIntersection() {
        ListNode headA = buildLinkedList(List.of(1, 3, 5, 7));
        ListNode headB = buildLinkedList(List.of(2, 4, 6, 8));
        assertEquals(null, sol.getIntersectionNode(headA, headB));
    }

    @Test
    void testGetNonEmptyIntersection() {
        ListNode headA = buildLinkedList(List.of(1, 2, 4));
        ListNode headB = buildLinkedList(List.of(3, 5, 6, 4));
        assertEquals(4, sol.getIntersectionNode(headA, headB));
    }
    

    private ListNode buildLinkedList(List<Integer> source) {
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
    private int getLength(ListNode list) {
        int lenList = 0;
        while (list != null) {
            lenList += 1;
            list = list.next;
        }
        return lenList;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int lenA = getLength(headA);
        int lenB = getLength(headB);

        if (lenA < lenB) {
            while (lenA != lenB) {
                headB = headB.next;
                lenB -= 1;
            }
        }

        if (lenB < lenA) {
            while (lenA != lenB) {
                headA = headA.next;
                lenA -= 1;
            }
        }

        while (headA != null || headB != null) {
            if (headA == headB) {
                return headA;
            } else {
                assert headA != null;
                headA = headA.next;
                headB = headB.next;
            }
        }
        return null;
    }
}
```


## Sort List

https://leetcode.com/problems/sort-list/

<details><summary>Test Cases</summary>

```java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.converter.ConvertWith;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    private Solution sol;

    @BeforeEach
    void setSolution() {
        sol = new Solution();
    }

    @Test
    void testSortEmptyList() {
        assertEquals(null, sol.sortList(null));
    }

    @Test
    void testSortEquals() {
        ListNode expected = buildLinkedList(List.of(1, 2, 3));
        ListNode lst = buildLinkedList(List.of(1, 2, 3));
        assertEquals(expected, sol.sortList(lst));
    }

    @Test
    void testSortList() {
        ListNode expected = buildLinkedList(List.of(-2, 0, 1, 4, 6));
        ListNode lst = buildLinkedList(List.of(6, 4, 1, -2, 0));
        assertEquals(expected, sol.sortList(lst));
    }


    private ListNode buildLinkedList(List<Integer> source) {
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
    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode prev = null, slow = head, fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        assert prev != null;
        prev.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        return merge(l1, l2);
    }

    public ListNode merge(ListNode list1, ListNode list2) {
        ListNode new_lst = new ListNode();
        ListNode res = new_lst;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                new_lst.next = list1;
                list1 = list1.next;

            } else {
                new_lst.next = list2;
                list2 = list2.next;
            }
            new_lst = new_lst.next;
        }

        if (list1 == null) {
            new_lst.next = list2;
        }

        if (list2 == null) {
            new_lst.next = list1;
        }

        return res.next;
    }
}
```