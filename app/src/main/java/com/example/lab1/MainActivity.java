package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    // Метод, который вызывается, когда приложение создает и отображает Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //  вызов метода родительского класса
        setContentView(R.layout.activity_main); // устанавливаем содержимое Activity из layout-файла

        // Определяем необходимые элементы управления
        Button button = (Button) findViewById(R.id.button);
        TextView tw = (TextView) findViewById(R.id.textView);

        // Получение высоты и ширины экрана смартфона
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;

        // Подготовление анимации, реализованной с помощью xml-файла
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.mytrans);

        // Обработка нажатия на кнопку
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Изменение текста объекта управления textView
                tw.setText("Привет, Мир!");

                TranslateAnimation animation = new TranslateAnimation(0, width/2-button.getWidth()/2,0, 0);
                animation.setDuration(1000);
                // animation.setStartOffset(1000);
                //animation.setFillAfter(true);

                TranslateAnimation animation1 = new TranslateAnimation(width/2-button.getWidth()/2, -(width/2-button.getWidth()/2),0, 0);
                animation1.setDuration(1000);
                animation1.setStartOffset(1000);
                //animation1.setFillAfter(true);

                // Запуск анимации в коде. Проблема. Если запускается несколько анимаций,
                // то отработает только самая последняя
                // button.startAnimation(animation);
                // button.startAnimation(animation1);
                
                // Запуск анимации, реализованной с помощью xml-файла
                button.startAnimation(anim);

                // Первая идея - реализовать перемещение по пикселям, но есть проблема
                // перемещение слишком быстрое, чтобы его увидеть надо замедлить, но как?

                /*
                while (button.getX() < width - button.getWidth()) {
                    button.setX(button.getX() + 1);
                }

                while (button.getX() > width/2 - button.getWidth()/2) {
                    button.setX(button.getX() - 1);
                }
                */

            }
        });



    }
}