package com.example.admin.eventdatabinding;

import model.Temperature;

/**
 * Created by ADMIN on 10/30/17.
 */

public class MainActivityPresenter {
    public MainActivityContact.View view;

    public MainActivityPresenter(MainActivityContact.View view) {
        this.view = view;
    }
    public void onShowData(Temperature temperature){
            this.view.showData(temperature);
    }
}
