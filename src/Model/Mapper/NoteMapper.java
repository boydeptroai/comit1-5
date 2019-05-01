package Model.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import Entity.NoteEntity;
import Entity.TestTopicEntity;

public class NoteMapper implements RowMapper<NoteEntity>{

	@Override
	public NoteEntity mapRow(ResultSet rs) {
		try {
			NoteEntity n=new NoteEntity();
			n.setMember_id(rs.getInt("member_id"));
			n.setNote_id(rs.getInt("note_id"));
			n.setWord_id(rs.getInt("word_id"));
			n.setNote_content(rs.getString("note_content"));
			return n;
		} catch (SQLException e) {
			return null;
		}
	}

}
