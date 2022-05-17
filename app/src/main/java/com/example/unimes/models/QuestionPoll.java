package com.example.unimes.models;

public class QuestionPoll {

    String QuestionId, Question, Answer1, Answer2, Answer3, Answer4, CorrectAnswer;


    public QuestionPoll(String questionId, String question, String answer1, String answer2, String answer3, String answer4, String correctAnswer) {
        QuestionId = questionId;
        Question = question;
        Answer1 = answer1;
        Answer2 = answer2;
        Answer3 = answer3;
        Answer4 = answer4;
        CorrectAnswer = correctAnswer;
    }

    public QuestionPoll() {
    }

    //Create Question Constructor
    public QuestionPoll(String question, String answer1, String answer2, String answer3, String answer4) {
        this.Question = question;
        this.Answer1 = answer1;
        this.Answer2 = answer2;
        this.Answer3 = answer3;
        this.Answer4 = answer4;
    }

    public String getQuestionId(String key) {
        return QuestionId;
    }

    public void setQuestionId(String questionId) {
        QuestionId = questionId;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public String getAnswer1() {
        return Answer1;
    }

    public void setAnswer1(String answer1) {
        Answer1 = answer1;
    }

    public String getAnswer2() {
        return Answer2;
    }

    public void setAnswer2(String answer2) {
        Answer2 = answer2;
    }

    public String getAnswer3() {
        return Answer3;
    }

    public void setAnswer3(String answer3) {
        Answer3 = answer3;
    }

    public String getAnswer4() {
        return Answer4;
    }

    public void setAnswer4(String answer4) {
        Answer4 = answer4;
    }

    public String getCorrectAnswer() {
        return CorrectAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        CorrectAnswer = correctAnswer;
    }
}
