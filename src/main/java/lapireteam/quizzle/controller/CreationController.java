package lapireteam.quizzle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import lapireteam.quizzle.entity.*;
import lapireteam.quizzle.repository.QuestionRepository;
import lapireteam.quizzle.repository.QuizRepository;
import lapireteam.quizzle.repository.SubjectRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("quiz/create")
public class CreationController {

    private int counter =0;

    private SubjectRepository subjectRepository;
    private QuestionRepository questionRepository;

    private QuizRepository quizRepository;

    @Autowired
    public CreationController(SubjectRepository subjectRepository,QuestionRepository questionRepository) {
        this.subjectRepository = subjectRepository;
        this.questionRepository = questionRepository;
    }

    @InitBinder
    public void webBinder(WebDataBinder webDataBinder) {
        webDataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    @GetMapping({"", "/"})
    public String getCreate(Model model) {
        counter=0;
        CreationForm creationForm = new CreationForm();
        model.addAttribute("cre", creationForm);
        model.addAttribute("subs", subjectRepository.findAll());
        return "create";
    }

    @PostMapping({"", "/"})
    public String processCreate(@Valid @ModelAttribute("cre") CreationForm form, BindingResult errors) {
        counter+=1;
        if (errors.hasErrors()) {
            return "create";
        }

        counter+=1;
        Subject subject = form.toSubject();
        subjectRepository.save(subject);

        Question question = form.toQuestion();
        questionRepository.save(question);

            return "redirect:/login";

    }
}
