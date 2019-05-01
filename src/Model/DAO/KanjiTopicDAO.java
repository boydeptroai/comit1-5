package Model.DAO;

import java.util.List;

import Entity.KanjiTopic;

public interface KanjiTopicDAO extends BaseDAO<KanjiTopic>{
	KanjiTopic findOne(Integer id);
	//List<KanjiTopic> findByCategoryId(Long categoryId);
	Integer save(KanjiTopic KjDetail);
	void update(KanjiTopic KjDetail);
	void delete(Integer id);
	List<KanjiTopic> findAll( Integer offset,Integer limit);
	List<KanjiTopic> findAll1();
	int getTotalItem();

}
