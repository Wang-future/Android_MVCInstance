package top.wang.hci2.activity.implementation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import top.wang.hci2.R;

import android.view.View;
import android.content.Intent;
import top.wang.hci2.User;
import android.widget.TextView;
import android.widget.ImageView;
import android.graphics.Color;

public class myAssets extends AppCompatActivity  {
    //User my_user= (User) getIntent().getSerializableExtra("Current_user");
    User global_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myassets);
        final User my_user= (User) getIntent().getSerializableExtra("Current_user");
        global_user=my_user;
        TextView temp1=(TextView)myAssets.this.findViewById(R.id.text_star);
        temp1.setText(String.valueOf(my_user.getStars()));
        TextView temp2=(TextView)myAssets.this.findViewById(R.id.text_coin);
        temp2.setText(String.valueOf(my_user.getCoins()));
        changecolor();
                findViewById(R.id.viewgift).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(myAssets.this,Giftactivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("Current_user", my_user);
                intent.putExtras(bundle);
                startActivity(intent);

            }

        });

        findViewById(R.id.rightcorner).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(myAssets.this,MainActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("Current_user", my_user);
                intent.putExtras(bundle);
                startActivity(intent);
            }

        });


    }
    public void changecolor()
    {
        if (global_user.getId() == 1)//当前为男
        {
            ImageView temp_day2 =(ImageView)myAssets.this.findViewById(R.id.imageView2);
            temp_day2.setColorFilter(Color.parseColor("#8ED5F3"));
            ImageView temp_day3 =(ImageView)myAssets.this.findViewById(R.id.split1);
            temp_day3.setImageDrawable(getResources().getDrawable(R.drawable.splitline));
            ImageView temp_day4 =(ImageView)myAssets.this.findViewById(R.id.split2);
            temp_day4.setImageDrawable(getResources().getDrawable(R.drawable.splitline));
            ImageView temp_day7 =(ImageView)myAssets.this.findViewById(R.id.imageView);
            temp_day7.setImageDrawable(getResources().getDrawable(R.drawable.boysmile));
        }
        else {
            ImageView temp_day2 =(ImageView)myAssets.this.findViewById(R.id.imageView2);
            temp_day2.setColorFilter(Color.parseColor("#F9BBDB"));
            ImageView temp_day3 =(ImageView)myAssets.this.findViewById(R.id.split1);
            temp_day3.setImageDrawable(getResources().getDrawable(R.drawable.split_girl));
            ImageView temp_day4 =(ImageView)myAssets.this.findViewById(R.id.split2);
            temp_day4.setImageDrawable(getResources().getDrawable(R.drawable.split_girl));
            ImageView temp_day7 =(ImageView)myAssets.this.findViewById(R.id.imageView);
            temp_day7.setImageDrawable(getResources().getDrawable(R.drawable.girlsmile));
        }
        }



}
