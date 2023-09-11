package com.example.individual_5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.WordViewHolder> {

    private List<String> words;
    private OnWordClickListener listener;

    public interface OnWordClickListener {
        void onWordClick(int position);
    }

    public WordAdapter(List<String> words, OnWordClickListener listener) {
        this.words = words;
        this.listener = listener;
    }

    public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        return new WordViewHolder(view, listener);
    }


    public void onBindViewHolder( WordViewHolder holder, int position) {
        holder.wordTextView.setText(words.get(position));
    }


    public int getItemCount() {
        return words.size();
    }

    static class WordViewHolder extends RecyclerView.ViewHolder {

        TextView wordTextView;

        WordViewHolder( View itemView, OnWordClickListener listener) {
            super(itemView);
            wordTextView = itemView.findViewById(android.R.id.text1);

            itemView.setOnClickListener(v -> {
                listener.onWordClick(getAdapterPosition());
            });
        }
    }
}
