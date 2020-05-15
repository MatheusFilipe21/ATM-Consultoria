package com.matheus.f.n.pereira.atmconsultoria;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviarEmail();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_principal, R.id.nav_servicos, R.id.nav_clientes, R.id.nav_contato, R.id.nav_sobre
        )
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    public void enviarEmail(){

        //String celular = "tel:81984059514"; //Intent.ACTION_DIAL
        //String links = "https://marsemfim.com.br/wp-content/uploads/2019/12/p-al-1-3.jpg"; //Intent.ACTION_VIEW imagens, mapas ...

        //Ação para enviar
        Intent intent = new Intent(Intent.ACTION_SEND);

        //Dado passado e-mail, criado um vetor de strings podendo ser enviados para um ou mais e-mails
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"matheusfilipe1999@gmail.com", "matheusfilipe1999alternativo@gmail.com"});
        // Assunto do e-mail
        intent.putExtra(Intent.EXTRA_SUBJECT, "Teste de envio de e-mail!");
        // Corpo do e-mail
        intent.putExtra(Intent.EXTRA_TEXT, "Teste de envio de e-mail!!");
        //Tipo para envio de e-mail
        intent.setType("message/rfc822");

        //Para abrir determinados tipos de arquivos https://www.sitepoint.com/mime-types-complete-list/
        //intent.setType("application/pdf"); Exemplo

        startActivity(Intent.createChooser(intent, "O que aparece na hora de escolher o app!"));
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
