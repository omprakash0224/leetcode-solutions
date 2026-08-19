class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, boolean[]> rowStatusMap = new HashMap<>();

        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];

            // Seats 1 and 10 do not affect any 4-person group
            if (col == 1 || col == 10) {
                continue;
            }

            // Row ke liye boolean array get ya create karo
            rowStatusMap.putIfAbsent(row, new boolean[3]);
            boolean[] blocked = rowStatusMap.get(row);

            if (col == 2 || col == 3) {
                blocked[0] = true; // Left blocked
            } else if (col == 8 || col == 9) {
                blocked[2] = true; // Right blocked
            } else if (col == 4 || col == 5) {
                blocked[0] = true; // Left blocked
                blocked[1] = true; // Middle blocked
            } else if (col == 6 || col == 7) {
                blocked[1] = true; // Middle blocked
                blocked[2] = true; // Right blocked
            }
        }

        int maxFamilies = 0;

        // Process occupied rows
        for (boolean[] blocked : rowStatusMap.values()) {
            boolean leftFree = !blocked[0];
            boolean middleFree = !blocked[1];
            boolean rightFree = !blocked[2];

            if (leftFree && rightFree) {
                maxFamilies += 2;
            } else if (leftFree || rightFree || middleFree) {
                maxFamilies += 1;
            }
        }

        // Fully unreserved rows (har empty row me 2 families)
        int unreservedRows = n - rowStatusMap.size();
        maxFamilies += unreservedRows * 2;

        return maxFamilies;
    }
}