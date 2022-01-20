# array.md

+ [Squares of a Sorted Array](#squares-of-a-sorted-array)

## Squares of a Sorted Array

https://leetcode.com/problems/squares-of-a-sorted-array/

<details><summary>Test Cases</summary>

```java
import org.junit.jupiter.api.Test;
import java.util.Arrays;

class SolutionTest {

    @Test
    void testSortedSquares() {
        int[] arr = new int[]{-3, -2, -1, 0, 1, 2, 3};
        int[] expected = new int[]{0, 1, 1, 4, 4, 9, 9};
        Arrays.equals(expected, arr);
    }

    @Test
    void testNotEquals() {
        int arr = new int[]{-1, -1, 0, 2, 2};
        int expected = new int[]{1, 1, 0, 4, 4};
        Arrays.equals(expected, arr);
    }
}
```
</details>

```java
class Solution {
    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] *= nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
}
```