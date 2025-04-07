<h2><a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array/?envType=problem-list-v2&envId=array">26. Remove Duplicates from Sorted Array</a></h2><h3>Easy</h3><hr><p>Given an integer array <code>nums</code> sorted in <strong>non-decreasing order</strong>, remove the duplicates <a href="https://en.wikipedia.org/wiki/In-place_algorithm" target="_blank"><strong>in-place</strong></a> such that each unique element appears only <strong>once</strong>. The <strong>relative order</strong> of the elements should be kept the <strong>same</strong>. Then return <em>the number of unique elements in </em><code>nums</code>.</p>

<p>Consider the number of unique elements of <code>nums</code> to be <code>k</code>, to get accepted, you need to do the following things:</p>

<ul>
	<li>Change the array <code>nums</code> such that the first <code>k</code> elements of <code>nums</code> contain the unique elements in the order they were present in <code>nums</code> initially. The remaining elements of <code>nums</code> are not important as well as the size of <code>nums</code>.</li>
	<li>Return <code>k</code>.</li>
</ul>

<p><strong>Custom Judge:</strong></p>

<p>The judge will test your solution with the following code:</p>

<pre>
int[] nums = [...]; // Input array
int[] expectedNums = [...]; // The expected answer with correct length

int k = removeDuplicates(nums); // Calls your implementation

assert k == expectedNums.length;
for (int i = 0; i &lt; k; i++) {
    assert nums[i] == expectedNums[i];
}
</pre>

<p>If all assertions pass, then your solution will be <strong>accepted</strong>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,1,2]
<strong>Output:</strong> 2, nums = [1,2,_]
<strong>Explanation:</strong> Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [0,0,1,1,1,2,2,3,3,4]
<strong>Output:</strong> 5, nums = [0,1,2,3,4,_,_,_,_,_]
<strong>Explanation:</strong> Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 3 * 10<sup>4</sup></code></li>
	<li><code>-100 &lt;= nums[i] &lt;= 100</code></li>
	<li><code>nums</code> is sorted in <strong>non-decreasing</strong> order.</li>
</ul>

---

<h1>NOTES</h1>


---

## ✅ Java Code:
```java
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
```

---

## 📘 **Clean Notes – Step-by-Step Explanation**

### 🔹 Step 1: Check for an empty array
```java
if (nums.length == 0) return 0;
```
- If the input array has **no elements**, there are **no unique numbers**.
- So we return `0` right away.

---

### 🔹 Step 2: Initialize pointer `i`
```java
int i = 0;
```
- `i` is the **slow pointer**.
- It tracks the **position where the next unique number should go**.
- Starts at `0` because the first element is **always unique**.

---

### 🔹 Step 3: Start looping with pointer `j`
```java
for (int j = 1; j < nums.length; j++) {
```
- `j` is the **fast pointer**.
- It goes through each element starting from the **second one** (index 1).

---

### 🔹 Step 4: Compare nums[j] with nums[i]
```java
if (nums[j] != nums[i]) {
```
- If the number at `j` is **not equal** to the number at `i`, it's a **new unique number**.

---

### 🔹 Step 5: Update unique value position
```java
i++;
nums[i] = nums[j];
```
- Move `i` forward by 1.
- Copy the new unique number at `j` into position `i`.
- This **builds a unique list at the front** of the array.

---

### 🔹 Step 6: After the loop, return the count
```java
return i + 1;
```
- The number of unique elements is `i + 1`.
- Why? Because `i` is index-based and starts from 0.

---

## 🧪 Example Walkthrough:

For input: `nums = [1, 1, 2, 3, 3]`

| Step | i | j | nums[i] | nums[j] | Action         | Resulting nums        |
|------|---|---|---------|---------|----------------|------------------------|
| Init | 0 | 1 | 1       | 1       | same → skip    | [1, 1, 2, 3, 3]        |
| Loop | 0 | 2 | 1       | 2       | new → i++, copy| [1, 2, 2, 3, 3]        |
| Loop | 1 | 3 | 2       | 3       | new → i++, copy| [1, 2, 3, 3, 3]        |
| Loop | 2 | 4 | 3       | 3       | same → skip    | [1, 2, 3, 3, 3]        |

Return `i + 1 = 3`

So the first 3 elements in `nums` are: `[1, 2, 3]`

---

## ✨ Summary:

| Part             | Meaning                                        |
|------------------|------------------------------------------------|
| `i`              | Slow pointer (tracks unique position)          |
| `j`              | Fast pointer (scans entire array)              |
| `if nums[j] != nums[i]` | Detects a new unique element           |
| `nums[i] = nums[j]` | Puts that unique element in place           |
| `return i + 1`   | Returns total number of unique elements        |

---
