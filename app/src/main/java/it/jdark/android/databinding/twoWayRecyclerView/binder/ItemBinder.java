package it.jdark.android.databinding.twoWayRecyclerView.binder;

/**
 * Created on 19/04/16.
 *
 * @Autor jDark
 */
public interface ItemBinder<T> {

    int getLayoutRes(T model);
    int getBindingVariable(T model);
}
