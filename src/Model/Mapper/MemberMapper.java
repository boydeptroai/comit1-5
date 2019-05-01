package Model.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import Entity.KanjiTopic;
import Entity.MemberEntity;

public class MemberMapper implements RowMapper<MemberEntity>{

	@Override
	public MemberEntity mapRow(ResultSet rs) {
		try {
			MemberEntity mm=new MemberEntity();
			mm.setCategory_id(rs.getInt("category_id"));
			mm.setMember_id(rs.getInt("member_id"));
			mm.setMember_email(rs.getString("member_email"));
			mm.setMember_firstname(rs.getString("member_firstname"));
			mm.setMember_img(rs.getString("member_img"));
			mm.setMember_lastname(rs.getString("member_lastname"));
			mm.setMember_pass(rs.getString("member_pass"));
			mm.setMember_status(rs.getBoolean("member_status"));
			return mm;
		} catch (SQLException e) {
			return null;
		}
		// TODO Auto-generated method stub
		
	}

}
