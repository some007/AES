package com.example.aes.Contactlist.viewmodel;

import android.content.Context;

import androidx.databinding.BaseObservable;
import androidx.databinding.ObservableArrayList;

import com.example.aes.Contactlist.model.Contact;
import com.example.user.contactlist.model.Contact;
import com.example.user.contactlist.model.ContactRepository;

import java.util.List;

public class ContactViewModel extends BaseObservable {

    private ObservableArrayList<Contact> contacts;
    private ContactRepository repository;

    public ContactViewModel(Context context) {
        contacts = new ObservableArrayList<>();
        repository = new ContactRepository(context);
    }

    public List<Contact> getContacts() {
        contacts.addAll(repository.fetchContacts());
        return contacts;
    }
}
