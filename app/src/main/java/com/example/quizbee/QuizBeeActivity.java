package com.example.quizbee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.quizbee.databinding.ActivityQuizBeeBinding;

public class QuizBeeActivity extends AppCompatActivity {
    private ActivityQuizBeeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQuizBeeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("QuizBee");
       handleStartBtn();
    }

    private void handleStartBtn() {
        binding.startBtn.setOnClickListener(v -> {
            Intent intent = new Intent(this,QuestionsActivity.class);
            startActivity(intent);
        });
    }
}