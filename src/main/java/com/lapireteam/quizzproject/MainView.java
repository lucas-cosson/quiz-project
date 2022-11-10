package com.lapireteam.quizzproject;

import com.lapireteam.quizzproject.security.SecurityService;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.annotation.security.PermitAll;

@PermitAll
@Route
@PageTitle("Home | Quiz")
public class MainView extends VerticalLayout {
    public MainView(SecurityService securityService) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        add(new H1("Welcome to Quizz!"));
        add(new Text(auth.getName() + " " + auth.getDetails() + " is logged in."));
        add(new Button("Logout", e -> securityService.logout()));
    }
}
