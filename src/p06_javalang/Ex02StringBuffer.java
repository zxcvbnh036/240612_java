package p06_javalang;

public class Ex02StringBuffer {
  public static void main(String[] args) {
    // String은 문자열 선언시 크기가 한정적
    // 문자열의 수정, 삽입, 삭제가 용이한 StringBuffer
    StringBuffer sb = new StringBuffer("hello");
    System.out.println(System.identityHashCode(sb));
    System.out.println(sb.length());
    System.out.println(sb.capacity());
    sb.append(" world");
    System.out.println(sb);
    System.out.println(sb.hashCode());
    System.out.println(System.identityHashCode(sb));
    System.out.println(sb.delete(4,6));
    System.out.println(sb.insert(4, "o"));
    System.out.println(sb.reverse());
    StringBuffer sb2 = new StringBuffer(
        "나랏말싸미 뒹국에 달아 백성에 이르고자 할배"
    );
    System.out.println(sb2.reverse());
  }
}
