package com.example.tarea5;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ANIMACION POR FRAMES
        ImageView imageView = findViewById(R.id.imageView3);
        AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getBackground();
        animationDrawable.start();

        //ANIMACION VECTORIAL
        ImageView imageView1 = findViewById(R.id.imageView4);
        AnimatedVectorDrawable animatedVectorDrawable = (AnimatedVectorDrawable) getDrawable(R.drawable.ducktales_1_animatedvector);
        imageView1.setImageDrawable(animatedVectorDrawable);
        animatedVectorDrawable.start();

        //ANIMACION DE VISTAS
        Animation animacion = AnimationUtils.loadAnimation(this, R.anim.animacionview);
        animacion.setRepeatCount(Animation.INFINITE);
        imageView1.startAnimation(animacion);



        //ANIMACION CON VALUEANIMATOR
        ValueAnimator valueTextSizeAnimator = ValueAnimator.ofInt(20, 60);
        valueTextSizeAnimator.setDuration(5000);
        valueTextSizeAnimator.setRepeatCount(Animation.INFINITE);

        //Conn esto animamos el textView2 "COMPRALO YA!!" para que aumente
        valueTextSizeAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                TextView helloText = findViewById(R.id.textView2);
                helloText.setTextSize((Integer)animator.getAnimatedValue());
            }
        });

        // Con esto animamos el textView "Pato oh oh..." y hacemos que cambie de color combiandole la propiedad BackgroundColor.
        TextView helloText2 = findViewById(R.id.textView);
        ObjectAnimator objectAnimatorColor = ObjectAnimator.ofInt(helloText2, "BackgroundColor", R.color.purple_200, R.color.black);
        objectAnimatorColor.setDuration(10000);
        objectAnimatorColor.setRepeatCount(Animation.INFINITE);

        //Con esto hacemos que ambas animaciones empiecen al mismo tiempo gracias al método playTogether
        AnimatorSet myanimatorSet = new AnimatorSet();
        myanimatorSet.playTogether(valueTextSizeAnimator,objectAnimatorColor);
        myanimatorSet.start();
    }
}