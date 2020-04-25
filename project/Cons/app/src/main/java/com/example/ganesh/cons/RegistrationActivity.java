package com.example.ganesh.cons;

import android.app.FragmentManager;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {


    EditText fn,ln,add,city,em,cno,un,ps,cps;
    Button btnsave;
    SQLiteDatabase db;
    RadioButton male, female;
    String gender = "";
    FragmentManager fragmentManager=getFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        male = (RadioButton) findViewById(R.id.radioMale);
        female = (RadioButton) findViewById(R.id.radioFeMale);


        try {
            db = openOrCreateDatabase("ConstructionDB", MODE_PRIVATE, null);
            db.execSQL("create table if not exists ConRegister(regId integer primary key autoincrement,fname varchar(20),lname varchar(20),addr varchar(100),ct varchar(20),em varchar(20),phone varchar(20),gender varchar(20),uname varchar(20),pass varchar(20))");
            Toast.makeText(getApplicationContext(), "Connection is successfully.....", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
        }

        fn = (EditText) findViewById(R.id.fname);
        ln = (EditText) findViewById(R.id.lname);
        add = (EditText) findViewById(R.id.add);
        city = (EditText) findViewById(R.id.City);
        em = (EditText) findViewById(R.id.email);
        cno = (EditText) findViewById(R.id.phno);
        un = (EditText) findViewById(R.id.uname);
        ps = (EditText) findViewById(R.id.pass1);
        cps = (EditText) findViewById(R.id.pass2);
        btnsave = (Button) findViewById(R.id.btn1);

       btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean flag = false;

                try {

                    String fname = fn.getText().toString();
                    String lname = ln.getText().toString();
                    String address = add.getText().toString();
                    String ct = city.getText().toString();
                    String contactno = cno.getText().toString();
                    String email = em.getText().toString();
                    String uname = un.getText().toString();
                    String password = ps.getText().toString();
                    String conpass = cps.getText().toString();

                    if (fname.isEmpty() || lname.isEmpty() || address.isEmpty() || contactno.isEmpty() || email.isEmpty() || uname.isEmpty() || password.isEmpty() || conpass.isEmpty()) {
                        flag = true;
                        Toast.makeText(getApplicationContext(), "Pls Input something", Toast.LENGTH_LONG).show();
                    }

                    if (!male.isChecked() && !female.isChecked()) {
                        Toast.makeText(getApplicationContext(), "Pls Select Your Gender", Toast.LENGTH_LONG).show();
                    }

                    if (male.isChecked()) {

                        gender = "Male";
                    }
                    if (female.isChecked()) {

                        gender = "FeMale";
                    }

                    if (flag != true) {
                        db.execSQL("insert into  ConRegister(fname,lname,addr,ct,em,phone,gender,uname,pass) values('" + fname + "','" + lname + "','" + address + "','" + ct + "','" + email + "','" + contactno + "','" + gender + "','" + uname + "','" + password + "')");
                        //Toast.makeText(getApplicationContext(),fname+lname+address+ct+contactno+email+gender+uname+password+conpass,Toast.LENGTH_LONG).show();
                        Toast.makeText(getApplicationContext(), "Records Successfully Saved... ..", Toast.LENGTH_LONG).show();
                    }

                    fragmentManager.beginTransaction().replace(R.id.nav1, new AdminFragment()).commit();
                }

            catch (Exception ex) {
               Toast.makeText(getApplicationContext(), ex.toString(), Toast.LENGTH_LONG).show();
           }


            }
        });
    }
}
