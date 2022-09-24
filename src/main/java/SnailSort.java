public class SnailSort {

    public static int[] snail(int[][] array) {

      int cols = array.length;
      int rows = array[0].length;
      int parts = cols * rows;
      int[] result = new int[parts];
      int counter = 0;
      int j = 0;

      while (counter != parts) {

          for (int i = j; i<cols-j; i++) {
              System.out.print(result[counter] = array[j][i]);
              counter++;
              if (counter == parts) {
                  break;
              }

          }

          System.out.println("\n");

          for (int i = 1+j; i<rows-j; i++ ) {
              System.out.println(result[counter] = array[i][cols-1-j]);
              counter++;
              if (counter == parts) {
                  break;
              }

          }

          for (int i = cols-2-j; i>-1+j; i--) {
              System.out.print(result[counter] = array[rows-1-j][i]);
              counter++;
              if (counter == parts) {
                  break;
              }
          }
          System.out.println("\n");

          for (int i = rows-2-j; i>j; i--) {
              System.out.println(result[counter] = array[i][j]);
              counter++;
              if (counter == parts) {
                  break;
              }
          }
          j++;

      }

      return result;
    }


}
