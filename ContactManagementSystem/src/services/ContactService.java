package services;

import models.Contact;
import java.util.ArrayList;
import java.util.List;

public class ContactService {
    private List<Contact> contacts = new ArrayList<>();

    // Add a new contact
    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    // Get all contacts
    public List<Contact> getContacts() {
        return contacts;
    }

    // Edit a contact
    public boolean editContact(int id, Contact updatedContact) {
        for (Contact contact : contacts) {
            if (contact.getId() == id) {
                contact.setName(updatedContact.getName());
                contact.setEmail(updatedContact.getEmail());
                contact.setPhoneNumber(updatedContact.getPhoneNumber());
                return true;
            }
        }
        return false;
    }

    // Delete a contact
    public boolean deleteContact(int id) {
        return contacts.removeIf(contact -> contact.getId() == id);
    }
}
