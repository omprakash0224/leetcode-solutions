class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();

        while (columnNumber > 0) {
            // Adjust to 0-indexed base-26 system
            columnNumber--;
            
            // Extract the remainder and map it to 'A' - 'Z'
            int remainder = columnNumber % 26;
            result.append((char) ('A' + remainder));
            
            // Move to the next digit
            columnNumber /= 26;
        }

        // Characters were appended from least significant to most significant
        return result.reverse().toString();
    }
}