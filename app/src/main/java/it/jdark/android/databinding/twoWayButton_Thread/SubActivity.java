package it.jdark.android.databinding.twoWayButton_Thread;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import it.jdark.android.databinding.BindingTwoWayButton_Thread;
import it.jdark.android.databinding.R;

public class SubActivity extends AppCompatActivity {

    User data;
    Handler mHandler;
    Runnable runnableCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_one_way);

        BindingTwoWayButton_Thread binding = DataBindingUtil.setContentView(this, R.layout.activity_two_way_button_thread);
        data = new User();
        binding.setUser(data);
        data.setName("Valore");


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

    public void onClickStart(android.view.View view) {
        Toast.makeText(this, "Thread start...", Toast.LENGTH_LONG).show();
        mHandler = new Handler();
        runnableCode= new Runnable() {
            @Override
            public void run() {
                mHandler.postDelayed(runnableCode, 3000);
                data.setName(data.getName() + " Bis");
            }
        };
        mHandler.post(runnableCode);
    }

    public void onClickStop(android.view.View view) {
        Toast.makeText(this, "Thread Stop!", Toast.LENGTH_LONG).show();
        mHandler.removeCallbacks(runnableCode);
    }


}
