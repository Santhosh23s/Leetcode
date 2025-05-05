Here are **clear and concise notes** explaining the Java solution for LeetCode Problem 35: **Search Insert Position**.

---

### 📌 **Purpose of the Code**

This method searches for a `target` value in a sorted array `nums`. If the target is found, it returns the index.
If not, it returns the index where the target should be **inserted** to keep the array sorted.

---

### 🧠 **Concept Used: Binary Search**

* **Why?** The array is **sorted** — binary search reduces time complexity from O(n) to **O(log n)**.
* **How?** Repeatedly divide the search range in half until the target is found or the insert position is located.

---

### 📘 **Line-by-Line Explanation**

```java
class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
```

* Start the binary search with the full array (`left` at 0, `right` at end of array).

---

```java
        while (left <= right) {
            int mid = left + (right - left) / 2;
```

* Keep looping until search space is exhausted.
* `mid` is the middle index. This formula avoids overflow better than `(left + right) / 2`.

---

```java
            if (nums[mid] == target) {
                return mid; // Found the target
            } else if (nums[mid] < target) {
                left = mid + 1; // Look in the right half
            } else {
                right = mid - 1; // Look in the left half
            }
```

* **If equal**: return index `mid`.
* **If mid value is too small**: search the right half.
* **If mid value is too big**: search the left half.

---

```java
        return left; // Target not found: return insert position
    }
}
```

* If the loop ends, `left` is the position where the target should be inserted to keep the array sorted.

---

### 🧪 **Examples**

For `nums = [1, 3, 5, 6]`:

* `target = 5` → returns `2` (found at index 2)
* `target = 2` → returns `1` (insert before 3)
* `target = 7` → returns `4` (insert at end)

---

### ✅ **Time & Space Complexity**

* **Time:** O(log n) — efficient due to binary search
* **Space:** O(1) — no extra memory used

---

