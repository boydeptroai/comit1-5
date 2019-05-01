package Model.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import Entity.KanjiTopic;

public class KanjiTopicMapper implements RowMapper<KanjiTopic>{

	@Override
	public KanjiTopic mapRow(ResultSet rs) {
		try {
			KanjiTopic kj=new KanjiTopic();
			kj.setTopic_id(rs.getInt("topic_id"));
			kj.setTopic_img(rs.getString("topic_img"));
			kj.setTopic_name(rs.getString("topic_name"));
			kj.setTopic_guide(rs.getString("topic_guide"));
			
			return kj;
		} catch (SQLException e) {
			return null;
		}
		// TODO Auto-generated method stub
		
	}

}
