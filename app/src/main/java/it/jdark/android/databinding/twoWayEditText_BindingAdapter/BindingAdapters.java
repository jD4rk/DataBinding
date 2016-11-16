package it.jdark.android.databinding.twoWayEditText_BindingAdapter;

import android.databinding.BindingAdapter;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;


import it.jdark.android.databinding.MainActivity;

@SuppressWarnings("unused")
public class BindingAdapters {


    // Binding for Edit Text SubActivity in the implementation of Two Way Data Binding (Bind Adapter)
    // see "activity_two_way_edit_test_bind_adapter.xml"
    @BindingAdapter("addTextChangedListener")
    public static void stringChanged(EditText editText, final Data text) {
        Log.d(MainActivity.LOG, "Binding Adapter: Two Edit Text Bind Adapter");
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d(MainActivity.LOG, "Binding Adapter: Two Edit Text Bind Adapter (onTextChanged)");
                if (!text.getString().equals(s.toString())) {
                    text.setString(s.toString());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }
}
