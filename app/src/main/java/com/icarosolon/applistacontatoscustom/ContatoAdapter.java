package com.icarosolon.applistacontatoscustom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ContatoAdapter extends ArrayAdapter<Contato> {


    private static class ContatoHolder {

        TextView tvNome;
        TextView tvTelefone;

        public ContatoHolder(View view){
            tvNome = view.findViewById(R.id.nome);
            tvTelefone = view.findViewById(R.id.telefone);

        }

    }


    public ContatoAdapter(Context context, ArrayList<Contato> list) {
        super(context, 0, list);
    }


    @Override
    public View getView(int position, View itemView, ViewGroup parent) {

         if (itemView == null){
             itemView = LayoutInflater.from(getContext()).inflate(R.layout.item_contato,parent,false);
         }

         ContatoHolder contatoHolder;

         if (itemView.getTag() == null){
            contatoHolder = new ContatoHolder(itemView);
            itemView.setTag(contatoHolder);
         }else{
             contatoHolder = (ContatoHolder) itemView.getTag();
         }

         Contato contato = getItem(position);

        contatoHolder.tvNome.setText(contato.getNome());

        contatoHolder.tvTelefone.setText(contato.getTelefone());


        return itemView;
    }
}
