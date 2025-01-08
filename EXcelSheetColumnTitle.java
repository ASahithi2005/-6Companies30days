//Time complexity : O(log_26(n)). Assume n is the number of columns. Each time we reduce n by 1/26.
class Solution1 {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            int r = (columnNumber - 1) % 26;
            sb.append((char) (r + 'A'));
            columnNumber = (columnNumber - 1) / 26;
        }
        return sb.reverse().toString();
    }
}