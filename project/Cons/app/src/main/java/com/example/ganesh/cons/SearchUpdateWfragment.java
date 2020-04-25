package com.example.ganesh.cons;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.app.Fragment;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class SearchUpdateWfragment extends Fragment {

    SQLiteDatabase db;
    EditText search1;
    Button btn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view= inflater.inflate(R.layout.fragment_search_update_wfragment, container, false);

        try
        {
            db=getActivity().openOrCreateDatabase("constructionDB",Context.MODE_PRIVATE,null);
            Toast.makeText(getActivity(), "Connection is successfully.....", Toast.LENGTH_LONG).show();
        }
        catch (Exception e){
            Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_LONG).show();
        }
        search1=(EditText)view.findViewById(R.id.sworker);
        btn=(Button)view.findViewById(R.id.wsearch);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String worker_name= search1.getText().toString();
                Cursor c = db.rawQuery("select * FROM worker where w_name='" + worker_name + "'", null);

                // Checking if no records found
                if (c.getCount() == 0) {
                    showMessage("Error", "No records found");
                }

                // Appending records to a string buffer
                StringBuffer buffer = new StringBuffer();

                while (c.moveToNext()) {
                    buffer.append("Id: " + c.getString(0) + "\n");
                    buffer.append("WORKER NAME:" + " -->" + c.getString(1) + "\n");
                    buffer.append("CONTACT NO:" + " --> " + c.getString(2) + "\n");
                    buffer.append("GENDER:" + " --> " + c.getString(3) + "\n");
                    buffer.append("ADDRESS:" + " --> " + c.getString(4) + "\n");
                    buffer.append(" SITEADDRESS:" + " --> " + c.getString(5) + "\n");
                    //buffer.append("password"+"    --> "+ c.getString(4) + "\n\n");
                }

                // Displaying all records
                showMessage("** WORKER DETAILS **", buffer.toString());


            }
        });

                return  view;
    }

    private void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();

    }

}
