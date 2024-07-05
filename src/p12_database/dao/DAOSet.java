package p12_database.dao;

import java.sql.*;

public class DAOSet {
  protected Connection conn;
  protected PreparedStatement pstmt;
  protected Statement stmt;
  protected ResultSet rs;

  public Connection connectDB() throws SQLException {
    //String driver ="jdbc:mariadb://127.0.0.1:3306/db7"; //maria db
    String driver = "jdbc:oracle:thin:@localhost:1521:xe"; //oracle
    String user = "db7", pass = "1234";
    conn = DriverManager.getConnection(driver, user, pass);
    return conn;
  }
  public void closeDB() {
    try {
      if (rs != null) rs.close();
      if (stmt != null) stmt.close();
      if (pstmt != null) pstmt.close();
      if (conn != null) conn.close();
//      System.out.println(conn.isClosed()?"접속종료":"접속중");
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
  /*
    create table members(
    mno number, id varchar2(20),
    pass varchar2(20),name varchar2(20),
    mobile varchar2(20));

    create sequence sq_members;
  */
}