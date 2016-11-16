package it.jdark.android.databinding.oneWayRecyclerView;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.List;

import it.jdark.android.databinding.R;
import it.jdark.android.databinding.utils.DividerItemDecoration;

public class SubActivity extends AppCompatActivity {

    private RecyclerView mRecycleView;
    private RecyclerView.Adapter mAdapter;

    private List<Data> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_way_recycler_view);

        // Init Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        // Init Data for RecyclerView
        users = Data.createItemList(50);

        // Init RecyclerView
        mRecycleView= (RecyclerView) findViewById(R.id.recyclerView);
        mRecycleView.setLayoutManager(new LinearLayoutManager(this));
        mRecycleView.setHasFixedSize(true);
        // Divider item decoration
        mRecycleView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        mAdapter= new RecyclerAdapter(users);
        mRecycleView.setAdapter(mAdapter);

        // Floating Action Button
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        assert fab != null;
        fab.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                // Boilerplate handler of new item (it's a OneWay RecyclerView)
                users.add(new Data("New Value"));
                mAdapter.notifyItemInserted(users.size());
                mRecycleView.getLayoutManager().smoothScrollToPosition(mRecycleView,null, users.size());
            }
        });
    }

}
