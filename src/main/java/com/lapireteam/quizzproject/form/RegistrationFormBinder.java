package com.lapireteam.quizzproject.form;

import com.lapireteam.quizzproject.enumeration.Role;
import com.lapireteam.quizzproject.entity.User;
import com.lapireteam.quizzproject.repository.UserRepository;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.data.binder.ValidationResult;
import com.vaadin.flow.data.binder.ValueContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class RegistrationFormBinder {

    private final RegistrationForm registrationForm;

    /**
     * Flag for disabling first run for password validation
     */
    private boolean enablePasswordValidation;

    public RegistrationFormBinder(RegistrationForm registrationForm) {
        this.registrationForm = registrationForm;
    }

    /**
     * Method to add the data binding and validation logics
     * to the registration form
     */
    public void addBindingAndValidation(UserRepository userRepository) {
        BeanValidationBinder<User> binder = new BeanValidationBinder<>(User.class);
        binder.bindInstanceFields(registrationForm);

        binder.forField(registrationForm.getPasswordField())
                .withValidator(this::passwordValidator).bind("password");

        registrationForm.getPasswordConfirmField().addValueChangeListener(e -> {
            enablePasswordValidation = true;

            binder.validate();
        });

        binder.setStatusLabel(registrationForm.getErrorMessageField());

        registrationForm.getSubmitButton().addClickListener(event -> {
            try {
                User userBean = new User();

                binder.writeBean(userBean);

                userBean.setRole(Role.USER);
                userBean.setPassword(new BCryptPasswordEncoder().encode(userBean.getPassword()));

                userRepository.save(userBean);

                showSuccess(userBean);
            } catch (ValidationException exception) {
                // validation errors are already visible for each field,
                // and bean-level errors are shown in the status label.
                // We could show additional messages here if we want, do logging, etc.
            }
        });
    }

    /**
     * Method to validate that:
     * <p>
     * 1) Password is at least 8 characters long
     * <p>
     * 2) Values in both fields match each other
     */
    private ValidationResult passwordValidator(String pass1, ValueContext ctx) {
        if (pass1 == null || pass1.length() < 8) {
            return ValidationResult.error("Votre mot de passe doit contenir au moins 8 caractères");
        }

        if (!enablePasswordValidation) {
            enablePasswordValidation = true;
            return ValidationResult.ok();
        }

        String pass2 = registrationForm.getPasswordConfirmField().getValue();

        if (pass1.equals(pass2)) {
            return ValidationResult.ok();
        }

        return ValidationResult.error("Les mots de passe ne correspondent pas");
    }

    /**
     * We call this method when form submission has succeeded
     */
    private void showSuccess(User userBean) {
        Notification notification =
                Notification.show("Bienvenue " + userBean.getFirstName());
        notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);

        UI.getCurrent().navigate("");
    }

}