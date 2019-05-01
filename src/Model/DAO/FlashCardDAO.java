package Model.DAO;

import java.util.List;

import Entity.FlashCardEntity;
import Entity.KanjiTopic;
import Entity.MemberEntity;

public interface FlashCardDAO extends BaseDAO<FlashCardEntity>{
	FlashCardEntity findOne(Integer id);
	List<FlashCardEntity> findByCategoryId(Integer categoryId,Integer offset,Integer limit);
	Integer save(FlashCardEntity flCardDetail);
	void update(FlashCardEntity flCardDetail);
	void delete(Integer id);
	List<FlashCardEntity> findAll( Integer offset,Integer limit);
	int getTotalItem();
}
