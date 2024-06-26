package p07_Collection;

import java.util.TreeSet;

public class Ex07TreeSet {
  public static void main(String[] args) {
    // Treeset 정렬되는 기능을 가짐
    // 정렬될 수 있는 값들만 받음
    TreeSet set = new TreeSet();
    set.add(new Ball(4));
    set.add(new Ball(1));
    set.add(new Ball(3));
    System.out.println(set);
  }
}

class Ball implements Comparable {
  private int num;

  public Ball(int num) {
    this.num = num;
  }

  @Override
  public int compareTo(Object o) {
    if (o instanceof Ball) {
      Ball b = (Ball) o;
      // 뺀 값이 0이면 같다, 음수면 작다, 양수면 크다
      return num - b.num; // 순차정렬
      // return - (num - b.num); // 역정렬
    }
    return 0;
  }

  @Override
  public String toString() {
    return num + "";
  }

}
