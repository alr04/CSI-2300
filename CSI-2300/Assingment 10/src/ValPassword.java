import java.util.Scanner;

public class ValPassword {

    public static class Validation {

        int a = 0;

        public void Validate (String pswd) {

            pswd.toLowerCase();
            
            if (pswd.length() < 8 || pswd.length() > 16) {
                System.out.println("Password must be between 8 and 16 characters (inclusive)");
            }

            else {

                if (pswd.matches("[a-z]+[0-9]+")) {
                    System.out.println("Valid");
                }

                else if (pswd.matches("[0-9]+[a-z]+")) {
                    System.out.println("Valid");
                }

                else if (pswd.matches("[a-z]+[~!@#$%^&*()-=+_]+")) {
                    System.out.println("Valid");
                }

                else if (pswd.matches("[~!@#$%^&*()-=+_]+[a-z]+")) {
                    System.out.println("Valid");
                }

                else if (pswd.matches("[\\w]+[~!@#$%^&*()-=+_]+")) {
                    System.out.println("Valid");
                }

                else if (pswd.matches("[~!@#$%^&*()-=+_]+[\\w]+"))
                    System.out.println("Valid");

                else {
                    System.out.println("Invalid");
                }
            }

        }

    }
        
    public static void main(String[] args) throws Exception {
            
        Scanner s = new Scanner(System.in);
        System.out.print("Enter Password: ");

        String password = s.nextLine();

        Validation val = new Validation();
        val.Validate(password);

        s.close();
        
    }

}
