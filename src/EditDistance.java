import java.util.*;

class EditDistance {
  public static int EditDistance(String s, String t) {
    int[][] editDistanceMatrix = new int[s.length() + 1][t.length() + 1];
    for (int i = 0; i < editDistanceMatrix.length; i++) {
      editDistanceMatrix[i][0] = i;
    }
    for (int i = 0; i < editDistanceMatrix[0].length; i++) {
      editDistanceMatrix[0][i] = i;
    }
    for (int i = 1; i < editDistanceMatrix.length; i++) {
      for (int j = 1; j < editDistanceMatrix[0].length; j++) {
        editDistanceMatrix[i][j] = getMinD(editDistanceMatrix, i, j, s.charAt(i - 1) == t.charAt(j - 1));
      }

    }

    return editDistanceMatrix[s.length()][t.length()];
  }

  public static void printMatrix(int[][] matrix) {
    for (int row = 0; row < matrix.length; row++) {
      for (int col = 0; col < matrix[row].length; col++) {
        System.out.printf("%4d", matrix[row][col]);
      }
      System.out.println();
    }
  }

  private static int getMinD(int[][] editDistanceMatrix, int i, int j, boolean lettersTheSame) {
    int insertion = editDistanceMatrix[i][j - 1] + 1;
    int delition = editDistanceMatrix[i - 1][j] + 1;

    int match = Integer.MAX_VALUE;
    int mismatch = Integer.MAX_VALUE;
    if (lettersTheSame) {
      match = editDistanceMatrix[i - 1][j - 1 ];
    } else {
      mismatch = editDistanceMatrix[i  -1 ][j - 1] + 1;
    }

    return Math.min(insertion, Math.min(delition, Math.min(match, mismatch)));
  }

  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    String s = scan.next();
    String t = scan.next();

    System.out.println(EditDistance(s, t));
  }

}
