//Brute force approach 
//Time Complexity: O(m*n) , space complexity: O(m*n)
class Solution1 {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length, n = img[0].length;
        int[][] output = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0, count = 0;
                for (int x = i - 1; x <= i + 1; x++) {
                    for (int y = j - 1; y <= j + 1; y++) {
                        if (0 <= x && x < m && 0 <= y && y < n) {
                            sum += img[x][y];
                            count += 1;
                        }
                    }
                }
                output[i][j] = sum / count;
            }
        }
        return output;
    }
}

// optimal Approach - Bit Manipulation
// Time Complexity: O(m*n) , space complexity: O(1)
class Solution2 {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length, n = img[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0, count = 0;
                for (int x = i - 1; x <= i + 1; x++) {
                    for (int y = j - 1; y <= j + 1; y++) {
                        if (0 <= x && x < m && 0 <= y && y < n) {
                            sum += img[x][y] & ((1 << 8) - 1);
                            count += 1;
                        }
                    }
                }
                img[i][j] |= (sum / count) << 8;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                img[i][j] = img[i][j] >> 8;
            }
        }
        return img;

    }
}
