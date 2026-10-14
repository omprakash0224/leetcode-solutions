class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if ((long) num * 9 < sum) {
            return "";
        }

        int count9 = sum / 9;
        int remainder = sum % 9;

        char[] result = new char[num];
        
        // Fill the largest digits ('9') first
        Arrays.fill(result, 0, count9, '9');
        int idx = count9;

        // Place the remainder digit if present
        if (remainder > 0) {
            result[idx++] = (char) ('0' + remainder);
        }

        // Fill the remaining positions with '0'
        Arrays.fill(result, idx, num, '0');

        return new String(result);
    }
}