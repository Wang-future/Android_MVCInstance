package top.wang.hci2.activity.implementation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.AlertDialog;
import top.wang.hci2.controller.ShopController;
import top.wang.hci2.activity.ShopControllerListener;
import android.view.Gravity;
import android.content.DialogInterface;
import top.wang.hci2.R;
import top.wang.hci2.view.ShopView;
import android.widget.Toast;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.view.*;
import android.content.Intent;
import top.wang.hci2.User;
import android.widget.TextView;
import android.graphics.Color;
import top.wang.hci2.Data_User;
public class Giftactivity extends AppCompatActivity implements ShopControllerListener {
    User my_user;
    int star_value=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.shop);
         my_user= (User) getIntent().getSerializableExtra("Current_user");
        TextView temp1=(TextView)Giftactivity.this.findViewById(R.id.textView10);
        temp1.setText(String.valueOf(my_user.getStars()));
        TextView temp2=(TextView)Giftactivity.this.findViewById(R.id.textView1);
        temp2.setText(String.valueOf(my_user.getCoins()));
        changeColor();

        ShopController shopController = new ShopController((ShopView)this.findViewById(R.id.ball4),this,R.id.ball4);
        ShopView my_ball4= this.findViewById(R.id.ball4);
        my_ball4.setListeners(shopController,my_ball4);

        ShopView my_car= (ShopView)(this.findViewById(R.id.car3));
        ShopController shopController_car = new ShopController(my_car,this,(R.id.car3));
        my_car.setListeners(shopController_car,my_car);

        ShopView my_duck= (ShopView)(this.findViewById(R.id.duck3));
        shopController = new ShopController(my_duck,this,R.id.duck3);
        my_car.setListeners(shopController,my_duck);


        ShopView my_dinosaur= (ShopView)(this.findViewById(R.id.dinosaur3));
        shopController = new ShopController(my_dinosaur,this,R.id.dinosaur3);
        my_dinosaur.setListeners(shopController,my_dinosaur);

        ShopView my_potatochips= (ShopView)(this.findViewById(R.id.potatochips3));
        shopController = new ShopController(my_potatochips,this,R.id.potatochips3);
        my_potatochips.setListeners(shopController,my_potatochips);

        ShopView my_beer= (ShopView)(this.findViewById(R.id.beer));
        shopController = new ShopController(my_beer,this,R.id.beer);
        my_beer.setListeners(shopController,my_beer);

        ShopView my_slide= (ShopView)(this.findViewById(R.id.slide));
        shopController = new ShopController(my_slide,this,R.id.slide);
        my_slide.setListeners(shopController,my_slide);

        ShopView my_telephone= (ShopView)(this.findViewById(R.id.telephone));
        shopController = new ShopController(my_telephone,this,R.id.telephone);
        my_telephone.setListeners(shopController,my_telephone);

        findViewById(R.id.rightcorner).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(Giftactivity.this,MainActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("Current_user", my_user);
                intent.putExtras(bundle);
               startActivity(intent);

            }

        });


        findViewById(R.id.imageView7).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(Giftactivity.this,myAssets.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("Current_user", my_user);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });
    }
    @Override
    public void onShopSelect( final int k)
    {

        AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
        localBuilder.setTitle("礼物购买");
        localBuilder.setIcon(R.mipmap.ic_launcher);
        localBuilder.setMessage("你确定购买该礼物吗");
        localBuilder.setPositiveButton("确定", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
        switch(k)
        {
            case R.id.ball4:
            {
                star_value=4;
                break;
            }
            case R.id.car3:
            {
                star_value=5;
                break;
            }
            case R.id.duck3:
            {
                star_value=7;
                break;
            }
            case R.id.telephone:
            {
                star_value=6;
                break;
            }
            case R.id.beer:
            {
                star_value=6;
                break;
            }
            case R.id.slide:
            {
                star_value=6;
                break;
            }
            default:
                star_value=4;
        }
                if(my_user.getStars()<star_value){
                    Toast toast = Toast.makeText(getApplicationContext(), "你的资产不够", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
                else
                {
                    my_user.setstars(my_user.getStars()-star_value);
                    Toast toast = Toast.makeText(getApplicationContext(), "-"+star_value, Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
// 2 创建Layout，并设置为水平布局
                    LinearLayout mLayout = new LinearLayout(getApplicationContext());
                    mLayout.setOrientation(LinearLayout.VERTICAL);
                    ImageView mImage = new ImageView(getApplicationContext());
// 用于显示图像的ImageView
                    mImage.setImageResource(R.drawable.star);
                    View toastView = toast.getView();
// 获取显示文字的Toast View
                    mLayout.addView(mImage);
// 添加到Layout
                    mLayout.addView(toastView);
// 3 关键，设置Toast显示的View(上面生成的Layout).
                    toast.setView(mLayout);
                    toast.show();
                    TextView temp1=(TextView)Giftactivity.this.findViewById(R.id.textView10);
                    temp1.setText(String.valueOf(my_user.getStars()));
                    TextView temp2=(TextView)Giftactivity.this.findViewById(R.id.textView1);
                    temp2.setText(String.valueOf(my_user.getCoins()));
                    Data_User application = (Data_User)Giftactivity.this.getApplication();
                    if(my_user.getId()==1)
                    {
                        application.setBoy_user(my_user);
                    }
                    else
                    {
                        application.setGirl_user(my_user);
                    }
                }


            }
        });
        localBuilder.setNegativeButton("取消", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
                /**
                 * 确定操作
                 * */
            }
        });

        /***
         * 设置点击返回键不会消失
         * */
        localBuilder.setCancelable(false).create();

        localBuilder.show();
}
    public void changeColor() {
        if (my_user.getId() == 1)//当前为男
        {
            ImageView temp_day7 =(ImageView)Giftactivity.this.findViewById(R.id.boysmile);
            temp_day7.setImageDrawable(getResources().getDrawable(R.drawable.boysmile));

            ImageView temp_day1 =(ImageView)Giftactivity.this.findViewById(R.id.imageView7);
            temp_day1.setImageDrawable(getResources().getDrawable(R.drawable.home_boy));
            ImageView temp_day2 =(ImageView)Giftactivity.this.findViewById(R.id.imageView2);
            temp_day2.setColorFilter(Color.parseColor("#8ED5F3"));
            ImageView temp_day3 =(ImageView)Giftactivity.this.findViewById(R.id.split);
            temp_day3.setImageDrawable(getResources().getDrawable(R.drawable.splitline));
            ImageView temp_day4 =(ImageView)Giftactivity.this.findViewById(R.id.split2);
            temp_day4.setImageDrawable(getResources().getDrawable(R.drawable.splitline));
        }
        else {

            ImageView temp_day7 =(ImageView)Giftactivity.this.findViewById(R.id.boysmile);
            temp_day7.setImageDrawable(getResources().getDrawable(R.drawable.girlsmile));

            ImageView temp_day1 =(ImageView)Giftactivity.this.findViewById(R.id.imageView7);
            temp_day1.setImageDrawable(getResources().getDrawable(R.drawable.home_girl));

            ImageView temp_day2 =(ImageView)Giftactivity.this.findViewById(R.id.imageView2);
            temp_day2.setColorFilter(Color.parseColor("#F9BBDB"));
            ImageView temp_day3 =(ImageView)Giftactivity.this.findViewById(R.id.split);
            temp_day3.setImageDrawable(getResources().getDrawable(R.drawable.split_girl));
            ImageView temp_day4 =(ImageView)Giftactivity.this.findViewById(R.id.split2);
            temp_day4.setImageDrawable(getResources().getDrawable(R.drawable.split_girl));
        }
    }
}
