package top.wang.hci2.view;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class ShopView extends LinearLayout {
    public ShopView(Context context,AttributeSet attrs)
    {
        super(context,attrs);
    }

    public void setListeners(OnClickListener onClickListener,ShopView my){
        //ShopView my= (ShopView) this.findViewById(R.id.dollthing);
       // ShopView my= (ShopView) this.findViewById(R.id.dollthing);
            my.setOnClickListener(onClickListener);

        //findViewById(R.id.viewgift).setOnClickListener(onClickListener);
    }
}