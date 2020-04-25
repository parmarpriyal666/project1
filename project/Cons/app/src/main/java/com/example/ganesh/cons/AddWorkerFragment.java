package com.example.ganesh.cons;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.app.Fragment;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


public class AddWorkerFragment extends Fragment {

    EditText name,contactno,addr,sadddr;
    SQLiteDatabase db;
    Button btn;
    String gender="";
    RadioButton male,female;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final  View view= inflater.inflate(R.layout.fragment_add_worker, container, false);

        name = (EditText)view.findViewById(R.id.wname);
        contactno = (EditText)view.findViewById(R.id.wcno);
        addr = (EditText)view.findViewById(R.id.wadd);
        sadddr = (EditText)view.findViewById(R.id.wsite);
        btn = (Button) view.findViewById(R.id.wsave);

        male = (RadioButton)view.findViewById(R.id.radioMale);
        female = (RadioButton)view.findViewById(R.id.radioFeMale);


        try {
            db = getActivity().openOrCreateDatabase("ConstructionDB", Context.MODE_PRIVATE, null);
            db.execSQL("create table if not exists worker(w_Id integer primary key autoincrement,w_name varchar(20),cno varchar(20),gender varchar(10),addr varchar(20),saddr varchar(20))");
            Toast.makeText(getActivity(), "Connection is successfully.....", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_LONG).show();
        }

        try {

            if (male.isChecked()) {

                gender = "Male";
            }
            if (female.isChecked()) {

                gender = "FeMale";
            }


            btn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {

                    String wname=name.getText().toString();
                    String wcno=contactno.getText().toString();
                    String add=addr.getText().toString();
                    String sadd=sadddr.getText().toString();


                    db.execSQL("insert into  worker(w_name,cno,gender,addr,saddr) values('" + wname + "','" + wcno + "','" + gender + "','" + add + "','" + sadd + "')");
                    Toast.makeText(getActivity(), "Records Successfully Saved... ..", Toast.LENGTH_LONG).show();
                }
            });
        }
        catch (Exception e){
            Toast.makeText(getActivity(),e.toString(),Toast.LENGTH_LONG).show();
        }










        return view;
    }


}
