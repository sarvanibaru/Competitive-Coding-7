// Time Complexity : O(nlog(max - min))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
We can use a binary search to find the initial mid element by taking (0,0),(m-1,n-1) cells' values.Now, we can
count at which level of k closest is that particular cell's value to the k. As in, if its less than k, we update
the low, if not, we move the high pointer. The logic for count computation is that since the column is sorted, once
I find a value ≤ target, all elements above it are also ≤ target, so I can count them together instead of
iterating.
 */
class Solution {
    int m;
    int n;
    public int kthSmallest(int[][] matrix, int k) {
        this.m = matrix.length;
        this.n = matrix[0].length;
        int low = matrix[0][0];
        int high = matrix[m - 1][n - 1];

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int count = binarySearch(matrix, mid);

            if (count < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    private int binarySearch(int[][] matrix, int target) {
        int row = m - 1;
        int col = 0;
        int count = 0;

        while (row >= 0 && col < n) {
            if (matrix[row][col] <= target) {
                int elementsInColumn = row + 1;
                count = count + elementsInColumn;
                col++;
            } else {
                row--;
            }
        }
        return count;
    }
}