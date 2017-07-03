package it.jdark.android.databinding.twoWayButton_ObservableField;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
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

    }

    public void onClick(android.view.View view) {
        Toast.makeText(this, "Add \"bis\" to last name value", Toast.LENGTH_LONG).show();
        user.lastName.set((user.lastName.get() + " Bis"));
    }

}
