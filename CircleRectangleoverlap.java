//Bruteforce approach - Time Complexity : O(x2-x1) * O(y2-y1) = O(n^2) where n is the length of the rectangle
class Solution1 {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        for (int x = x1; x <= x2; x++) {
            for (int y = y1; y <= y2; y++) {
                int value = (x - xCenter) * (x - xCenter) + (y - yCenter) * (y - yCenter);
                if (value <= radius * radius) {
                    return true;
                }
            }
        }
        return false;
    }
}

// optimal approach - Time Complexity : O(1)
class Solution2 {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int dx, dy;
        if (x1 > xCenter)
            dx = x1;
        else if (x2 < xCenter)
            dx = x2;
        else
            dx = xCenter;

        if (y1 > yCenter)
            dy = y1;
        else if (y2 < yCenter)
            dy = y2;
        else
            dy = yCenter;

        return (xCenter - dx) * (xCenter - dx) + (yCenter - dy) * (yCenter - dy) <= radius * radius;
    }
}