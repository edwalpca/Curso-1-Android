package com.cyberfuel.tarea1;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return image.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setAdjustViewBounds(true);
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(image[position]);
        return imageView;
    }

    // references to our images
    public static Integer[] image = {
            R.drawable.img_1, 
            R.drawable.img_2, 
            R.drawable.img_3, 
            R.drawable.img_4, 
            R.drawable.img_5, 
            R.drawable.img_6, 
            R.drawable.img_7, 
            R.drawable.img_8,
            R.drawable.img_9, 
            R.drawable.img_10 
    };
}

