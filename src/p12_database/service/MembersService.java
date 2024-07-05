package p12_database.service;

import p12_database.dao.MembersDAO;
import p12_database.vo.Members;

import java.util.ArrayList;

public class MembersService {
  private MembersDAO membersDAO = new MembersDAO();

  public ArrayList<Members> getList() {
    ArrayList<Members> result = null;
    result = membersDAO.getList();
    return result;
  }
  public void deleteMembers(int mno) {
    membersDAO.deleteMembers(mno);
  }

  public Members loginCheck(String id, String pass) {
    return membersDAO.loginCheck(id, pass);
  }

  public boolean insertMembers(Members members) {
    return membersDAO.insertMembers(members);
  }
  public boolean isDuplicatedId(String id) {
    return membersDAO.isDuplicateId(id);
  }

}