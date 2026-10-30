# LeetCode 88: Merge Sorted Array

**Difficulty:** Easy  
**Topics:** Arrays, Two Pointers, Sorting  
**Problem Link:** [Merge Sorted Array — LeetCode](https://leetcode.com/problems/merge-sorted-array/)

## Problem Statement

You are given two integer arrays, `nums1` and `nums2`, sorted in non-decreasing order, and two integers, `m` and `n`, representing the number of elements in `nums1` and `nums2`, respectively.

Merge `nums2` into `nums1` as one sorted array.

The merged array must be stored inside `nums1`. You must not return the merged array as the result.

`nums1` has a length of `m + n`, where the first `m` elements are the elements to merge and the last `n` elements are set to `0` and should be ignored. `nums2` has a length of `n`.

## Examples

### Example 1

**Input:**
```text
nums1 = [1,2,3,0,0,0]
m = 3
nums2 = [2,5,6]
n = 3
```

**Output:**
```text
[1,2,2,3,5,6]
```

**Explanation:**  
The arrays `[1,2,3]` and `[2,5,6]` are merged into one sorted array: `[1,2,2,3,5,6]`.

### Example 2

**Input:**
```text
nums1 = [1]
m = 1
nums2 = []
n = 0
```

**Output:**
```text
[1]
```

**Explanation:**  
There are no elements to merge from `nums2`, so `nums1` remains unchanged.

### Example 3

**Input:**
```text
nums1 = [0]
m = 0
nums2 = [1]
n = 1
```

**Output:**
```text
[1]
```

**Explanation:**  
`nums1` has no valid elements initially. Its zero is just an empty placeholder.

## Constraints

- `nums1.length == m + n`
- `nums2.length == n`
- `0 <= m, n <= 200`
- `1 <= m + n <= 200`
- `-10^9 <= nums1[i], nums2[j] <= 10^9`

Both arrays are sorted in non-decreasing order.

## Approach: Three Pointers

Instead of creating a new array or shifting elements, we can merge the arrays **from right to left**.

### Why start from the end?

`nums1` already contains its valid elements at the beginning and has extra space at the end.

If we start merging from the beginning, we may overwrite elements in `nums1` that we haven't processed yet.

Starting from the end avoids this problem.

### Pointer initialization

Use three pointers:

- `i = m - 1`: Points to the last valid element of `nums1`.
- `j = n - 1`: Points to the last element of `nums2`.
- `k = m + n - 1`: Points to the last position of `nums1`, where the next largest element will be placed.

### Algorithm

1. Compare `nums1[i]` and `nums2[j]`.
2. Place the larger element at `nums1[k]`.
3. Move the corresponding pointer backward.
4. Move `k` backward after each placement.
5. Continue while elements remain in `nums2`.

We only need to check whether `j >= 0` because any remaining elements in `nums1` are already in their correct positions.

## Java Solution

```java
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
    }
}
```

## Dry Run

**Input:**

```text
nums1 = [1, 2, 3, 0, 0, 0]
m = 3

nums2 = [2, 5, 6]
n = 3
```

Initially:

```text
i = 2
j = 2
k = 5
```

| Step | `nums1[i]` | `nums2[j]` | Action | Updated `nums1` |
|---|---:|---:|---|---|
| 1 | 3 | 6 | Place 6 at index 5 | `[1,2,3,0,0,6]` |
| 2 | 3 | 5 | Place 5 at index 4 | `[1,2,3,0,5,6]` |
| 3 | 3 | 2 | Place 3 at index 3 | `[1,2,3,3,5,6]` |
| 4 | 2 | 2 | Place 2 from `nums2` at index 2 | `[1,2,2,3,5,6]` |

Now `j = -1`, so the loop terminates.

**Final output:**

```text
[1, 2, 2, 3, 5, 6]
```

## Complexity Analysis

### Time Complexity: O(m + n)

Each element is processed at most once, so the total number of operations is proportional to the combined size of the arrays.

### Space Complexity: O(1)

The algorithm uses only three pointers and modifies `nums1` directly. It does not allocate an additional array.

## Key Takeaways

- Use the **two-pointer technique** to compare elements from sorted arrays.
- Merge from the **end toward the beginning** to avoid overwriting valid elements.
- The largest remaining element belongs at the current last available position.
- Only the remaining elements of `nums2` need to be copied.
- The solution runs in linear time and constant auxiliary space.

## Practice Questions

After solving this problem, try:

1. [Merge Two Sorted Lists — LeetCode 21](https://leetcode.com/problems/merge-two-sorted-lists/)
2. [Remove Duplicates from Sorted Array — LeetCode 26](https://leetcode.com/problems/remove-duplicates-from-sorted-array/)
3. [Squares of a Sorted Array — LeetCode 977](https://leetcode.com/problems/squares-of-a-sorted-array/)

These problems help strengthen your understanding of arrays and the two-pointer technique.
