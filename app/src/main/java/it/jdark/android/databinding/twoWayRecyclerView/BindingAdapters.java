package it.jdark.android.databinding.twoWayRecyclerView;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.Collection;

import it.jdark.android.databinding.twoWayRecyclerView.binder.ItemBinder;

/**
 * Created on 19/04/16.
 *
 * @Autor jDark
 */
public class BindingAdapters {

    private final static String TAG = "BindingAdapters";

    private static final int KEY_ITEMS = -123;

    @BindingAdapter("items")
//    @BindingAdapter(value = {"items"}, requireAll = false)
    public static <T> void setItems(RecyclerView recyclerView, Collection<T> items) {
        Log.d(TAG, "Binding Adapter: -- SetItems");
        Log.e(TAG, "size data: "+items.size());
//        Log.w((TAG, "Value " + items.get(0).getLastName() + " -- " + data.get(0).getFirstName());
        RecyclerViewAdapter<T> adapter = (RecyclerViewAdapter<T>) recyclerView.getAdapter();
        if (adapter != null)
        {
            Log.w(TAG, "ADAPTER NOT NULL");
            adapter.setItems(items);
        }
        else
        {
            Log.w(TAG, "ADAPTER NULL!!!");
            recyclerView.setTag(KEY_ITEMS, items);
        }
    }

    @BindingAdapter("itemViewBinder")
    public static <T> void setItemViewBinder(RecyclerView recyclerView, ItemBinder<T> itemViewMapper) {
        Log.d(TAG, "Binding Adapter: --- itemViewBinder");
        Collection<T> items = (Collection<T>) recyclerView.getTag(KEY_ITEMS);
        Log.d(TAG, "Binding Adapter: items.size: " + items.size());
//        ClickHandler<T> clickHandler = (ClickHandler<T>) recyclerView.getTag(KEY_CLICK_HANDLER);
        RecyclerViewAdapter<T> adapter = new RecyclerViewAdapter<>(itemViewMapper, items);
//        if(clickHandler != null)
//        {
//            adapter.setClickHandler(clickHandler);
//        }
        recyclerView.setAdapter(adapter);
    }

}

