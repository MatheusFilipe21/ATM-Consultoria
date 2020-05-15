package com.matheus.f.n.pereira.atmconsultoria.ui.sobre;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.matheus.f.n.pereira.atmconsultoria.R;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

/**
 * A simple {@link Fragment} subclass.
 */
public class SobreFragment extends Fragment {

    public SobreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String descricao = "Descrição de tudo sobre a empresa...";

        Element versao = new Element();
        versao.setTitle("Versão 1.0");

        View view = new AboutPage(getActivity())
                .setImage(R.drawable.logo)
                .setDescription(descricao)

                .addGroup("Entre em contato!")
                .addEmail("matheusfilipe1999@gmail.com", "Envie um e-mail!")
                .addWebsite("www.google.com.br", "Acesse nosso site!")

                .addGroup("Redes Sociais")
                .addInstagram("mf4real", "Instagram")
                .addGitHub("MatheusFilipe21", "GitHub")
                .addPlayStore("com.mojang.minecraftpe", "Baixe o ATM Consultoria na Play Store")

                .addItem(versao)

                .create();

        return view;
        //return inflater.inflate(R.layout.fragment_sobre, container, false);
    }
}
