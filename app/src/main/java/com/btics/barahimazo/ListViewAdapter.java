package com.btics.barahimazo;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Gisus on 26/02/15.
 */



    public class ListViewAdapter extends BaseAdapter {

        // Declare Variables
        Context mContext;
        LayoutInflater inflater;
        private List<Trago> barList = null;
        private ArrayList<Trago> arraylist;

        public ListViewAdapter(Context context,
                               List<Trago> worldpopulationlist) {
            mContext = context;
            this.barList = worldpopulationlist;
            inflater = LayoutInflater.from(mContext);
            this.arraylist = new ArrayList<Trago>();
            this.arraylist.addAll(worldpopulationlist);
        }

        public class ViewHolder {
            TextView name;
            TextView description;
            TextView latitude;
            TextView longitude;
            ImageView picBar;
        }

        @Override
        public int getCount() {
            return barList.size();
        }

        @Override
        public Trago getItem(int position) {
            return barList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        public View getView(final int position, View view, ViewGroup parent) {
            final ViewHolder holder;
            if (view == null) {
                holder = new ViewHolder();
                view = inflater.inflate(R.layout.listview_item, null);
// Locate the TextViews in listview_item.xml
                holder.name = (TextView) view.findViewById(R.id.name);
                holder.description = (TextView) view.findViewById(R.id.description);
                holder.latitude = (TextView) view.findViewById(R.id.latitude);
                holder.longitude = (TextView) view.findViewById(R.id.longitude);
                holder.picBar = (ImageView) view.findViewById(R.id.imgTragos);

                view.setTag(holder);
            } else {
                holder = (ViewHolder) view.getTag();
            }
// Set the results into TextViews
            holder.name.setText(barList.get(position).getNombre());
            holder.description.setText(barList.get(position).getDescripcion());
            holder.latitude.setText(barList.get(position).getLatitud());
            holder.longitude.setText(barList.get(position).getLongitud());
            holder.picBar.setImageDrawable(
                    Drawable.createFromStream(
                            new ByteArrayInputStream(barList.get(position).getImage()),
                            barList.get(position).getNombre()
                    ));

// Listen for ListView Item Click
            view.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View arg0) {
// Send single item click data to SingleItemView Class
                    Intent intent = new Intent(mContext, SingleItemView.class);
// Pass all data rank
                    intent.putExtra("name",
                            (barList.get(position).getNombre()));
// Pass all data country
                    intent.putExtra("description",
                            (barList.get(position).getDescripcion()));
// Pass all data population
                    intent.putExtra("latitude",(barList.get(position).getLatitud()));
                    intent.putExtra("longitude",(barList.get(position).getLongitud()));
// Start SingleItemView Class
                    intent.putExtra("image",(barList.get(position).getNombre()));
                    mContext.startActivity(intent);
                }
            });

            return view;
        }
    }

