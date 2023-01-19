package com.lapireteam.quizzproject.views;

import com.lapireteam.quizzproject.components.Layout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.*;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@AnonymousAllowed
@Route("login")
@PageTitle("Se connecter | Quizzle")
public class LoginView extends VerticalLayout implements BeforeEnterObserver {
    LoginI18n i18n = LoginI18n.createDefault();
    private final LoginForm loginForm = new LoginForm();

    public LoginView() {
        addClassName("login-view");
        setAlignItems(Alignment.CENTER);

        this.setuptI18N();

        loginForm.setI18n(i18n);
        loginForm.setAction("login");
        loginForm.setForgotPasswordButtonVisible(false);

        add(new Layout(), new H1("Quizzle"), loginForm, new RouterLink("S'inscrire", RegistrationView.class));
    }

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        if (beforeEnterEvent.getLocation()
                .getQueryParameters()
                .getParameters()
                .containsKey("error")) {
            loginForm.setError(true);
        }
    }

    /**
     * Set up the internationalization for the login form
     */
    private void setuptI18N() {
        LoginI18n.Form i18nForm = i18n.getForm();

        i18nForm.setTitle("");
        i18nForm.setUsername("Nom d'utilisateur");
        i18nForm.setPassword("Mot de passe");
        i18nForm.setSubmit("Se connecter");
        i18nForm.setForgotPassword("Mot de passe oublié ?");
        i18n.setForm(i18nForm);

        LoginI18n.ErrorMessage i18nErrorMessage = i18n.getErrorMessage();
        i18nErrorMessage.setTitle("Nom d'utilisateur ou mot de passe incorrect");
        i18nErrorMessage.setMessage(
                "Veuillez vérifier votre nom d'utilisateur et votre mot de passe et réessayer.");
        i18n.setErrorMessage(i18nErrorMessage);
    }
}
