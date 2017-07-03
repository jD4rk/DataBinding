package it.jdark.android.databinding.twoWayEditText_NativeSupport;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import it.jdark.android.databinding.BindingTwoWayEditText_NativeSupport;
import it.jdark.android.databinding.R;

public class SubActivity extends AppCompatActivity {

    Data data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_two_way_edit_text_bind_adapter);

        BindingTwoWayEditText_NativeSupport binding = DataBindingUtil.setContentView(this, R.layout.activity_two_way_edit_text_native_support);
        data= new Data();
        binding.setData(data);
        data.setString("Text Demo!");

        // Fix the "cursor position" at the end of the string
        binding.textEdit.setText(data.getString());
        binding.textEdit.setSelection(data.getString().length());

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

}
