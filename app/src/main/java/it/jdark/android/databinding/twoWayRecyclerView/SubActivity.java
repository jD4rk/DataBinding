package it.jdark.android.databinding.twoWayRecyclerView;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View.OnClickListener;

import it.jdark.android.databinding.BR;
import it.jdark.android.databinding.R;
import it.jdark.android.databinding.databinding.ActivityTwoWayRecyclerViewBinding;
import it.jdark.android.databinding.twoWayRecyclerView.binder.ItemBinder;
import it.jdark.android.databinding.twoWayRecyclerView.binder.MixItemBinder;
import it.jdark.android.databinding.twoWayRecyclerView.binder.UserBinder;
import it.jdark.android.databinding.twoWayRecyclerView.model.User;
import it.jdark.android.databinding.twoWayRecyclerView.viewModel.UserViewModel;
import it.jdark.android.databinding.twoWayRecyclerView.viewModel.UsersViewModel;

public class SubActivity extends AppCompatActivity {

    private final String TAG = getClass().getSimpleName();

    ActivityTwoWayRecyclerViewBinding binding;
    UsersViewModel usersViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_two_way_recycler_view);

        usersViewModel = new UsersViewModel();
        usersViewModel.usersTwoWay.add(new UserViewModel(new User("Marco", "Rossi")));

        binding = DataBindingUtil.setContentView(this, R.layout.activity_two_way_recycler_view);
        binding.setUsersViewModel(usersViewModel);
        binding.setView(this);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }


    public OnClickListener onButtonClick() {
        return new OnClickListener(){

            @Override
            public void onClick(android.view.View v) {
                String firstName = binding.newDataFirstName.getText() == null ? null : binding.newDataFirstName.getText().toString();
                String lastName = binding.newDataLastName.getText() == null ? null : binding.newDataLastName.getText().toString();
                usersViewModel.addUser(firstName, lastName);
            }
        };
    }

    public ItemBinder<UserViewModel> itemViewBinder() {
        Log.i(TAG, "execute: itemViewBinder");
        return new MixItemBinder<UserViewModel>(new UserBinder(BR.usersTwoWay, R.layout.row_user_two_way_recycler_view));
    }
}
