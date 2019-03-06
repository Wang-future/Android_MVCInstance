package top.wang.hci2.activity.implementation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.graphics.Color;
import android.content.Intent;
import android.widget.ImageView;

import top.wang.hci2.R;
import top.wang.hci2.activity.CloseControllerListener;
import top.wang.hci2.activity.StarControllerListener;
import top.wang.hci2.activity.SwitchControllerListener;
import top.wang.hci2.controller.StarController;
import top.wang.hci2.controller.SwitchController;
import top.wang.hci2.controller.CloseController;
import top.wang.hci2.view.StarView;
import top.wang.hci2.view.SwitchView;
import top.wang.hci2.view.CloseView;
import android.widget.TextView;
import top.wang.hci2.User;
import top.wang.hci2.Data_User;
import top.wang.hci2.model.dataHelper;

public class MainActivity extends AppCompatActivity implements SwitchControllerListener,StarControllerListener,CloseControllerListener {
    int imageID[]=new int[]{ R.id.imageView14,R.id.reward_night,R.id.ball3};
    int i_visiblity=0;
    int firsttime=0;
    boolean layout_boy=true;


//    User boy_user=application.getBoy_user();
//    User girl_user=application.getGirl_user();
   User boy_user=new dataHelper().getUser(1);
   User girl_user=new dataHelper().getUser(2);
    User Current_user=boy_user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Data_User application = (Data_User)this.getApplication();
        if(application.getBoy_user()!=null)
        {
            boy_user=application.getBoy_user();
        }
        if(application.getGirl_user()!=null)
        {
            girl_user=application.getGirl_user();
        }
        //setContentView(R.layout.activity_main_boy);
        if(Current_user.getSex()==1)
        {
            setContentView(R.layout.activity_main_boy);
            TextView startext=(TextView)MainActivity.this.findViewById(R.id.textView10);
           startext.setText(String.valueOf(Current_user.getStars()));
            TextView cointext=(TextView)MainActivity.this.findViewById(R.id.textView9);
            cointext.setText(String.valueOf(Current_user.getCoins()));
        }

        else
            {
                setContentView(R.layout.activity_main_boy);
                changeUser();
            }

        final User my_user= (User) getIntent().getSerializableExtra("Current_user");
        if(my_user!=null)
        {

            Current_user=my_user;
            changeUser();
            TextView startext=(TextView)MainActivity.this.findViewById(R.id.textView10);
            startext.setText(String.valueOf(Current_user.getStars()));
            TextView cointext=(TextView)MainActivity.this.findViewById(R.id.textView9);
            cointext.setText(String.valueOf(Current_user.getCoins()));
            if(Current_user.getId()==1)
                boy_user=Current_user;
            else
                girl_user=Current_user;
        }
        SwitchController switchController = new SwitchController((SwitchView)this.findViewById(R.id.headIcon_boy),this);
        ((SwitchView) this.findViewById(R.id.headIcon_boy)).setListeners(switchController);

        StarController starController = new StarController((StarView)this.findViewById(R.id.starIcon1),this);
        ((StarView) this.findViewById(R.id.starIcon1)).setListeners(starController);



