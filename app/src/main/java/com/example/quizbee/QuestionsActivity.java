package com.example.quizbee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import com.example.quizbee.databinding.ActivityQuestionsBinding;
import com.example.quizbee.model.Question;
import com.example.quizbee.model.Quiz;
import com.example.quizbee.network.FakeApi;
import com.example.quizbee.network.OnServiceApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuestionsActivity extends AppCompatActivity {
    private List<Quiz> quizList = new ArrayList<>();
    private QuestionAdapter adapter;
    private ActivityQuestionsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQuestionsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setUpData();
        connectData();
        getApiData();
    }

    private void getApiData() {
        OnServiceApi onServiceApi = new FakeApi().createFakeApiService();
        Call<List<Quiz>> call = onServiceApi.getDataApi();
        call.enqueue(new Callback<List<Quiz>>() {
            @Override
            public void onResponse(Call<List<Quiz>> call, Response<List<Quiz>> response) {
                quizList = response.body();
                adapter.setQuestions(quizList.get(0).getQuestions());
                showQuestionDetails(1);
            }

            @Override
            public void onFailure(Call<List<Quiz>> call, Throwable t) {
                Toast.makeText(QuestionsActivity.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void connectData() {
        binding.questionRv.setAdapter(adapter);
        binding.questionRv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }

    private void setUpData() {
        adapter = new QuestionAdapter(new ArrayList<>());
    }

    public void showQuestionDetails(int questionNo) {
        Question question = quizList.get(0).getQuestions().get(questionNo - 1);
        binding.questionTxt.setText(question.getQuestion());
        binding.oneRb.setText(question.getAnswers().get(0));
        binding.twoRb.setText(question.getAnswers().get(1));
        binding.threeRb.setText(question.getAnswers().get(2));
        binding.fourRb.setText(question.getAnswers().get(3));


    }
}