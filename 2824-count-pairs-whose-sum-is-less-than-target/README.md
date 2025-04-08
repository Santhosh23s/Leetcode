<h2><a href="https://leetcode.com/problems/count-pairs-whose-sum-is-less-than-target/?envType=problem-list-v2&envId=sorting">2824. Count Pairs Whose Sum is Less than Target</a></h2><h3>Easy</h3><hr>Given a <strong>0-indexed</strong> integer array <code>nums</code> of length <code>n</code> and an integer <code>target</code>, return <em>the number of pairs</em> <code>(i, j)</code> <em>where</em> <code>0 &lt;= i &lt; j &lt; n</code> <em>and</em> <code>nums[i] + nums[j] &lt; target</code>.
<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [-1,1,2,3,1], target = 2
<strong>Output:</strong> 3
<strong>Explanation:</strong> There are 3 pairs of indices that satisfy the conditions in the statement:
- (0, 1) since 0 &lt; 1 and nums[0] + nums[1] = 0 &lt; target
- (0, 2) since 0 &lt; 2 and nums[0] + nums[2] = 1 &lt; target 
- (0, 4) since 0 &lt; 4 and nums[0] + nums[4] = 0 &lt; target
Note that (0, 3) is not counted since nums[0] + nums[3] is not strictly less than the target.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [-6,2,5,-2,-7,-1,3], target = -2
<strong>Output:</strong> 10
<strong>Explanation:</strong> There are 10 pairs of indices that satisfy the conditions in the statement:
- (0, 1) since 0 &lt; 1 and nums[0] + nums[1] = -4 &lt; target
- (0, 3) since 0 &lt; 3 and nums[0] + nums[3] = -8 &lt; target
- (0, 4) since 0 &lt; 4 and nums[0] + nums[4] = -13 &lt; target
- (0, 5) since 0 &lt; 5 and nums[0] + nums[5] = -7 &lt; target
- (0, 6) since 0 &lt; 6 and nums[0] + nums[6] = -3 &lt; target
- (1, 4) since 1 &lt; 4 and nums[1] + nums[4] = -5 &lt; target
- (3, 4) since 3 &lt; 4 and nums[3] + nums[4] = -9 &lt; target
- (3, 5) since 3 &lt; 5 and nums[3] + nums[5] = -3 &lt; target
- (4, 5) since 4 &lt; 5 and nums[4] + nums[5] = -8 &lt; target
- (4, 6) since 4 &lt; 6 and nums[4] + nums[6] = -4 &lt; target
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length == n &lt;= 50</code></li>
	<li><code>-50 &lt;= nums[i], target &lt;= 50</code></li>
</ul>

---
Sure! Here's a clear and beginner-friendly explanation of the code in note format. These notes are great to include in your GitHub repo alongside the code to help others (or future you!) understand what's going on.

---

## ✅ Notes: Count Number of Pairs With Sum Less Than Target

### 💡 Problem Statement (Simplified)
We are given:
- A list of integers `nums`
- A number `target`

We need to count how many **pairs of indices (i, j)** satisfy these conditions:
1. `i < j` (i comes before j)
2. `nums[i] + nums[j] < target`

---

### 🔍 Example:
If `nums = [-1, 1, 2, 3, 1]` and `target = 2`  
Valid pairs:
- (-1 + 1) = 0 ✔
- (-1 + 2) = 1 ✔
- (-1 + 1) = 0 ✔  
So, the answer is **3**.

---

### 🧠 Logic Behind the Code
- We go through all possible pairs of numbers in the list.
- For each pair `(i, j)` where `i < j`, we check if the sum is less than the target.
- If yes, we increase our counter (`result`).

---

### 🔁 How the Code Works
```java
for (int i = 0; i < n; i++) {
    for (int j = i + 1; j < n; j++) {
        if (nums.get(i) + nums.get(j) < target) {
            result++;
        }
    }
}
```

- Outer loop picks the first number.
- Inner loop picks the second number (always after the first).
- We check if their sum is less than the target and count it.

---

### 🧮 Time & Space Complexity
- **Time Complexity:** O(n²)  
  Because we're checking every pair of numbers.
- **Space Complexity:** O(1)  
  We're not using any extra space—just a counter.

---

### 🧼 Code Style Tips
- `j = i + 1` is used to make sure we only count each pair once and maintain `i < j`.
- Using `List<Integer>` makes the code compatible with Java's List interface (like `ArrayList`).

---

