<h2><a href="https://leetcode.com/problems/score-of-a-string/?envType=problem-list-v2&envId=string">3110. Score of a String</a></h2><h3>Easy</h3><hr><p>You are given a string <code>s</code>. The <strong>score</strong> of a string is defined as the sum of the absolute difference between the <strong>ASCII</strong> values of adjacent characters.</p>

<p>Return the <strong>score</strong> of<em> </em><code>s</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;hello&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">13</span></p>

<p><strong>Explanation:</strong></p>

<p>The <strong>ASCII</strong> values of the characters in <code>s</code> are: <code>&#39;h&#39; = 104</code>, <code>&#39;e&#39; = 101</code>, <code>&#39;l&#39; = 108</code>, <code>&#39;o&#39; = 111</code>. So, the score of <code>s</code> would be <code>|104 - 101| + |101 - 108| + |108 - 108| + |108 - 111| = 3 + 7 + 0 + 3 = 13</code>.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;zaz&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">50</span></p>

<p><strong>Explanation:</strong></p>

<p>The <strong>ASCII</strong> values of the characters in <code>s</code> are: <code>&#39;z&#39; = 122</code>, <code>&#39;a&#39; = 97</code>. So, the score of <code>s</code> would be <code>|122 - 97| + |97 - 122| = 25 + 25 = 50</code>.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= s.length &lt;= 100</code></li>
	<li><code>s</code> consists only of lowercase English letters.</li>
</ul>

---

## 📝 Notes


### ✅ **Java Code Notes: Calculate Score of a String**

```java
class Solution {
    public int scoreOfString(String s) {
        int score = 0;  // Initialize score to 0

        // Loop through the string from the first character to the second-last one
        for (int i = 0; i < s.length() - 1; i++) {
            
            // Get the ASCII value of current character
            int a = (int) s.charAt(i);

            // Get the ASCII value of the next character
            int b = (int) s.charAt(i + 1);

            // Add the absolute difference between the two ASCII values to the score
            score += Math.abs(a - b);
        }

        // Return the final calculated score
        return score;
    }
}
```

---

### 💡 **What this code does:**

- It **calculates the score of a string** based on the sum of the **absolute differences** between the ASCII values of **adjacent characters**.
- For example, if the string is `"hello"`:
  - ASCII values: `h=104`, `e=101`, `l=108`, `l=108`, `o=111`
  - Differences: `|104-101| + |101-108| + |108-108| + |108-111|`
  - Result: `3 + 7 + 0 + 3 = 13`

---

### 🧠 **Key Concepts Used:**

- `charAt(i)` – Access individual characters in the string
- `(int)` – Casts the character to its ASCII value
- `Math.abs()` – Ensures the difference is always positive
- Looping till `s.length() - 1` to safely access `i + 1`

---

