package com.android.emerson;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MANTENIMIENTOS extends AppCompatActivity {
    Button productos,marcas,categorias,clientes,menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mantenimientos);
        productos=(Button) findViewById(R.id.btnproductos);
        marcas=(Button) findViewById(R.id.btnmarcas);
        categorias=(Button) findViewById(R.id.btncategorias);
        menu=(Button) findViewById(R.id.btnmenu);
        clientes=(Button) findViewById(R.id.btncliente);

        productos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent prod =new Intent(getApplicationContext(),Agregarproducto.class);
                startActivity(prod);

            }
        });

        marcas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent marca =new Intent(getApplicationContext(),Agregarmarca.class);
                startActivity(marca);

            }
        });


        categorias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cat =new Intent(getApplicationContext(),Agregarcategoria.class);
                startActivity(cat);

            }
        });

        clientes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cli =new Intent(getApplicationContext(),Agregarcliente.class);
                startActivity(cli);

            }
        });


        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu =new Intent(getApplicationContext(),menu_opciones.class);
                startActivity(menu);

            }
        });

    }
}
