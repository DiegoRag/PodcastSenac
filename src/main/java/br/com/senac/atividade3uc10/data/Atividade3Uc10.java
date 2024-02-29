/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package br.com.senac.atividade3uc10.data;

import br.com.senac.atividade3uc10.persistencia.Podcast;
import br.com.senac.atividade3uc10.persistencia.PodcastDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 *
 * @author lizz
 */
public class Atividade3Uc10 {

    public static void main(String[] args) {

       PodcastDAO podDAO = new PodcastDAO();
       
        Podcast p = new Podcast();
        
        p.setProdutor("Diergo");
        p.setNome_do_episodio("Joao do grau");
        p.setNumero_do_episodio(2);
        p.setDuracao_do_episodio("1:30h");
        p.setUrl_do_repositorio("url/poggers");
        
        podDAO.cadastrar(p);
        
    }
}
