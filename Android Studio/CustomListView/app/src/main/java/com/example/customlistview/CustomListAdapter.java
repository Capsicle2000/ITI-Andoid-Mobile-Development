package com.example.customlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class CustomListAdapter extends ArrayAdapter<Contact> {
    private Context context;
    private List<Contact> contactList;

    public CustomListAdapter(Context context, List<Contact> contactList) {
        super(context, 0, contactList);
        this.context = context;
        this.contactList = contactList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(context).inflate(R.layout.list_item_card, parent, false);
        }

        final Contact currentContact = contactList.get(position);

        ImageView imageViewProfile = listItemView.findViewById(R.id.imageViewProfile);
        TextView textViewName = listItemView.findViewById(R.id.textViewName);
        TextView textViewNumber = listItemView.findViewById(R.id.textViewNumber);

        imageViewProfile.setImageResource(currentContact.getProfileImage());
        textViewName.setText(currentContact.getName());
        textViewNumber.setText(currentContact.getNumber());

        // Set click listener for the contact card
        listItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String contactName = currentContact.getName();
                Toast.makeText(context, "Clicked on contact: " + contactName, Toast.LENGTH_SHORT).show();
            }
        });

        return listItemView;
    }
}