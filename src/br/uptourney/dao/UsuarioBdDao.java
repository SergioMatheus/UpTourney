package br.uptourney.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import br.uptourney.model.Equipe;
import br.uptourney.model.Usuario;
import br.uptourney.util.UpUtil;

public class UsuarioBdDao {

	Connection conexao = UpUtil.getConnection();
	
	HttpServletRequest request;
	
	public List<Equipe> listarEquipesDoUsuario(Usuario usuario){
		
		List<Equipe> listaEquipeDoUsuario = new ArrayList<>();
		
		try {
			PreparedStatement pstm = conexao.prepareStatement("select nome_equipe from equipes eq " +
			"inner join usuarios_equipes ue on (eq.id_equipe = ue.id_equipe)  " +
			"inner join usuarios us on (ue.id_usuario = us.id_usuario)  " +
			"where id_usuario = ?");
			
			PreparedStatement pstm2 = conexao.prepareStatement("select id_usuario from usuarios where login = ? and senha = ?");
			
			pstm2.setString(1, usuario.getLogin());
			pstm2.setString(2, usuario.getSenha());
			
			ResultSet rs = pstm2.executeQuery();

			Long idsUser = null;
			while (rs.next()) {
				idsUser = rs.getLong("id_usuario");
			}
			System.out.println("ids: " + idsUser);
			pstm.setLong(1, idsUser);

			ResultSet rs2 = pstm.executeQuery();
			
			while (rs2.next()) {
				System.out.println(rs2.getString("nome_equipe"));
				Equipe equipe = new Equipe();
				equipe.setNomeEquipe(rs2.getString("nome_equipe"));
				listaEquipeDoUsuario.add(equipe);
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
		for (Equipe equipe : listaEquipeDoUsuario) {
			System.out.println("Nome: " + equipe.getNomeEquipe());
		}
		
		return listaEquipeDoUsuario;
		

	}
}
