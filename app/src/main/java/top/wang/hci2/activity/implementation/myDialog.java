package top.wang.hci2.activity.implementation;

import android.app.Dialog;
import android.content.Context;

import top.wang.hci2.R;
import top.wang.hci2.activity.CloseControllerListener;
import top.wang.hci2.controller.CloseController;
import top.wang.hci2.view.CloseView;

public class myDialog extends Dialog implements CloseControllerListener {

    public myDialog(Context context) {
        super(context, R.style.dialog);
        setContentView(R.layout.activity_switch_boy);

        CloseController closeController = new CloseController((CloseView)this.findViewById(R.id.closeIcon),this);
        ((CloseView) this.findViewById(R.id.closeIcon)).setListeners(closeController,R.id.closeIcon);
    }

    @Override
    public void onCloseSelect()
    {
        this.dismiss();
    }

    @Override
    public void show() {
        super.show();
    }
}
