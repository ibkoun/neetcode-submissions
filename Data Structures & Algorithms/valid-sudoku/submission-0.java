class Solution {
    public boolean isValidSudoku(char[][] board) {
        char empty = '.';
        int n = 9;
        List<Set<Character>> rows = new ArrayList<>();
        List<Set<Character>> cols = new ArrayList<>();
        List<Set<Character>> squares = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            rows.add(new HashSet<>());
            cols.add(new HashSet<>());
            squares.add(new HashSet<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char num = board[i][j];
                if (num == empty) {
                    continue;
                }

                if (rows.get(i).contains(num)) {
                    return false;
                }
                rows.get(i).add(num);

                if (cols.get(j).contains(num)) {
                    return false;
                }
                cols.get(j).add(num);

                int k = (i / 3) * 3 + j / 3;
                if (squares.get(k).contains(num)) {
                    return false;
                }
                squares.get(k).add(num);
            }
        } 

        return true; 
    }
}
