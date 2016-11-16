package it.jdark.android.databinding.twoWayRecyclerView.viewModel;

import android.databinding.BaseObservable;

import it.jdark.android.databinding.twoWayRecyclerView.model.User;

/**
 * Created on 18/04/16.
 *
 * @Autor jDark
 */
public class UserViewModel extends BaseObservable {

    private User user;

    public UserViewModel(User data) {
        this.user = data;
    }

    public String getFirstName() {
        return user.getFirstName();
    }

    public String getLastName() {
        return user.getLastName();
    }
}
