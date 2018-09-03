package com.swarn.workday3;


import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Product> mProductList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Add data for Product List
        addProductData();

        // Add ShoppingListFragment in blank activity
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        ShoppingListFragment fragment = ShoppingListFragment.newInstance(ShoppingListFragment.class.getName(), mProductList);

        fragmentTransaction.add(R.id.frame_container, fragment);
        fragmentTransaction.commit();
    }

    private void addProductData() {
        mProductList = new ArrayList<>();

        for (int i = 1; i <= 20; i++) {
            Product product = new Product();
            product.setProductName("Book" +" "+i);
            product.setProductPrice("Rs. "+(100+i));

            mProductList.add(product);
        }
    }
}
