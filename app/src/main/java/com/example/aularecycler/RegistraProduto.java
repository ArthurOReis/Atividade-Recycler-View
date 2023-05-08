package com.example.aularecycler;

import static com.example.aularecycler.MainActivity.listaProdutos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class RegistraProduto extends AppCompatActivity {
    EditText nome, categoria, preco;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registra_produto);
        getSupportActionBar().hide();
        nome = findViewById(R.id.nomeP);
        preco = findViewById(R.id.precoP);
        categoria = findViewById(R.id.categoriaP);
    }

    public void criaProduto(View v){
        String nomeProduto = String.valueOf(nome.getText());
        String categoriaProduto = String.valueOf(categoria.getText());
        float precoProduto = Float.parseFloat(String.valueOf(preco.getText()));
        Produto pn = new Produto(nomeProduto, categoriaProduto, precoProduto);
        listaProdutos.add(pn);
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }


}