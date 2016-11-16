package it.jdark.android.databinding.twoWayButton_ObservableField;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import it.jdark.android.databinding.BindingTwoWayButton_ObservableField;
import it.jdark.android.databinding.R;

public class SubActivity extends AppCompatActivity {

    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_two_way_button_observable_field);

        BindingTwoWayButton_ObservableField binding = DataBindingUtil.setContentView(this, R.layout.activity_two_way_button_observable_field);
        user = new User();
        binding.setUser(user);
        user.firstName.set("Marco");
        user.lastName.set("Rossi");


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

    public void onClick(android.view.View view) {
        Toast.makeText(this, "CLICKED", Toast.LENGTH_LONG).show();
        user.lastName.set((user.lastName.get() + " Bis"));
    }

}
