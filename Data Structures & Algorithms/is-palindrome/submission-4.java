class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();

        if (s.length() == 1) {
            return true;
        }

        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            // Skip the non-alphanumeric characters
            while (i < s.length() && !isAlphanumerical(s.charAt(i))) {
                i++;
            }
            while (j >= 0 && !isAlphanumerical(s.charAt(j))) {
                j--;
            }

            // No alphanumeric characters found
            if (i >= s.length() || j < 0) {
                return true;
            }

            // Check the equality of character at both end of the string
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean isAlphanumerical(char c) {
        int n = c - '0';
        boolean isNum = n >= 0 && n <= 9;
        int l = c - 'a';
        boolean isChar = l >= 0 && l <= 25;
        return isNum || isChar;
    }
}
