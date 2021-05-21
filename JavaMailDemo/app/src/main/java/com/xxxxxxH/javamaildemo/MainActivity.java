package com.xxxxxxH.javamaildemo;

import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import javax.mail.MessagingException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            MailUtils.getInstance().setUpServerAndSelfInfo();
                        } catch (MessagingException e) {
//                            Toast.makeText(MainActivity.this, "e = " + e.toString(), Toast.LENGTH_SHORT).show();
                            Log.i("xxxxxxH", "e = " + e.toString());
                        }
                    }
                }).start();

            }
        });
    }
}