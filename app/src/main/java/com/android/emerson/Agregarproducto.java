package com.android.emerson;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.emerson.util.ConexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Agregarproducto extends AppCompatActivity {
Spinner spm,spcat;
    EditText prod,costo,preciou,stock;
    Button guardarp;

    ConexionBD conexionBD = new ConexionBD();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregarproducto);


        prod=(EditText)findViewById(R.id.txtproducto);
        costo=(EditText)findViewById(R.id.txtcosto);
        preciou=(EditText)findViewById(R.id.txtprecio);
        stock=(EditText)findViewById(R.id.txtstock);
        spm=(Spinner) findViewById(R.id.spmarca);
        spcat=(Spinner) findViewById(R.id.spcategoria);
        guardarp=(Button) findViewById(R.id.btnagregarproducto);

        cargarspinnermarca();
        cargarspinnercategoria();


        guardarp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guardar_producto();
            }
        });


    }

    public void guardar_producto(){
        try{
            PreparedStatement stm= conexionBD.conexionBD().prepareStatement( "INSERT INTO tbl_producto Values(?,?,?,?,?,?)");
            stm.setString(1,prod.getText().toString());
            stm.setString(2,costo.getText().toString());
            stm.setString(3,preciou.getText().toString());
            stm.setString(4,stock.getText().toString());
            stm.setString(5,spm.getSelectedItem().toString());
            stm.setString(6,spcat.getSelectedItem().toString());
            stm.executeUpdate();
            Toast.makeText(getApplicationContext(), " Producto registrado exitosamente",Toast.LENGTH_SHORT).show();

            prod.setText("");
            costo.setText("");
            preciou.setText("");
            stock.setText("");
        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }


    public void cargarspinnermarca(){

        try {

            String query = "Select * from tbl_marca";
            PreparedStatement stmt = conexionBD.conexionBD().prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            ArrayList<String> data = new ArrayList<>();
            while (rs.next()) {

                String id = rs.getString("id_marca");
                String nombre = rs.getString("marca");

                data.add(nombre);
            }

            ArrayAdapter array = new ArrayAdapter(this, android.R.layout.simple_list_item_1,data);

            spm.setAdapter(array);


        } catch (SQLException e) {
            e.printStackTrace();
        }



    }


    public void cargarspinnercategoria(){

        try {

            String query = "Select * from tbl_categoria";
            PreparedStatement stmt = conexionBD.conexionBD().prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            ArrayList<String> data = new ArrayList<>();
            while (rs.next()) {

                String id = rs.getString("id_categoria");
                String nombre = rs.getString("categoria");
                String descripcion = rs.getString("descripcion");

                data.add(nombre);
            }

            ArrayAdapter array = new ArrayAdapter(this, android.R.layout.simple_list_item_1,data);

            spcat.setAdapter(array);


        } catch (SQLException e) {
            e.printStackTrace();
        }



    }


}
