package com.lapireteam.quizzproject.views;

import com.lapireteam.quizzproject.components.Layout;
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
@PageTitle("Home | Quiz")
public class MainView extends VerticalLayout {
    public MainView(SecurityService securityService) {
        Layout layout = new Layout(securityService);
        add(layout);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        add(new H1("Welcome to Quizzle!"));
    }
}
