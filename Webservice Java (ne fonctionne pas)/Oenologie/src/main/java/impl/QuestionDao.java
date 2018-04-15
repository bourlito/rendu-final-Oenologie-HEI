package impl;

import entities.Question;

public interface QuestionDao {
    public Question getQuestion(Integer id);
    public Question addQuestion(Question question);


}

