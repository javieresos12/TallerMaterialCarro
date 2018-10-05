package com.example.android.tallercarro;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Random;

public class AgregarCarrros extends AppCompatActivity {

    private EditText txtPlaca, txtPrecio;
    private Spinner cmbcolor, cmbmarca;

    private ArrayAdapter<String> adapter1;
    private ArrayAdapter<String> adapter2;
    private String color[], marca[];
    private ArrayList<Integer> fotos;
    private ImageView foto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_carrros);

        txtPlaca= findViewById(R.id.txtPlaca);
        txtPrecio=findViewById(R.id.txtPrecio);
        cmbcolor=findViewById(R.id.cmbColor);
        cmbmarca=findViewById(R.id.cmbMarca);
        foto = findViewById(R.id.fotos);

        fotos = new ArrayList<>();
        fotos.add(R.drawable.img1);
        fotos.add(R.drawable.img2);
        fotos.add(R.drawable.img3);
        fotos.add(R.drawable.img4);
        fotos.add(R.drawable.img5);

        color = getResources().getStringArray(R.array.color);
        adapter1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,color);
        cmbcolor.setAdapter(adapter1);

        marca = getResources().getStringArray(R.array.marca);
        adapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,marca);
        cmbmarca.setAdapter(adapter2);

    }

    public int fotoAleatoria(){
        int fotoSeleccionada;
        Random r = new Random();
        fotoSeleccionada = r.nextInt(this.fotos.size());
        return fotos.get(fotoSeleccionada);
    }

    public void guardar(View v){
        String placa;
        int fotoaux, color, marca;
        double precio;
        fotoaux = this.fotoAleatoria();
        placa = txtPlaca.getText().toString();
        precio = Double.parseDouble(txtPrecio.getText().toString());
        marca = cmbmarca.getSelectedItemPosition();
        color = cmbcolor.getSelectedItemPosition();
        Carro c = new Carro(fotoaux, placa, color, marca, precio);
        c.guardar();
        limpiar();
        Snackbar.make(v,getResources().getString(R.string.Mensaje),Snackbar.LENGTH_SHORT)
                .show();

    }

    public void onBackPressed(){
        finish();
        Intent i = new Intent(AgregarCarrros.this,Principal.class);
        startActivity(i);
    }

    public void limpiar(){
        txtPlaca.setText("");
        txtPrecio.setText("");
        cmbcolor.setSelection(0);
        cmbmarca.setSelection(0);
        txtPlaca.requestFocus();
        InputMethodManager inputMethodManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
    }


    public void limpiar(View v){
        limpiar();
    }
}
