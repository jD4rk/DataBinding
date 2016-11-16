package it.jdark.android.databinding.twoWayEditText_TextWatcher;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import it.jdark.android.databinding.BindingTwoWayEditText_TextWatcher;
import it.jdark.android.databinding.R;

public class SubActivity extends AppCompatActivity {

    Data data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_two_way_edit_text_text_watcher);

        BindingTwoWayEditText_TextWatcher binding = DataBindingUtil.setContentView(this, R.layout.activity_two_way_edit_text_text_watcher);
        data= new Data();
        binding.setData(data);
        data.setString("Text Demo!");

        // Fix the "cursor position" at the end of the string
        binding.textEdit.setText(data.getString());
        binding.textEdit.setSelection(data.getString().length());

        // You can set "Listener" here instead in che xml file with "app:addTextChangedListener="@{dataList.OnDataChanged}""
//        binding.textEdit.addTextChangedListener(new SimpleTextWatcher() {
//            @Override
//            public void onTextChanged(String newValue) {
//                dataList.setString(newValue);
//            }
//        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
