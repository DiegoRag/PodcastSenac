/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senac.atividade3uc10.persistencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;
import javax.swing.JOptionPane;


/**
 *
 * @author lizz
 */
public class UsuarioDAO {


/** classe responsavel DAO responsavel pela autenticacao dos usuarios */

    public Usuario autenticar(String nome, String senha) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            Query query = em.createQuery("SELECT u FROM Usuario u WHERE u.nome = :nome AND u.senha = :senha");
            query.setParameter("nome", nome);
            query.setParameter("senha", senha);
            List<Usuario> resultados = query.getResultList();
            if (!resultados.isEmpty()) {
                Usuario usuarioAutenticado = resultados.get(0); // Retorna o primeiro usuário encontrado
                return usuarioAutenticado;
            } else {
                JOptionPane.showMessageDialog(null,"Sua senha ou usuario esta incorreto");
                return null; // Retorna null se nenhum usuário corresponder às credenciais
            }
        } finally {
            JPAUtil.closeEntityManager();
        }
    }
}
