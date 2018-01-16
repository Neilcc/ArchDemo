package com.zcc.archdemo;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.zcc.archdemo.datarepo.PageRepo;
import com.zcc.archdemo.model.PagePOJO;

public class MainActivity extends AppCompatActivity {

    TextView hello;
    TextView change;
    PageRepo pageRepo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pageRepo = new PageRepo(this);
        hello = findViewById(R.id.text);
        change = findViewById(R.id.change);
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pageRepo.getData();
                pageRepo.upDateText("updated");
            }
        });

        pageRepo.getData().observe(this, new Observer<PagePOJO>() {
            @Override
            public void onChanged(@Nullable PagePOJO pagePOJO) {
                if (pagePOJO != null)
                    hello.setText(pagePOJO.getText());
            }
        });
    }

}
