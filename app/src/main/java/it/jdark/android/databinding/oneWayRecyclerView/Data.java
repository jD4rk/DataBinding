package it.jdark.android.databinding.oneWayRecyclerView;

/**
 * Created by jDark on 08/03/16.
 */
import java.util.ArrayList;
import java.util.List;


public class Data {

    private String text;

    public Data(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String data) {
        this.text = data;
    }

    public static List<Data> createItemList (int numItems) {
        List<Data> items = new ArrayList<Data>();

        for (int i=1; i<= numItems; i++) {
            items.add(new Data("Data " + i));
        }
        return items;
    }
}