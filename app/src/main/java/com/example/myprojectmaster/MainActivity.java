package com.example.myprojectmaster;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Passer un appel téléphonique
        Button callButton = findViewById(R.id.call_button);
        EditText phoneNumberInput = findViewById(R.id.phone_number_input);
        callButton.setOnClickListener(v -> {
            String phoneNumber = phoneNumberInput.getText().toString();
            if (!phoneNumber.isEmpty()) {
                Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneNumber));
                startActivity(callIntent);
            } else {
                Toast.makeText(this, "Entrez un numéro valide", Toast.LENGTH_SHORT).show();
            }
        });

        // Envoyer un SMS
        Button smsButton = findViewById(R.id.sms_button);
        EditText smsNumberInput = findViewById(R.id.sms_number_input);
        EditText smsContentInput = findViewById(R.id.sms_content_input);
        smsButton.setOnClickListener(v -> {
            String phoneNumber = smsNumberInput.getText().toString();
            String message = smsContentInput.getText().toString();
            if (!phoneNumber.isEmpty() && !message.isEmpty()) {
                Intent smsIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + phoneNumber));
                smsIntent.putExtra("sms_body", message);
                startActivity(smsIntent);
            } else {
                Toast.makeText(this, "Complétez tous les champs", Toast.LENGTH_SHORT).show();
            }
        });

        // Envoyer un email
        Button emailButton = findViewById(R.id.email_button);
        emailButton.setOnClickListener(v -> {
            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.setType("message/rfc822");
            emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"destinataire@example.com"});
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Sujet de l'email");
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Corps de l'email");
            startActivity(Intent.createChooser(emailIntent, "Envoyer l'email via"));
        });

        // Partager du contenu
        Button shareButton = findViewById(R.id.share_button);
        EditText shareContentInput = findViewById(R.id.share_content_input);
        shareButton.setOnClickListener(v -> {
            String content = shareContentInput.getText().toString();
            if (!content.isEmpty()) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT, content);
                startActivity(Intent.createChooser(shareIntent, "Partager via"));
            } else {
                Toast.makeText(this, "Entrez du contenu à partager", Toast.LENGTH_SHORT).show();
            }
        });

        // Ouvrir Google Maps
        Button mapsButton = findViewById(R.id.maps_button);
        EditText locationInput = findViewById(R.id.location_input);
        mapsButton.setOnClickListener(v -> {
            String location = locationInput.getText().toString();
            if (!location.isEmpty()) {
                Intent mapsIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + location));
                startActivity(mapsIntent);
            } else {
                Toast.makeText(this, "Entrez une localisation", Toast.LENGTH_SHORT).show();
            }
        });

        // Ouvrir un navigateur web
        Button browserButton = findViewById(R.id.browser_button);
        EditText urlInput = findViewById(R.id.url_input);
        browserButton.setOnClickListener(v -> {
            String url = urlInput.getText().toString();
            if (!url.isEmpty()) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(browserIntent);
            } else {
                Toast.makeText(this, "Entrez une URL valide", Toast.LENGTH_SHORT).show();
            }
        });
    }
}