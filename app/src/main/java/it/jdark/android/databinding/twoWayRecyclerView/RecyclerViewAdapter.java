package it.jdark.android.databinding.twoWayRecyclerView;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.databinding.ViewDataBinding;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.Collection;

import it.jdark.android.databinding.twoWayRecyclerView.binder.ItemBinder;

/**
 * Created on 18/04/16.
 *
 * @Autor jDark
 */
public class RecyclerViewAdapter<T> extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private final String TAG = getClass().getSimpleName();

    private static final int ITEM_MODEL = -124;

    private final ItemBinder<T> itemBinder;
    private ObservableList<T> items;
    private LayoutInflater inflater;


    public RecyclerViewAdapter(ItemBinder<T> itemBinder, @Nullable Collection<T> items)
    {
        this.itemBinder = itemBinder;
        setItems(items);
    }


    public void setItems(@Nullable Collection<T> items)
    {
        if (this.items == items)
        {
            Log.i(TAG, "RecyclerView: this.items = items");
            return;
        }

        if (this.items != null)
        {
            Log.i(TAG, "RecyclerView: this.items != null");
//            this.items.removeOnListChangedCallback(onListChangedCallback);
            notifyItemRangeRemoved(0, this.items.size());
        }

        if (items instanceof ObservableList)
        {
            Log.i(TAG, "RecyclerView: items instanceof ObservableList");
            this.items = (ObservableList<T>) items;
            notifyItemRangeInserted(0, this.items.size());
//            this.items.addOnListChangedCallback(onListChangedCallback);
        }
        else if (items != null)
        {
            Log.i(TAG, "RecyclerView: items != null");
            this.items = new ObservableArrayList<>();
//            this.items.addOnListChangedCallback(onListChangedCallback);
            this.items.addAll(items);
        }
        else
        {
            Log.i(TAG, "RecyclerView: ELSE");
            this.items = null;
        }
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.i(TAG, "---- onCreateViewHolder");
        if (inflater == null) {
            inflater = LayoutInflater.from(parent.getContext());
        }

        ViewDataBinding binding = DataBindingUtil.inflate(inflater, viewType, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.i(TAG, "---- onBindViewHolder");

        final T user = items.get(position);
        holder.binding.setVariable(itemBinder.getBindingVariable(user), user);
        holder.binding.getRoot().setTag(ITEM_MODEL, user);
        holder.binding.executePendingBindings();

    }

    @Override
    public int getItemViewType(int position) {
//        return super.getItemViewType(position);
        return itemBinder.getLayoutRes(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items == null ? 0 : items.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        final ViewDataBinding binding;

        ViewHolder(ViewDataBinding binding)
        {
            super(binding.getRoot());
            this.binding = binding;
        }

    }
}
