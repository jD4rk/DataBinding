package it.jdark.android.databinding.oneWayRecyclerView;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import it.jdark.android.databinding.BindingOneWayRecyclerView;
import it.jdark.android.databinding.R;
import it.jdark.android.databinding.utils.ReusableBindingViewHolder;
import it.jdark.android.databinding.MainActivity;

import it.jdark.android.databinding.BR;

/**
 * Created by jDark on 29/03/16.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<ReusableBindingViewHolder> {

    private List<Data> data;

    public RecyclerAdapter(List<Data> data) {
        this.data = data;
    }

    @Override
    public ReusableBindingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.v(MainActivity.LOG, "RecyclerView Adapter -> onCreateViewHolder");
        BindingOneWayRecyclerView v = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.row_one_way_recycler_view, parent, false);
        return new ReusableBindingViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ReusableBindingViewHolder holder, int position) {
        Log.i(MainActivity.LOG, "RecyclerView Adapter -> onBindViewHolder position: " +position);
        final Data text = data.get(position);
        holder.getBinding().setVariable(BR.user, text);
        holder.getBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


//    @Override
//    public RecyclerAdapter.BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        Log.v(MainActivity.LOG, "RecyclerView Adapter -> onCreateViewHolder");
//        SubActivity v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_one_way_recycler_view, parent, false);
//        BindingHolder holder = new BindingHolder(v);
//        return holder;
//    }
//
//    @Override
//    public void onBindViewHolder(RecyclerAdapter.BindingHolder holder, int position) {
//        Log.i(MainActivity.LOG, "RecyclerView Adapter -> onBindViewHolder position: " +position);
//        final Data user = Data.get(position);
//        holder.getBinding().setVariable(BR.user, user);
//        holder.getBinding().executePendingBindings();
//
//    }
//
//    public static class BindingHolder extends RecyclerView.ViewHolder {
//        private ViewDataBinding binding;
//
//        public BindingHolder(SubActivity v) {
//            super(v);
//            binding = DataBindingUtil.bind(v);
//        }
//
//        public ViewDataBinding getBinding() {
//            return binding;
//        }
//    }
}
