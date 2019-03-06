package top.wang.hci2.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class CloseView extends LinearLayout {
    public CloseView(Context context,AttributeSet attrs)
    {
        super(context,attrs);
    }

//    public void setListeners(OnClickListener onClickListener){
//        findViewById(R.id.closeIcon).setOnClickListener(onClickListener);
//    }
    public void setListeners(OnClickListener onClickListener,int my){
        findViewById(my).setOnClickListener(onClickListener);
    }
}
