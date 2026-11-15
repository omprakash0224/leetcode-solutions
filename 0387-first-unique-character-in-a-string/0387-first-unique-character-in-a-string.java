class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> countMap = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            countMap.put(ch, countMap.getOrDefault(ch, 0)+1);
            q.add(i);

            while(!q.isEmpty() && countMap.get(s.charAt(q.peek())) > 1){
                q.poll();
            }
        }
        return q.isEmpty() ? -1 : q.peek();
    }
}