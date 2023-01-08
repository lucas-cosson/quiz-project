package com.lapireteam.quizzproject.components;

import com.lapireteam.quizzproject.security.SecurityService;
import com.lapireteam.quizzproject.views.LoginView;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.RouterLink;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;


public class Layout extends AppLayout {
    public Layout(SecurityService securityService) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Button searchButton = new Button(new Icon(VaadinIcon.SEARCH));
        //TODO lien vers la page de recherche de quiz

        Button createButton = new Button("Create");
        //TODO lien vers la page de création de quiz

        H1 title = new H1("Quizzle");
        title.getStyle().set("font-size", "var(--lumo-font-size-l)")
                .set("margin", "0");


        if(auth.isAuthenticated() && !auth.getName().equals("anonymousUser")){
            Button profile = new Button(auth.getName(),new Icon(VaadinIcon.USER));
            addToNavbar(searchButton,createButton,title,profile);
        }else{
            RouterLink login = new RouterLink("Login",LoginView.class);
            login.add(new Icon(VaadinIcon.USER));
            addToNavbar(searchButton,title,login);
        }

    }
}
