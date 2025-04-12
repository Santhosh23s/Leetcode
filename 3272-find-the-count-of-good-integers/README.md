<h2><a href="https://leetcode.com/problems/find-the-count-of-good-integers/?envType=daily-question&envId=2025-04-12">3272. Find the Count of Good Integers</a></h2><h3>Hard</h3><hr><p>You are given two <strong>positive</strong> integers <code>n</code> and <code>k</code>.</p>

<p>An integer <code>x</code> is called <strong>k-palindromic</strong> if:</p>

<ul>
	<li><code>x</code> is a <span data-keyword="palindrome-integer">palindrome</span>.</li>
	<li><code>x</code> is divisible by <code>k</code>.</li>
</ul>

<p>An integer is called <strong>good</strong> if its digits can be <em>rearranged</em> to form a <strong>k-palindromic</strong> integer. For example, for <code>k = 2</code>, 2020 can be rearranged to form the <em>k-palindromic</em> integer 2002, whereas 1010 cannot be rearranged to form a <em>k-palindromic</em> integer.</p>

<p>Return the count of <strong>good</strong> integers containing <code>n</code> digits.</p>

<p><strong>Note</strong> that <em>any</em> integer must <strong>not</strong> have leading zeros, <strong>neither</strong> before <strong>nor</strong> after rearrangement. For example, 1010 <em>cannot</em> be rearranged to form 101.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">n = 3, k = 5</span></p>

<p><strong>Output:</strong> <span class="example-io">27</span></p>

<p><strong>Explanation:</strong></p>

<p><em>Some</em> of the good integers are:</p>

<ul>
	<li>551 because it can be rearranged to form 515.</li>
	<li>525 because it is already k-palindromic.</li>
</ul>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">n = 1, k = 4</span></p>

<p><strong>Output:</strong> <span class="example-io">2</span></p>

<p><strong>Explanation:</strong></p>

<p>The two good integers are 4 and 8.</p>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">n = 5, k = 6</span></p>

<p><strong>Output:</strong> <span class="example-io">2468</span></p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 10</code></li>
	<li><code>1 &lt;= k &lt;= 9</code></li>
</ul>

---
# Notes

---

## 🧠 **What is the problem?**

We are given:
- `n`: number of digits
- `k`: a number

We need to count how many **n-digit integers** can be **rearranged into a palindrome** that is **divisible by k**.

---

## 🔁 Step-by-step approach in the code:

---

### 🔹 Step 1: Generate all valid k-palindromic numbers

```java
generatePalindromes(...)
```

This function:
- Builds all **palindromic numbers** of length `n`
- Checks if each is **divisible by k**
- Saves the valid ones

💡 **Palindrome Rule:** A number that reads the same forwards and backwards.  
Examples: `121`, `202`, `12321`, etc.

🛑 It avoids invalid palindromes like `01210` (leading zero not allowed).

---

### 🔹 Step 2: Convert each palindrome into a **digit frequency pattern**

```java
int[] freq = new int[10];
```

We count how many times each digit appears in the palindrome.

Then we convert this frequency into a **unique string pattern** using characters:

Example: if digit 0 appears 2 times, digit 1 appears 1 time... we create a pattern like `"cabaaa..."`  
Why? So we can compare patterns easily and avoid recalculating duplicates.

---

### 🔹 Step 3: Store all unique frequency patterns

```java
Set<String> uniquePatterns = new HashSet<>();
```

If two palindromes have the **same digit pattern**, they can be made from the **same digits**, just in a different order.

So we **only keep one of each unique pattern**.

---

### 🔹 Step 4: For each pattern, calculate how many integers can be made

```java
long permutations = totalPermutations;
```

We use **factorial math** to calculate permutations:
- Total ways to arrange `n` digits: `n!`
- If digits repeat, divide by their counts:  
  E.g., `n! / (count0! * count1! * ...)`

This gives **how many numbers** we can build from those digits.

---

### ⚠️ Step 5: Remove numbers with **leading zeros**

We cannot have numbers like `012` — those are not valid.

So we subtract permutations that start with `0`.  
This is handled carefully by:
- Fixing a non-zero digit at the first position
- Then permuting the rest

---

### ✅ Step 6: Add all valid permutations together

```java
totalValidPermutations += permutations;
```

This gives the final result:  
**How many n-digit numbers can be rearranged into a k-divisible palindrome.**

---

## 📌 Summary (cheat-sheet style):

| Concept         | Explanation                                                                 |
|----------------|-----------------------------------------------------------------------------|
| Palindrome      | Reads same forward and backward                                             |
| k-palindromic   | A palindrome divisible by `k`                                               |
| Good integer    | An integer that can be **rearranged** into a k-palindrome                  |
| Frequency pattern | Tracks how many times each digit appears                                  |
| Permutations    | Use `n! / (repeated counts)!`                                               |
| Invalid cases   | Remove permutations that start with zero                                   |

---
