package it.jdark.android.databinding.twoWayButton_BaseObservable;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import it.jdark.android.databinding.BR;

/**
 * Created by jDark on 08/03/16.
 */
public class User extends BaseObservable {
    private String firstName;
    private String lastName;

    @Bindable
    public String getLastName() {
        return lastName;
    }

    @Bindable
    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        notifyPropertyChanged(BR.lastName);

    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        notifyPropertyChanged(BR.firstName);
    }

}