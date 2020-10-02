package com.cikarastudio.cikararesep.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.cikarastudio.cikararesep.R;

public class MainActivity extends AppCompatActivity {

    TextView btn_mainMulai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_mainMulai = findViewById(R.id.btn_mainMulai);

        btn_mainMulai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent btnMulai = new Intent(MainActivity.this, KategoriResepActivity.class);
                startActivity(btnMulai);
            }
        });

    }
}