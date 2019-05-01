package Model.DAO;

import Entity.CommentEntity;
import Entity.MemberEntity;

public interface CmtDAO extends BaseDAO<CommentEntity>{
	CommentEntity findOne(Integer id);
	//List<KanjiTopic> findByCategoryId(Long categoryId);
	Integer save(CommentEntity cmtDetail);
	void update(CommentEntity cmtDetail);
	void delete(Integer id);
	//List<KanjiTopic> findAll(Pageble pageble);
	//int getTotalItem();

}
