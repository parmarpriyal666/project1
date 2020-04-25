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
import android.widget.GridView;
import android.widget.Toast;


public class ListSiteFragment extends Fragment {

    SQLiteDatabase db;
    GridView gv;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_list_site, container, false);


        try
        {
            db=getActivity().openOrCreateDatabase("ConstructionDB",Context.MODE_PRIVATE,null);
            gv=(GridView)view.findViewById(R.id.mygrid);
            Toast.makeText(getActivity(), "Connection is successfully.....", Toast.LENGTH_LONG).show();
        }
        catch (Exception e){
            Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_LONG).show();
        }


        Cursor c = db.rawQuery("select * FROM site", null);

        // Checking if no records found
        if (c.getCount() == 0) {
            showMessage("Error", "No records found");
        }

        // Appending records to a string buffer
        StringBuffer buffer = new StringBuffer();

        while (c.moveToNext()) {
            buffer.append("Id: "+c.getString(0)+"\n");
            buffer.append("SITE NAME:"+" -->"+ c.getString(1) + "\n");
            buffer.append("SITE ADDRESS:"+" --> "+ c.getString(2) + "\n");
            buffer.append("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
            //buffer.append("password"+"    --> "+ c.getString(4) + "\n\n");
        }

        // Displaying all records
        showMessage("** Site Details **", buffer.toString());

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
