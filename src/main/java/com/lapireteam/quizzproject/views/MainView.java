package com.lapireteam.quizzproject.views;


import com.lapireteam.quizzproject.components.Layout;
import com.lapireteam.quizzproject.components.Pubs;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@AnonymousAllowed
@Route
@PageTitle("Home | Quizzle")
public class MainView extends VerticalLayout {
    public MainView() {
        add(new Layout(), new Pubs());
    }
}
