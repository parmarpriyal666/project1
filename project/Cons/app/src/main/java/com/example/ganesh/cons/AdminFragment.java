package com.example.ganesh.cons;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class AdminFragment extends Fragment {

    EditText e1,e2;
    TextView t1,t2;
    Button btn;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      final  View view= inflater.inflate(R.layout.fragment_admin, container, false);

         e1= (EditText)view.findViewById(R.id.un);
         e2= (EditText)view.findViewById(R.id.pword);
         t1= (TextView)view.findViewById(R.id.fp);
         t2= (TextView)view.findViewById(R.id.cnew);
         btn= (Button)view.findViewById(R.id.save);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {

                    String usname = e1.getText().toString();
                    String password = e2.getText().toString();

                    if(usname.equals("admin")&&password.equals("111"))
                    {
                        Intent dhara1=new Intent(getActivity(),afteradmin.class);
                        startActivity(dhara1);
                        Toast.makeText(getActivity()," Admin login Successfully.....", Toast.LENGTH_LONG).show();

                    }
                    else
                    {
                        Intent dhara2=new Intent(getActivity(),aftermanager.class);
                        startActivity(dhara2);
                        Toast.makeText(getActivity()," Manager login Successfully.....",Toast.LENGTH_LONG).show();
                    }

                }
                catch (Exception ex){
                    Toast.makeText(getActivity(), ex.toString(), Toast.LENGTH_LONG).show();
                }

            }

        });


        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myint3 = new Intent(getActivity(),RegistrationActivity.class);
                startActivity(myint3);

            }
        });

        return view;
    }



}
