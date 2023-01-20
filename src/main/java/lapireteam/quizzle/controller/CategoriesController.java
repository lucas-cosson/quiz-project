package lapireteam.quizzle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import lapireteam.quizzle.repository.SubjectRepository;

@Controller
@RequestMapping("quiz/categories")
public class CategoriesController {

    SubjectRepository subjectRepository;

    @Autowired
    public CategoriesController(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @GetMapping({"", "/"})
    public String getCategories(Model model) {
        model.addAttribute("subs", subjectRepository.findAll());
        return "categories";
    }


}
