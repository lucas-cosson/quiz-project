package com.lapireteam.quizzproject.views;

import com.lapireteam.quizzproject.form.RegistrationForm;
import com.lapireteam.quizzproject.form.RegistrationFormBinder;
import com.lapireteam.quizzproject.repository.UserRepository;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@AnonymousAllowed
@Route("register")
@PageTitle("Register | Quizz")
public class RegistrationView extends VerticalLayout {
    public RegistrationView(UserRepository userRepository) {
        RegistrationForm registrationForm = new RegistrationForm();
        setHorizontalComponentAlignment(Alignment.CENTER, registrationForm);

        add(registrationForm);

        RegistrationFormBinder registrationFormBinder = new RegistrationFormBinder(registrationForm);
        registrationFormBinder.addBindingAndValidation(userRepository);
    }
}
