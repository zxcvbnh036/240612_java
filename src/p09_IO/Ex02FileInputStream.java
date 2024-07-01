package p09_IO;

import java.io.*;

public class Ex02FileInputStream {
  public static void main(String[] args) {
    // try catch finally 반드시 close 해야함.
    FileInputStream fis = null;
    InputStreamReader reader = null;
    BufferedReader br = null;
    try {
      fis = new FileInputStream(
          "C:\\workspace\\spaceJava\\20240611_java" +
              "\\src\\p08_IO\\Ex02FileInputStream.java");
      reader = new InputStreamReader(fis);
      br = new BufferedReader(reader);
      int data;
      while ((data = br.read()) != -1) {
        char c = (char) data;
        System.out.print(c);
      }
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    } finally {
      try {
        br.close();
        reader.close();
        fis.close();
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }

    // tryWithResource
    try (
        FileInputStream fis2 = new FileInputStream(
            "C:\\workspace\\spaceJava\\20240611_java" +
                "\\src\\p08_IO\\Ex02FileInputStream.java");
        InputStreamReader reader2 = new InputStreamReader(fis2);
        BufferedReader br2 = new BufferedReader(reader2);
    ) {
      int data;
      while ((data = br2.read()) != -1) {
        char c = (char) data;
        System.out.print(c);
      }
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}