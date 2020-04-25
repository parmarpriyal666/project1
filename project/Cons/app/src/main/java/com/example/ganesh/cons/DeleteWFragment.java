package com.example.ganesh.cons;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;


public class DeleteWFragment extends Fragment {

SQLiteDatabase db;
    EditText e1;
    Button dlt;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view= inflater.inflate(R.layout.fragment_delete_w, container, false);

        e1 = (EditText)view.findViewById(R.id.dwname);
        dlt = (Button) view.findViewById(R.id.dworker);

        try
        {
            db=getActivity().openOrCreateDatabase("ConstructionDB",Context.MODE_PRIVATE,null);
            Toast.makeText(getActivity(), "Connection is successfully.....", Toast.LENGTH_LONG).show();
        }
        catch (Exception e){
            Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_LONG).show();
        }


        dlt.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                String coll_name = e1.getText().toString();


                 db.execSQL("delete  FROM worker where w_name='" + coll_name + "'", null);

                showMessage("SUccess", "Records Deleted..");
                Toast.makeText(getActivity(), "Success", Toast.LENGTH_LONG).show();



            }
        });


        return  view;
    }

    public void showMessage(String title, String message) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        Toast.makeText(getActivity(),"builder", Toast.LENGTH_LONG).show();
        builder.setCancelable(true);
        Toast.makeText(getActivity(),"cancle", Toast.LENGTH_LONG).show();
        builder.setTitle(title);
        Toast.makeText(getActivity(),"title", Toast.LENGTH_LONG).show();
        builder.setMessage(message);
        Toast.makeText(getActivity(),"set msg", Toast.LENGTH_LONG).show();
        builder.show();
    }


}
