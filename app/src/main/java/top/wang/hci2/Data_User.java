package top.wang.hci2;

import android.app.Application;

public class Data_User extends Application {
    public User girl_user;
    public User boy_user;
    public  Data_User()
    {
    }

    public void setGirl_user(User g)
    {
        this.girl_user=g;
    }
    public void setBoy_user(User g)
    {
        this.boy_user=g;
    }

    public User getBoy_user() {
        return boy_user;
    }

    public User getGirl_user() {
        return girl_user;
    }
}
