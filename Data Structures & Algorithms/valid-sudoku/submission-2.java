class Solution {
    public boolean isValidSudoku(char[][] board) {
        char empty = '.';
        int n = 9;
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<Integer, Set<Character>> squares = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char num = board[i][j];
                if (num == empty) {
                    continue;
                }

                rows.putIfAbsent(i, new HashSet<>());
                if (rows.get(i).contains(num)) {
                    return false;
                }
                rows.get(i).add(num);

                cols.putIfAbsent(j, new HashSet<>());
                if (cols.get(j).contains(num)) {
                    return false;
                }
                cols.get(j).add(num);

                int k = (i / 3) * 3 + j / 3;
                squares.putIfAbsent(k, new HashSet<>());
                if (squares.get(k).contains(num)) {
                    return false;
                }
                squares.get(k).add(num);
            }
        } 

        return true; 
    }
}
