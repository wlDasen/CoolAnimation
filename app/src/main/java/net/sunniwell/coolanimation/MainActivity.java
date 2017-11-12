package net.sunniwell.coolanimation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "jpd-M";
    private Button menu;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private static final int radius = 500;
    private boolean isMenuOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }
    private void initView() {
        menu = (Button)findViewById(R.id.menu);
        menu.setOnClickListener(this);
        button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(this);
        button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(this);
        button3 = (Button)findViewById(R.id.button3);
        button3.setOnClickListener(this);
        button4 = (Button)findViewById(R.id.button4);
        button4.setOnClickListener(this);
        button5 = (Button)findViewById(R.id.button5);
        button5.setOnClickListener(this);
    }
    private void doOpenAnimation(View view, int index) {
        if (view.getVisibility() == View.GONE)
            view.setVisibility(View.VISIBLE);
        float translationX = -(float)(radius * Math.sin(Math.toRadians(22 * index)));
        float translationY = -(float)(radius * Math.cos(Math.toRadians(22 * index)));
//        Log.d(TAG, "doAnimation: transX:" + translationX + ",Y:" + translationY);
        ObjectAnimator xAnim = ObjectAnimator.ofFloat(view, "TranslationX", 0.0f, translationX);
        ObjectAnimator yAnim = ObjectAnimator.ofFloat(view, "TranslationY", 0.0f, translationY);
        ObjectAnimator xScale = ObjectAnimator.ofFloat(view, "ScaleX", 0.0f, 1.0f);
        ObjectAnimator yScale = ObjectAnimator.ofFloat(view, "ScaleY", 0.0f, 1.0f);
        ObjectAnimator alpha = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
        AnimatorSet set = new AnimatorSet();
        set.playTogether(xAnim, yAnim, xScale, yScale, alpha);
        set.setDuration(500);
        set.start();
        Log.d(TAG, "doOpenAnimation: index:" + index);
    }
    private void doCloseAnimation(View view, int index) {
        float translationX = -(float)(radius * Math.sin(Math.toRadians(22 * index)));
        float translationY = -(float)(radius * Math.cos(Math.toRadians(22 * index)));
//        Log.d(TAG, "doAnimation: transX:" + translationX + ",Y:" + translationY);
        ObjectAnimator xAnim = ObjectAnimator.ofFloat(view, "TranslationX", translationX, 0.0f);
        ObjectAnimator yAnim = ObjectAnimator.ofFloat(view, "TranslationY", translationY, 0.0f);
        ObjectAnimator xScale = ObjectAnimator.ofFloat(view, "ScaleX", 1.0f, 0.1f);
        ObjectAnimator yScale = ObjectAnimator.ofFloat(view, "ScaleY", 1.0f, 0.1f);
        ObjectAnimator alpha = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
        AnimatorSet set = new AnimatorSet();
        set.playTogether(xAnim, yAnim, xScale, yScale, alpha);
        set.setDuration(500);
        set.start();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.menu:
                Log.d(TAG, "onClick: click menu button...");
                if (!isMenuOpen) {
                    isMenuOpen = true;
                    doOpenAnimation(button1, 0);
                    doOpenAnimation(button2, 1);
                    doOpenAnimation(button3, 2);
                    doOpenAnimation(button4, 3);
                    doOpenAnimation(button5, 4);
                } else {
                    isMenuOpen = false;
                    doCloseAnimation(button1, 0);
                    doCloseAnimation(button2, 1);
                    doCloseAnimation(button3, 2);
                    doCloseAnimation(button4, 3);
                    doCloseAnimation(button5, 4);
                }
                break;
            case R.id.button1:
                Log.d(TAG, "onClick: click button1...");
                break;
            case R.id.button2:
                Log.d(TAG, "onClick: click button2...");
                break;
            case R.id.button3:
                Log.d(TAG, "onClick: click button3...");
                break;
            case R.id.button4:
                Log.d(TAG, "onClick: click button4...");
                break;
            case R.id.button5:
                Log.d(TAG, "onClick: click button5...");
                break;
        }
    }
}
