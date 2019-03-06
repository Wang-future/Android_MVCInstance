//package top.juusok.hci2.activity.implementation;
//import android.content.Context;
//
//import top.juusok.hci2.R;
//import android.app.Dialog;
//import top.juusok.hci2.activity.ShopControllerListener;
//import top.juusok.hci2.controller.ShopController;
//import top.juusok.hci2.view.ShopView;
//public class shop_dialog extends Dialog implements ShopControllerListener {
//    public shop_dialog(Context context) {
//        super(context, R.style.dialog);
//        setContentView(R.layout.activity_switch_boy);
//
//        ShopController shopController = new ShopController((ShopView)this.findViewById(R.id.closeIcon),this,R.id.closeIcon);
//        ShopView my_closeIcon= this.findViewById(R.id.closeIcon);
//        my_closeIcon.setListeners(shopController,my_closeIcon);
//    }
//
//    @Override
//    public void onShopSelect()
//    {
//        this.dismiss();
//    }
//
//    @Override
//    public void show() {
//        super.show();
//    }
//}
