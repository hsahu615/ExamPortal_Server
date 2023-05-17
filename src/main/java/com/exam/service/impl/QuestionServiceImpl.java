package com.exam.service.impl;

import com.exam.model.exam.Question;
import com.exam.model.exam.Quiz;
import com.exam.repository.QuestionRepository;
import com.exam.repository.QuizRepository;
import com.exam.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionRepository questionRepository;
    @Override
    public Question addQuestion(Question question) {
        return this.questionRepository.save(question);
    }

    @Override
    public Question updateQuestion(Question question) {
        return this.questionRepository.save(question);
    }

    @Override
    public void deleteQuestion(Long qid) {
        Question question = new Question();
        question.setQuesId(qid);
        this.questionRepository.delete(question);

    }

    @Override
    public Set<Question> getQuestions() {
        return new HashSet<>(this.questionRepository.findAll());
    }

    @Override
    public Question getQuestion(Long qid) {
        return this.questionRepository.findById(qid).get();
    }

    @Override
    public Set<Question> getQuestionsOfQuiz(Quiz quiz) {
        return this.questionRepository.findByQuiz(quiz);
    }
}
