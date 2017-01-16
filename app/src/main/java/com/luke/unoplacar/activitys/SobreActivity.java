package com.luke.unoplacar.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.luke.unoplacar.R;

public class SobreActivity extends AppCompatActivity {

    private ImageView img;
    int statusLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);

        statusLogo = 1;
    }

    @Override
    protected void onResume() {
        super.onResume();

        img = (ImageView) findViewById(R.id.imgMeLogo);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(statusLogo == 1){
                    img.setImageDrawable(getDrawable(R.drawable.melogo2));
                    statusLogo = 2;
                }else if(statusLogo == 2){
                    img.setImageDrawable(getDrawable(R.drawable.melogo3));
                    statusLogo = 3;
                }else{
                    img.setImageDrawable(getDrawable(R.drawable.melogo1));
                    statusLogo = 1;
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
        return;
    }
}
