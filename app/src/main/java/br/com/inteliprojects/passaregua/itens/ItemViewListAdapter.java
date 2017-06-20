package br.com.inteliprojects.passaregua.itens;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import br.com.inteliprojects.passaregua.itens.ItemView;

/**
 * Created by DARUMA02 on 31/03/2017.
 */

public class ItemViewListAdapter extends BaseAdapter {
    private List<ItemView> lsItemView;
    private Context context;

    public ItemViewListAdapter(Context context, List<ItemView> lsItemView) {
        this.context = context;
        this.lsItemView = lsItemView;
    }

    @Override
    public int getCount() {
        return lsItemView.size();
    }

    @Override
    public Object getItem(int position) {
        return lsItemView.get(position);
    }

    @Override
    public long getItemId(int position) {
        return lsItemView.get(position).getView().getId();
    }

    /**
     * Get a View that displays the data at the specified position in the data set. You can either
     * create a View manually or inflate it from an XML layout file. When the View is inflated, the
     * parent View (GridView, ListView...) will apply default layout parameters unless you use
     * {@link LayoutInflater#inflate(int, ViewGroup, boolean)}
     * to specify a root view and to prevent attachment to the root.
     *
     * @param position    The position of the item within the adapter's data set of the item whose view
     *                    we want.
     * @param convertView The old view to reuse, if possible. Note: You should check that this view
     *                    is non-null and of an appropriate type before using. If it is not possible to convert
     *                    this view to display the correct data, this method can create a new view.
     *                    Heterogeneous lists can specify their number of view types, so that this View is
     *                    always of the right type (see {@link #getViewTypeCount()} and
     *                    {@link #getItemViewType(int)}).
     * @param parent      The parent that this view will eventually be attached to
     * @return A View corresponding to the data at the specified position.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View layout;

        if(convertView == null) {
            layout = lsItemView.get(position).getView();
        } else {
            layout = convertView;
        }

        return layout;
    }
}
