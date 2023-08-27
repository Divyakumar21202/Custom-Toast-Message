package com.example.mycustomtoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast toast=new Toast(getApplicationContext());

        Button button=findViewById(R.id.btn_toast);
        Toast.makeText(MainActivity.this,"This is my Default Toast",Toast.LENGTH_SHORT).show();


        //inflator is used to convert layout to view

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View vie= getLayoutInflater().inflate(R.layout.custom_toast_layout,(ViewGroup) findViewById(R.id.toast_layout_container));


                textView=vie.findViewById(R.id.txt_message);
                textView.setText("This is Custom Toast");
                toast.setView(vie);
                toast.setDuration(Toast.LENGTH_SHORT);
                // We set Gravity at Top right
                toast.setGravity(Gravity.TOP|Gravity.END,0,0);
                toast.show();
            }
        });

    }
}