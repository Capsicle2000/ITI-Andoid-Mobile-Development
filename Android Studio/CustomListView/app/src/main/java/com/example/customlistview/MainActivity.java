package com.example.customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listViewContacts;
    private CustomListAdapter adapter;
    private List<Contact> contactList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewContacts = findViewById(R.id.listViewContacts);
        contactList = generateContactList();

        adapter = new CustomListAdapter(this, contactList);
        listViewContacts.setAdapter(adapter);

    }


    private List<Contact> generateContactList() {
        List<Contact> contacts = new ArrayList<>();

        contacts.add(new Contact("Marwan Magdy Saad", "01015252646", R.drawable.profile1));
        contacts.add(new Contact("Ahmed Tarek Rashad", "01185558018", R.drawable.profile2));
        contacts.add(new Contact("Mahmoud Mohamed", "01285158018", R.drawable.profile3));
        contacts.add(new Contact("Mohamoud Ahmed", "01114261564", R.drawable.profile4));
        contacts.add(new Contact("Adham Emad", "01585558018", R.drawable.profile5));
        contacts.add(new Contact("Sirag Mohamed Mostafa", "01051526649", R.drawable.profile6));
        contacts.add(new Contact("Mohamed Mostafa", "01235152664", R.drawable.profile7));
        contacts.add(new Contact("Moamen Raafat", "01182689423", R.drawable.profile8));
        contacts.add(new Contact("Shehab El-Din", "01033980808", R.drawable.profile9));
        contacts.add(new Contact("Ahmed Ek-Badawy", "01115269872", R.drawable.profile10));

        return contacts;
    }
}