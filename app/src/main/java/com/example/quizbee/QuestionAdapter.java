package com.example.quizbee;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizbee.databinding.QuestionItemBinding;
import com.example.quizbee.model.Question;

import java.util.List;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionViewHolder> {
     private List<Question> questions;
     private OnServiceListener serviceListener;
    public QuestionAdapter(List<Question> questions) {
        this.questions = questions;
    }
    void setServiceAction(OnServiceListener listener){
        this.serviceListener = listener;
    }

    void setQuestions(List<Question> questions) {
        this.questions = questions;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public QuestionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        QuestionItemBinding binding = QuestionItemBinding.inflate(inflater, parent, false);
        QuestionViewHolder viewHolder = new QuestionViewHolder(binding);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionViewHolder holder, int position) {
        Question quiz = questions.get(position);
        holder.binding.qnoTxt.setText(String.valueOf(quiz.getNumber()));
        holder.binding.getRoot().setOnClickListener(v -> {
            serviceListener.onClicked(quiz.getNumber());
        });

    }

    @Override
    public int getItemCount() {
        return questions.size();
    }
}
