package com.lapireteam.quizzproject.components;

import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.server.StreamResource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class Pubs extends VerticalLayout {
    public Pubs() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (!auth.isAuthenticated() || auth.getName().equals("anonymousUser")) {
            StreamResource imageResource = new StreamResource("pubFooter.PNG",
                    () -> getClass().getResourceAsStream("/images/pubFooter.PNG"));
            Image image = new Image(imageResource, "pub footer");
            add(image);
        }
    }
}
