package top.wang.hci2.model;

import top.wang.hci2.User;

public class dataHelper {
    public void dataHelper(){}

    public User getUser(int id)
    {
        User res = new User();
        if(id==1) {
            res.modify(1, "boy", 10, 12, 1);
            res.setDay(1, 3);
            res.setDay(2, 4);
            res.setDay(3, 2);
            res.setDay(4, 3);
        } else {
            res.modify(2,"girl",3,9,2);
            res.setDay(1,1);
            res.setDay(2,2);
            res.setDay(3,3);
            res.setDay(4,3);
        }
        return res;
    }
}
