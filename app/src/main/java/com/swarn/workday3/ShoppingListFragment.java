package com.swarn.workday3;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShoppingListFragment extends Fragment {

    private RecyclerView mShoppingListView;

    private ProductAdapter mProductAdapter;

    private List<Product> mProductList;

    private RecyclerView.LayoutManager mLayoutManager;

    public ShoppingListFragment() {}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            // Get Product List of products
            mProductList = getArguments().getParcelableArrayList(ShoppingListFragment.class.getName());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_shopping_list, container, false);

        mShoppingListView = view.findViewById(R.id.shopping_list_view);
        mProductAdapter = new ProductAdapter(getContext(), mProductList);

        mLayoutManager = new LinearLayoutManager(getActivity());
        mShoppingListView.setLayoutManager(mLayoutManager);

        mShoppingListView.setHasFixedSize(true);
        mShoppingListView.setAdapter(mProductAdapter);


        // Set Horizontal divider in Recycler ListView
        DividerItemDecoration horizontalDecoration = new DividerItemDecoration(mShoppingListView.getContext(),
                DividerItemDecoration.VERTICAL);
        Drawable horizontalDivider = ContextCompat.getDrawable(getActivity(), R.drawable.horizontal_divider);
        horizontalDecoration.setDrawable(horizontalDivider);
        mShoppingListView.addItemDecoration(horizontalDecoration);

        return view;
    }

    public static ShoppingListFragment newInstance(String argument, List<Product> mProductList) {
        ShoppingListFragment fragment = new ShoppingListFragment();
        Bundle args = new Bundle();

        // Set ProductList in Bundle
        args.putParcelableArrayList(argument, (ArrayList<? extends Parcelable>) mProductList);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
