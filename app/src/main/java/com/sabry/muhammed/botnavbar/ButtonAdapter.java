package com.sabry.muhammed.botnavbar;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import java.util.List;

public class ButtonAdapter extends BaseAdapter {
    private Context mContext;
    private List<String> buttonNames;
    private List<Drawable> buttonDrawables;

    public ButtonAdapter(Context c, List<String> buttonNames, List<Drawable> buttonDrawables) {
        mContext = c;
        this.buttonDrawables = buttonDrawables;
        this.buttonNames = buttonNames;
    }

    public int getCount() {
        return buttonNames.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        Button button;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            button = new Button(mContext);
            button.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            button.setPadding(16, 16, 16, 16);
            button.setText(buttonNames.get(position));
        } else {
            button = (Button) convertView;
        }
        button.setCompoundDrawablesWithIntrinsicBounds(null, buttonDrawables.get(position), null, null);
        return button;
    }
}
