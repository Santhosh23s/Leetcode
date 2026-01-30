/**
 * Forward declaration of guess API.
 * This method is already implemented by LeetCode.
 *
 * @param num your guessed number
 * @return -1 if num is higher than the picked number
 *          1 if num is lower than the picked number
 *          0 if num is equal to the picked number
 */
 // int guess(int num);

public class Solution extends GuessGame {

    /**
     * Finds the secret number between 1 and n using binary search.
     *
     * @param n the upper bound of the range
     * @return the picked secret number
     */
    public int guessNumber(int n) {

        int start = 0;     // lower bound of search range
        int end = n;       // upper bound of search range

        while (start <= end) {

            // calculate mid to avoid integer overflow
            int mid = start + (end - start) / 2;

            // call the predefined guess API
            int result = guess(mid);

            if (result == 0) {
                // mid is the correct number
                return mid;
            } else if (result == 1) {
                // mid is lower than the picked number
                start = mid + 1;
            } else {
                // mid is higher than the picked number
                end = mid - 1;
            }
        }

        // safety return (will not be reached for valid inputs)
        return -1;
    }
}
