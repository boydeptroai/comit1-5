package Model.DAO;

import java.util.List;

import Entity.KanjiWordNewsEntity;
import Entity.NoteEntity;
import Model.Mapper.NoteMapper;
import Model.DBConnection;

public class NoteDAOIml extends BaseDAOIml<NoteEntity> implements NoteDAO{

	
	@Override
	public NoteEntity findOne(Integer id) {
		String sql = "SELECT * FROM tbl_note WHERE note_id = ?";
		List<NoteEntity> result = Query(sql,new NoteMapper(), id);
		return result.isEmpty() ? null : result.get(0);
	}

	@Override
	public Integer save(NoteEntity noteDetail) {
		String sql="insert into tbl_note(note_content,member_id,word_id) values(?,?,?)";
		return Insert(sql,noteDetail.getNote_content(),noteDetail.getMember_id(),noteDetail.getWord_id());
	}

	@Override
	public void update(NoteEntity noteDetail) {
		String sql="UPDATE tbl_note SET note_content=?,member_id=?,word_id=? where note_id=?";		
		 Update(sql,noteDetail.getNote_content(),noteDetail.getMember_id(),noteDetail.getWord_id(),noteDetail.getNote_id());
	}

	@Override
	public void delete(Integer id) {
		String sql = "DELETE FROM tbl_note WHERE note_id = ?";
		Delete(sql, id);
	}

}
