package controllers;

import models.Contact;
import services.ContactService;
import java.util.Scanner;

public class ContactController {
    private static ContactService contactService = new ContactService();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nContact Management System");
            System.out.println("1. Add Contact");
            System.out.println("2. Get Contacts");
            System.out.println("3. Edit Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    getContacts();
                    break;
                case 3:
                    editContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addContact() {
        System.out.print("Enter Contact ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Phone Number: ");
        String phoneNumber = scanner.nextLine();

        Contact contact = new Contact(id, name, email, phoneNumber);
        contactService.addContact(contact);
        System.out.println("Contact added successfully.");
    }

    private static void getContacts() {
        System.out.println("Contacts List:");
        for (Contact contact : contactService.getContacts()) {
            System.out.println(contact);
        }
    }

    private static void editContact() {
        System.out.print("Enter Contact ID to Edit: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter New Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter New Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter New Phone Number: ");
        String phoneNumber = scanner.nextLine();

        Contact updatedContact = new Contact(id, name, email, phoneNumber);
        if (contactService.editContact(id, updatedContact)) {
            System.out.println("Contact updated successfully.");
        } else {
            System.out.println("Contact not found.");
        }
    }

    private static void deleteContact() {
        System.out.print("Enter Contact ID to Delete: ");
        int id = scanner.nextInt();
        if (contactService.deleteContact(id)) {
            System.out.println("Contact deleted successfully.");
        } else {
            System.out.println("Contact not found.");
        }
    }
}
