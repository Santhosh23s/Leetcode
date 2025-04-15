class Solution {
    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] posInNums2 = new int[n];
        for (int i = 0; i < n; i++) {
            posInNums2[nums2[i]] = i;
        }

        int[] mapped = new int[n];
        for (int i = 0; i < n; i++) {
            mapped[i] = posInNums2[nums1[i]];
        }

        FenwickTree leftTree = new FenwickTree(n);
        FenwickTree rightTree = new FenwickTree(n);

        for (int i = 0; i < n; i++) {
            rightTree.update(mapped[i], 1);
        }

        long goodTriplets = 0;

        for (int i = 0; i < n; i++) {
            int current = mapped[i];
            rightTree.update(current, -1);
            long leftSmaller = leftTree.query(current - 1);
            long rightGreater = rightTree.query(n - 1) - rightTree.query(current);
            goodTriplets += leftSmaller * rightGreater;
            leftTree.update(current, 1);
        }

        return goodTriplets;
    }

    class FenwickTree {
        int[] tree;
        int size;

        FenwickTree(int size) {
            this.size = size + 2;
            tree = new int[this.size];
        }

        void update(int index, int value) {
            index++;
            while (index < size) {
                tree[index] += value;
                index += index & -index;
            }
        }

        int query(int index) {
            index++;
            int result = 0;
            while (index > 0) {
                result += tree[index];
                index -= index & -index;
            }
            return result;
        }
    }
}
