package com.example.quizbee.model;

import com.example.quizbee.model.Module;
import com.example.quizbee.model.Question;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Quiz {
    @SerializedName("_id")
    private String id;
    private Module module;
    private List<Question> questions;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
