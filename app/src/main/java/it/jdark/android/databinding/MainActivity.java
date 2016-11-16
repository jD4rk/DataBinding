package it.jdark.android.databinding;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {

    String[] data;
    public static final String LOG = "DataBinding";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data = getResources().getStringArray(R.array.listActivityName);
        ArrayAdapter<String> mAdapter = new ArrayAdapter<>(this, R.layout.row_layout_main, R.id.rowMainActivity, data);
        setListAdapter(mAdapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        String localPath = getResources().getStringArray(R.array.listActivityName)[position].
                replaceAll("\\s+", "")                                          // take away whitespace
                .replaceAll("\\)", "").replaceAll("\\(", "_")                   // take away close bracket - change open bracket with underscore
                .replace("1-Way", "oneWay").replace("2-Way", "twoWay");         // convert 1-Way and 2-Way in char only
        String packageName = getPackageName() + "." + localPath;
        String activityName = "SubActivity";
        Log.v(LOG, "path -> " + localPath);
        Log.v(LOG, "Full package Name -> " + packageName);
        Intent intent = null;
        try {
            intent = new Intent(MainActivity.this, Class.forName(packageName+"."+activityName));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        MainActivity.this.startActivity(intent);
    }
}