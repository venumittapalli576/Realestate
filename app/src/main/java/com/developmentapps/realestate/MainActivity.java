package com.developmentapps.realestate;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText eid,pwd;
    Button cont;
    String q;
    SQLiteDatabase SQLITEDATABASE;
    Boolean CheckEditTextEmpty;
    SQLiteHelper db;
    TextView login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eid=findViewById(R.id.editText);
        pwd=findViewById(R.id.editText2);
        cont=findViewById(R.id.button);

    }


    public void cont(View view) {
        String email=eid.getText().toString();
        String password=pwd.getText().toString();
        db=new SQLiteHelper(this);
        SQLITEDATABASE=db.getWritableDatabase();
        Cursor c=SQLITEDATABASE.rawQuery("select * from login where unm='"+email+"' and pwd='"+password+"'",null);

        if(c.getCount()>0 && c.moveToNext()){
            Toast.makeText(getApplicationContext(),"login successfully",Toast.LENGTH_LONG).show();
            Intent in = new Intent(this,Navigation.class);
            startActivity(in);

        }
        else{


            Toast.makeText(getApplicationContext(),"invalid credentials",Toast.LENGTH_LONG).show();

        }
    }

    public void goreg(View view) {
        Intent in=new Intent(this,signup.class);

        startActivity(in);
    }
    @Override
    public void onBackPressed() {

        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        startActivity(intent);
    }
}
