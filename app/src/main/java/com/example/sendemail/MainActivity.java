package com.example.sendemail;

import android.content.Intent;
import android.net.Uri;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    EditText destinationEmail, emailSubject, emailMessage;
    Button sendButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        destinationEmail = findViewById(R.id.editTextTextEmailAddress);
        emailSubject = findViewById(R.id.editTextSubject);
        emailMessage = findViewById(R.id.editTextTextMultiLineMessage);
        sendButton = findViewById(R.id.buttonSend);

        sendButton.setOnClickListener(v -> {

            String destination = destinationEmail.getText().toString();
            String subject = emailSubject.getText().toString();
            String message = emailMessage.getText().toString();

            sendEmail(destination, subject, message);

        });


    }

    public void sendEmail(String destination, String subject, String message) {

        // In real world app you may send email to many email addresses
        String[] emailAddresses = {destination};

        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto"));
        emailIntent.setType("text/plain");

        emailIntent.putExtra(Intent.EXTRA_EMAIL, emailAddresses);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        emailIntent.putExtra(Intent.EXTRA_TEXT, message);

        startActivity(Intent.createChooser(emailIntent, "Send email"));

    }


}