package interviewproblem.array_string;

/*
 * 0 행렬: M x N 행렬의 한 원소가 O일 경우,
 * 해당 원소가 속한 행과 열의 모든 원소를 0으로 설정하는 알고리즘을 작성하라.
 */
public class Problem8 {

    public static int[][] solve(int[][] matrix, int m, int n) {
        int zeroX = -1, zeroY = -1;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == 0) {
                    zeroY = i;
                    zeroX = j;
                }
            }
        }

        if (zeroX == -1 || zeroY == -1) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < n; ++i) {
            matrix[zeroY][i] = 0;
        }

        for (int i = 0; i < m; ++i) {
            matrix[i][zeroX] = 0;
        }

        return matrix;
    }

    /*
     *
     */

    void setZeros(int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        boolean[] column = new boolean[matrix[0].length];

        // 값이 0인 행과 열의 인덱스를 저장한다.
        for (int i=0; i<matrix.length; ++i) {
            for (int j=0; j<matrix[0].length; ++j) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    column[j] = true;
                }
            }
        }

        // 행의 원소를 전부 0으로 바꾼다.
        for (int i=0; i<row.length; ++i) {
            if (row[i]) nullifyRow(matrix, i);
        }

        // 열의 원소를 전부 0으로 바꾼다.
        for (int i=0; i<column.length; ++i) {
            if (column[i]) nullifyColumn(matrix, i);
        }
    }

    void nullifyRow(int[][] matrix, int row) {
        for (int i=0; i<matrix[0].length; ++i) {
            matrix[row][i] = 0;
        }
    }

    void nullifyColumn(int[][] matrix, int col) {
        for (int i=0; i<matrix.length; ++i) {
            matrix[i][col] = 0;
        }
    }
}
