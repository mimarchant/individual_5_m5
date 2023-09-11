package com.example.individual_5;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class SecondFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);

        EditText editText = view.findViewById(R.id.editTextWord);
        Button btnSave = view.findViewById(R.id.btnSave);

        int position = getArguments().getInt("position");
        editText.setText(FirstFragment.wordList.get(position));

        btnSave.setOnClickListener(v -> {
            FirstFragment.wordList.set(position, editText.getText().toString());
            FirstFragment.wordAdapter.notifyDataSetChanged();
            Navigation.findNavController(view).navigateUp();
        });

        return view;
    }
}