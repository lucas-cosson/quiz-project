package lapireteam.quizzle.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import lapireteam.quizzle.entity.Question;
import lapireteam.quizzle.entity.QuestionOption;
import lapireteam.quizzle.entity.Subject;
import lapireteam.quizzle.repository.QuestionRepository;
import lapireteam.quizzle.repository.SubjectRepository;
import lapireteam.quizzle.repository.UserRepository;

import java.util.Arrays;

@Component
@Profile("dev")
public class InitialData implements ApplicationListener<ApplicationReadyEvent> {

    private SubjectRepository subjectRepository;
    private QuestionRepository questionRepository;
    private UserRepository userRepository;
    private BCryptPasswordEncoder encoder;

    @Autowired
    public InitialData(SubjectRepository subjectRepository, QuestionRepository questionRepository, UserRepository userRepository) {
        this.subjectRepository = subjectRepository;
        this.questionRepository = questionRepository;
        this.userRepository = userRepository;
        this.encoder = new BCryptPasswordEncoder();
    }

    /**
     * This event is executed as late as conceivably possible to indicate that
     * the application is ready to service requests.
     */
    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
        initData();
    }

    public void initData() {

        questionRepository.deleteAll();
        subjectRepository.deleteAll();
        userRepository.deleteAll();

        Subject CS101 = new Subject();
        CS101.setSubjectCode("CS101");
        CS101.setTitle("Quiz sur NLP");

        subjectRepository.save(CS101);

        Subject MTH101 = new Subject();
        MTH101.setSubjectCode("MTH101");
        MTH101.setTitle("Quiz n°2");

        subjectRepository.save(MTH101);


        questionRepository.save(createQuestion(
                CS101,
                "Que signifie NLP ?",
                new String[]{
                        "Natural Language Parsing",
                        "Natural Language Performing",
                        "Natural Language Processing",
                        "Natural Language Processing"
                },
                2
        ));

        questionRepository.save(createQuestion(
                CS101,
                "Que préfèrent les français ?",
                new String[]{
                        "Les quizzes",
                        "Les blindtests",
                        "Le loto",
                        "Les sudokus"
                },
                0
        ));

        questionRepository.save(createQuestion(
                CS101,
                "Combien de balises possède POS ?",
                new String[]{
                        "4",
                        "6",
                        "8",
                        "10"
                },
                2
        ));

        questionRepository.save(createQuestion(
                CS101,
                "Qu'est ce qu'un texte multilabel ?",
                new String[]{
                        "Plusieurs étiquettes par token",
                        "Plusieurs tokens par etiquettes",
                        "Une étiquette par texte",
                        "Plusieurs bouteilles de Label 5"
                },
                0
        ));

        questionRepository.save(createQuestion(
                CS101,
                "Python est-il un bon langage ?",
                new String[]{
                        "Mieux que C++",
                        "Oui",
                        "Non",
                        "Pas du tout"
                },
                0
        ));

        questionRepository.save(createQuestion(
                CS101,
                "Qu'est ce que NLP ?",
                new String[]{
                        "Une danse",
                        "Une IA d'apprentissage",
                        "Un NFT",
                        "Une marque de voiture"
                },
                1
        ));

        questionRepository.save(createQuestion(
                CS101,
                "spacy a sa propre méthode d'impression graphie ?",
                new String[]{
                        "Oui",
                        "Non",
                        "Ni oui ni non",
                        "Oui et non"
                },
                0
        ));

        questionRepository.save(createQuestion(
                CS101,
                "Qu'est ce que le preprocessing ?",
                new String[]{
                        "Des préliminaires",
                        "Un processeur précoce",
                        "Une suppression des mots inutiles et ponctuations",
                        "La reponse D"
                },
                2
        ));

        questionRepository.save(createQuestion(
                CS101,
                "Qu'est ce qu'un stopword ?",
                new String[]{
                        "Un mot final",
                        "Un panneau stop",
                        "Un mot inutile",
                        "Un mot grossier"
                },
                2
        ));

        questionRepository.save(createQuestion(
                CS101,
                "Qui est le meilleur professeur ?",
                new String[]{
                        "Nicolas Marilleau",
                        "Jacques Bahi",
                        "Violeta Felea",
                        "Jean Michel Hufflen"
                },
                0
        ));


/*
        questionRepository.save(createQuestion(
                MTH101,
                "Communication protocol is a __________that governs the flow of information over a network",
                new String[]{
                        "Set of protocols",
                        "Set of rules",
                        "Device",
                        "Set of methods"
                },
                1
        ));

        questionRepository.save(createQuestion(
                MTH101,
                "Communication protocol is a __________that governs the flow of information over a network",
                new String[]{
                        "Set of protocols",
                        "Set of rules",
                        "Device",
                        "Set of methods"
                },
                1
        ));

        questionRepository.save(createQuestion(
                MTH101,
                "Communication protocol is a __________that governs the flow of information over a network",
                new String[]{
                        "Set of protocols",
                        "Set of rules",
                        "Device",
                        "Set of methods"
                },
                1
        ));

        questionRepository.save(createQuestion(
                MTH101,
                "Communication protocol is a __________that governs the flow of information over a network",
                new String[]{
                        "Set of protocols",
                        "Set of rules",
                        "Device",
                        "Set of methods"
                },
                1
        ));

        questionRepository.save(createQuestion(
                MTH101,
                "Communication protocol is a __________that governs the flow of information over a network",
                new String[]{
                        "Set of protocols",
                        "Set of rules",
                        "Device",
                        "Set of methods"
                },
                1
        ));

        questionRepository.save(createQuestion(
                MTH101,
                "Communication protocol is a __________that governs the flow of information over a network",
                new String[]{
                        "Set of protocols",
                        "Set of rules",
                        "Device",
                        "Set of methods"
                },
                1
        ));

        questionRepository.save(createQuestion(
                MTH101,
                "Communication protocol is a __________that governs the flow of information over a network",
                new String[]{
                        "Set of protocols",
                        "Set of rules",
                        "Device",
                        "Set of methods"
                },
                1
        ));

        questionRepository.save(createQuestion(
                MTH101,
                "Communication protocol is a __________that governs the flow of information over a network",
                new String[]{
                        "Set of protocols",
                        "Set of rules",
                        "Device",
                        "Set of methods"
                },
                1
        ));

        questionRepository.save(createQuestion(
                MTH101,
                "Communication protocol is a __________that governs the flow of information over a network",
                new String[]{
                        "Set of protocols",
                        "Set of rules",
                        "Device",
                        "Set of methods"
                },
                1
        ));
*/
    }
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

        question.setQuestionOptions(Arrays.asList(option1, option2,option3, option4));

        question.setCorrectAnswer(question.getQuestionOptions().get(ansIndex));

        return question;
    }
}