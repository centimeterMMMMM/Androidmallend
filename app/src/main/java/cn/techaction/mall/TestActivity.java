package cn.techaction.mall;

//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import cn.techaction.mall.config.Constant;
import okhttp3.Call;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        findViewById(R.id.btnOK).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView img = (ImageView)findViewById(R.id.img);
                final TextView txt = (TextView)findViewById(R.id.showTxt);
                Glide.with(TestActivity.this).load("https://p3.ssl.qhimgs1.com/sdr/400__/t01a44596706ed343dd.jpg")
                        .into(img);
                OkHttpUtils.get().url(Constant.API.CATEGORY_PARAM_URL)
                        .build().execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }
                    @Override
                    public void onResponse(String response, int id) {
                        txt.setText(response);
                    }
                });
            }
        });
    }
}
