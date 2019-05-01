package Model.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import Entity.FlCardTopicEntity;
import Entity.TestTopicEntity;

public class FlCardTopicMapper implements RowMapper<FlCardTopicEntity> {

	@Override
	public FlCardTopicEntity mapRow(ResultSet rs) {
		try {
			FlCardTopicEntity fc = new FlCardTopicEntity();
			fc.setFlctopic_id(rs.getInt("flctopic_id"));
			fc.setFlctopic_img(rs.getString("flctopic_img"));
			fc.setFlctopic_name(rs.getString("flctopic_name"));
			return fc;
		} catch (SQLException e) {
			return null;
		}
	}

}
