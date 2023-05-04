package com.example.aularecycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Produto> listaProdutos = new ArrayList<>();
    RecyclerView recycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        Intent intent = getIntent();
        if(intent != null && intent.getExtras() != null){
            Produto produto = (Produto) intent.getSerializableExtra("produto");
            if(produto != null){
                listaProdutos.add(produto);
                // atualiza o RecyclerView com o novo produto
                Adaptador adapter = (Adaptador) recycler.getAdapter();
                adapter.notifyDataSetChanged();
            }
        }
        cadastroInicial();
        recycler = findViewById(R.id.rv);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        Adaptador adapter = new Adaptador(this, listaProdutos, new Adaptador.OnItemClickListener() {
            @Override
            public void onItemClick(Produto p) {
                //Aqui é o que vai acontecer quando clicar em um item
                Toast.makeText(MainActivity.this, p.getNome(), Toast.LENGTH_SHORT).show();
            }
        });
        recycler.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
    public void cadastroInicial(){
        Produto p1 = new Produto("Arroz","Alimento",(float)7.49);
        Produto p2 = new Produto("Batata","Alimento",(float)10.99);
        Produto p3 = new Produto("Geladeira","Eletrodoméstico",(float)5000);
        Produto p4 = new Produto("Lâmpada","Elétrica",(float)10.25);
        Produto p5 = new Produto("Dúzia de ovos","Alimento",(float)12);
        Produto p6 = new Produto("Macarrão","Alimento",(float)8.99);
        Produto p7 = new Produto("Java","Dev",(float)300);
        Produto p8 = new Produto("Mochila","Material",(float)150);
        Produto p9 = new Produto("Picanha","Alimento",(float)200);
        listaProdutos.add(p1);
        listaProdutos.add(p2);
        listaProdutos.add(p3);
        listaProdutos.add(p4);
        listaProdutos.add(p5);
        listaProdutos.add(p6);
        listaProdutos.add(p7);
        listaProdutos.add(p8);
        listaProdutos.add(p9);
    }

    public void mudaTela (View v){
        Intent i = new Intent(this, RegistraProduto.class);
        startActivity(i);
    }

}