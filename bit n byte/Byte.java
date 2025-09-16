import java.util.Scanner;

class Bytestuffing {

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter number of words");
    int n = sc.nextInt();
    System.out.println("Enter the message ");
    String[] in = new String[n];
    for (int i = 0; i < n; i++) {
      in[i] = sc.next();
    }

    System.out.print("Transmitted message is: ");
    System.out.print("esc ");
    for (int i = 0; i < n; i++) {
      if (in[i].equals("esc")) {
        System.out.print("esc ");
      }
      System.out.print(in[i] + " ");
    }
    System.out.println("esc");
  }
}