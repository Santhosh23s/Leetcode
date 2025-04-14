# Notes📝

---

## ✅ **Java Code Notes: Count Good Triplets**

### **Purpose:**
To count how many triplets `(arr[i], arr[j], arr[k])` exist in the array that satisfy these three conditions:

1. `i < j < k`
2. `|arr[i] - arr[j]| <= a`
3. `|arr[j] - arr[k]| <= b`
4. `|arr[i] - arr[k]| <= c`

---

### **Code Breakdown:**

#### 1. **Initialize the count:**
```java
int count = 0;
```
- Keeps track of how many good triplets we find.

---

#### 2. **Three Nested Loops:**

```java
for (int i = 0; i < arr.length - 2; i++)
```
- `i` starts from the beginning of the array.
- Stops at `arr.length - 2` to leave room for `j` and `k`.

```java
for (int j = i + 1; j < arr.length - 1; j++)
```
- `j` always comes after `i`.

```java
for (int k = j + 1; k < arr.length; k++)
```
- `k` always comes after `j`.

This ensures `i < j < k`.

---

#### 3. **Condition Check:**
```java
if (Math.abs(arr[i] - arr[j]) <= a &&
    Math.abs(arr[j] - arr[k]) <= b &&
    Math.abs(arr[i] - arr[k]) <= c)
```

- Uses `Math.abs()` to compute absolute differences.
- Checks if all three given conditions are satisfied.

---

#### 4. **Counting Valid Triplets:**
```java
count++;
```
- If all conditions are met, increment the count.

---

#### 5. **Return the Result:**
```java
return count;
```
- Final number of good triplets found in the array.

---
