package p12_database.dao;

import p12_database.vo.Members;

import java.sql.SQLException;
import java.util.ArrayList;

public class MembersDAO extends DAOSet {
  public Members loginCheck(String id, String pass) {
    Members members = null;
    try {
      conn = connectDB();
      String sql = "select * from members where id=? and pass=? ";
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, id);
      pstmt.setString(2, pass);
      rs = pstmt.executeQuery();
      if (rs.next()) {
        members = new Members(rs.getLong("mno"), rs.getString("id"), rs.getString("pass"), rs.getString("name"), rs.getString("mobile"));
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally {
      closeDB();
    }
    return members;
  }

  public Members getMembers(int mno) {
    Members members = null;
    try {
      conn = connectDB();
      String sql = "select * from members where mno=? ";
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, mno);
      rs = pstmt.executeQuery();
      if (rs.next()) {
        members = new Members(rs.getLong("mno"), rs.getString("id"), rs.getString("pass"), rs.getString("name"), rs.getString("mobile"));
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally {
      closeDB();
    }
    return members;
  }
  public boolean insertMembers(Members members) {
    boolean result = false;
    try {
      conn = connectDB();

      String sql = "insert into members(mno,id, pass, name, mobile) "
          + "VALUES(sq_members.nextval, ?, ?, ?, ?) ";
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, members.getId());
      pstmt.setString(2, members.getPass());
      pstmt.setString(3, members.getName());
      pstmt.setString(4, members.getMobile());
      int cnt = pstmt.executeUpdate(); //insert되는 행의 수만큼 리턴
      if (cnt > 0) result = true;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally {
      closeDB();
    }
    return result;
  }

  public boolean updateMembers(Members members) {
    boolean result = false;
    try {
      conn = connectDB();
      String sql = "update members set pass=?, name=?, mobile=? where mno=? ";
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, members.getPass());
      pstmt.setString(2, members.getName());
      pstmt.setString(3, members.getMobile());
      pstmt.setLong(4, members.getMno());
      int cnt = pstmt.executeUpdate(); //insert되는 행의 수만큼 리턴
      if (cnt > 0) result = true;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally {
      closeDB();
    }
    return result;
  }

  public boolean deleteMembers(int mno) {
    boolean result = false;
    try {
      conn = connectDB();
      String sql = "delete members where mno=? ";
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, mno);
      int cnt = pstmt.executeUpdate(); //insert되는 행의 수만큼 리턴
      if (cnt > 0) result = true;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally {
      closeDB();
    }
    return result;
  }

  public ArrayList<Members> getList() {
    ArrayList<Members> result = new ArrayList<>();
    try {
      conn = connectDB();
      String sql = "select * from members ";
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();
      while (rs.next()) {
        Members m = new Members(
            rs.getLong("mno"),
            rs.getString("id"),
            rs.getString("pass"),
            rs.getString("name"),
            rs.getString("mobile"));
        result.add(m);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      closeDB();
    }
    return result;
  }

  public boolean isDuplicateId(String id) {
    boolean result = false;
    try {
      conn = connectDB();
      String sql = "select * from members where id=? ";
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, id);
      rs = pstmt.executeQuery();
      if (rs.next()) result = true;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally {
      closeDB();
    }
    return result;
  }
}