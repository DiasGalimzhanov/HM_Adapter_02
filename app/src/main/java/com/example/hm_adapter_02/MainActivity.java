package com.example.hm_adapter_02;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.hm_adapter_02.model.Product;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final ArrayList<Product> products = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);
//        products = new ArrayList<>();
        products.add(new Product(R.drawable.img, "Sandwich", 400));
        products.add(new Product(R.drawable.img1, "Meat", 1000));
        products.add(new Product(R.drawable.img2, "Juice", 500));
        products.add(new Product(R.drawable.img3, "Bread", 200));
        products.add(new Product(R.drawable.img_1, "Milk", 850));
        products.add(new Product(R.drawable.img_2, "Ice cream", 850));
        products.add(new Product(R.drawable.img_3, "Chips", 750));
        products.add(new Product(R.drawable.img_4, "Banana", 550));

        ProductAdapter adapter = new ProductAdapter(this,products);
        listView.setAdapter(adapter);

        listView.setOnItemLongClickListener((parent, view, position, id) -> {
            products.remove(position);
            adapter.notifyDataSetChanged();
            return true;
        });

    }
}