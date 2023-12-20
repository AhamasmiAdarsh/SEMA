package com.example.sema3.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


import com.example.sema3.R;

public class HomeFragment extends Fragment {



     ImageView image1;
     ImageView image2;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        // Find the ImageView by ID

        image1 = view.findViewById(R.id.image1);
        image2 = view.findViewById(R.id.image2);

        // Set OnClickListener for image1

        // Set OnClickListener for image2
        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new WaterFragment();
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container,fragment).commit();
            }
        });


        return view;





    }

}
