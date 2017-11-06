package model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by ADMIN on 10/25/17.
 */

public class User extends BaseObservable {
    public String firstname;
    public String lastname;

    public User() {
    }

    public User(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }
    @Bindable
    public String getFirstname() {
        return firstname;
    }
    @Bindable
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    @Bindable
    public String getLastname() {
        return lastname;
    }
    @Bindable
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
