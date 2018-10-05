package com.example.android.tallercarro;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorCarro  extends
        RecyclerView.Adapter<AdaptadorCarro.CarrosViewHolder> {
    private ArrayList<Carro> carros;
    private Context contexto;


    public AdaptadorCarro(ArrayList<Carro> carros, Context contexto) {
        this.carros = carros;
        this.contexto = contexto;
    }

    @Override
    public CarrosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itemcarro,parent,false);
        return new CarrosViewHolder(v);
    }



    @Override
    public void onBindViewHolder(CarrosViewHolder holder, int position) {
        Carro c = carros.get(position);
        holder.foto.setImageResource(c.getFoto());
        holder.placa.setText(""+c.getPlaca());
        holder.precio.setText(""+c.getPrecio());
        holder.color.setText(contexto.getResources().getStringArray(R.array.color)[c.getColor()]);
        holder.marca.setText(contexto.getResources().getStringArray(R.array.marca)[c.getMarca()]);

    }

    @Override
    public int getItemCount() {
        return carros.size();
    }

    public static class CarrosViewHolder extends RecyclerView.ViewHolder{
        private ImageView foto;
        private TextView placa;
        private EditText precio;
        private TextView color;
        private TextView marca;
        private TextView apellido;
        private View v;

        public CarrosViewHolder(View itemView){
            super(itemView);
            v = itemView;
            foto = v.findViewById(R.id.fotos);
            placa = v.findViewById(R.id.txtPlaca);
            precio = v.findViewById(R.id.txtPrecio);
            color= v.findViewById(R.id.cmbColor);
            marca= v.findViewById(R.id.cmbMarca);

        }
    }


}
