class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), 0, s);
        return result;
    }
    private void backtrack(List<List<String>> result, List<String> path, int start, String s){
        if(start == s.length()){
            result.add(new ArrayList<>(path));
            return;
        }

        for(int end = start; end < s.length(); end++){
            if(isPalindrome(s, start, end)){
                path.add(s.substring(start, end+1));
                backtrack(result, path, end+1, s);
                path.remove(path.size()-1);
            }
        }
    }
    private boolean isPalindrome(String s, int left, int right){
        while(left < right){
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}