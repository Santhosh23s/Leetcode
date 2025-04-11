<h2><a href="https://leetcode.com/problems/count-symmetric-integers/?envType=daily-question&envId=2025-04-11">2843.   Count Symmetric Integers</a></h2><h3>Easy</h3><hr><p>You are given two positive integers <code>low</code> and <code>high</code>.</p>

<p>An integer <code>x</code> consisting of <code>2 * n</code> digits is <strong>symmetric</strong> if the sum of the first <code>n</code> digits of <code>x</code> is equal to the sum of the last <code>n</code> digits of <code>x</code>. Numbers with an odd number of digits are never symmetric.</p>

<p>Return <em>the <strong>number of symmetric</strong> integers in the range</em> <code>[low, high]</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> low = 1, high = 100
<strong>Output:</strong> 9
<strong>Explanation:</strong> There are 9 symmetric integers between 1 and 100: 11, 22, 33, 44, 55, 66, 77, 88, and 99.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> low = 1200, high = 1230
<strong>Output:</strong> 4
<strong>Explanation:</strong> There are 4 symmetric integers between 1200 and 1230: 1203, 1212, 1221, and 1230.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= low &lt;= high &lt;= 10<sup>4</sup></code></li>
</ul>


---

# Notes📝

---

## 📘 **Program Notes for `countSymmetricIntegers`**

### ✅ **Purpose:**
This program counts how many **symmetric integers** exist between two given numbers (`low` and `high`), inclusive.

---

### 🔄 **Definition: Symmetric Integer**
An integer is symmetric if:
- It has an **even number of digits**
- The **sum of the first half** of its digits is equal to the **sum of the second half**

---

### 🔧 **Code Breakdown:**

#### 🧮 `int result = 0;`
- Initializes the result counter to store how many symmetric integers we find.

---

#### 🔁 `for (int i = low; i <= high; i++)`
- Loops through every integer from `low` to `high` (inclusive)

---

#### 📦 `String digit = String.valueOf(i);`
- Converts the integer `i` to a string so we can access its individual digits

---

#### 🔢 `int len = digit.length();`
- Stores the number of digits in the current number

---

#### 🧪 `if (len % 2 == 0)`
- Checks if the number has an **even number of digits** (only then it's a candidate for symmetry)

---

#### ✂️ `int half = len / 2;`
- Divides the number into **two halves** using the digit count

---

#### 🔁 First `for` loop: `j = 0 to half - 1`
```java
for (int j = 0; j < half; j++)
```
- Loops over the **first half** of the digits
- Converts each digit character to an integer using `Character.getNumericValue(...)`
- Adds up the digits into `sum1`

---

#### 🔁 Second `for` loop: `k = half to len - 1`
```java
for (int k = half; k < len; k++)
```
- Loops over the **second half** of the digits
- Adds them into `sum2` the same way

---

#### ⚖️ Check for symmetry:
```java
if (sum1 == sum2)
```
- If both halves have the same digit sum → it's a symmetric number

---

#### ➕ Update result:
```java
result += 1;
```
- Increments the counter for each symmetric number found

---

### 🏁 Final Step:
```java
return result;
```
- Returns the total number of symmetric integers found in the range

---

### 📈 Time Complexity:
- **O(n × d)** where:
  - `n = high - low + 1` (range of numbers)
  - `d = number of digits` (max is 4 here)
- Effectively behaves like **O(n)** due to small digit count

---
