package p12_database.controller;

import p12_database.service.MembersService;
import p12_database.ui.FrmJoin;
import p12_database.ui.FrmLogin;
import p12_database.ui.FrmMain;
import p12_database.ui.FrmModify;
import p12_database.vo.Members;

import javax.swing.*;
import java.util.HashMap;

public class MainController {
  private Members session;
  private static MainController mainController;
  private MembersService membersService = new MembersService();

  private MainController() { }

  public static MainController getInstance() {
    if(mainController == null) mainController = new MainController();
    return mainController;
  }

  public void setSession(Members session) {
    this.session = session;
  }
  public Members getSession() {return session;}
  public MembersService getMembersService() {return membersService;}

  public void dispatchCmd(String request, HashMap map) {
    if (request.equals("Join")) {
      new FrmJoin();
    } else if (request.equals("Main")) {
      new FrmMain();
    } else if (request.equals("Modify")) {
      JFrame fr = (JFrame) map.get("owner");
      Members members = (Members) map.get("members");
      boolean modal = (boolean) map.get("modal");
      new FrmModify(fr, members, modal);
    } else {
      new FrmLogin();
    }
  }
}