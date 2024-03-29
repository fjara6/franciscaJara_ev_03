package com.example.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class Home_act extends AppCompatActivity {

    private ViewFlipper vf;
    private int [] images = {R.drawable.a , R.drawable.b , R.drawable.c};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_act);

        vf = (ViewFlipper)findViewById(R.id.slider);

        for(int i=0; i<images.length; i++)
        {
            Instrucciones(images[i]);
        }

    }

    public void Instrucciones (int i){
        ImageView view = new ImageView( this);//obtener imagenes
        view.setBackgroundResource(i);

        vf.addView(view);//añade las imagenes
        vf.setFlipInterval(2800);//velocidad en que cambian las imagenes
        vf.setAutoStart(true);// para que inicie de forma automatica

        //sentido de movimiento del slider

        vf.setInAnimation(this,android.R.anim.slide_in_left);
        vf.setOutAnimation(this, android.R.anim.slide_out_right);

    }

    public void Informacion(View v) {
        Intent i = new Intent(this, Info_act.class);
        startActivity(i);
    }

    String[] dataLibros = {"Farenheith", "Revival", "Tesla", "El Alquimista"};

    public void Libros(View view)
    {
        Intent i = new Intent(this, Libros_act.class);
        i.putExtra("libros", dataLibros); // almaceno los valores o extras
        startActivity(i);

    }

    public void Base (View view)
    {
        Intent i = new Intent(this, Base_act.class);
        startActivity(i);
    }

    public void Seguridad (View view)
    {
        Intent i = new Intent(this, Sec_act.class);
        startActivity(i);
    }
}
