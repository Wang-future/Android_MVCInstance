package top.wang.hci2.controller;

import top.wang.hci2.activity.ShopControllerListener;
import android.view.View;
import android.view.View.OnClickListener;


import top.wang.hci2.view.ShopView;

public class ShopController implements OnClickListener{
    private ShopView shopView;
    private ShopControllerListener listener;
    private int id_value;

    public ShopController(ShopView shopView, ShopControllerListener listener,int id_value) {
        this.shopView = shopView;
        this.listener = listener;
        this.id_value = id_value;
    }
    @Override
    public void onClick(View v)
    {
        listener.onShopSelect(this.id_value);
    }
}
