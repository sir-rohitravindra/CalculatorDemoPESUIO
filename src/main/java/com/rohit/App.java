package com.rohit;

import com.rohit.Controller.Controller;
import com.rohit.Model.Model;
import com.rohit.View.View;

public class App {

    static Controller appController;
    static View appView;
    static Model appModel;

    public static void main(String[] args) {

        appModel = new Model();
        appView = new View(240, 150, true);

        appController = new Controller(appView, appModel);

    }
}
