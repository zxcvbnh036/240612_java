package p03_method;

public class Ex06operator {
  public static void main(String[] args) {
    System.out.println("사칙 연산자 +,-,*,/");
    System.out.println("나머지연산자 %");
    System.out.println("증감 연산자(단항) ++. --");
    int a = 1;
    System.out.printf("a = %d \n", a);
    System.out.printf("a++ = %d, ++a = %d \n", a++, ++a);

    a = 1;
    System.out.printf("a++ : %d %d %d %d %d \n",
        a++, a++, a++, a++, a++);
    a = 1;
    System.out.printf("a++ : %d %d %d %d %d \n",
        ++a, ++a, ++a, ++a, ++a);
    a = 1;
    int s = a++ + a++ + ++a;
    System.out.printf("s : %d \n", s);
    System.out.println("대입 연산자 +=, -=, *=, /=, %=");
    System.out.println("a : " + a);
    a += 1; // a = a + 1
    a -= 1 + s; // a = a -1 -s // a = a - (1+s)
    System.out.println(a);
    a = 1;
    a *= 2 + a; // a = a * (2+a)
    System.out.println(a);
    System.out.println("비교 연산자 >,>=,<,<=,!=,==");
    System.out.println(100 > 10);
    System.out.println("논리 연산자 ||, &&, !");
    System.out.println(!false);
    // ^ = false + true = true
    System.out.println(10>2 && 2>10);
    System.out.println("shift 연산자 >>,<<");
    a = 2;
    System.out.println(a<<2); // 2진수로 변환 후 왼쪽 2번 옮김 = < 한 번에 2씩 곱하기
    System.out.println("bit 연산자 |, &, ^, ~ ");
    System.out.println(2 | 1);
    System.out.println(2 & 3);
    System.out.println(2 ^ 1);
    System.out.println(~1);
    System.out.println("a: " + a + (a > 0 ? "양수" : "음수"));
    System.out.println("a: " + (a = -1) + (a > 0 ? "양수" : "음수"));
  }
}
