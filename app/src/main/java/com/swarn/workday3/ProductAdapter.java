package com.swarn.workday3;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * @author Swarn Singh.
 */
public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private Context mContext;
    private List<Product> mProducts;

    public ProductAdapter(Context context, List<Product> products) {
        this.mContext = context;
        this.mProducts = products;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.shopping_layout, parent, false);

        ProductViewHolder productViewHolder = new ProductViewHolder(view);
        return productViewHolder;
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        Product product = mProducts.get(position);

        holder.productNameTxtView.setText(product.getProductName());
        holder.productPriceTxtView.setText(product.getProductPrice());
    }

    @Override
    public int getItemCount() {
        return mProducts.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView productImageView;

        private TextView productNameTxtView;

        private TextView productPriceTxtView;

        private View view;

        public ProductViewHolder(View itemView) {
            super(itemView);
            this.view = itemView;

            productImageView = view.findViewById(R.id.product_img_view);

            productNameTxtView = view.findViewById(R.id.product_name_txt_view);

            productPriceTxtView = view.findViewById(R.id.product_price_txt_view);

            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            FragmentManager fragmentManager = ((Activity) mContext).getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            Product product = mProducts.get(getLayoutPosition());

            ProductDetailFragment productDetailFragment = ProductDetailFragment.newInstance(ProductDetailFragment.class.getName(), product);

            fragmentTransaction.replace(R.id.frame_container, productDetailFragment);

            fragmentTransaction.addToBackStack(ProductDetailFragment.class.getName());

            fragmentTransaction.commit();

        }
    }

}