        findViewById(R.id.imageView7).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(MainActivity.this,myAssets.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("Current_user", Current_user);
                intent.putExtras(bundle);

                startActivity(intent);
            }
        });
    }


    @Override
    public void onStarSelect()
    {

        final myDialog  dialog = new myDialog(this);
        ImageView temimageView14 = (ImageView) dialog.findViewById(R.id.imageView14);

//
        final int arr_length=imageID.length;
        dialog.setContentView(R.layout.activity_star_daytime_boy);
        dialog.show();
        dialog.setCanceledOnTouchOutside(true); // Sets whether this dialog is
        Window win = dialog.getWindow();
        win.setGravity(Gravity.CENTER);
        ImageView reward_night = (ImageView) dialog.findViewById(R.id.reward_night);
        reward_night.setVisibility(View.INVISIBLE);
        ImageView ball3 = (ImageView) dialog.findViewById(R.id.ball3);
        ball3.setVisibility(View.INVISIBLE);


        ImageView imageView_leftnarrow = (ImageView) dialog.findViewById(R.id.leftnarrow);
        imageView_leftnarrow.setVisibility(View.INVISIBLE);
        CloseController closeController = new CloseController((CloseView)dialog.findViewById(R.id.closeIcongg),this);
        ((CloseView) dialog.findViewById(R.id.closeIcongg)).setListeners(closeController,R.id.closeIcongg);
        imageView_leftnarrow.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        ImageView temp = (ImageView) dialog.findViewById(imageID[i_visiblity]);
                        temp.setVisibility(View.INVISIBLE);

                        i_visiblity--;
                            ImageView temp1 = (ImageView) dialog.findViewById(imageID[i_visiblity]);
                            temp1.setVisibility(View.VISIBLE);
                            if(i_visiblity==1)
                            {
                               TextView temp2 = (TextView) dialog.findViewById(R.id.TextView16);
                                temp2.setText("5");
                            }
                            else
                            {
                                TextView temp2 = (TextView) dialog.findViewById(R.id.TextView16);
                               temp2.setText("4");
                            }
                            if(0==i_visiblity)
                            {
                                ImageView imageView_leftnarrow1 = (ImageView) dialog.findViewById(R.id.leftnarrow);
                                imageView_leftnarrow1.setVisibility(View.INVISIBLE);
                            }

                        if(arr_length-2==i_visiblity)
                        {
                            ImageView imageView_leftnarrow1 = (ImageView) dialog.findViewById(R.id.rightnarrow);
                            imageView_leftnarrow1.setVisibility(View.VISIBLE);
                        }


                    }
                });
        ImageView imageView_rightnarrow = (ImageView) dialog.findViewById(R.id.rightnarrow);
        imageView_rightnarrow.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        ImageView temp = (ImageView) dialog.findViewById(imageID[i_visiblity]);
                        temp.setVisibility(View.INVISIBLE);

                            if(0==i_visiblity)
                            {
                                ImageView imageView_leftnarrow1 = (ImageView) dialog.findViewById(R.id.leftnarrow);
                                imageView_leftnarrow1.setVisibility(View.VISIBLE);
                            }


                            if(arr_length-2==i_visiblity)
                            {
                                ImageView imageView_leftnarrow1 = (ImageView) dialog.findViewById(R.id.rightnarrow);
                                imageView_leftnarrow1.setVisibility(View.INVISIBLE);


                            }
                        i_visiblity++;
                        if(i_visiblity==1)
                        {
                            TextView temp2 = (TextView) dialog.findViewById(R.id.TextView16);
                            temp2.setText("5");
                        }
                        else
                        {
                            TextView temp2 = (TextView) dialog.findViewById(R.id.TextView16);
                            temp2.setText("4");
                        }
                            ImageView temp1 = (ImageView) dialog.findViewById(imageID[i_visiblity]);
                            temp1.setVisibility(View.VISIBLE);


                    }
                });

    }

    @Override
    public void onCloseSelect( )
    {
int a=0;

    }



    @Override
    public void onSwitchSelect()
    {

        final myDialog dialog = new myDialog(this);

        dialog.setContentView(R.layout.activity_switch_boy);
        dialog.show();
        Window win = dialog.getWindow();
        win.setGravity(Gravity.LEFT | Gravity.TOP);
        win.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams params = win.getAttributes();
        //设置窗口宽度为充满全屏
        params.width = WindowManager.LayoutParams.FILL_PARENT;
        //设置窗口高度为包裹内容
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        //将设置好的属性set回去
        win.setAttributes(params);

        TextView temp4 = (TextView) dialog.findViewById(R.id.textView2);
        temp4.setText(" "+Current_user.getCoins());
        TextView temp5 = (TextView) dialog.findViewById(R.id.textView3);
        temp5.setText(" "+Current_user.getStars());
//这里根据当前的男女显示颜色
        //textView10 宝宝_girl textView8 宝宝_boy  headIcon_boy headIcon_girl
        if(Current_user.getId()==1)
        {
           ImageView temp_imageView6 = (ImageView) dialog.findViewById(R.id.imageView6);
           temp_imageView6.setColorFilter(Color.parseColor("#4FACDF"));
            ImageView temp_imageView5 = (ImageView) dialog.findViewById(R.id.imageView5);
            temp_imageView5.setColorFilter(Color.parseColor("#8ED5F3"));

            ImageView temp_imageView7 = (ImageView) dialog.findViewById(R.id.imageView7);
            temp_imageView7.setImageDrawable(getResources().getDrawable(R.drawable.boy));
            ImageView temp_imageView4 = (ImageView) dialog.findViewById(R.id.imageView13);
            temp_imageView4.setImageDrawable(getResources().getDrawable(R.drawable.girl_baobao));

            TextView temp2 = (TextView) dialog.findViewById(R.id.textView8);
            temp2.setText("宝宝_boy");
            TextView temp3 = (TextView) dialog.findViewById(R.id.textView10);
            temp3.setText("宝宝_girl");
        }
        else
        {
            ImageView temp_imageView6 = (ImageView) dialog.findViewById(R.id.imageView6);
            temp_imageView6.setColorFilter(Color.parseColor("#F67EAB"));
            ImageView temp_imageView5 = (ImageView) dialog.findViewById(R.id.imageView5);
            temp_imageView5.setColorFilter(Color.parseColor("#F9BBDB"));

            ImageView temp_imageView7 = (ImageView) dialog.findViewById(R.id.imageView7);
            temp_imageView7.setImageDrawable(getResources().getDrawable(R.drawable.girl_baobao));
            ImageView temp_imageView4 = (ImageView) dialog.findViewById(R.id.imageView13);
            temp_imageView4.setImageDrawable(getResources().getDrawable(R.drawable.boy));

            TextView temp2 = (TextView) dialog.findViewById(R.id.textView8);
            temp2.setText("宝宝_girl");
            TextView temp3 = (TextView) dialog.findViewById(R.id.textView10);
            temp3.setText("宝宝_boy");
        }
        // closeicon触发代码
        ImageView temp_closeicon = (ImageView) dialog.findViewById(R.id.closeIcon1);
        temp_closeicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.onCloseSelect();
            }
        });
        //切换代码 imageView13
        ImageView temp_SwitchToGirl = (ImageView) dialog.findViewById(R.id.imageView13);
        temp_SwitchToGirl.setOnClickListener(new View.OnClickListener() {
                                @Override
                    public void onClick(View view) {

                                    dialog.dismiss();
                                    if(Current_user.getId()==1)//当前为男 要切换到女
                                    {   //layout_boy=false;
                                        Current_user=girl_user;}
                                    else
                                    {
                                        Current_user=boy_user;
                                    }
                                        changeUser();

                    }
                });

    }
    public void changeUser()
    {
        if(Current_user.getId()==2)//当前为男 要切换到女
        {   //layout_boy=false;

            TextView startext=(TextView)MainActivity.this.findViewById(R.id.textView10);
            startext.setText(String.valueOf(Current_user.getStars()));
            TextView cointext=(TextView)MainActivity.this.findViewById(R.id.textView9);
            cointext.setText(String.valueOf(Current_user.getCoins()));

            ImageView temp_day0 =(ImageView)MainActivity.this.findViewById(R.id.hide_headIcon_boy);
            temp_day0.setImageDrawable(getResources().getDrawable(R.drawable.girl_baobao));

            ImageView temp_day7 =(ImageView)MainActivity.this.findViewById(R.id.imageView);
            temp_day7.setImageDrawable(getResources().getDrawable(R.drawable.girlsmile));

            temp_day7 =(ImageView)MainActivity.this.findViewById(R.id.imageView2);
            temp_day7.setColorFilter(Color.parseColor("#F9BBDB"));

            temp_day7 =(ImageView)MainActivity.this.findViewById(R.id.imageView3);
            temp_day7.setColorFilter(Color.parseColor("#F67EAB"));

            temp_day7 =(ImageView)MainActivity.this.findViewById(R.id.imageView4);
            temp_day7.setColorFilter(Color.parseColor("#F9BBDB"));

            temp_day7 =(ImageView)MainActivity.this.findViewById(R.id.imageView7);
            temp_day7.setImageDrawable(getResources().getDrawable(R.drawable.home_girl));

            temp_day7 =(ImageView)MainActivity.this.findViewById(R.id.imageView10);
            temp_day7.setImageDrawable(getResources().getDrawable(R.drawable.goal_girl));
            //周一到周日替换
            TextView temp_day6 =(TextView)MainActivity.this.findViewById(R.id.sunday);
            temp_day6.setTextColor(Color.parseColor("#F9BBDB"));
            temp_day6 =(TextView)MainActivity.this.findViewById(R.id.saturday);
            temp_day6.setTextColor(Color.parseColor("#F9BBDB"));
            temp_day6 =(TextView)MainActivity.this.findViewById(R.id.monday);
            temp_day6.setTextColor(Color.parseColor("#F9BBDB"));
            temp_day6 =(TextView)MainActivity.this.findViewById(R.id.wednesday);
            temp_day6.setTextColor(Color.parseColor("#F9BBDB"));
            temp_day6 =(TextView)MainActivity.this.findViewById(R.id.tuesday);
            temp_day6.setTextColor(Color.parseColor("#F9BBDB"));
            temp_day6 =(TextView)MainActivity.this.findViewById(R.id.friday);
            temp_day6.setTextColor(Color.parseColor("#F9BBDB"));
            temp_day6 =(TextView)MainActivity.this.findViewById(R.id.thursday);
            temp_day6.setTextColor(Color.parseColor("#F9BBDB"));
            //第一行替换
            ImageView temp_day8 =(ImageView)MainActivity.this.findViewById(R.id.day1);
            temp_day8.setColorFilter(Color.parseColor("#FFEFFF"));
            temp_day8 =(ImageView)MainActivity.this.findViewById(R.id.day2);
            temp_day8.setColorFilter(Color.parseColor("#FFEFFF"));
            temp_day8 =(ImageView)MainActivity.this.findViewById(R.id.day3);
            temp_day8.setColorFilter(Color.parseColor("#FFEFFF"));
            temp_day8 =(ImageView)MainActivity.this.findViewById(R.id.day4);
            temp_day8.setColorFilter(Color.parseColor("#FFEFFF"));
            temp_day8 =(ImageView)MainActivity.this.findViewById(R.id.day5);
            temp_day8.setColorFilter(Color.parseColor("#FFEFFF"));
            temp_day8 =(ImageView)MainActivity.this.findViewById(R.id.day6);
            temp_day8.setColorFilter(Color.parseColor("#FFEFFF"));
            temp_day8 =(ImageView)MainActivity.this.findViewById(R.id.day7);
            temp_day8.setColorFilter(Color.parseColor("#FFEFFF"));

            //第二行替换
            ImageView temp_day9 =(ImageView)MainActivity.this.findViewById(R.id.day8);
            temp_day9.setColorFilter(Color.parseColor("#FDDBEB"));
            temp_day9 =(ImageView)MainActivity.this.findViewById(R.id.day9);
            temp_day9.setColorFilter(Color.parseColor("#FDDBEB"));
            temp_day9 =(ImageView)MainActivity.this.findViewById(R.id.day10);
            temp_day9.setColorFilter(Color.parseColor("#FDDBEB"));
            temp_day9 =(ImageView)MainActivity.this.findViewById(R.id.day11);
            temp_day9.setColorFilter(Color.parseColor("#FDDBEB"));
            temp_day9 =(ImageView)MainActivity.this.findViewById(R.id.day12);
            temp_day9.setColorFilter(Color.parseColor("#FDDBEB"));
            temp_day9 =(ImageView)MainActivity.this.findViewById(R.id.day13);
            temp_day9.setColorFilter(Color.parseColor("#FDDBEB"));
            temp_day9 =(ImageView)MainActivity.this.findViewById(R.id.day14);
            temp_day9.setColorFilter(Color.parseColor("#FDDBEB"));

            //第三行
            ImageView temp_day10 =(ImageView)MainActivity.this.findViewById(R.id.day15);
            temp_day10.setColorFilter(Color.parseColor("#FFC4C5"));
            temp_day10 =(ImageView)MainActivity.this.findViewById(R.id.day16);
            temp_day10.setColorFilter(Color.parseColor("#FFC4C5"));
            temp_day10 =(ImageView)MainActivity.this.findViewById(R.id.day17);
            temp_day10.setColorFilter(Color.parseColor("#FFC4C5"));
            temp_day10 =(ImageView)MainActivity.this.findViewById(R.id.day18);
            temp_day10.setColorFilter(Color.parseColor("#FFC4C5"));
            temp_day10 =(ImageView)MainActivity.this.findViewById(R.id.day19);
            temp_day10.setColorFilter(Color.parseColor("#FFC4C5"));
            temp_day10 =(ImageView)MainActivity.this.findViewById(R.id.day20);
            temp_day10.setColorFilter(Color.parseColor("#FFC4C5"));
            temp_day10 =(ImageView)MainActivity.this.findViewById(R.id.day21);
            temp_day10.setColorFilter(Color.parseColor("#FFC4C5"));



        }
        else
        {


            TextView startext=(TextView)MainActivity.this.findViewById(R.id.textView10);
            startext.setText(String.valueOf(Current_user.getStars()));
            TextView cointext=(TextView)MainActivity.this.findViewById(R.id.textView9);
            cointext.setText(String.valueOf(Current_user.getCoins()));
            ImageView temp_day0 =(ImageView)MainActivity.this.findViewById(R.id.hide_headIcon_boy);
            temp_day0.setImageDrawable(getResources().getDrawable(R.drawable.boy));

            ImageView temp_day7 =(ImageView)MainActivity.this.findViewById(R.id.imageView);
            temp_day7.setImageDrawable(getResources().getDrawable(R.drawable.boysmile));

            temp_day7 =(ImageView)MainActivity.this.findViewById(R.id.imageView2);
            temp_day7.setColorFilter(Color.parseColor("#8ED5F3"));

            temp_day7 =(ImageView)MainActivity.this.findViewById(R.id.imageView3);
            temp_day7.setColorFilter(Color.parseColor("#4FACDF"));

            temp_day7 =(ImageView)MainActivity.this.findViewById(R.id.imageView4);
            temp_day7.setColorFilter(Color.parseColor("#8ED5F3"));

            temp_day7 =(ImageView)MainActivity.this.findViewById(R.id.imageView7);
            temp_day7.setImageDrawable(getResources().getDrawable(R.drawable.home_boy));

            temp_day7 =(ImageView)MainActivity.this.findViewById(R.id.imageView10);
            temp_day7.setImageDrawable(getResources().getDrawable(R.drawable.goal_boy));
            //周一到周日替换
            TextView temp_day6 =(TextView)MainActivity.this.findViewById(R.id.sunday);
            temp_day6.setTextColor(Color.parseColor("#8ED5F3"));
            temp_day6 =(TextView)MainActivity.this.findViewById(R.id.saturday);
            temp_day6.setTextColor(Color.parseColor("#8ED5F3"));
            temp_day6 =(TextView)MainActivity.this.findViewById(R.id.monday);
            temp_day6.setTextColor(Color.parseColor("#8ED5F3"));
            temp_day6 =(TextView)MainActivity.this.findViewById(R.id.wednesday);
            temp_day6.setTextColor(Color.parseColor("#8ED5F3"));
            temp_day6 =(TextView)MainActivity.this.findViewById(R.id.tuesday);
            temp_day6.setTextColor(Color.parseColor("#8ED5F3"));
            temp_day6 =(TextView)MainActivity.this.findViewById(R.id.friday);
            temp_day6.setTextColor(Color.parseColor("#8ED5F3"));
            temp_day6 =(TextView)MainActivity.this.findViewById(R.id.thursday);
            temp_day6.setTextColor(Color.parseColor("#8ED5F3"));
            //第一行替换
            ImageView temp_day8 =(ImageView)MainActivity.this.findViewById(R.id.day1);
            temp_day8.setColorFilter(Color.parseColor("#56E1B8"));
            temp_day8 =(ImageView)MainActivity.this.findViewById(R.id.day2);
            temp_day8.setColorFilter(Color.parseColor("#56E1B8"));
            temp_day8 =(ImageView)MainActivity.this.findViewById(R.id.day3);
            temp_day8.setColorFilter(Color.parseColor("#56E1B8"));
            temp_day8 =(ImageView)MainActivity.this.findViewById(R.id.day4);
            temp_day8.setColorFilter(Color.parseColor("#56E1B8"));
            temp_day8 =(ImageView)MainActivity.this.findViewById(R.id.day5);
            temp_day8.setColorFilter(Color.parseColor("#56E1B8"));
            temp_day8 =(ImageView)MainActivity.this.findViewById(R.id.day6);
            temp_day8.setColorFilter(Color.parseColor("#56E1B8"));
            temp_day8 =(ImageView)MainActivity.this.findViewById(R.id.day7);
            temp_day8.setColorFilter(Color.parseColor("#56E1B8"));

            //第二行替换
            ImageView temp_day9 =(ImageView)MainActivity.this.findViewById(R.id.day8);
            temp_day9.setColorFilter(Color.parseColor("#6BD3F7"));
            temp_day9 =(ImageView)MainActivity.this.findViewById(R.id.day9);
            temp_day9.setColorFilter(Color.parseColor("#6BD3F7"));
            temp_day9 =(ImageView)MainActivity.this.findViewById(R.id.day10);
            temp_day9.setColorFilter(Color.parseColor("#6BD3F7"));
            temp_day9 =(ImageView)MainActivity.this.findViewById(R.id.day11);
            temp_day9.setColorFilter(Color.parseColor("#6BD3F7"));
            temp_day9 =(ImageView)MainActivity.this.findViewById(R.id.day12);
            temp_day9.setColorFilter(Color.parseColor("#6BD3F7"));
            temp_day9 =(ImageView)MainActivity.this.findViewById(R.id.day13);
            temp_day9.setColorFilter(Color.parseColor("#6BD3F7"));
            temp_day9 =(ImageView)MainActivity.this.findViewById(R.id.day14);
            temp_day9.setColorFilter(Color.parseColor("#6BD3F7"));

            //第三行
            ImageView temp_day10 =(ImageView)MainActivity.this.findViewById(R.id.day15);
            temp_day10.setColorFilter(Color.parseColor("#47B6DB"));
            temp_day10 =(ImageView)MainActivity.this.findViewById(R.id.day16);
            temp_day10.setColorFilter(Color.parseColor("#47B6DB"));
            temp_day10 =(ImageView)MainActivity.this.findViewById(R.id.day17);
            temp_day10.setColorFilter(Color.parseColor("#47B6DB"));
            temp_day10 =(ImageView)MainActivity.this.findViewById(R.id.day18);
            temp_day10.setColorFilter(Color.parseColor("#47B6DB"));
            temp_day10 =(ImageView)MainActivity.this.findViewById(R.id.day19);
            temp_day10.setColorFilter(Color.parseColor("#47B6DB"));
            temp_day10 =(ImageView)MainActivity.this.findViewById(R.id.day20);
            temp_day10.setColorFilter(Color.parseColor("#47B6DB"));
            temp_day10 =(ImageView)MainActivity.this.findViewById(R.id.day21);
            temp_day10.setColorFilter(Color.parseColor("#47B6DB"));



        }
        ImageView temp_day8 =(ImageView)MainActivity.this.findViewById(R.id.day8);

    }

}


