package it.jdark.android.databinding.utils;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

/**
 * Created by jDark on 08/04/16.
 */
public class ReusableBindingViewHolder<T extends ViewDataBinding> extends RecyclerView.ViewHolder {

    private T binding;

    public ReusableBindingViewHolder(T binding) {
        super(binding.getRoot().getRootView());
        this.binding = binding;
    }

    public T getBinding() {
        return binding;
    }
}
