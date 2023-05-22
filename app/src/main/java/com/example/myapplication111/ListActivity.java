package com.example.myapplication111;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        List <User> userList = new ArrayList<>();
        for (int i = 0; i < 20; i++){
            User u1 = new User("Name"+ new Random().nextInt(10000), new Random().nextInt(10000),0,false);
            userList.add(u1);
        }

        ImageView image = findViewById(R.id.imageView2);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ListActivity.this);
                builder.setTitle("Profile");
                builder.setMessage("MADness");
                builder.setCancelable(true);
                builder.setPositiveButton("View", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        Intent activityname = new Intent(ListActivity.this, MainActivity.class);
                        activityname.putExtra("Key", new Random().nextInt(100000));
                        startActivity(activityname);

                    }
                });
                builder.setNegativeButton("Close", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){

                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }

}