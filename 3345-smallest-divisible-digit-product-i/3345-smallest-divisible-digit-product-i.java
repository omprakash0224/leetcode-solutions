class Solution {
    public int smallestNumber(int n, int t) {
        int x = n;
        while (getDigitProduct(x) % t != 0) {
            x++;
        }
        return x;
    }
    private int getDigitProduct(int num) {
        int product = 1;
        while (num > 0) {
            product *= (num % 10);
            num /= 10;
        }
        return product;
    }
}