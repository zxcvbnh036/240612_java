package p07_Collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Ex02LinkedList {
  public static void main(String[] args) {
    List al = new ArrayList();
    List ll = new LinkedList();

    System.out.println("===순차적 추가===");
    System.out.println("ArrayList  : " + addSequentially(al));
    System.out.println("LinkedList : " + addSequentially(ll));
    System.out.println("===중간에 추가===");
    System.out.println("ArrayList  : " + addMiddle(al));
    System.out.println("LinkedList : " + addMiddle(ll));
    System.out.println("===중간 삭제===");
    System.out.println("ArrayList  : "+ removeMiddle(al));
    System.out.println("LinkedList : " + removeMiddle(ll));
    System.out.println("===순차적 삭제===");
    System.out.println("ArrayList  : " + removeaddSequentially(al));
    System.out.println("LinkedList : " + removeaddSequentially(ll));
  }

  private static long addSequentially(List list) {
    long start = System.currentTimeMillis();
    for (int i = 0; i < 1000000; i++) {
      list.add(i + "");
    }
    long end = System.currentTimeMillis();
    return end - start;
  }

  private static long addMiddle(List list) {
    long start = System.currentTimeMillis();
    for (int i = 0; i < 10000; i++) {
      list.add(5000, i + "");
    }
    long end = System.currentTimeMillis();
    return end - start;
  }

  private static long removeaddSequentially(List<String> list) {
    long start = System.currentTimeMillis();
    for (int i = list.size() - 1; i >= 0; i--) {
      list.remove(i); // index로 지음
    }
    long end = System.currentTimeMillis();
    return end - start;
  }

  private static long removeMiddle(List<String> list) {
    long start = System.currentTimeMillis();
    for (int i = 0; i <= 10000; i++) {
      list.remove(i); // index로 지음
    }
    long end = System.currentTimeMillis();
    return end - start;
  }
}
