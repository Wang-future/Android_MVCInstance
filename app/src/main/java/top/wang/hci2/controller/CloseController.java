package top.wang.hci2.controller;

import android.view.View;
import android.view.View.OnClickListener;

import top.wang.hci2.activity.CloseControllerListener;
import top.wang.hci2.view.CloseView;

public class CloseController implements OnClickListener {
    private CloseView closeView;
    private CloseControllerListener listener;


    public CloseController(CloseView closeView, CloseControllerListener listener) {
        this.closeView = closeView;
        this.listener = listener;
        //this.dialog=dialog;
    }
    @Override
    public void onClick(View v)
    {
        listener.onCloseSelect();
    }
}
