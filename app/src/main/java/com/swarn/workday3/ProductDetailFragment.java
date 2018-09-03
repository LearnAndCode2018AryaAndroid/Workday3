package com.swarn.workday3;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class ProductDetailFragment extends Fragment {

    private Product mProduct;


    private TextView mProductNameTxtView;

    private TextView mProductPriceTxtView;

    private ImageView mProductImgView;

    public ProductDetailFragment() {
    }

    public static ProductDetailFragment newInstance(String argument, Product product) {
        ProductDetailFragment fragment = new ProductDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable(argument, product);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mProduct = getArguments().getParcelable(ProductDetailFragment.class.getName());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.product_detail, container, false);

        mProductNameTxtView = view.findViewById(R.id.product_name_txt_view);
        mProductPriceTxtView = view.findViewById(R.id.product_price_txt_view);
        mProductImgView = view.findViewById(R.id.product_img_view);

        mProductNameTxtView.setText(mProduct.getProductName());
        mProductPriceTxtView.setText(mProduct.getProductPrice());
        mProductImgView.setImageResource(R.mipmap.ic_launcher_round);
        return view;
    }
}
