package com.lapireteam.quizzproject.form;

import com.vaadin.flow.component.HasValueAndElement;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;

import java.util.stream.Stream;

public class RegistrationForm extends FormLayout {
    private final PasswordField password;
    private final PasswordField passwordConfirm;

    private final Span errorMessageField;

    private final Button submitButton;

    public RegistrationForm() {
        H3 title = new H3("Inscription");

        TextField firstName = new TextField("Prénom");
        TextField lastName = new TextField("Nom");
        TextField username = new TextField("Nom d'utilisateur");

        EmailField email = new EmailField("Email");

        password = new PasswordField("Mot de passe");
        passwordConfirm = new PasswordField("Confirmation du mot de passe");

        setRequiredIndicatorVisible(firstName, lastName, email, password,
                passwordConfirm);

        errorMessageField = new Span();

        submitButton = new Button("S'inscrire");
        submitButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        add(title, firstName, lastName, username, email, password,
                passwordConfirm, errorMessageField,
                submitButton);

        setMaxWidth("500px");

        setResponsiveSteps(
                new ResponsiveStep("0", 1, ResponsiveStep.LabelsPosition.TOP),
                new ResponsiveStep("490px", 2, ResponsiveStep.LabelsPosition.TOP));

        setColspan(title, 2);
        setColspan(username, 2);
        setColspan(email, 2);
        setColspan(errorMessageField, 2);
        setColspan(submitButton, 2);
    }

    public PasswordField getPasswordField() {
        return password;
    }

    public PasswordField getPasswordConfirmField() {
        return passwordConfirm;
    }

    public Span getErrorMessageField() {
        return errorMessageField;
    }

    public Button getSubmitButton() {
        return submitButton;
    }

    private void setRequiredIndicatorVisible(HasValueAndElement<?, ?>... components) {
        Stream.of(components).forEach(comp -> comp.setRequiredIndicatorVisible(true));
    }
}
