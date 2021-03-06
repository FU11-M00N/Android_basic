package org.techtown.a2b_20201026_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView ivPic[] = new ImageView[9];
    int ivI[]= {R.id.imageView1, R.id.imageView2, R.id.imageView3,R.id.imageView4,R.id.imageView5
            ,R.id.imageView6,R.id.imageView7,R.id.imageView8,R.id.imageView9};
    Button btnResult;

    String picName[] = {
            "독서하는 소녀",
            "꽃장식 모자 소녀",
            "부채를 든 소녀",
            "이레느깡 단 베르양",
            "잠자는 소녀",
            "테라스의 두 자매",
            "피아노 레슨",
            "피아노 앞의 소녀들",
            "해변에서"
    };

    int voteCount[] = new int[9];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnResult = findViewById(R.id.btnResult);
        for(int i=0; i<ivPic.length;i++){
            ivPic[i]= findViewById(ivI[i]);
        }

        for(int i=0; i<ivPic.length;i++){
            final int index = i;
            ivPic[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    voteCount[index]++;
                    Toast.makeText(getApplicationContext(), picName[index]+" : "+voteCount[index],Toast.LENGTH_SHORT).show();
                }
            });
        }

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ResultActivity.class);
                intent.putExtra("voteCount", voteCount);
                intent.putExtra("imageName",picName);
                startActivity(intent);
            }
        });
    }
}