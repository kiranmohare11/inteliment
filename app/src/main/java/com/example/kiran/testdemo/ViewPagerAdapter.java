package com.example.kiran.testdemo;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.view.*;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by kiran on 3/10/2016.
 */
public class ViewPagerAdapter extends android.support.v4.view.PagerAdapter {
    Context context;
    Drawable[] GalImages;
    int index;

    public ViewPagerAdapter(Context context, Drawable[] imageURLS) {
        this.context = context;
        this.GalImages = imageURLS;
    }

    @Override
    public int getCount() {
        return GalImages.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((ImageView) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        ((ViewPager) container).addView(imageView, 0);
            //imageView.setBackgroundColor(Color.parseColor(GalImages[position]));
            imageView.setImageDrawable(GalImages[position]);
            index=position;
        imageView.setOnClickListener(
                new OnImageClickListener(GalImages[position],index));
        return imageView;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((ImageView) object);
    }

    class OnImageClickListener implements View.OnClickListener {
        Drawable _postion;
        int index;
        // constructor
        public OnImageClickListener(Drawable position,int index) {
            this._postion = position;
            this.index = index;
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(context,"Index "+ index ,Toast.LENGTH_LONG).show();
        }
    }
}
