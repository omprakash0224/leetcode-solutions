class Solution {
    public String countAndSay(int n) {
        // Base Case
        if (n == 1) {
            return "1";
        }
        
        // Previous sequence result
        String say = countAndSay(n - 1);
        
        // StringBuilder avoids creating new String objects in memory
        StringBuilder result = new StringBuilder();
        int nLength = say.length();
        
        for (int i = 0; i < nLength; i++) {
            char ch = say.charAt(i);
            int count = 1;
            
            // Continuous duplicate characters count karo
            while (i + 1 < nLength && say.charAt(i) == say.charAt(i + 1)) {
                count++;
                i++;
            }
            
            // In-place append (Zero unnecessary allocation)
            result.append(count).append(ch);
        }
        
        return result.toString();
    }
}