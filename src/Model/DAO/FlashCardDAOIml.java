package Model.DAO;

import java.util.Comparator;
import java.util.List;
import java.util.Random;

import Entity.FlashCardEntity;
import Entity.KanjiTopic;
import Model.Mapper.FlashCardMapper;
import Model.Mapper.KanjiNewsMapper;
import Model.DBConnection;

public class FlashCardDAOIml extends BaseDAOIml<FlashCardEntity> implements FlashCardDAO{

	

	@Override
	public FlashCardEntity findOne(Integer id) {
		String sql = "SELECT * FROM tbl_flashcard WHERE flcard_id = ?";
		List<FlashCardEntity> result = Query(sql, new FlashCardMapper(), id);
		return result.isEmpty() ? null : result.get(0);
	
	}

	@Override
	public Integer save(FlashCardEntity flCardDetail) {
		String sql="insert into tbl_flashcard(flcard_name,flcard_img,flctopic_id,flcard_question1,flcard_question2) values(?,?,?)";
		return Insert(sql,flCardDetail.getFlcard_name(),flCardDetail.getFlcard_img(),flCardDetail.getFlcard_question1(),flCardDetail.getFlcard_question2());
	}

	@Override
	public void update(FlashCardEntity flCardDetail) {
		// TODO Auto-generated method stub
		String sql="UPDATE tbl_flashcard SET flcard_name=?,flcard_img=?,flctopic_id=?,flcard_question1=?,flcard_question2=? where flcard_id=?";		
		 Update(sql, flCardDetail.getFlcard_name(),flCardDetail.getFlcard_img(),flCardDetail.getFlcard_question1(),flCardDetail.getFlcard_question2(),flCardDetail.getFlcard_id());
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM tbl_flashcard WHERE flcard_id = ?";
		Delete(sql, id);
		
	}
	

	@Override
	public List<FlashCardEntity> findAll(Integer offset, Integer limit) {
		String sql = "SELECT * FROM tbl_flashcard ORDER BY flcard_id DESC LIMIT ?, ? ";
		return Query(sql, new FlashCardMapper(), offset,limit);
	}

	@Override
	public int getTotalItem() {
		String sql="SELECT count(*) from tbl_flashcard";
		return Count(sql);
	}

	@Override
	public List<FlashCardEntity> findByCategoryId(Integer categoryId,Integer offset,Integer limit) {
		String sql = "SELECT * FROM tbl_flashcard WHERE flctopic_id=? LIMIT ?, ? ";
		return  Query(sql, new FlashCardMapper(), categoryId,offset,limit);
		
	}
	public static void main(String[] args) {
		FlashCardDAOIml f=new FlashCardDAOIml();
	List<FlashCardEntity> n=f.findByCategoryId(1, 0, 7);
//		System.out.println(n);
		
		//List<Foo> list = createItSomehow();
		int random = new Random().nextInt();
		for(int i=0;i<10;i++)
		{
		FlashCardEntity foo = n.stream().sorted(Comparator.comparingInt(o -> System.identityHashCode(o) ^ random)).findFirst().get();
		System.out.println(foo.getFlcard_id());
		}
	}

}
