package p04_Array;

public class Ex03Dimension {
  public static void main(String[] args) {
    int[][] arr = new int[3][3];
    arr = new int[][]{{1, 2, 3},{4, 5, 6},{7, 8, 9}};
    int[][] arr2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    System.out.println(arr2[0][0]);
    int sum = 0;
    for (int i = 0; i < arr2.length; i++) {
      for (int j = 0; j < arr2[i].length; j++) {
        if (j != 0) {System.out.print(", ");}
        sum = sum + arr2[i][j];
        System.out.print(arr2[i][j]);
      }
      System.out.println();
    }
    System.out.println(sum);
  }
}
