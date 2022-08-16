package com.geektech.lesson2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ThirdFragment extends Fragment {

        private Button btnNext;
        private String KEY_FOR_BUNDLE ="KeyValue";
        private EditText editText;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.fragment_main, container, false);
        }

        @Override
        public void onDestroyView() {
            super.onDestroyView();
        }

        @Override
        public void onDetach() {
            super.onDetach();
        }

        @Override
        public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            btnNext=view.findViewById(R.id.bntNext);
            editText=view.findViewById(R.id.text);
            editText=view.findViewById(R.id.text2);
            editText=view.findViewById(R.id.text3);

            btnNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    nextFragment();
                }
            });
        }

        private void nextFragment(){
            Bundle bundle=new Bundle();
            bundle.putString(KEY_FOR_BUNDLE,editText.getText().toString());
            SecondFragment fragment=new SecondFragment();
            fragment.setArguments(bundle);
            requireActivity().getSupportFragmentManager().beginTransaction().
                    replace(R.id.container,fragment).
                    addToBackStack(null).commit();
        }

    }