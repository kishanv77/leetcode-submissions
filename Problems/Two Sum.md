# Two Sum

**Topic:** Arrays, HashMap  
**Difficulty:** Easy  
**Commonly Asked In:** Coding interviews

## 1. Problem Statement

Given an array of integers `nums` and an integer `target`, return the indices of the two numbers such that they add up to `target`.

You may assume that each input has exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

### Example 1

**Input:**
```text
nums = [2, 7, 11, 15]
target = 9
```

**Output:**
```text
[0, 1]
```

**Explanation:**

`nums[0] + nums[1] = 2 + 7 = 9`

Therefore, the answer is `[0, 1]`.

### Example 2

**Input:**
```text
nums = [3, 2, 4]
target = 6
```

**Output:**
```text
[1, 2]
```

**Explanation:**

`nums[1] + nums[2] = 2 + 4 = 6`

### Example 3

**Input:**
```text
nums = [3, 3]
target = 6
```

**Output:**
```text
[0, 1]
```

**Explanation:**

`nums[0] + nums[1] = 3 + 3 = 6`

---

## 2. Approach 1: Brute Force

### Idea

Use two nested loops to check every possible pair of elements.

If the sum of two elements equals the target, return their indices.

### Java Solution

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{};
    }
}
```

### Complexity Analysis

- **Time Complexity:** `O(n²)` — Two nested loops examine possible pairs.
- **Space Complexity:** `O(1)` — Constant extra space, excluding the returned array.

---

## 3. Approach 2: Optimized Using HashMap

### Idea

Instead of checking every pair, use a `HashMap` to store previously visited numbers and their indices.

For every element, calculate its complement:

```text
complement = target - nums[i]
```

The complement is the number needed to reach the target.

Check whether the complement already exists in the map.

- If it exists, return the stored index of the complement and the current index.
- If it doesn't exist, store the current number and its index in the map.

### Java Solution

```java
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            map.put(nums[i], i);
        }

        return new int[]{};
    }
}
```

---

## 4. Dry Run

Consider the following input:

```text
nums = [2, 7, 11, 15]
target = 9
```

Initially, the map is empty.

| Iteration | Index `i` | `nums[i]` | Complement (`target - nums[i]`) | Map Before Check | Action |
|---|---:|---:|---:|---|---|
| 1 | 0 | 2 | 7 | `{}` | 7 not found; store `2 → 0` |
| 2 | 1 | 7 | 2 | `{2=0}` | 2 found; return `[0, 1]` |

**Final Output:**

```text
[0, 1]
```

### Step-by-Step Explanation

**Iteration 1:**

```java
int complement = 9 - 2; // 7
```

The map does not contain `7`, so store the current number and its index:

```java
map.put(2, 0);
```

The map now contains:

```text
{2=0}
```

**Iteration 2:**

```java
int complement = 9 - 7; // 2
```

The map contains `2`, so retrieve its index:

```java
map.get(2); // Returns 0
```

The current index is `1`.

Return the result:

```java
return new int[]{map.get(complement), i};
```

The returned array is:

```text
[0, 1]
```

---

## 5. Understanding Important HashMap Methods

### `map.put(key, value)`

Stores a key-value pair in the map.

```java
map.put(nums[i], i);
```

For example:

```java
map.put(2, 0);
```

The map stores the number `2` as the key and its index `0` as the value.

### `map.containsKey(complement)`

Checks whether the specified key exists in the map.

```java
if (map.containsKey(complement))
```

Returns `true` if the key exists; otherwise, returns `false`.

### `map.get(complement)`

Retrieves the value associated with the specified key.

```java
map.get(complement)
```

For example:

```java
map.put(2, 0);
System.out.println(map.get(2));
```

Output:

```text
0
```

Here, `2` is the key and `0` is the stored index.

### `map.getOrDefault(key, defaultValue)`

Returns the value associated with the key if it exists. Otherwise, returns the specified default value.

```java
map.getOrDefault(complement, -1)
```

For example, if the map does not contain `7`:

```java
map.getOrDefault(7, -1); // Returns -1
```

**Note:** `map.get(complement, i)` is not a standard Java `Map` method. The method for retrieving a value with a fallback is `map.getOrDefault(complement, i)`.

---

## 6. Why Check Before Inserting?

Consider this input:

```text
nums = [3, 3]
target = 6
```

At index `0`, the complement is `3`, but the map is empty. We store:

```text
{3=0}
```

At index `1`, the complement is `3`. The map already contains this key, so we return:

```text
[0, 1]
```

Checking before inserting ensures that we use a previously visited element rather than the same element twice.

It also allows duplicate values to work correctly.

---

## 7. Complexity Analysis

Let `n` be the number of elements in the array.

| Approach | Time Complexity | Auxiliary Space Complexity |
|---|---|---|
| Brute Force | `O(n²)` | `O(1)` |
| HashMap | `O(n)` average | `O(n)` |

The HashMap approach is generally preferred because it reduces the average time complexity from quadratic to linear.

---

## 8. Key Takeaways

- Use a HashMap to store numbers and their indices.
- Calculate the complement using `target - nums[i]`.
- Check whether the complement exists before inserting the current element.
- Use `map.get(complement)` to retrieve the previously stored index.
- Return the indices using `new int[]{map.get(complement), i}`.
- The HashMap approach achieves `O(n)` average time complexity.
- Checking before insertion prevents using the same array element twice.

---

## 9. Interview Pattern

The Two Sum problem teaches an important problem-solving pattern:

**Find the required value → Check whether it has already been seen → Return the result or store the current value.**

This pattern is useful in problems involving:
- Finding pairs with a target sum.
- Detecting duplicates.
- Finding complements.
- Counting frequencies.
- Looking up previously visited elements efficiently.
