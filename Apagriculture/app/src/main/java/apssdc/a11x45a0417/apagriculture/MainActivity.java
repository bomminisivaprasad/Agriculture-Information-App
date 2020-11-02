package apssdc.a11x45a0417.apagriculture;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv;
    private Animation animSlideUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv);
        animSlideUp = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.text_anim);
        tv.startAnimation(animSlideUp);
        new Handler().postDelayed(new Runnable() {
            // Using handler with postDelayed called runnable run method
            @Override
            public void run() {

                Intent i = new Intent(MainActivity.this, LogINRegisterActivity.class);
                startActivity(i);
                // close this activity
                finish();
            }
        }, 5*1000); // wait for 5 seconds
    }
}
