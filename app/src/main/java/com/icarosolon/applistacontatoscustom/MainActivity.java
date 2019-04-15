package com.icarosolon.applistacontatoscustom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contato> contatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        contatos = new ArrayList<Contato>();

        contatos.add(new Contato("Icaro Solon", "74988475426","icaro@gmail.com","Rua A numero 1723"));
        contatos.add(new Contato("Jose Antonio", "74988475426","jose@gmail.com","Rua A numero 12783"));
        contatos.add(new Contato("Daniel Redclif", "74988423475426","daniel@gmail.com","Rua A numero 12332"));
        contatos.add(new Contato("Valtency Remígio", "74982348475426","val@gmail.com","Rua A numero 1233"));
        contatos.add(new Contato("Daniel Araujo", "74982348475426","daniel@gmail.com","Rua A numero 16233"));
        contatos.add(new Contato("Juliana Brandao", "74988423475426","ju@gmail.com","Rua A numero 1723"));
        contatos.add(new Contato("Erica Lisboa", "7498847232345426","erica@gmail.com","Rua A numero 1283"));
        contatos.add(new Contato("Marta Souza", "74988423475426","marta@gmail.com","Rua A numero 1623"));


        ContatoAdapter adapterContatos = new ContatoAdapter(this,contatos);

        ListView listaContatos = findViewById(R.id.list_view);

        listaContatos.setAdapter(adapterContatos);


        listaContatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Contato contato = contatos.get(position);
                Toast.makeText(MainActivity.this, "Olá " +contato.getNome() + ", seu email é " + contato.getEmail(), Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.menu_config:
                Toast.makeText(this, "Configurações", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_ligacoes:
                Toast.makeText(this, "Ligações", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
