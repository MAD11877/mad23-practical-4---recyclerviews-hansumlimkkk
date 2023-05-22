package com.example.myapplication111;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent receivingEnd = getIntent();
        int message = receivingEnd.getIntExtra("Key", 0);
        TextView text = findViewById(R.id.editTextText2);
        text.setText("MAD"+message);

        User user1 = new User("Bruh","nigger",0,false);
        Button followButton = findViewById(R.id.followButton);
        followButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String buttonTextString = followButton.getText().toString();
                if (user1.Followed == false) {
                    followButton.setText("Unfollow");
                    user1.Followed = true;
                    Toast toast = Toast.makeText(getApplicationContext(),"Unfollow", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else{
                    followButton.setText("Follow");
                    user1.Followed = false;
                    Toast toast = Toast.makeText(getApplicationContext(),"Follow", Toast.LENGTH_SHORT);
                    toast.show();
                }

            }
        });
        Button sendbutton = findViewById(R.id.button2);
        sendbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activityname = new Intent(MainActivity.this, MessageGroup.class);
                startActivity(activityname);
            }
        });

    }
}