package com.cdp.agenda.adaptadores;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cdp.agenda.R;
import com.cdp.agenda.entidades.CLiente;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListaClienteAdapter extends RecyclerView.Adapter<ListaClienteAdapter.clienteViewHolder> {

    ArrayList<CLiente> listaclientes;
    ArrayList<CLiente> listaOriginal;

    public ListaClienteAdapter(ArrayList<CLiente> listaclientes) {
        this.listaclientes = listaclientes;
        listaOriginal = new ArrayList<>();
        listaOriginal.addAll(listaclientes);
    }

    @NonNull
    @Override
    public clienteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_cliente, null, false);
        return new clienteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull clienteViewHolder holder, int position) {
        holder.viewNombre.setText(listaclientes.get(position).getCedula()+" "+listaclientes.get(position).getNombre()+" "+listaclientes.get(position).getApellido());
        holder.viewTelefono.setText(listaclientes.get(position).getTelefono());
        holder.viewCorreo.setText(listaclientes.get(position).getCorreo_electornico());
    }

    @Override
    public int getItemCount() {
        return listaclientes.size();
    }

    public class clienteViewHolder extends RecyclerView.ViewHolder {

        TextView viewNombre, viewTelefono, viewCorreo;

        public clienteViewHolder(@NonNull View itemView) {
            super(itemView);

            viewNombre = itemView.findViewById(R.id.viewNombre);
            viewTelefono = itemView.findViewById(R.id.viewTelefono);
            viewCorreo = itemView.findViewById(R.id.viewCorreo);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                }
            });
        }

    }
}
