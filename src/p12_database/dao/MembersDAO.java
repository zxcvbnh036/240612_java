package p12_database.dao;

import p12_database.vo.Members;

import java.sql.SQLException;

public class MembersDAO extends DAOSet {
  public Members longinCheck(String id, String pass) {
    Members members = null;
    try {
      conn = connectDB();
      String sql = "select * from members where id=? and pass=? ";
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally {
    }
    return members;
  }
}
