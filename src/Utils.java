public class Utils {

  public static void addHeader(String header) {
    int count = 0;
    String dashes = "";
    for (int i = 0; i < 50 - header.length(); i++) {
      dashes = dashes + "-";
    }
    System.out.println();
    System.out.println("----- " + header + " " + dashes);
  }
}
