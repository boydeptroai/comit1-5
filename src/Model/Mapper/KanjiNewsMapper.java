package Model.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import Entity.KanjiWordNewsEntity;
import Entity.TestTopicEntity;

public class KanjiNewsMapper implements RowMapper<KanjiWordNewsEntity>{

	@Override
	public KanjiWordNewsEntity mapRow(ResultSet rs) {
		try {
			KanjiWordNewsEntity kw=new KanjiWordNewsEntity();
			kw.setTopic_id(rs.getInt("topic_id"));
			kw.setWord_animation(rs.getString("word_animation"));
			kw.setWord_id(rs.getInt("word_id"));
			kw.setWord_img(rs.getString("word_img"));
			kw.setWord_info(rs.getString("word_info"));
			kw.setWord_name(rs.getString("word_name"));
			return kw;
		} catch (SQLException e) {
			return null;
		}
	}

}
