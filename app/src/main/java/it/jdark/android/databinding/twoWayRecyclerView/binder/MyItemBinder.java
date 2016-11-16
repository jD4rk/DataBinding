package it.jdark.android.databinding.twoWayRecyclerView.binder;

/**
 * Created on 19/04/16.
 *
 * @Autor jDark
 */
public class MyItemBinder<T> implements ItemBinder<T> {

    protected final int bindingVariable;
    protected final int layoutId;

    public MyItemBinder(int bindingVariable, int layoutId)
    {
        this.bindingVariable = bindingVariable;
        this.layoutId = layoutId;
    }

    @Override
    public int getLayoutRes(T model) {
        return layoutId;
    }

    @Override
    public int getBindingVariable(T model) {
        return bindingVariable;
    }
}
