package com.dam.tuto_authentication.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.dam.tuto_authentication.MainActivity;
import com.dam.tuto_authentication.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class StartActivity extends AppCompatActivity {

    /** #1 Définition des variables globales **/
    Button btn_login, btn_register;

    /** #2 Méthode initUI pour la gestion design // code **/
    public void initUI(){
        btn_login = findViewById(R.id.btn_login);
        btn_register = findViewById(R.id.btn_register);
    }

    /** #3 Méthodes pour la gestion des clics et l'ouverture des activités associées  **/
    /** #3.1  le login **/
    public void login(){
        btn_login.setOnClickListener(v ->  {
            Intent intent = new Intent(StartActivity.this, LoginActivity.class);
            startActivity(intent);
        });
    }
    /** #3.2  l'inscription **/
    public void register(){
        btn_register.setOnClickListener(v -> {
            Intent intent = new Intent(StartActivity.this, RegisterActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        // Appel de la méthode initUI()
        initUI();
        // Appel des méthodes de gestion des clic sur les boutons
        login();
        register();
    }

/** Vérifie au lancement dans le cache/memoire de l'appli si l'utilisateur n'est pas déjà connecté
 * si il l'est ça bypass l'étape login/register pour aller directement dans le main
 * **/
    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if(currentUser!=null){
            startActivity(new Intent(StartActivity.this, MainActivity.class));
        }

    }

}