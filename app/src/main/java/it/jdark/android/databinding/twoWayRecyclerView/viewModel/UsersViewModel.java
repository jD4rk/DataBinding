package it.jdark.android.databinding.twoWayRecyclerView.viewModel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableArrayList;

import it.jdark.android.databinding.twoWayRecyclerView.model.User;

/**
 * Created on 18/04/16.
 *
 * @Autor jDark
 */
public class UsersViewModel extends BaseObservable {

    @Bindable
    public ObservableArrayList<UserViewModel> usersTwoWay;

    public UsersViewModel() {
        usersTwoWay = new ObservableArrayList<>();
    }

    public void addUser(String firstName, String lastName) {
        usersTwoWay.add(new UserViewModel(new User(firstName, lastName)));
    }

}
