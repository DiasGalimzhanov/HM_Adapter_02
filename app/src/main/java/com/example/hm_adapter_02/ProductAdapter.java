package com.example.hm_adapter_02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hm_adapter_02.model.Product;

import java.util.ArrayList;

public class ProductAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Product> products;
    private LayoutInflater inflater;

    public ProductAdapter(Context context, ArrayList<Product> products) {
        this.context = context;
        this.products = products;
        this.inflater = LayoutInflater.from(context);
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public LayoutInflater getInflater() {
        return inflater;
    }

    public void setInflater(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Object getItem(int i) {
        return products.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null){
            view = inflater.inflate(R.layout.products_item,viewGroup, false);
            holder = new ViewHolder();
            holder.imgView = view.findViewById(R.id.product_img);
            holder.tvName = view.findViewById(R.id.name);
            holder.twPrice = view.findViewById(R.id.price);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }
        Product product = products.get(i);
        holder.imgView.setImageResource(product.getImg());
        holder.tvName.setText(product.getName());
        holder.twPrice.setText(String.valueOf(product.getPrice()) + " tg");

        return view;
    }

    static class ViewHolder{
        ImageView imgView;
        TextView tvName;
        TextView twPrice;
    }
}
