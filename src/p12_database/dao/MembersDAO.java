package p12_database.dao;

import p12_database.vo.Members;

import java.sql.SQLException;

public class MembersDAO extends DAOSet {
  public Members longinCheck(String id, String pass) {
    Members members = null;
    try {
      conn = connectDB();
      String sql = "select * from members where id=? and pass=? ";
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, id);
      pstmt.setString(2, pass);
      rs = pstmt.executeQuery();
      if (rs.next()) {
        members = new Members(rs.getLong("mno"),
            rs.getString("id"),rs.getString("pass"),
            rs.getString("name"),rs.getString("mobile")
        );
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally {
      closeDB();
    }
    return members;
  }
}
