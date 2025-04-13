---

## 📝 **Java Notes: Count Good Digit Strings Using Modular Exponentiation**

### ✅ **Problem Recap:**
You are given a number `n`. A **"good digit string"** of length `n` has:
- **Even-indexed digits (0, 2, 4,...)** → must be **even digits** (0, 2, 4, 6, 8) → **5 choices**
- **Odd-indexed digits (1, 3, 5,...)** → must be **prime digits** (2, 3, 5, 7) → **4 choices**

We must find **how many such good digit strings** are there of length `n`, **modulo 10⁹ + 7**.

---

### 💡 **Logic:**

- Let `even = (n + 1) / 2` → number of even positions  
- Let `odd = n / 2` → number of odd positions  
- Total combinations:
  \[
  \text{Answer} = (5^{even} \times 4^{odd}) \mod (10^9 + 7)
  \]

---

### 🔐 **Why `MOD = 10^9 + 7`?**

- Keeps numbers small and avoids overflow  
- It’s a large **prime number**, commonly used in competitive programming  
- Ensures results are accurate and manageable

---

### 🧮 **Efficient Power Calculation: `modPow(base, exp, MOD)`**

Instead of using `Math.pow()`, which:
- Works with `double` (not exact for large ints)
- Can cause **overflow or precision errors**

We use **modular exponentiation** (also called "fast power"):
- Time complexity: **O(log n)**
- Safe for large numbers
- Uses repeated squaring

---

### ✅ **Final Working Code (with comments):**

```java
class Solution {
    public int countGoodNumbers(long n) {
        final int MOD = 1_000_000_007;

        long even = (n + 1) / 2;  // number of even index positions
        long odd = n / 2;         // number of odd index positions

        long result = (modPow(5, even, MOD) * modPow(4, odd, MOD)) % MOD;

        return (int) result;
    }

    // Efficient power function to calculate (base^exp) % MOD
    public long modPow(long base, long exp, int MOD) {
        long result = 1;
        base %= MOD;  // bring base into MOD range

        while (exp > 0) {
            if (exp % 2 == 1) {
                result = (result * base) % MOD;  // multiply only when exponent is odd
            }
            base = (base * base) % MOD;  // square the base
            exp = exp / 2;               // halve the exponent
        }

        return result;
    }
}
```

---

### 🔍 **Example:**

If `n = 4`:
- even = 2 → \(5^2 = 25\)
- odd = 2 → \(4^2 = 16\)
- Total = \(25 \times 16 = 400\)

---

### ⏱️ **Time Complexity:**
- `modPow()` is **O(log n)**  
- Efficient even when `n` is very large (like \(10^{15}\))

---
