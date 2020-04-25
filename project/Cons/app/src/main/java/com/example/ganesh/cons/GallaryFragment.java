package com.example.ganesh.cons;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link GallaryFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link GallaryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GallaryFragment extends Fragment {
    ImageView slider;
    int[] imageArray = {
            R.drawable.g1,
            R.drawable.g2,
            R.drawable.g3,
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View myview=inflater.inflate(R.layout.fragment_gallary, container, false);
    slider=(ImageView)myview.findViewById(R.id.imageView2);
    final Handler handler = new Handler();

    final Runnable runnable = new Runnable() {

        int i = 0;
        public void run() {

            slider.setImageResource(imageArray[i]);
            i++;

            if(i > imageArray.length - 1) {
                i = 0;
            }
            handler.postDelayed(this, 2000);
        }
    };
        handler.postDelayed(runnable, 2000);

        return myview;
}
}
