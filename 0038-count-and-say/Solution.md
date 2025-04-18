# Notes 📝
---

# Count-and-Say Problem - Java Solution

## Problem Description

The **Count-and-Say** sequence is a sequence of digit strings defined recursively:

- **countAndSay(1) = "1"**
- **countAndSay(n) = RLE (Run-Length Encoding) of countAndSay(n-1)**

### Run-Length Encoding (RLE):
Run-Length Encoding (RLE) is a compression method where consecutive identical characters are replaced by the character followed by the count of occurrences. 

For example:
- `"3322251"` → `"23321511"` (replace "33" with "23", "222" with "32", "5" with "15", and "1" with "11")

Your task is to implement a method that returns the `n`-th element of the **Count-and-Say** sequence.

---

## Approach

We solve the problem recursively, building the sequence from the base case (`n = 1`) and applying **Run-Length Encoding** (RLE) at each recursive step.

### Steps:

1. **Base Case**: 
   - For `n = 1`, return `"1"` (the first element of the sequence).

2. **Recursive Case**:
   - For `n > 1`, recursively calculate `countAndSay(n - 1)`, then apply **Run-Length Encoding** (RLE) to the result of the previous term.

3. **Run-Length Encoding (RLE)**:
   - Traverse through the previous term and count consecutive identical characters.
   - For each group of consecutive characters, append the count followed by the character to the result.

4. **Recursive Call**:
   - Use recursion to find the `(n-1)`-th term and then build the `n`-th term by applying RLE.

---

## Time Complexity

- **Time Complexity**: `O(2^n)` in the worst case. The length of each term grows exponentially, so generating successive terms involves increasingly expensive string operations.
- **Space Complexity**: `O(n)` due to the space used to store strings during recursion.

---

## Code Implementation

```java
class Solution {
    public String countAndSay(int n) {
        // Base case: for n = 1, return "1"
        if (n == 1) {
            return "1";
        }
        
        // Recursive call: get the previous term in the sequence
        String prev = countAndSay(n - 1);
        StringBuilder result = new StringBuilder();
        
        int count = 1;
        // Loop through the previous string and apply run-length encoding
        for (int i = 1; i < prev.length(); i++) {
            if (prev.charAt(i) == prev.charAt(i - 1)) {
                count++;  // Increment count if the character is the same
            } else {
                result.append(count).append(prev.charAt(i - 1));  // Append count and character
                count = 1;  // Reset count for the next character
            }
        }
        
        // Append the last character run
        result.append(count).append(prev.charAt(prev.length() - 1));
        
        return result.toString();  // Return the new term in the sequence
    }
}
```

### Code Explanation:

- **Base Case**: If `n == 1`, return `"1"` directly (the first term of the sequence).
  
- **Recursive Call**: For `n > 1`, the function calls itself recursively to get the previous term (`countAndSay(n - 1)`).

- **Run-Length Encoding**: 
  - A loop iterates through the previous term to count consecutive characters.
  - For each group of characters, the count and the character are appended to the result.

- **StringBuilder**: Used for efficient string construction, as concatenating strings in a loop can be costly if done with `+`.

- **Final Result**: The method returns the string after processing the previous term and applying the RLE.

---

## Example Walkthrough

For `n = 4`, the output will be `"1211"`.

- **countAndSay(1) = "1"**
- **countAndSay(2)** is the RLE of `"1"`, which gives `"11"` (one "1").
- **countAndSay(3)** is the RLE of `"11"`, which gives `"21"` (two "1"s).
- **countAndSay(4)** is the RLE of `"21"`, which gives `"1211"` (one "2", one "1").

Thus, `countAndSay(4)` returns `"1211"`.

---

## Conclusion

The provided solution recursively computes the `n`-th term of the Count-and-Say sequence. The use of recursion ensures that each term is generated based on the previous term, and **Run-Length Encoding (RLE)** is applied to construct the new term efficiently. 

This approach works well for smaller values of `n` and provides a clear, understandable implementation of the problem.

---
