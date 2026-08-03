class Solution {
    public int myAtoi(String s) {

        int i=0, n = s.length();
        int sign = 1;
        long result = 0;

        if (s == null || n == 0) {
            return 0;
        }

        // Step 1: skip spaces
        while(i < n && s.charAt(i) == ' '){
            i++;
        }

        // Edge case: string was all spaces
        if(i == n){
            return 0;
        }

        // Step 2: sign check
        if(i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')){
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // Step 3: parse digit
        while(i<n && Character.isDigit(s.charAt(i))){
            int digit = s.charAt(i) - '0';

            //Step 4: overflow/underflow check
            if(result > (Integer.MAX_VALUE - digit)/10){
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            i++; 
        }
        return (int)(result * sign);
    }
}