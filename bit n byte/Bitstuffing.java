import java.util.Scanner;

public class Bitstuffing {

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the message: ");
    String data = sc.nextLine();
    String stuffedData = "";
    int counter = 0;

    // Stuffing Process
    for (int i = 0; i < data.length(); i++) {
      char c = data.charAt(i);
      if (c != '0' && c != '1') {
        System.out.println("Error: Enter a valid binary value (0 or 1).");
        return;
      }

      if (c == '1') {
        counter++;
        stuffedData += c;
      } else {
        counter = 0;
        stuffedData += c;
      }
      if (counter == 5) {
        stuffedData += '0';
        counter = 0;
      }
    }

    String flag = "01111110";
    String finalStuffedData = flag + stuffedData + flag;
    System.out.println("Flag--> " + flag);
    System.out.println("Stuffed data at intermediate site is: " + finalStuffedData);

    // Destuffing Process
    String destuffedData = "";
    counter = 0;
    for (int i = 0; i < stuffedData.length(); i++) {
      char c = stuffedData.charAt(i);
      if (c == '1') {
        counter++;
        destuffedData += c;
      } else {
        counter = 0;
        destuffedData += c;
      }
      if (counter == 5) {
        if (i + 1 < stuffedData.length() && stuffedData.charAt(i + 1) == '0') {
          i++; // Skip the stuffed '0'
        }
        counter = 0;
      }
    }
    System.out.println("Destuffed BIT is: " + destuffedData);
  }
}