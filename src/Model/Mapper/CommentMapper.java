package Model.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import Entity.CommentEntity;
import Entity.TestTopicEntity;

public class CommentMapper implements RowMapper<CommentEntity>{

	@Override
	public CommentEntity mapRow(ResultSet rs) {
		try {
			CommentEntity m =new CommentEntity();
			m.setCmt_id(rs.getInt("cmt_id"));
			m.setMember_id(rs.getInt("member_id"));
			m.setWord_id(rs.getInt("word_id"));
			m.setCmt_content(rs.getString("cmt_content"));
			m.setCmt_time(rs.getString("cmt_time"));
			return m;
		} catch (SQLException e) {
			return null;
		}
	}

}
