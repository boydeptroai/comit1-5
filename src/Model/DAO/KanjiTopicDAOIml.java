package Model.DAO;

import java.sql.Connection;
import java.util.List;

import com.sun.media.jfxmedia.events.NewFrameEvent;

import Entity.KanjiTopic;
import Model.Mapper.KanjiTopicMapper;
import Model.DBConnection;

public class KanjiTopicDAOIml extends BaseDAOIml<KanjiTopic> implements KanjiTopicDAO{

//	public KanjiTopicDAOIml(DBConnection dbConn) {
//		super(dbConn);
//		// TODO Auto-generated constructor stub
//	}

	@Override
	public KanjiTopic findOne(Integer id) {
		String sql = "SELECT * FROM tbl_topic WHERE topic_id = ?";
		List<KanjiTopic> result = Query(sql, new KanjiTopicMapper(), id);
		return result.isEmpty() ? null : result.get(0);
	}
	

	@Override
	public Integer save(KanjiTopic kjDetail) {
		// TODO Auto-generated method stub
		String sql="insert into tbl_topic(topic_name,topic_guide,topic_img) values(?,?,?)";
		return Insert(sql, kjDetail.getTopic_name(),kjDetail.getTopic_guide(),kjDetail.getTopic_img());
	}

	@Override
	public void update(KanjiTopic kjDetail) {
		//System.out.println("koko");
		String sql="UPDATE tbl_topic SET topic_name=?,topic_img=?,topic_guide=? where topic_id=?";		
		 Update(sql, kjDetail.getTopic_name(),kjDetail.getTopic_img(),kjDetail.getTopic_guide(),kjDetail.getTopic_id());
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM tbl_topic WHERE topic_id = ?";
		Delete(sql, id);
	}
	@Override
	public List<KanjiTopic> findAll(Integer offset,Integer limit) {
		String sql = "SELECT * FROM tbl_topic ORDER BY topic_id DESC LIMIT ?, ? ";
		List<KanjiTopic> gg=Query(sql, new KanjiTopicMapper(),offset,limit);
		return gg;
	}
	@Override
	public int getTotalItem() {
		String sql="SELECT count(*) from tbl_topic";
		return Count(sql);
	}
	@Override
	public List<KanjiTopic> findAll1() {
		String sql = "SELECT * FROM tbl_topic";
		return Query(sql, new KanjiTopicMapper());
	}
	public static void main(String[] args) {
		DBConnection dbConn=new DBConnection();
		System.out.println(dbConn);
		//KanjiTopicDAOIml t=new KanjiTopicDAOIml(dbConn);
//		KanjiTopic kj=new KanjiTopic();
//		kj.setTopic_guide("lllll");
//		kj.setTopic_id(1);
//		kj.setTopic_img("vvvv");
//		kj.setTopic_name("sdhjaw");
	//	t.update(kj);
	//	List<KanjiTopic> gg=t.findAll(0,3);
		//int gg=t.getTotalItem();
		//System.out.println(gg);
		//System.out.println(t.findAll1());
		//int k=t.save(kj);
		//System.out.println(t.update(kj));
	}

	

	

	

	

	

}
