package com.example.aularecycler;

import static com.example.aularecycler.MainActivity.listaProdutos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RegistraProduto extends AppCompatActivity {
    EditText nome, categoria, preco;
    String existeOuNao;

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

        verificaSeExiste(pn);
    }

    public void verificaSeExiste(Produto produto){
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
        reference.child("Produtos").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.hasChild(produto.getNome())){
                    Toast.makeText(RegistraProduto.this, "Esse produto já existe", Toast.LENGTH_SHORT).show();
                }
                else {
                    listaProdutos.add(produto);
                    produto.salvar();
                    RegistraProduto.super.onBackPressed();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


}