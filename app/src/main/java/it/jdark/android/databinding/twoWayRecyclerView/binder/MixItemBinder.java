package it.jdark.android.databinding.twoWayRecyclerView.binder;

/**
 * Created on 19/04/16.
 *
 * @Autor jDark
 */
public class MixItemBinder<T> implements ItemBinder<T> {

    private final ItemTypeX<T>[] mixItemBinders;

    public MixItemBinder(ItemTypeX<T>... mixItemBinders) {
        this.mixItemBinders = mixItemBinders;
    }

    @Override
    public int getLayoutRes(T model) {
        for (int i = 0; i < mixItemBinders.length; i++) {
            ItemTypeX<T> itemBinder = mixItemBinders[i];
            if (itemBinder.canHandle(model)) {
                return itemBinder.getLayoutRes(model);
            }
        }
        throw new IllegalStateException();
    }

    @Override
    public int getBindingVariable(T model) {
        for (int i = 0; i < mixItemBinders.length; i++) {
            ItemTypeX<T> itemBinder = mixItemBinders[i];
            if (itemBinder.canHandle(model)) {
                return itemBinder.getBindingVariable(model);
            }
        }
        throw new IllegalStateException();
    }
}
