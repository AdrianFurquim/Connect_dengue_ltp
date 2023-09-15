package edu.ifsp.connectdengue.connectdengueapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.ifsp.connectdengue.connectdengueapi.model.DengueShow;
import edu.ifsp.connectdengue.connectdengueapi.model.DengueShowDAO;


@RestController
public class ControllerDengueShow {
    @GetMapping("/dengueshow/ver")
    public List<DengueShow> endPoint1() {

        DengueShowDAO quiz = DengueShowDAO.getInstance();
        // DengueShow questionario = new DengueShow(1, null, 5);
        // quiz.create(questionario);
        List<DengueShow> quizes = quiz.findAll();
        return quizes;
    }
    @PostMapping("dengueshow/inserir")
    public DengueShow endPoint2(@RequestBody DengueShow questionario) {

        DengueShowDAO quizDados = DengueShowDAO.getInstance();
        List<DengueShow> quizes = quizDados.findAll();
        int existente = 0;
        for (DengueShow quizFor : quizes) {
            if(questionario.getIdQuiz() == quizFor.getIdQuiz()){
                existente++;
            }
        }
        if(existente > 0){
            return null;
        }else{
            quizDados.create(questionario);
            return questionario;
        }
        
    }
    @DeleteMapping("/dengueshow/quiz/remove/{id}")
    public DengueShow removerQuestionario(@PathVariable("id") long idQuiz) {
        
        DengueShowDAO quizDados = DengueShowDAO.getInstance();
        List<DengueShow> quizes = quizDados.findAll();
        for (DengueShow quiz : quizes) {
            if(quiz.getIdQuiz() == idQuiz){
                quizDados.delete(quiz);
                return quiz;
            }
        }
        return null;
    }

}
