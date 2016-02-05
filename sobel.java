import java.io.*;

public class Sobel {

  public static void main(String[] args) {
    int     i, j, nrows, ncols, img[][];
    double  Gx[][], Gy[][], G[][];

    if (args.length != 6) {
      System.out.println(
        "Usage: Sobel <nrows> <ncols> <in_img> <Gx> <Gy> <G>");
      System.exit(0);
    }
    nrows = Integer.parseInt(args[0]);
    ncols = Integer.parseInt(args[1]);
    img = new int[nrows][ncols];
    ArrayIO.readByteArray(args[2], img, nrows, ncols);
    Gx = new double[nrows][ncols];
    Gy = new double[nrows][ncols];
    G  = new double[nrows][ncols];

    for (i=0; i<nrows; i++) {
      for (j=0; j<ncols; j++) {
        if (i==0 || i==nrows-1 || j==0 || j==ncols-1)
          Gx[i][j] = Gy[i][j] = G[i][j] = 0; // Image boundary cleared
        else{using Java Advanced Imaging using uml
          Gx[i][j] = img[i+1][j-1] + 2*img[i+1][j] + img[i+1][j+1] -
                     img[i-1][j-1] - 2*img[i-1][j] - img[i-1][j+1];
          Gy[i][j] = img[i-1][j+1] + 2*img[i][j+1] + img[i+1][j+1] -
                     img[i-1][j-1] - 2*img[i][j-1] - img[i+1][j-1];
          G[i][j]  = Math.abs(Gx[i][j]) + Math.abs(Gy[i][j]);
        }
      }
    }
}
