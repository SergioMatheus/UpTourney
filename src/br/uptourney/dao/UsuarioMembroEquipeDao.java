package br.uptourney.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import br.uptourney.model.Usuario;
import br.uptourney.util.UpUtil;

public class UsuarioMembroEquipeDao {

	Connection conexao = UpUtil.getConnection();
	
	HttpServletRequest request;
	
	public List<Usuario> listarMembrosEquipes(Usuario usuario){
		
		List<Usuario> listaMembrosEquipe = new ArrayList<>();
		
		try {
			PreparedStatement pstm = conexao.prepareStatement("select nome from usuarios us "+
					"inner join usuarios_equipes ue on (us.id_usuario = ue.id_usuario) "+
					"inner join equipes eq on (ue.id_equipe = eq.id_equipe) "+
					"where eq.id_equipe = ? "+
					"group by nome" );
			
			PreparedStatement pstm2 = conexao.prepareStatement("select id_equipe from equipes eq "+
		             "inner join usuarios_equipes ue on (eq.id_equipe=ue.id_equipe) "+
		             "inner join usuarios u on(ue.id_usuario=u.id_usuario) "+
		             "where id_usuario=? "+
		             "group by id_equipe");
		              
		       pstm2.setLong(1, usuario.getId());
			
			ResultSet rs = pstm2.executeQuery();

			Long idsUser = null;
			while (rs.next()) {
				idsUser = rs.getLong("id_usuario");
			}
			System.out.println("ids: " + idsUser);
			pstm.setLong(1, idsUser);

			ResultSet rs2 = pstm.executeQuery();
			
			while (rs2.next()) {
				System.out.println(rs2.getString("nome"));
				Usuario usuario1 = new Usuario();
				usuario.setNome(rs2.getString("nome"));
				listaMembrosEquipe.add(usuario1);
			}
			
			pstm.close();
			pstm2.close();
			rs.close();
			rs2.close();
		} catch (SQLException e) {
			System.out.println("Pau no listar usuarioDB");
			e.printStackTrace();
		}
		System.out.println("Tentar imprim Lista");
		for (Usuario usuario1 : listaMembrosEquipe) {
			System.out.println("Nome: " + usuario1.getNome());
		}
		
		return listaMembrosEquipe;
		

	}
}
