package it.jdark.android.databinding.twoWayButton_Thread;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import it.jdark.android.databinding.BR;

/**
 * Created by jDark on 08/03/16.
 */
public class User extends BaseObservable {
    private String name;

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);

    }

}