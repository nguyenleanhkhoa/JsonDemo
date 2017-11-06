package model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.admin.eventdatabinding.BR;

import java.util.Observable;

/**
 * Created by ADMIN on 10/30/17.
 */

public class Temperature extends BaseObservable {
    private String celsius;
    private String fahrenheit;

    public Temperature(String celsius) {
        this.celsius = celsius;
    }

    @Bindable
    public String getCelsius() {
        return celsius;
    }
    @Bindable
    public void setCelsius(String celsius) {
        this.celsius = celsius;
        notifyPropertyChanged(BR.celsius);
    }
    @Bindable
    public String getFahrenheit() {
        return fahrenheit;
    }
    @Bindable
    public void setFahrenheit(String fahrenheit) {
        this.fahrenheit = fahrenheit;
    }
}
