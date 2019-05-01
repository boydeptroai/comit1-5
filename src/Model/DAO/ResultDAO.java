package Model.DAO;

import Entity.MemberEntity;
import Entity.ResultEntity;

public interface ResultDAO extends BaseDAO<ResultEntity>{
	ResultEntity findOne(Integer id);
	//List<KanjiTopic> findByCategoryId(Long categoryId);
	Integer save(ResultEntity rsDetail);
	void update(ResultEntity rsDetail);
	void delete(Integer id);
	//List<KanjiTopic> findAll(Pageble pageble);
	//int getTotalItem();
}
