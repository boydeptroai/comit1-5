package Model.DAO;

import java.util.List;

import Entity.FlCardTopicEntity;
import Entity.KanjiWordNewsEntity;
import Entity.MemberEntity;

public interface KanjiNewsDAO extends BaseDAO<KanjiWordNewsEntity>{
	KanjiWordNewsEntity findOne(Integer id);
	List<KanjiWordNewsEntity> findByCategoryId(Integer categoryId,Integer offset,Integer limit);
	Integer save(KanjiWordNewsEntity wordDetail);
	void update(KanjiWordNewsEntity wordDetail);
	void delete(Integer id);
	List<KanjiWordNewsEntity> findAll( Integer offset,Integer limit);
	int getTotalItem();

}
