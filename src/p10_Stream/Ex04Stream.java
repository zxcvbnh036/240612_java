package p10_Stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex04Stream {
  public static void main(String[] args) {
    // Stream: 데이터를 처리하는 코드에만 집중
    // 반복되는 요소는 컬렉션이 처리할 수 있게 함.
    // 1) 데이터 변경 안함,2)일회용, 3) 내부반복작업

    // Stream을 통하여 데이터를 모은다.
    Stream<Student> stream = Stream.of(
        new Student("김자바", 3, 300),
        new Student("이자바", 3, 200),
        new Student("박자바", 2, 200),
        new Student("정자바", 2, 200),
        new Student("최자바", 1, 200),
        new Student("성자바", 1, 200),
        new Student("안자바", 3, 200),
        new Student("전자바", 1, 200),
        new Student("홍자바", 2, 100)
    );
    /* // stream을 정렬하는 메서드를 적용하고 비교하는 객체를 Comparator.comparing
    stream.sorted(Comparator.comparing(new Function<Student, Integer>() {
      @Override
      public Integer apply(Student student) {
        return student.getBan(); //반별로 묶어 준다.
      }
      // 반별로 묶은 것을 반을 naturalOrder(오름차순)로 정렬한다.
    }).thenComparing(Comparator.naturalOrder())).forEach(new Consumer<Student>() {
      @Override
      public void accept(Student student) {
        System.out.println(student); //정렬후 각각에 대하여 출력한다.
      }
    });
    */

    // Optional 객체 사용하여 totalScore 점수가 가장 큰 사람 구하기
    // 함수형 인터페이스 Fuction에 매개변수를 2개받기 위해 만든 함수.
    /*Optional<Student> student = stream.reduce(new BinaryOperator<Student>() {
      @Override
      public Student apply(Student s1, Student s2) {
        return s1.totalScore > s2.totalScore ? s1 : s2;
      }
    });
    if(student.isPresent()) System.out.println(student);*/

    // stream을 배열로 변환
    /*System.out.println(Arrays.toString(stream.toArray(Student[]::new)));
    System.out.println(Arrays.toString(stream.toArray(new IntFunction<Student[]>() {
      @Override
      public Student[] apply(int value) {
        return new Student[value];
      }
    })));*/

    // 학생 전체 인원수 구하기
    /*System.out.println(stream.count());
    System.out.println(stream.collect(Collectors.counting()));*/

    // 학생모두의 합계 구하기
    /*System.out.println(stream.collect(Collectors.summingInt(
        new ToIntFunction<Student>() {
      @Override
      public int applyAsInt(Student s) {
        return s.getTotalScore();
      }
    })));*/

    System.out.println(stream.collect(Collectors.maxBy(
        Comparator.comparingInt(new ToIntFunction<Student>() {
          @Override
          public int applyAsInt(Student s) {
            return s.getTotalScore();
          }
        })
    )));
  }
}

class Student implements Comparable<Student> {
  String name; int ban;int totalScore;
  public Student(String name, int ban, int totalScore) {
    this.name = name;this.ban = ban;this.totalScore = totalScore;
  }
  @Override
  public int compareTo(Student s) {return -1*(totalScore-s.totalScore);  }
  public String toString(){
    return String.format("[%s, %d, %d]", name,ban,totalScore);}
  public String getName() {return name;}
  public int getBan() {return ban;}
  public int getTotalScore() {return totalScore;}
}