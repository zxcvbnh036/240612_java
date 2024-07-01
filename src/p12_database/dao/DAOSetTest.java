package p12_database.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class DAOSetTest {
  public static void main(String[] args) {
    DAOSet daoSet = new DAOSet();
    try {
      Class.forName("oracle.jdbc.driver.OracleDriver");
      Connection conn = daoSet.connectDB();
      System.out.println(conn.isClosed()?"접속종료":"접속중");
    } catch (ClassNotFoundException e) {
      System.out.println("드라이버로딩 오류: "+e.getMessage());
    } catch (SQLException e) {
      System.out.println("접속 오류: "+e.getMessage());
    } finally {
      daoSet.closeDB();
    }
  }
}