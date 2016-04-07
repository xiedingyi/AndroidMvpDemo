package com.norman.demo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.norman.demo.R;
import com.norman.demo.entity.Version;

/**
 * Created by Administrator on 2016/3/23.
 */
public class ListAdapter extends BaseAdapter<Version> {

    public ListAdapter(Context context){
        super(context);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            view = inflater.inflate(R.layout.plisetview_item, viewGroup, false);
            holder = new ViewHolder();
            holder.titleText = (TextView) view.findViewById(R.id.tvdes);
            holder.infoText = (TextView) view.findViewById(R.id.tvid);
            holder.priceText = (TextView) view.findViewById(R.id.tvurl);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        Version coupon = itemList.get(i);
        holder.titleText.setText(coupon.getVDES());
        holder.infoText.setText(coupon.getVID());
        holder.priceText.setText(coupon.getVURL());
        return view;
    }

    static class ViewHolder {
        TextView titleText;
        TextView infoText;
        TextView priceText;
    }
}
