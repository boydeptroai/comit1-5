package Model.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import Entity.FlashCardEntity;
import Entity.TestTopicEntity;

public class FlashCardMapper implements RowMapper<FlashCardEntity>{

	@Override
	public FlashCardEntity mapRow(ResultSet rs) {
		try {
			FlashCardEntity fc=new FlashCardEntity();
			fc.setFlcard_id(rs.getInt("flcard_id"));
			fc.setFlcard_img(rs.getString("flcard_img"));
			fc.setFlcard_name(rs.getString("flcard_name"));
			fc.setFlcard_question1(rs.getString("flcard_question1"));
			fc.setFlcard_question2(rs.getString("flcard_question2"));
			fc.setFlctopic_id(rs.getInt("flctopic_id"));
			return fc;
		} catch (SQLException e) {
			return null;
		}
	}

}
