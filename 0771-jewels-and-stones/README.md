<h2><a href="https://leetcode.com/problems/jewels-and-stones/?envType=problem-list-v2&envId=string">771. Jewels and Stones</a></h2><h3>Easy</h3><hr><p>You&#39;re given strings <code>jewels</code> representing the types of stones that are jewels, and <code>stones</code> representing the stones you have. Each character in <code>stones</code> is a type of stone you have. You want to know how many of the stones you have are also jewels.</p>

<p>Letters are case sensitive, so <code>&quot;a&quot;</code> is considered a different type of stone from <code>&quot;A&quot;</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> jewels = "aA", stones = "aAAbbbb"
<strong>Output:</strong> 3
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> jewels = "z", stones = "ZZ"
<strong>Output:</strong> 0
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;=&nbsp;jewels.length, stones.length &lt;= 50</code></li>
	<li><code>jewels</code> and <code>stones</code> consist of only English letters.</li>
	<li>All the characters of&nbsp;<code>jewels</code> are <strong>unique</strong>.</li>
</ul>

---

# Notes📝

---

## ✅ **Goal of the Program**:
To count how many of the characters (stones) in the `stones` string are also present in the `jewels` string.

---

## 📥 **Inputs**:
- `jewels`: a string that contains the types of stones that are jewels  
- `stones`: a string that contains the stones you have

Each character represents one stone.

---

## 📤 **Output**:
- An integer: the number of stones that are jewels

---

## 💡 **Main Concepts Used**:

### 1. **Loop through each character in `stones`**:
```java
for(int i = 0; i < stones.length(); i++) {
    ...
}
```
- This loop checks every stone you have.

---

### 2. **Check if current stone is a jewel**:
```java
jewels.indexOf(stones.charAt(i)) != -1
```
- `stones.charAt(i)` → gets the current stone  
- `jewels.indexOf(...)` → checks if that stone exists in the jewels string  
- If it's **not -1**, it means the stone **is a jewel**.

---

### 3. **Count the jewels**:
```java
if (condition) sum++;
```
- Every time we find a jewel in `stones`, we increase `sum` by 1.

---

## 📦 Example:

```java
jewels = "aA"
stones = "aAAbbbb"
```

Looping through each character in `stones`:
- 'a' → in jewels → count++
- 'A' → in jewels → count++
- 'A' → in jewels → count++
- 'b' → not in jewels → no count
- 'b' → no count
- 'b' → no count
- 'b' → no count

✅ Final count = **3**

---

## 🧠 Extra Notes:

- `indexOf()` is case-sensitive (`'a'` ≠ `'A'`).
- Time complexity: **O(n × m)** where `n = stones.length()` and `m = jewels.length()`.
- This is fine for small inputs, but we can make it faster using a `Set` (optional optimization).

---
