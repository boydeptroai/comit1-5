package Model.DAO;

import java.util.List;

import Entity.MemberEntity;
import Entity.TestEntity;

public interface TestDAO extends BaseDAO<TestEntity>{
	TestEntity findOne(Integer id);
	//List<KanjiTopic> findByCategoryId(Long categoryId);
	Integer save(TestEntity testDetail);
	void update(TestEntity testDetail);
	void delete(Integer id);
	List<TestEntity> findAll( Integer offset,Integer limit);
	int getTotalItem();
}
