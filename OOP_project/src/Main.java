import java.util.Scanner;

public class Main {
    static Contact[] contacts = new Contact[5];
    static int contactIndex = 0;
    static Scanner scannerNum = new Scanner(System.in);
    static Scanner scannerStr = new Scanner(System.in);
    public static void main(String[] args) {
        boolean b = true;
        while (b) {
            int n = menu();
            switch (n) {
                case 1 -> {
                    Contact contact = addContact();
                    contacts[contactIndex++] = contact;
                }
                case 2 -> showContact();
                case 3 -> deleteContact();
                case 4 -> editContact();
                case 5 -> searchContact();
                case 0-> {
                    b = false;
                }
            }
        }
    }

    public static int menu() {
        String menu = """
                *******CONTACT*******
                1.Add Contact
                2.Show Contact
                3.Delete Contact
                4.Edit Contact
                5.Search Contact
                0.Exit
                Enter option :""";
        System.out.print(menu);
        return scannerNum.nextInt();
    }

    public static Contact addContact() {
        Contact contact = new Contact();
        System.out.print("Enter name : ");
        contact.name = scannerStr.nextLine();
        System.out.print("Enter surname : ");
        contact.surname = scannerStr.nextLine();
        System.out.print("Enter phone : ");
        contact.phone = scannerStr.nextLine();
        return contact;
    }

    public static void showContact() {
        System.out.println("**********CONTACTS😊😊**********");
        System.out.println(" -------------------------------------------");
        System.out.printf(" |%-13s|%-13s|%-13s|\n","Name","Surname","Phone");
        for (int i = 0; i < contacts.length; i++) {
            Contact c = contacts[i];
            if (c != null) {
                // exception sababi null.name -> error
                System.out.printf(i + 1 + "|%-13s|%-13s|%-13s|\n",c.name,c.surname,c.phone);
            }
        }
        System.out.println(" -------------------------------------------");

    }

    public static void deleteContact(){
        showContact();
        System.out.print("Choose contact to delete: ");
        int n = scannerNum.nextInt();
        if (n>0 && n<contacts.length&&contacts[n-1]!=null) {
            for (int i = n - 1; i < contacts.length-1; i++) {
                contacts[i] = contacts[i + 1];
            }
            contacts[contacts.length - 1] = null;
        }
    }
    public static void editContact(){
        showContact();
        System.out.print("Choose contact to edit: ");
        int n = scannerNum.nextInt();
        System.out.print("Enter new name : ");
        contacts[n-1].name = scannerStr.nextLine();
        System.out.print("Enter new surname : ");
        contacts[n-1].surname = scannerStr.nextLine();
        System.out.print("Enter new phone : ");
        contacts[n-1].phone = scannerStr.nextLine();
        System.out.print("Contact edited successfully");
    }
    public static void searchContact(){
        System.out.print("Enter contact to search: ");
        String word = scannerStr.nextLine();
        for (Contact contact : contacts) {
            if (contact != null) {
                if (contact.name.contains(word) || contact.surname.contains(word) || contact.phone.contains(word)) {
                    System.out.println("*******FOUND CONTACTS😊😊********");
                    System.out.println(" -------------------------------------------");
                    System.out.printf(" |%-13s|%-13s|%-13s|\n", "Name", "Surname", "Phone");
                    System.out.printf(" |%-13s|%-13s|%-13s|\n", contact.name, contact.surname, contact.phone);
                    System.out.println(" -------------------------------------------");
                } else {
                    System.out.println("Contact not found");
                }
            }
        }
    }
}