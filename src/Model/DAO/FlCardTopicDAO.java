package Model.DAO;

import java.util.List;

import Entity.FlCardTopicEntity;
import Entity.FlashCardEntity;
import Entity.MemberEntity;

public interface FlCardTopicDAO extends BaseDAO<FlCardTopicEntity>{
	FlCardTopicEntity findOne(Integer id);
	//List<KanjiTopic> findByCategoryId(Long categoryId);
	Integer save(FlCardTopicEntity FlTopicDetail);
	void update(FlCardTopicEntity FlTopicDetail);
	void delete(Integer id);
	List<FlCardTopicEntity> findAll( Integer offset,Integer limit);
	int getTotalItem();
}
