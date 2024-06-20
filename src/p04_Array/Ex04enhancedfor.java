package p04_Array;

public class Ex04enhancedfor {
  public static void main(String[] args) {
    String[] arr = {"홍길동", "이순신", "장보고", "김유신"};
    for (String item : arr) {
      System.out.println(item);
    }
    // 자바에서 배열의 단점
    // 1. 설정된 크기를 변경할 수 없다.
    int[] nums = {1, 2, 3};
    System.out.println(nums.hashCode());
    int[] nums2 = {1, 2, 3, 4};
    System.out.println(nums2.hashCode());
    nums = nums2;
    System.out.println(nums.hashCode());

  }
}
