package p10_Stream;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

public class Ex01Stream {
  public static void main(String[] args) {
    // stream : 데이터를 처리하는 코드에만 집중
    // 반복되는 요소는 컬렉션이 처리할 수 있게 함
    // 1) 데이터 변경 안 함, 2) 일회용, 3) 내부 반복작업

    // Stream을 통하여 데이터를 모은다.
    Stream<Student> stream = Stream.of(
        new Student("감자바", 3, 200),
        new Student("이자바", 3, 200),
        new Student("박자바", 2, 200),
        new Student("정자바", 2, 200),
        new Student("최자바", 1, 200),
        new Student("성자바", 1, 200),
        new Student("안자바", 3, 200),
        new Student("전자바", 1, 200),
        new Student("홍자바", 2, 200)
    );
    // Stream을 정렬하는 메서드를 적용하고 비교하는 객체를 Comparator.comparing
    stream.sorted(Comparator.comparing(new Function<Student, Integer>() {
      @Override
      public Integer apply(Student student) {
        return student.getBan(); // 반별로 묶어 준다.
      }
      // 반별로 묶은 것을 반을 naturalOrder(오름차순)으로 정렬한다.
    }).thenComparing(Comparator.naturalOrder())).forEach(new Consumer<Student>() {
      @Override
      public void accept(Student student) {
        System.out.println(); // 정렬 후 각각에 대하여 출력한다.
      }
    });
  }
}

class Student implements Comparable<Student> {
  String name;
  int ban;
  int totalScore;

  public Student(String name, int ban, int totalScore) {
    this.name = name;
    this.ban = ban;
    this.totalScore = totalScore;
  }

  @Override
  public int compareTo(Student s) {
    return -1 * (totalScore - s.totalScore);
  }

  public String toString() {
    return String.format("[%s, %d, %d]", name, ban, totalScore);
  }

  public String getName() {
    return name;
  }

  public int getBan() {
    return ban;
  }

  public int getTotalScore() {
    return totalScore;
  }
}
