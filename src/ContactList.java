import java.util.ArrayList;
import java.util.Scanner;

public class ContactList {
    private ArrayList<Person> contacts;

    public ContactList()
    {
        contacts = new ArrayList<Person>();
    }

    public ArrayList<Person> getContacts()
    {
        return contacts;
    }

    // Add contact
    public void addContact(Person contact)
    {
        contacts.add(contact);
    }

    // Print contact
    public void printContacts()
    {
        for (Person contact : contacts)
        {
            System.out.println(contact);
        }
    }

    // Bubble sort
    public void sort(int sortBy) {
        for (int i = 0; i < contacts.size() - 1; i++) {
            for (int j = 0; j < contacts.size() - i - 1; j++) {
                Person p1 = contacts.get(j);
                Person p2 = contacts.get(j + 1);
                int comparison = 0;

                if (sortBy == 0) {
                    comparison = p1.getFirstName().compareTo(p2.getFirstName());
                } else if (sortBy == 1) {
                    comparison = p1.getLastName().compareTo(p2.getLastName());
                } else if (sortBy == 2) {
                    comparison = p1.getPhoneNumber().compareTo(p2.getPhoneNumber());
                }

                if (comparison > 0) {
                    contacts.set(j, p2);
                    contacts.set(j + 1, p1);
                }
            }
        }
    }

    // Search by fire name
    public Person firstNameSearch(String firstName)
    {
        for (Person contact : contacts)
        {
            if (contact.getFirstName().equalsIgnoreCase(firstName))
            {
                return contact;
            }
        }
        return null;

    }

    // Search by last name
    public Person lastNameSearch(String lastName)
    {
        for (Person contact : contacts)
        {
            if (contact.getLastName().equalsIgnoreCase(lastName))
            {
                return contact;
            }
        }
        return null;

    }

    // Search by phone number
    public Person phoneNumberSearch(String phoneNumber)
    {
        for (Person contact : contacts)
        {
            if (contact.getPhoneNumber().equalsIgnoreCase(phoneNumber))
            {
                return contact;
            }
        }
        return null;

    }

    // List Students
    public void listStudents()
    {
        for (Person contact : contacts)
        {
            if (contact instanceof Student)
            {
                System.out.println(contact);
            }
        }
    }

    // "main" function
    public void run()
    {
        Scanner scanner = new Scanner(System.in);
        int option;

        // do while loop aka menu
        do {
            System.out.println("\nMenu options:");
            System.out.println("1. Add Contact");
            System.out.println("2. Print Contact");
            System.out.println("3. Sort Contacts");
            System.out.println("4. Search by First Name");
            System.out.println("5. Search by Last Name");
            System.out.println("6. Search by Phone Number");
            System.out.println("7. List all Students");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option)
            {
                // add contact
                case 1:
                    System.out.println("Enter first name: ");
                    String firstName = scanner.nextLine();
                    System.out.println("Enter last name: ");
                    String lastName = scanner.nextLine();
                    System.out.println("Enter Phone Number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.println("Is this a Student or Worker? (S/W): ");
                    String type = scanner.nextLine();

                    // adding a check for either a student or worker
                    if (type.equalsIgnoreCase("S"))
                    {
                        System.out.println("Enter grade");
                        int grade = scanner.nextInt();
                        scanner.nextLine();
                        addContact(new Student(firstName, lastName, phoneNumber, grade));
                    }
                    else if (type.equalsIgnoreCase(("W")))
                    {
                        System.out.println("Enter job title: ");
                        String job = scanner.nextLine();
                        addContact(new Worker(firstName, lastName, phoneNumber, job));
                    }
                    break;

                // list contacts
                case 2:
                    printContacts();
                    break;

                // sort contacts
                case 3:
                    System.out.println("Sort by (0: First Name, 1: Last Name, 2: Phone Number): ");
                    int sortBy = scanner.nextInt();
                    scanner.nextLine();
                    sort(sortBy);
                    break;

                // search by first name
                case 4:
                    System.out.println("Enter first name to search: ");
                    String searchFirstName = scanner.nextLine();
                    Person foundByFirstName = firstNameSearch(searchFirstName);
                    if (foundByFirstName != null)
                    {
                        System.out.println(foundByFirstName);
                    }
                    else
                    {
                        System.out.println(searchFirstName + "is not available");
                    }
                    break;

                // search by last name
                case 5:
                    System.out.println("Enter last name to search: ");
                    String searchLastName = scanner.nextLine();
                    Person foundByLastName = lastNameSearch(searchLastName);
                    if (foundByLastName != null)
                    {
                        System.out.println(foundByLastName);
                    }
                    else
                    {
                        System.out.println(searchLastName + "is not available");
                    }
                    break;

                // search by phone #
                case 6:
                    System.out.print("Enter phone number to search: ");
                    String searchPhoneNumber = scanner.nextLine();
                    Person foundByPhoneNumber = phoneNumberSearch(searchPhoneNumber);
                    if (foundByPhoneNumber != null) {
                        System.out.println(foundByPhoneNumber);
                    } else {
                        System.out.println(searchPhoneNumber + " is not in the list.");
                    }
                    break;

                // list all students
                case 7:
                    listStudents();
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                // default case
                default:
                    System.out.println("invalid, please try again");
            }
        } while (option != 0);

    }

    // main
    public static void main(String[] args) {
        ContactList contactList = new ContactList();

        contactList.run();
    }

}
