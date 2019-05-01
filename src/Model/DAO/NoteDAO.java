package Model.DAO;

import Entity.MemberEntity;
import Entity.NoteEntity;

public interface NoteDAO extends BaseDAO<NoteEntity>{
	NoteEntity findOne(Integer id);
	//List<KanjiTopic> findByCategoryId(Long categoryId);
	Integer save(NoteEntity noteDetail);
	void update(NoteEntity notetail);
	void delete(Integer id);
	//List<KanjiTopic> findAll(Pageble pageble);
	//int getTotalItem();
}
