import p05_Inherit.Ex10Modifier;

public class Ex10protected extends Ex10Modifier {
  String str = protectedVar;
  public Ex10protected() {
    System.out.println(protectedVar);
  }
  void done() {
    System.out.println(publicVar);
    System.out.println(protectedVar);
    // System.out.println(defaultVar);
    // System.out.println(privatVar);
  }
}

class ModifierEx {
  Ex10Modifier ex10Modifier = new Ex10Modifier();
  void done() {
    System.out.println(ex10Modifier.publicVar);
    // System.out.println(ex10Modifier.protectedVar);
    // System.out.println(ex10Modifier.defaultVar);
    // System.out.println(ex10Modifier.privatVar);
  }
}


