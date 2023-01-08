package com.lapireteam.quizzproject.components;

import com.lapireteam.quizzproject.views.LoginView;
import com.lapireteam.quizzproject.views.MainView;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.StreamResource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@CssImport("styles/shared-styles.css")
public class Layout extends AppLayout {
    public Layout() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        buildNavBar(auth);
    }

    private void buildNavBar(Authentication auth){
        Button searchButton = new Button(new Icon(VaadinIcon.SEARCH));
        //TODO lien vers la page de recherche de quiz

        Button createButton = new Button("Create");
        //TODO lien vers la page de création de quiz

        StreamResource imageResource = new StreamResource("logoQuizz.png",
                () -> getClass().getResourceAsStream("/images/logoQuizz.png"));
        Image logo = new Image(imageResource,"logo quizz");
        RouterLink quizzleButton = new RouterLink("", MainView.class);
        quizzleButton.add(logo);


        if(auth.isAuthenticated() && !auth.getName().equals("anonymousUser")){
            Button profile = new Button(auth.getName(),new Icon(VaadinIcon.USER));
            addToNavbar(searchButton,createButton,quizzleButton,profile);
        }else{
            RouterLink login = new RouterLink("Login",LoginView.class);
            login.add(new Icon(VaadinIcon.USER));
            addToNavbar(searchButton,quizzleButton,login);
        }
    }
}
