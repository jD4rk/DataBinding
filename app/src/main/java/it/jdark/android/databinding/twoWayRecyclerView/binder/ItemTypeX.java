package it.jdark.android.databinding.twoWayRecyclerView.binder;

/**
 * Created on 19/04/16.
 *
 * @Autor jDark
 */
public abstract class ItemTypeX<T> extends MyItemBinder<T> {

public ItemTypeX(int bindingVariable, int layoutId) {
        super(bindingVariable, layoutId);
    }

    public abstract boolean canHandle(T model);

    public boolean canHandle(int layoutId) {
        return this.layoutId == layoutId;
    }
}
