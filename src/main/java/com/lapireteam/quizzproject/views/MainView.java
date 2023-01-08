package com.lapireteam.quizzproject.views;

import com.lapireteam.quizzproject.security.SecurityService;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@AnonymousAllowed
@Route
@PageTitle("Home | SuperQuiz")
public class MainView extends VerticalLayout {
    public MainView(SecurityService securityService) {
        addClassName("main-view");
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        add(new H1("Bienvenue " + currentPrincipalName + " !"));
        add(new Text("Vous êtes connecté en tant que " + securityService.getAuthenticatedUser() + "."));

        Button logoutButton = new Button("Se déconnecter", event -> {
            securityService.logout();
        });

        add(logoutButton);
    }
}
