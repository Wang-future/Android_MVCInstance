package top.wang.hci2.activity.implementation;

import android.app.Dialog;
import android.content.Context;

import top.wang.hci2.R;
import top.wang.hci2.activity.StarControllerListener;
import top.wang.hci2.controller.StarController;
import top.wang.hci2.view.StarView;

public class starDialog extends Dialog implements StarControllerListener {

    public starDialog(Context context) {
        super(context);
        setContentView(R.layout.activity_star_daytime_boy);

        StarController starController = new StarController((StarView) this.findViewById(R.id.starIcon1), this);
        ((StarView) this.findViewById(R.id.starIcon1)).setListeners(starController);

    }

    @Override
    public void onStarSelect() {
        this.dismiss();
    }

    @Override
    public void show() {
        super.show();
    }
}
