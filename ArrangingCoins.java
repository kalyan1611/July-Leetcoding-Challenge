class Solution {

    public int arrangeCoins(int n) {

        long low = 0, high = n;
        long mid, sum;
        while (low <= high) {
            mid = low + (high - low) / 2;
            sum = (mid % 2 == 0) ? (mid/2) * (mid + 1) : (mid + 1)/2 * (mid);
            if (sum == n) {
                return (int) mid;
            } else if (sum > n) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (int) high;
    }
}
