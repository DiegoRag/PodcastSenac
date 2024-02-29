/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senac.atividade3uc10.persistencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;

/**
 *
 * @author lizz
 */
public class PodcastDAO {


/** Classe DAO onde se localizam os metodos usados para manipular a entidade de podcast e o banco de dados */

    public void cadastrar(Podcast p) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    public List<Podcast> listar() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            Query consulta = em.createQuery("SELECT p FROM Podcast p");
            List<Podcast> podcasts = consulta.getResultList();
            return podcasts;
        } finally {
            JPAUtil.closeEntityManager();
        }
    }
    
    public List<Podcast> listarFiltro() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            Query consulta = em.createQuery("SELECT p FROM Podcast p");
            List<Podcast> podcasts = consulta.getResultList();
            return podcasts;
        } finally {
            JPAUtil.closeEntityManager();
        }
    }
    
    public List<Podcast> pesquisarPorProdutor(String produtor) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            Query consulta = em.createQuery("SELECT p FROM Podcast p WHERE p.produtor = :produtor");
            consulta.setParameter("produtor", produtor);
            List<Podcast> podcasts = consulta.getResultList();
            return podcasts;
        } finally {
            JPAUtil.closeEntityManager();
        }
    }
    
   public void excluirPodcastPorId(int id) {
    EntityManager em = JPAUtil.getEntityManager();
    try {
        em.getTransaction().begin();
        
        // Consulta para encontrar o podcast com o ID especificado
        Podcast podcast = em.find(Podcast.class, id);
        
        // Se o podcast for encontrado, exclui-o
        if (podcast != null) {
            em.remove(podcast);
            em.getTransaction().commit();
        } else {
            // Se o podcast não for encontrado, realiza o rollback da transação
            em.getTransaction().rollback();
        }
    } finally {
        JPAUtil.closeEntityManager();
    }
}


}
