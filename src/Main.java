public class Main {
  int num1 = 10;
  int num2 = 20;
  int num3 = num1 + num2;


  void done() {
    System.out.println(num3);
    if(num1 < num2) {
      num3 = num1;
    } else {
      num3 = num2;
    }
  }

  public void main(String[] args) {
    Main main = new Main();
    main.done();
  }
}









