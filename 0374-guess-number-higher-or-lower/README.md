# Guess Number Higher or Lower

## 🧩 Problem Description

We are playing the Guess Game.

The game is as follows:

I pick a number from **1 to n**.
You have to guess which number I picked.

Every time you guess wrong, I will tell you whether the number I picked is **higher or lower** than your guess.

You call a predefined API `guess(int num)` which returns:

* `-1` if `num` is **higher** than the picked number
* `1` if `num` is **lower** than the picked number
* `0` if `num` is **equal** to the picked number

Return the number that I picked.

> Problem sourced from **LeetCode**

---

## 📌 Problem Definition

* You are given an integer `n`
* The secret number is in the range `[1, n]`
* You **cannot access** the secret number directly
* You can only use the `guess()` API
* Your task is to determine the picked number

---

## 🔌 Given API (Forward Declaration)

```text
int guess(int num)
```

**Returns:**

* `-1` → your guess is higher than the picked number
* `1` → your guess is lower than the picked number
* `0` → your guess is correct

> You must **not implement** this API.

---

## 🧪 Examples

### Example 1

```
Input:  n = 10, pick = 6
Output: 6
```

### Example 2

```
Input:  n = 1, pick = 1
Output: 1
```

### Example 3

```
Input:  n = 2, pick = 1
Output: 1
```

---

## ⚙️ Constraints

* `1 <= n <= 2^31 - 1`
* `1 <= pick <= n`
* `guess(num)` always returns a valid result

---

## 🧠 Approach

* Use **Binary Search**
* Reduce the search range based on the result of `guess(mid)`
* Continue until the correct number is found

---

## ⏱️ Complexity

* **Time Complexity:** `O(log n)`
* **Space Complexity:** `O(1)`

---

## ✅ Key Notes

* `guess(num)` does **not** return the picked number
* It only indicates **higher**, **lower**, or **correct**
* Binary search is required for efficiency
