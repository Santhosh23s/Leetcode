<h2><a href="https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/?envType=problem-list-v2&envId=hash-table">1365. How Many Numbers Are Smaller Than the Current Number</a></h2><h3>Easy</h3><hr><p>Given the array <code>nums</code>, for each <code>nums[i]</code> find out how many numbers in the array are smaller than it. That is, for each <code>nums[i]</code> you have to count the number of valid <code>j&#39;s</code>&nbsp;such that&nbsp;<code>j != i</code> <strong>and</strong> <code>nums[j] &lt; nums[i]</code>.</p>

<p>Return the answer in an array.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [8,1,2,2,3]
<strong>Output:</strong> [4,0,1,1,3]
<strong>Explanation:</strong> 
For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3). 
For nums[1]=1 does not exist any smaller number than it.
For nums[2]=2 there exist one smaller number than it (1). 
For nums[3]=2 there exist one smaller number than it (1). 
For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [6,5,4,8]
<strong>Output:</strong> [2,1,0,3]
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> nums = [7,7,7,7]
<strong>Output:</strong> [0,0,0,0]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= nums.length &lt;= 500</code></li>
	<li><code>0 &lt;= nums[i] &lt;= 100</code></li>
</ul>

---

# Notes📝
---

---

### ✅ **Code Explanation with Notes**

```java
class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;           // Get the length of the input array
        int[] arr = new int[n];        // Create a new array to store the result
        
        for(int i = 0; i < n; i++) {   // Outer loop to pick each element one by one
            int count = 0;             // Initialize a counter for each nums[i]
            
            for(int j = 0; j < n; j++) {      // Inner loop to compare nums[i] with every nums[j]
                if(nums[i] > nums[j]) {       // If current number is greater than another number
                    count += 1;               // Increase the count
                }
            }
            
            arr[i] = count;           // Store the count of smaller numbers in the result array
        }
        
        return arr;                   // Return the result array
    }
}
```

### 📝 **Summary:**

- This code uses a **brute force approach** (nested loops) to compare each number with all other numbers.
- Time Complexity is **O(n²)** due to the nested loop.
- For each number in `nums`, it counts how many other numbers are smaller than it.
- The count is stored in the same index in a new result array `arr`.

---
