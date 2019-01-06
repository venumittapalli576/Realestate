package com.developmentapps.realestate;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class Contactus extends AppCompatActivity {
    EditText nm,no,eid,type;
    String to,subject,message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactus);
        nm=findViewById(R.id.editText7) ;
        no=findViewById(R.id.editText8) ;
        eid=findViewById(R.id.editText9) ;
        type=findViewById(R.id.editText10) ;

        Toolbar toolbar =findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab =findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Welcome to Realestate Mobile Application ", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
            }
        });
    }

    public void sendmail(View view) {
        to = "info@example.com";
        subject = "inquiry";
        message = nm.getText().toString()+"\n"+no.getText().toString()+"\n"+eid.getText().toString()+"\n"+type.getText().toString();


        Intent email = new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
        email.putExtra(Intent.EXTRA_SUBJECT, subject);
        email.putExtra(Intent.EXTRA_TEXT, message);

        //need this to prompts email client only
        email.setType("message/rfc822");

        startActivity(Intent.createChooser(email, "Choose The Type:"));
    }
}
