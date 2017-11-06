package com.example.admin.eventdatabinding;

import model.Temperature;

/**
 * Created by ADMIN on 10/30/17.
 */

public interface MainActivityContact
{
    public interface Presenter{
        void onShowData(Temperature temperature);
    }
    public interface View{
        void showData(Temperature temperature);
    }
}
