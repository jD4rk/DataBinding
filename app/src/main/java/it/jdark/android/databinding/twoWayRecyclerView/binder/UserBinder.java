package it.jdark.android.databinding.twoWayRecyclerView.binder;

import it.jdark.android.databinding.twoWayRecyclerView.viewModel.UserViewModel;

/**
 * Created on 19/04/16.
 *
 * @Autor jDark
 */
public class UserBinder extends ItemTypeX<UserViewModel> {

    public UserBinder(int bindingVariable, int layoutId) {
        super(bindingVariable, layoutId);
    }

    @Override
    public boolean canHandle(UserViewModel model) {
        return true;
    }
}
