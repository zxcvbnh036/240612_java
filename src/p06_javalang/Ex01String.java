package p06_javalang;

import java.util.Arrays;
import java.util.StringJoiner;

public class Ex01String {
  public static void main(String[] args) {
    String str2 = new String("hello");
    // new 생성 연산자 제외 모두 같음
    String str1 = "hello";
    String str3 = "hello";
    String str4 = String.valueOf("hello");
    System.out.println(str1 == str2);
    System.out.println(str1 == str3);
    System.out.println(str1 == str4);
    System.out.println(str1.hashCode());
    System.out.println(str2.hashCode());
    System.out.println(str3.hashCode());
    System.out.println(str4.hashCode());
    System.out.println(System.identityHashCode(str1));
    System.out.println(System.identityHashCode(str2));
    System.out.println(System.identityHashCode(str3));
    System.out.println(System.identityHashCode(str4));
    System.out.println(str1.equals(str4));
    // 문자열을 다루는 함수는 '=='이 아닌 'equals'로 비교해야 함

    // constant pool에 str1의 변수가 가리키는 "hello"를 가져옴
    System.out.println("str1.intern(): "+ str1.intern());
    for (int i = 0; i < str1.length(); i++) {
      if (i!=0) System.out.print(",");
      System.out.print(str1.charAt(i));
    }
    System.out.println();
    System.out.println(str1.compareTo("world"));
    System.out.println(str1.concat(" world"));
    System.out.println(str1.contains("hell"));
    System.out.println(str1.startsWith("hell"));
    System.out.println(str1.endsWith("lo"));
    System.out.println(str1.indexOf("l"));
    System.out.println(str1.indexOf("l", 3));
    System.out.println(str1.lastIndexOf("l"));
    System.out.println(str1.replace("l", "k"));
    System.out.println(str1.replace("o", ""));
    String[] arr = "Passion is genesis of genius".split(" ");
    System.out.println(Arrays.toString(arr));
    String fileName = "abc.index.html";
    System.out.println(fileName.substring(fileName.lastIndexOf(".") + 1));
    System.out.println(fileName.substring(fileName.indexOf(".")+1, fileName.lastIndexOf(".")));
    System.out.println("hello world".toUpperCase());
    System.out.println("hello world".toLowerCase());
    System.out.println("  hello world  ".trim());
    System.out.println(String.valueOf(0b100));
    System.out.println(String.valueOf(0010));
    System.out.println(String.valueOf(0xa0));
    StringJoiner sj = new StringJoiner(" ", "'", "'");
    for (String s : arr) {
      sj.add(s);
    }
    System.out.println(sj.toString());


  }
}
