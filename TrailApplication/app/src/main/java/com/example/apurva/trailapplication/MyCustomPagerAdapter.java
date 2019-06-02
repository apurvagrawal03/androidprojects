package com.example.apurva.trailapplication;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 * Created by apurva on 30/1/19.
 */

public class MyCustomPagerAdapter extends PagerAdapter {

    Context context;
    ArrayList<Images> mArrayListImages;
    LayoutInflater layoutInflater;

    //Ctreate a constructor
    public MyCustomPagerAdapter(Context context, ArrayList<Images> mArrayListImages) {
        this.context = context;
        this.mArrayListImages = mArrayListImages;
        layoutInflater=LayoutInflater.from(context);
    }

    //to count the size of the array list
    @Override
    public int getCount() {
        return mArrayListImages.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }


    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View itemView = layoutInflater.inflate(R.layout.lay_post_item, container, false);

        assert itemView!=null;
        final ImageView imageView = (ImageView) itemView.findViewById(R.id.imageView);


        imageView.setImageURI(mArrayListImages.get(position).getUri());

        final Uri imageUri=mArrayListImages.get(position).getUri();


        container.addView(itemView);

        //on imageView click listener;open the another activity
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,
                        FullScreenImage.class);

                intent.setData(imageUri);
                context.startActivity(intent);
            }
        });
        return itemView;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
