package perusu.mobolutions.com.mycalculator;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomListViewAdapter extends ArrayAdapter<StoreItems> {

    Context context;

    public CustomListViewAdapter(Context context, int resource, List<StoreItems> items) {
        super(context, resource, items);
        this.context = context;
    }

    private class ViewHolder{
        TextView title;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        StoreItems StoreItems = getItem(position);

        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.list_item, null);
            holder = new ViewHolder();
            holder.title = (TextView) convertView.findViewById(R.id.title);
            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();

        holder.title.setText(StoreItems.getTitle());

        return convertView;
    }
}
