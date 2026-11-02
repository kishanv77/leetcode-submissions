# Merge Sort Using Recursion

## 1. What Is Merge Sort?

Merge Sort is a sorting algorithm based on the **Divide and Conquer** technique.

It divides an array into smaller subarrays, recursively sorts them, and then merges the sorted subarrays to produce one final sorted array.

**Main idea:**
1. Divide the array into two halves.
2. Recursively divide each half until every subarray contains only one element.
3. Merge the smaller sorted subarrays into larger sorted subarrays.
4. Continue merging until the entire array becomes sorted.

## 2. Example

**Input:**

`[38, 27, 43, 3, 9, 82, 10]`

**Expected Output:**

`[3, 9, 10, 27, 38, 43, 82]`

## 3. Divide and Conquer Approach

Merge Sort works in three steps:

- **Divide:** Split the array into two halves.
- **Conquer:** Recursively sort both halves.
- **Combine:** Merge the two sorted halves.

### Step 1: Divide the Array

Initially, divide the array into two halves.

`[38, 27, 43, 3, 9, 82, 10]`

First division:

- Left: `[38, 27, 43, 3]`
- Right: `[9, 82, 10]`

Continue dividing until each subarray contains only one element.

```text
                [38, 27, 43, 3, 9, 82, 10]
                         /       \
              [38, 27, 43, 3]   [9, 82, 10]
                  /     \         /     \
             [38, 27]  [43, 3]  [9, 82]  [10]
              /  \      /  \     /  \
            [38][27]  [43][3]  [9][82] [10]
```

A single-element array is already sorted. Therefore, recursion stops when the subarray contains one or zero elements.

### Step 2: Merge the Smaller Arrays

After dividing, start merging the subarrays in sorted order.

First level:

- `[38]` and `[27]` → `[27, 38]`
- `[43]` and `[3]` → `[3, 43]`
- `[9]` and `[82]` → `[9, 82]`
- `[10]` remains unchanged.

Second level:

- `[27, 38]` and `[3, 43]` → `[3, 27, 38, 43]`
- `[9, 82]` and `[10]` → `[9, 10, 82]`

Final merge:

- `[3, 27, 38, 43]` and `[9, 10, 82]`
- Result: `[3, 9, 10, 27, 38, 43, 82]`

## 4. Understanding the Recursive Logic

The recursive sorting operation works on a specific portion of the array.

It uses three important values:

| Parameter | Purpose |
|---|---|
| `arr` | Original array |
| `left` | Starting index of the portion being sorted |
| `right` | Ending index of the portion being sorted |

### A. Base Condition

The recursion stops when:

`left >= right`

This means the current portion contains either one element or no elements.

A single-element array is already sorted, so no further division is required.

The base condition prevents infinite recursion.

### B. Calculate the Middle Index

The middle index divides the current portion into two halves.

`mid = left + (right - left) / 2`

This formula is preferred over `(left + right) / 2` because it avoids possible integer overflow when indices are very large.

### C. Recursive Call for the Left Half

The left half contains elements from index `left` to `mid`.

Recursively divide this portion until it contains only single-element subarrays.

### D. Recursive Call for the Right Half

The right half contains elements from index `mid + 1` to `right`.

Recursively divide this portion in the same way.

### E. Merge Both Halves

Once both recursive calls finish, the left and right portions are sorted.

Now merge them into one sorted portion.

**Important:** Recursion divides the array, while the merge operation performs the actual sorting.

## 5. Understanding the Merge Operation

The merge operation combines two already sorted portions of the original array.

It receives:

- Original array
- Starting index: `left`
- Middle index: `mid`
- Ending index: `right`

The two sorted portions are:

- Left portion: `left` to `mid`
- Right portion: `mid + 1` to `right`

### A. Create Temporary Arrays

Create two temporary arrays:

- `leftArr` stores the left portion.
- `rightArr` stores the right portion.

Their sizes are:

- `n1 = mid - left + 1`
- `n2 = right - mid`

The `+1` is required because the starting and ending indices are inclusive.

### B. Copy Elements into Temporary Arrays

Copy the elements from the original array into the corresponding temporary arrays.

This is important because the original array will be overwritten during the merging process.

Temporary arrays preserve the values that still need to be compared.

### C. Initialize Three Pointers

Three pointers are used during merging.

