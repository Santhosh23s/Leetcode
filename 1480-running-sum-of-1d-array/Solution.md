# Notes📝
---

### ✅ Java Code:

```java
class Solution {
    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i - 1] + nums[i];
        }
        return nums;
    }
}
```

---

### 🔍 What does this code do?

This method calculates the **running sum** of an integer array.
The running sum means that each element at index `i` is updated to be the sum of all elements from index `0` to `i`.

---

### 🧠 Step-by-Step Workflow (Example: `nums = [1, 2, 3, 4]`)

Initial array:

```
Index:   0   1   2   3
Value:   1   2   3   4
```

Now, the loop starts from `i = 1` (because the first element is already part of the sum):

---

#### ▶ i = 1

```
nums[1] = nums[0] + nums[1] → 1 + 2 = 3
nums = [1, 3, 3, 4]
```

---

#### ▶ i = 2

```
nums[2] = nums[1] + nums[2] → 3 + 3 = 6
nums = [1, 3, 6, 4]
```

---

#### ▶ i = 3

```
nums[3] = nums[2] + nums[3] → 6 + 4 = 10
nums = [1, 3, 6, 10]
```

---

### ✅ Final Result:

```java
[1, 3, 6, 10]
```

---

### 📌 Summary:

* The loop updates each index with the sum of all previous values.
* It modifies the array **in-place** (without using extra memory).
* Time Complexity: `O(n)`
* Space Complexity: `O(1)` (in-place)

