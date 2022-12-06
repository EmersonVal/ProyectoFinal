package com.android.emerson;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Listacategoriaproductos extends AppCompatActivity {
ImageButton cable1,herramientas1,fierro1,pinturas1,mayolicas1,mayolicas2;
Button cable2,herramientas2,fierro2,pinturas2,menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listacategoriaproductos);

        cable1=findViewById(R.id.btnccables2);
        cable2=findViewById(R.id.btnccables3);
        herramientas1=findViewById(R.id.btnh1);
        herramientas2=findViewById(R.id.btnh2);
        fierro1=findViewById(R.id.btnf1);
        fierro2=findViewById(R.id.btnf2);
        pinturas1=findViewById(R.id.btnp1);
        pinturas2=findViewById(R.id.btnp2);

        menu=findViewById(R.id.btnmenu1);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu =new Intent(getApplicationContext(),menu_opciones.class);
                startActivity(menu);

            }
        });

        cable1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent c =new Intent(getApplicationContext(),Categoriacables.class);
                startActivity(c);

            }
        });
        cable2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent c1 =new Intent(getApplicationContext(),Categoriacables.class);
                startActivity(c1);

            }
        });

        herramientas1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent h1 =new Intent(getApplicationContext(),Categoriaherramientas.class);
                startActivity(h1);

            }
        });

        herramientas2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent h =new Intent(getApplicationContext(),Categoriaherramientas.class);
                startActivity(h);

            }
        });

        fierro1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent f =new Intent(getApplicationContext(),Categoriafierros.class);
                startActivity(f);

            }
        });


        fierro2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent f1 =new Intent(getApplicationContext(),Categoriafierros.class);
                startActivity(f1);

            }
        });

        pinturas1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent p =new Intent(getApplicationContext(),Categoriapinturas.class);
                startActivity(p);

            }
        });

        pinturas2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent p1 =new Intent(getApplicationContext(),Categoriapinturas.class);
                startActivity(p1);

            }
        });
    }

}
