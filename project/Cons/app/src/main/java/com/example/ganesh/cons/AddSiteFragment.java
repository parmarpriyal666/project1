package com.example.ganesh.cons;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class AddSiteFragment extends Fragment {

    SQLiteDatabase db;
    EditText e1,e2;
    Button btn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final  View view=inflater.inflate(R.layout.fragment_add_site, container, false);

        e1 = (EditText)view.findViewById(R.id.sitename);
        e2 = (EditText)view.findViewById(R.id.sadd);
        btn = (Button)view.findViewById(R.id.ssave);

        try {
            db = getActivity().openOrCreateDatabase("ConstructionDB", Context.MODE_PRIVATE, null);
            db.execSQL("create table if not exists site(s_Id integer primary key autoincrement,s_name varchar(20),saddr varchar(20))");
            Toast.makeText(getActivity(), "Connection is successfully.....", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_LONG).show();
        }

        try {
            btn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {

                    String sname=e1.getText().toString();
                    String add=e2.getText().toString();

                    db.execSQL("insert into site(s_name,saddr) values('" + sname + "','" + add + "')");
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
