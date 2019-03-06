package top.wang.hci2;
import java.io.Serializable;
public class User implements Serializable{
    private int id,coins,stars,sex;
    private String name;
    private int[] day = new int[43];

    public User(){}

    public void modify(int id, String name, int coins, int stars, int sex)
    {
        this.id = id;
        this.coins = coins;
        this.stars = stars;
        this.sex = sex;//当sex为1是男 2是女
        this.name = name;
    }

    public void setDay(int th, int cnt)
    {
        day[th] = cnt;
    }
    public void setcoins(int th)
    {
        coins = th;
    }
    public void setstars(int th)
    {
        stars = th;
    }

    public int getId()
    {
        return id;
    }

    public int getCoins()
    {
        return coins;
    }

    public int getStars()
    {
        return stars;
    }

    public int getSex()
    {
        return sex;
    }

    public int getDay(int t)
    {
        return day[t];
    }


}
