package p08_IO;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

public class Ex03FileOutputStream {
  public static void main(String[] args) {
    try (
        FileOutputStream fos = new FileOutputStream("123.txt");
        BufferedOutputStream bos = new BufferedOutputStream(fos, 5);
    ) {
      for (int i = 0; i < '9'; i++) {
        bos.write(i);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
