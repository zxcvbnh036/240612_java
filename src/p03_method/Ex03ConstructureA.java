package p03_method;

public class Ex03ConstructureA {
  public static void main(String[] args) {
    Employee employee =
        new Employee("LGH", 1, "2000-10-10", 22, "male");
    System.out.println(employee.getEname());
    Employee employee1 = new Employee();
    Employee employee2 = new Employee();
  }
}

class Employee {
  {
    System.out.println("Initial Bolck instance");
  }
  static {
    System.out.println("Initial Bolck static");
  }

  private String Ename;
  private int Empno;
  private String hiredate;
  private int age;
  private String gender;

  public Employee() {

  }

  public Employee(String ename, int empno, String hiredate, int age, String gender) {
    Ename = ename;
    Empno = empno;
    this.hiredate = hiredate;
    this.age = age;
    this.gender = gender;
  }

  public String getEname() {
    return Ename;
  }

  public void setEname(String ename) {
    Ename = ename;
  }

  public int getEmpno() {
    return Empno;
  }

  public void setEmpno(int empno) {
    Empno = empno;
  }

  public String getHiredate() {
    return hiredate;
  }

  public void setHiredate(String hiredate) {
    this.hiredate = hiredate;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }
}