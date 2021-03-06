package it.jdark.android.databinding.twoWayButton_BaseObservable;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import it.jdark.android.databinding.BindingTwoWayButton_BaseObservable;
import it.jdark.android.databinding.R;

public class SubActivity extends AppCompatActivity {

    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_one_way);

        BindingTwoWayButton_BaseObservable binding = DataBindingUtil.setContentView(this, R.layout.activity_two_way_button_base_observable);
        user = new User();
        binding.setUser(user);
        user.setFirstName("Marco");
        user.setLastName("Rossi");


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
        user.setLastName(user.getLastName()+" Bis");
    }

}
