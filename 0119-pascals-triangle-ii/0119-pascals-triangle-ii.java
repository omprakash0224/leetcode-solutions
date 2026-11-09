class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>(rowIndex + 1);
        
        long val = 1;
        row.add((int) val);
        
        for (int k = 1; k <= rowIndex; k++) {
            // val = val * (rowIndex - k + 1) / k
            val = val * (rowIndex - k + 1) / k;
            row.add((int) val);
        }
        
        return row;
    }
}