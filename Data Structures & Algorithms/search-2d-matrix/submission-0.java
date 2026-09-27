class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;

        int left = 0;
        int right = row * col - 1;

        while(left <= right) {
            int mid = (left + right)/2;
            
            //Devide mid by col to get no of row and take modulas to get col
            if(matrix[mid/col][mid % col] == target) return true;
            else if(matrix[mid/col][mid % col] < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }

    public boolean searchMatrix0(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            int row = 0;
            int col = matrix[0].length - 1;

            if (matrix[mid][0] == target)
                return true;
            else if (matrix[mid][0] > target)
                right = mid - 1;
            else if (matrix[mid][0] < target && matrix[mid][matrix[0].length - 1] < target)
                left = mid + 1;
            else {
                while (row <= col) {
                    int midV = (row + col) / 2;

                    if (matrix[mid][midV] == target)
                        return true;
                    else if (matrix[mid][midV] < target) {
                        row++;
                    } else {
                        col--;
                    }
                }
            }
        }
        return false;
    }
}
