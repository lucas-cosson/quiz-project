package lapireteam.quizzle.entity;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Arrays;

@Getter
@Setter
public class CreationForm {
    String title;
    Subject subject;
    String questionText;
    @NotNull
    String[] optionsText;
    int ansIndex;
    private Question createQuestion(Subject subject, String questionText, String[] optionsText, int ansIndex) {
        Question question = new Question();
        question.setQuestion(questionText);
        question.setSubject(subject);
        question.setTotalMarks(1);

        QuestionOption option1 = new QuestionOption();
        option1.setQuestion(question);
        option1.setQuestionOption(optionsText[0]);

        QuestionOption option2 = new QuestionOption();
        option2.setQuestion(question);
        option2.setQuestionOption(optionsText[1]);

        QuestionOption option3 = new QuestionOption();
        option3.setQuestion(question);
        option3.setQuestionOption(optionsText[2]);

        QuestionOption option4 = new QuestionOption();
        option4.setQuestion(question);
        option4.setQuestionOption(optionsText[3]);

        question.setQuestionOptions(Arrays.asList(option1, option2, option3, option4));

        question.setCorrectAnswer(question.getQuestionOptions().get(ansIndex));

        return question;
    }
    public CreationForm() {
    }

    public CreationForm(String title,String questionText, @NotBlank(message = "options are required") String[] optionsText, int ansIndex) {
        this.title=title;
        this.questionText=questionText;
        this.optionsText=optionsText;
        this.ansIndex=ansIndex;
    }
    public Subject toSubject() {
        Subject CS102 = new Subject();
        CS102.setSubjectCode("CS102");
        CS102.setTitle(title);
        subject=CS102;
        ansIndex=0;
        return CS102;
    }
    public Question toQuestion() {
        return createQuestion(subject,questionText,optionsText,ansIndex);
    }

}
