## 📌 **LeetCode 33 — Problem**

You are given an integer array `nums` that was **originally sorted in ascending order** and then **rotated at some unknown pivot index**.([LeetCode][1])

### **Definition**

* The array was originally sorted.
* It may have been rotated between `0` and `n-1` times.
* You are given an integer `target`.

👉 **Return the index of `target` in `nums`** if it is present, otherwise return **-1**.([LeetCode][1])

---

## 🔹 **What “rotated” means**

A left rotation at pivot `k` moves the first `k` elements to the end.
Example:

```
Original: [0,1,2,4,5,6,7]
Rotated (k = 3): [4,5,6,7,0,1,2]
```

([AlgoMonster][2])

---

## 🔹 **Examples**

```
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
```

```
Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
```

```
Input: nums = [1], target = 0
Output: -1
```

([AlgoMonster][2])

---

## 📊 **Constraints**

* `1 <= nums.length <= 5000`
* `-10^4 <= nums[i] <= 10^4`
* All values in `nums` are **distinct** (no duplicates)
* `nums` was **sorted in ascending order**, then possibly rotated
* `-10^4 <= target <= 10^4`
* Expected time complexity: **O(log n)** (binary search based)([AlgoMonster][2])

