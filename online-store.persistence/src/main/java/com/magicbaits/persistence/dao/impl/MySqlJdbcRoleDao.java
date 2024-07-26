package com.magicbaits.persistence.dao.impl;

import java.sql.SQLException;

import com.magicbaits.persistence.dao.RoleDao;
import com.magicbaits.persistence.dto.RoleDto;
import com.magicbaits.persistence.utils.DBUtils;

public class MySqlJdbcRoleDao implements RoleDao{

	@Override
	public RoleDto getRoleById(int id) {
		try(var conn = DBUtils.getConnection();
				var ps = conn.prepareStatement("SELECT * FROM role WHERE id = ?")){
			
			ps.setInt(1, id);
			
			try(var rs = ps.executeQuery()){
				if(rs.next()) {
					RoleDto role = new RoleDto();
					role.setId(rs.getInt("id"));
					role.setRoleName(rs.getString("role_name"));
					return role;
				}
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public RoleDto getRoleByName(String roleName) {
		try(var conn = DBUtils.getConnection();
				var ps = conn.prepareStatement("SELECT * FROM role WHERE role_name = ?")){
			
			ps.setString(1, roleName);
			
			try(var rs = ps.executeQuery()){
				if(rs.next()) {
					RoleDto role = new RoleDto();
					role.setRoleName(rs.getString("role_name"));
					role.setId(rs.getInt("id"));
					return role;
				}
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
