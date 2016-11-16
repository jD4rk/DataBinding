package it.jdark.android.databinding.twoWayEditText_TextWatcher;

import android.text.Editable;
import android.text.TextWatcher;

/**
 * Created by jDark on 28/03/16.
 *
 * Simple Text  Watcher used on the Edit Text SubActivity in the Two Way DataBinding
 */
public abstract class SimpleTextWatcher implements TextWatcher {
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
            onTextChanged(s.toString());
    }

    public abstract void onTextChanged(String newValue);

}
