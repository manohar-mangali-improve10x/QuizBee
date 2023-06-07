package com.example.quizbee;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizbee.databinding.QuestionItemBinding;

public class QuestionViewHolder extends RecyclerView.ViewHolder {
    QuestionItemBinding binding;

    public QuestionViewHolder(QuestionItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}
