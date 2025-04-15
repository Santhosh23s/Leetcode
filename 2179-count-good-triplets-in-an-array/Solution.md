# Notes 📝

---

### 📝 **Notes for "Count Good Triplets in Two Arrays"**

---

### 🔹 **Problem Summary**
You are given two permutations `nums1` and `nums2`. You need to count how many triplets `(x, y, z)` exist such that:

- The **indexes** of `x`, `y`, and `z` in `nums1` are in increasing order.
- The **indexes** of the same values in `nums2` are also in increasing order.

---

### 🔹 **Main Idea**
We want to count how many **increasing triplets** exist in **both** arrays.  
To do this efficiently, we:

1. **Convert `nums1` into the order of `nums2`** using a mapping.
2. Then, just count the number of increasing triplets in that new array.

---

### 🔹 **Step-by-Step Breakdown**

#### ✅ Step 1: Create a Position Map
- Build an array `posInNums2` where `posInNums2[val]` = index of `val` in `nums2`.
- This helps us quickly find where any number appears in `nums2`.

#### ✅ Step 2: Map `nums1` to New Positions
- Replace each value in `nums1` with its position in `nums2`, using the map.
- This gives you a new array `mapped[]`, and now you just need to count how many triplets in `mapped` have values in increasing order.

#### ✅ Step 3: Use Two Fenwick Trees
We use **two Fenwick Trees** for counting efficiently:
- `leftTree`: to count how many values to the **left** of a number are **smaller**.
- `rightTree`: to count how many values to the **right** of a number are **greater**.

We:
- Fill the `rightTree` initially with all elements.
- For each index `i`, remove the current element from `rightTree`, because we're processing it now.
- Query:
  - From `leftTree`: how many elements < current (to the left)?
  - From `rightTree`: how many elements > current (to the right)?
- Multiply those two counts — this gives the number of triplets where `mapped[i]` is in the **middle**.
- Update `leftTree` with the current element.

#### ✅ Step 4: Fenwick Tree (Binary Indexed Tree)
- This is a data structure that supports:
  - Fast prefix sums (`query`)
  - Fast updates (`update`)
- Time complexity: `O(log n)` per operation.

---

### 🧠 **Why This Works**
- For each possible **middle element** of a triplet, you're counting:
  - How many valid **left** elements (`leftSmaller`)
  - How many valid **right** elements (`rightGreater`)
- The total number of good triplets = sum of `leftSmaller * rightGreater` across all indices.

---

### ⏱️ **Time and Space Complexity**
- **Time:** O(n log n)
- **Space:** O(n)

---

### 💡 Pro Tips:
- This is a classic use of BIT (Fenwick Tree) for range counting problems.
- Always think about transforming problems to a **single dimension** when comparing orders from two permutations.

---