| Pointer | Purpose |
|---|---|
| `i` | Tracks the current position in the left temporary array |
| `j` | Tracks the current position in the right temporary array |
| `k` | Tracks the position where the next merged element should be placed in the original array |

Initially:

- `i = 0`
- `j = 0`
- `k = left`

Notice that `k` starts at `left`, not zero, because we may be merging only a portion of the original array.

### D. Compare and Merge

Compare the current elements of the two temporary arrays.

1. If the left element is smaller than or equal to the right element, place the left element into the original array.
2. Otherwise, place the right element into the original array.
3. Move the pointer of the array from which the element was selected.
4. Move the original-array pointer forward.
5. Continue until one of the temporary arrays is exhausted.

Using the smaller element first ensures that the merged portion remains sorted.

### E. Copy Remaining Elements

After the main comparison loop, one temporary array may still contain elements.

Copy all remaining elements into the original array.

No additional comparisons are needed because the remaining elements are already sorted.

## 6. Why Do We Use Temporary Arrays?

During merging, elements in the original array are overwritten.

If we directly overwrite elements without preserving their original values, we may lose data that is still required for comparison.

Temporary arrays preserve both sorted portions while the original array is updated.

## 7. Why Does Merge Sort Have O(n log n) Time Complexity?

Suppose the original array contains `n` elements.

### A. Number of Division Levels

Every division splits the array into approximately two halves.

The number of times an array can be divided by two is approximately:

`log₂(n)`

Therefore, the recursion has `O(log n)` levels.

### B. Work at Each Level

At every level, the merge operations together process all `n` elements.

Therefore, the total work at each level is `O(n)`.

### C. Total Time Complexity

Number of levels × Work per level:

`O(log n) × O(n) = O(n log n)`

## 8. Complexity Analysis

| Case | Time Complexity |
|---|---|
| Best Case | `O(n log n)` |
| Average Case | `O(n log n)` |
| Worst Case | `O(n log n)` |

**Auxiliary Space Complexity:** `O(n)`

The temporary arrays used during merging require linear space. The recursion stack uses `O(log n)` additional space.

Overall auxiliary space complexity remains `O(n)`.

## 9. Is Merge Sort Stable?

Yes. The standard Merge Sort implementation is stable when equal elements from the left half are selected before equal elements from the right half.

This is achieved by choosing the left element when both elements are equal.

A stable sorting algorithm preserves the relative order of equal elements.

## 10. Merge Sort — Important Points to Remember

- Merge Sort follows the Divide and Conquer technique.
- Recursion divides the array into smaller portions.
- The base condition is reached when a portion contains one or zero elements.
- The middle index separates the left and right portions.
- The merge operation combines two sorted portions.
- Temporary arrays preserve elements during merging.
- Three pointers are used during the merge operation.
- Remaining elements must be copied after the main comparison loop.
- Time complexity is `O(n log n)` in all cases.
- Auxiliary space complexity is `O(n)`.
- Merge Sort is stable when equal elements from the left half are selected first.

## 11. Quick Revision

| Concept | Explanation |
|---|---|
| Algorithm | Merge Sort |
| Technique | Divide and Conquer |
| Main Operations | Divide, Recursively Sort, Merge |
| Base Condition | `left >= right` |
| Middle Index | `left + (right - left) / 2` |
| Number of Recursion Levels | `O(log n)` |
| Work Per Level | `O(n)` |
| Best Time | `O(n log n)` |
| Average Time | `O(n log n)` |
| Worst Time | `O(n log n)` |
| Auxiliary Space | `O(n)` |
| Stable | Yes |

## 12. Practice Checklist

- [ ] I understand the Divide and Conquer approach.
- [ ] I understand how the array is divided recursively.
- [ ] I understand why the base condition is necessary.
- [ ] I can calculate the middle index.
- [ ] I understand the difference between the left and right recursive calls.
- [ ] I understand when the merge operation is executed.
- [ ] I understand why temporary arrays are required.
- [ ] I understand the roles of `i`, `j`, and `k`.
- [ ] I understand how elements are compared and merged.
- [ ] I understand why remaining elements must be copied.
- [ ] I can explain the time complexity of `O(n log n)`.
- [ ] I can explain the auxiliary space complexity of `O(n)`.

**Practice Tip:** Try implementing recursive Merge Sort from scratch without referring to a solution. Focus on understanding how the recursive calls divide the array and how the merge operation combines the sorted portions.
