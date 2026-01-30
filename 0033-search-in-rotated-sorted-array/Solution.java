## 📘 Problem: Search in Rotated Sorted Array (LeetCode 33)

### Problem Statement

You are given an integer array `nums` that was originally sorted in ascending order and then rotated at some unknown pivot.
Given a target value, return its index if it exists in the array, otherwise return `-1`.

**Constraints**

* Array contains **no duplicate elements**
* Must solve in **O(log n)** time

---

## 💡 Approach Used in This Solution

This solution uses a **two-step binary search strategy**:

1. **Find the pivot (peak element)** — the index where rotation happens
2. **Apply standard binary search** on the correct sorted half

---

## 🧩 Code

```java
class Solution {
    public int search(int[] nums, int target) {
        int pivot = findPeakElement(nums);
        if (pivot == -1) {
            return binarySearch(nums, target, 0, nums.length - 1);
        }

        if (nums[pivot] == target) return pivot;
        if (target >= nums[0]) 
            return binarySearch(nums, target, 0, pivot - 1);
        return binarySearch(nums, target, pivot + 1, nums.length - 1);
    }

    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid < end && nums[mid] > nums[mid + 1]) return mid;
            if (mid > start && nums[mid] < nums[mid - 1]) return mid - 1;

            if (nums[mid] <= nums[start]) end = mid - 1;
            else start = mid + 1;
        }
        return -1;
    }

    public int binarySearch(int[] nums, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }
}
```

---

## 🧠 Explanation

### 1️⃣ Finding the Pivot (`findPeakElement`)

* The pivot is the **largest element** in the rotated array.
* It is identified where:

  * `nums[mid] > nums[mid + 1]` → `mid` is the pivot
  * `nums[mid] < nums[mid - 1]` → `mid - 1` is the pivot
* Binary search is used to locate this efficiently.

If no pivot is found, the array is **not rotated**.

---

### 2️⃣ Searching for the Target (`search`)

* If array is not rotated → normal binary search on the whole array
* If pivot exists:

  * If `nums[pivot] == target` → return pivot
  * If `target >= nums[0]` → search in **left sorted part**
  * Else → search in **right sorted part**

---

### 3️⃣ Binary Search (`binarySearch`)

* Standard binary search on a **fully sorted subarray**
* Ensures logarithmic time complexity

---

## 🧠 Core Logic Summary

* A rotated sorted array can be split into **two sorted halves** using the pivot
* Binary search works only on sorted arrays
* By finding the pivot first, we ensure binary search is applied correctly

---

## ⏱️ Time Complexity

* Finding pivot: **O(log n)**
* Binary search: **O(log n)**

**Total Time Complexity:**
➡️ **O(log n)**

---

## 🧮 Space Complexity

* No extra data structures used
* Only constant variables

**Space Complexity:**
➡️ **O(1)**

---

## 📌 Key Notes (Important)

* Works only when **no duplicates** are present
* More verbose than one-pass solutions, but easier to reason
* Valid and acceptable for interviews
