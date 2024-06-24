package p05_Inherit;

public class Ex15MyException {
  public static void main(String[] args) {
    try {
      // Exception 상속받았기 때문에 throw 사용
      throw new MyException("내가 발생시킨 예외");
    } catch (MyException e) {
      System.out.println(e.getMessage());
    }
  }
}

class MyException extends Exception {
  public MyException(String message) {
    super(message);
  }
}
