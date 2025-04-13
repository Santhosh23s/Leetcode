class Solution {
    public int countGoodNumbers(long n) {
        final int MOD =1000000007;
        long even = (n+1)/2;
        long odd = n/2;
        long result =1;
        result = (result * modPow(5, even, MOD)) % MOD;
        result = (result * modPow(4, odd, MOD)) % MOD;        
        return (int) result;
    }

     public long modPow(long base, long exp, int MOD) {
        long result = 1;
        base = base % MOD; // Ensure base is within range of MOD
        
        while (exp > 0) {
            if (exp % 2 == 1) {
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            exp = exp / 2;
        }
        
        return result;
    }
}