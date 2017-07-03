package it.jdark.android.databinding.twoWayEditText_NativeSupport;

/**
 * Created by jDark on 08/03/16.
 */
import android.databinding.BaseObservable;
import android.databinding.Bindable;

import it.jdark.android.databinding.BR;


public class Data extends BaseObservable {

    private String string;

    @Bindable
    public String getString() {
        return string;
    }

    public void setString(String text) {
        this.string = text;
        notifyPropertyChanged(BR.string);
    }
}