package com.example.lrving.myapplication.view;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.lrving.myapplication.R;
import com.example.lrving.myapplication.model.User;

import org.json.JSONException;
import org.json.JSONObject;


public class ProfileActivity extends AppCompatActivity {
    //初始化按钮控件
    private Button btn_editPortrait, btn_editName, btn_editSex, btn_editAge, btn_editHobbies,
            btn_editAutograph, btn_editGoal, btn_editHeight, btn_editWeight, btn_profileOk;
    private TextView tv_userName, tv_sex, tv_age, tv_hobby, tv_autograph, tv_goal, tv_weight, tv_height, tv_goalWeight, tv_goalTime;
    private LinearLayout ll_weightInfo;
    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mQueue = Volley.newRequestQueue(this);
        //获取按钮控件
        btn_editPortrait = (Button) findViewById(R.id.btn_editPortrait);
        btn_editName = (Button) findViewById(R.id.btn_editName);
        btn_editSex = (Button) findViewById(R.id.btn_editSex);
        btn_editAge = (Button) findViewById(R.id.btn_editAge);
        btn_editHobbies = (Button) findViewById(R.id.btn_editHobbies);
        btn_editAutograph = (Button) findViewById(R.id.btn_editAutograph);
        btn_editGoal = (Button) findViewById(R.id.btn_editGoal);
        btn_editHeight = (Button) findViewById(R.id.btn_editHeight);
        btn_editWeight = (Button) findViewById(R.id.btn_editWeight);
        btn_profileOk = (Button) findViewById(R.id.btn_profileOk);
        //显示
        //getInfo();
        //按下头像修改跳转到头像界面
        btn_editPortrait.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, PortraitActivity.class);
                startActivity(intent);
            }
        });

        //按下昵称修改跳转到昵称界面
        btn_editName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, NameActivity.class);
                startActivity(intent);
            }
        });

        //按下年龄修改跳转到年龄界面
        btn_editAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, AgeActivity.class);
                startActivity(intent);
            }
        });

        //按下兴趣修改跳转到兴趣界面
        btn_editHobbies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, HobbiesActivity.class);
                startActivity(intent);
            }
        });

        //按下个性签名修改跳转到个性签名界面
        btn_editAutograph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, AutographActivity.class);
                startActivity(intent);
            }
        });

        //按下运动目的修改跳转到运动目的界面
        btn_editGoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, GoalActivity.class);
                startActivity(intent);
            }
        });

        //按下性别修改跳转到行呗界面
        btn_editSex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, SexActivity.class);
                startActivity(intent);
            }
        });

        //按下身高修改跳转到身高界面
        btn_editHeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, HeightActivity.class);
                startActivity(intent);
            }
        });

        //按下体重修改跳转到体重界面
        btn_editWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, HeightActivity.class);
                startActivity(intent);
            }
        });

        //按下确认按钮返回
        btn_profileOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateInfo();
            }
        });


    }

    protected void onResume() {
        super.onResume();
        showInfo();
    }

    private void showInfo() {
        //获取显示信息控件
        //头像
        ImageView iv_portrait = (ImageView) findViewById(R.id.iv_portrait);
        // iv_portrait.setImageBitmap(User.stringToBitmap(User.portrait));
//        Bitmap b = convertViewToBitmap(iv_portrait);
//        User.portrait=User.bitmapToString(b);
        //iv_portrait.setImageBitmap(User.stringToBitmap(User.portrait));
        //昵称
        tv_userName = (TextView) findViewById(R.id.tv_userName);
        tv_userName.setText(User.name);
        tv_sex = (TextView) findViewById(R.id.tv_sex);
        //性别
        if (User.sex == "女")
            tv_sex.setText("女");
        else
            tv_sex.setText("男");
        //年龄
        tv_age = (TextView) findViewById(R.id.tv_age);
        tv_age.setText(User.age);
        //兴趣
        tv_hobby = (TextView) findViewById(R.id.tv_hobby);
        tv_hobby.setText(User.hobby);
        //个性签名
        tv_autograph = (TextView) findViewById(R.id.tv_autograph);
        tv_autograph.setText(User.autograph);
        //目的
        tv_goal = (TextView) findViewById(R.id.tv_goal);
        tv_goal.setText(User.goal);
        //体重身高
        tv_height = (TextView) findViewById(R.id.tv_height);
        tv_height.setText(User.height);
        tv_weight = (TextView) findViewById(R.id.tv_weight);
        tv_weight.setText(User.weight);

        tv_goalWeight = (TextView) findViewById(R.id.tv_goalWeight);
        tv_goalTime = (TextView) findViewById(R.id.tv_goalTime);
        ll_weightInfo = (LinearLayout) findViewById(R.id.ll_weightInfo);
        if (User.goal == "减肥") {
            ll_weightInfo.setVisibility(View.VISIBLE);
            tv_goalWeight.setText(User.goal_weight);
            tv_goalTime.setText(User.goal_time);
        } else {
            ll_weightInfo.setVisibility(View.GONE);
            tv_goalWeight.setText("60");
            tv_goalTime.setText("60");
        }
    }

    private void updateInfo() {
        StringRequest stringRequest1 = new StringRequest("http://localhost:8080/SportsRecipe/user_update?" +
                "username=" + User.userId + "&nickname=" + User.name + "&interest=" + User.hobby + "&signature=" + User.autograph + "&purpose="
                + User.goal + "&height=" + User.height + "&weight=" + User.weight + "&age=" + User.age + "&sex=" + User.sex + "&pweight=" + User.goal_weight + "&pdays=" + User.goal_time,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        Log.d("TAG", "===================网络请求返回：" + s);
                        String[] str = s.split("\"");
                        int code = Integer.parseInt(str[1]);
                        switch (code) {
                            case 1:
                                doSuccess();
                                break;
                            default:
                                doError();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e("TAG", volleyError.getMessage(), volleyError);
                doError();
            }
        });
        mQueue.add(stringRequest1);

        StringRequest stringRequest2 = new StringRequest("http://localhost:8080/SportsRecipe/img_update?" +
                "username=" + User.userId + "&imgbase64=" + User.portrait,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        Log.d("TAG", "===================网络请求返回：" + s);
                        String[] str = s.split("\"");
                        int code = Integer.parseInt(str[1]);
                        switch (code) {
                            case 1:
                                doSuccess();
                                break;
                            default:
                                doError();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e("TAG", volleyError.getMessage(), volleyError);
                doError();
            }
        });
        mQueue.add(stringRequest2);
    }

    private void getInfo() {
        StringRequest stringRequest1 = new StringRequest("http://localhost:8080/SportsRecipe/user_update?username=" + User.userId,
                new Response.Listener<String>() {
                    JSONObject jsonObject = null;

                    public void onResponse(String s) {
                        try {
                            jsonObject = new JSONObject(s);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        try {
                            User.name = jsonObject.getString("nickname");
                            User.hobby = jsonObject.getString("interest");
                            User.autograph = jsonObject.getString("signature");
                            User.goal = jsonObject.getString("purpose");
                            User.height = jsonObject.getString("height");
                            User.weight = jsonObject.getString("weight");
                            User.age = jsonObject.getString("age");
                            User.sex = jsonObject.getString("sex");
                            User.goal_weight = jsonObject.getString("pWeight");
                            User.goal_time = jsonObject.getString("pDays");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e("Tag", volleyError.getMessage(), volleyError);
            }
        });
        mQueue.add(stringRequest1);
        StringRequest stringRequest2 = new StringRequest("http://localhost:8080/SportsRecipe/img_get?username=" + User.userId,
                new Response.Listener<String>() {
                    JSONObject jsonObject = null;

                    public void onResponse(String s) {
                        try {
                            jsonObject = new JSONObject(s);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        try {
                            User.portrait = jsonObject.getString("imgbase64");

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e("Tag", volleyError.getMessage(), volleyError);
            }
        });
        mQueue.add(stringRequest2);

    }

    private void doSuccess() {
        Log.i("TAG", "success");
    }

    private void doError() {
        Log.e("TAG", "error");
    }

    private static Bitmap convertViewToBitmap(View view) {
        view.measure(MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED), MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        view.buildDrawingCache();
        Bitmap bitmap = view.getDrawingCache();
        return bitmap;
    }
}
