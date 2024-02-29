/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senac.atividade3uc10.persistencia;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * 
 * @author lizz
 */


/** Classe responsavel por criar os objetos das entidades de podcast */

@Entity
@Table(name = "podcast")
public class Podcast {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    

/** */

    @Column(name = "produtor")
    private String produtor;

    @Column(name = "nome_do_episodio")
    private String nome_do_episodio;

    @Column(name = "numero_do_episodio")
    private int numero_do_episodio;

    @Column(name = "duracao_do_episodio")
    private String duracao_do_episodio;

    @Column(name = "url_do_repositorio")
    private String url_do_repositorio;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProdutor() {
        return produtor;
    }

    public void setProdutor(String produtor) {
        this.produtor = produtor;
    }

    public String getNome_do_episodio() {
        return nome_do_episodio;
    }

    public void setNome_do_episodio(String nome_do_episodio) {
        this.nome_do_episodio = nome_do_episodio;
    }

    public int getNumero_do_episodio() {
        return numero_do_episodio;
    }

    public void setNumero_do_episodio(int numero_do_episodio) {
        this.numero_do_episodio = numero_do_episodio;
    }

    public String getDuracao_do_episodio() {
        return duracao_do_episodio;
    }

    public void setDuracao_do_episodio(String duracao_do_episodio) {
        this.duracao_do_episodio = duracao_do_episodio;
    }

    public String getUrl_do_repositorio() {
        return url_do_repositorio;
    }

    public void setUrl_do_repositorio(String url_do_repositorio) {
        this.url_do_repositorio = url_do_repositorio;
    }

}
