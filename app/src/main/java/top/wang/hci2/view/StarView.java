package top.wang.hci2.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import top.wang.hci2.R;

public class StarView extends LinearLayout {
    public StarView(Context context,AttributeSet attrs)
    {
        super(context,attrs);
    }

    public void setListeners(OnClickListener onClickListener){
        findViewById(R.id.starIcon1).setOnClickListener(onClickListener);
    }
}
