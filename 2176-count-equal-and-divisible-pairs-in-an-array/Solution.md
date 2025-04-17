# Notes 📝

---

### ✅ **Code:**

```java
class Solution {
    public int countPairs(int[] nums, int k) {
        int count = 0;  // This variable will keep track of valid pairs
        
        // Loop through each element in the array (excluding the last)
        for (int i = 0; i < nums.length - 1; i++) {
            
            // Loop through all elements after index i
            for (int j = i + 1; j < nums.length; j++) {
                
                // Check all 3 conditions:
                // 1. i < j (already guaranteed by the loop)
                // 2. nums[i] == nums[j] → the values at i and j are equal
                // 3. (i * j) % k == 0 → the product of indices is divisible by k
                if (i < j && nums[i] == nums[j] && (i * j) % k == 0) {
                    count++;  // Valid pair found, increment count
                }
            }
        }

        return count;  // Return total number of valid pairs
    }
}
```

---

### 📝 **Key Notes:**

- **Time Complexity:**  
  - `O(n^2)` because of the nested loops (n is the length of the `nums` array).
  - This is okay since the input size is small (n ≤ 100).

- **Why `i < j` is included in the `if` condition even though the loops guarantee it?**  
  - It's technically redundant here because `j` always starts at `i + 1`, but it ensures clarity and extra safety.

- **Main Conditions Being Checked:**
  1. **Same Value:** `nums[i] == nums[j]`
  2. **Index Product Divisible by k:** `(i * j) % k == 0`

- **When all conditions are true:**  
  We found a valid pair → `count++`

---
