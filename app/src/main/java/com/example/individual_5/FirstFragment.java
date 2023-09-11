package com.example.individual_5;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;


public class FirstFragment extends Fragment {

    public static List<String> wordList = new ArrayList<>();
    public static WordAdapter wordAdapter;

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        FloatingActionButton fab = view.findViewById(R.id.fab);

        wordAdapter = new WordAdapter(wordList, position -> {
            String clickedWord = "Clicked " + wordList.get(position);
            wordList.set(position, clickedWord);
            wordAdapter.notifyItemChanged(position);

            Bundle bundle = new Bundle();
            bundle.putInt("position", position);
            Navigation.findNavController(view).navigate(R.id.action_firstFragment_to_secondFragment, bundle);
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(wordAdapter);

        fab.setOnClickListener(v -> {
            wordList.add("New Word");
            wordAdapter.notifyItemInserted(wordList.size() - 1);
        });

        return view;
    }
}