package top.wang.hci2.controller;

import android.view.View;
import android.view.View.OnClickListener;

import top.wang.hci2.activity.StarControllerListener;
import top.wang.hci2.view.StarView;

public class StarController implements OnClickListener {
    private StarView starView;
    private StarControllerListener listener;


    public StarController(StarView starView, StarControllerListener listener) {
        this.starView = starView;
        this.listener = listener;
    }
    @Override
    public void onClick(View v)
    {
        listener.onStarSelect();
    }
}
