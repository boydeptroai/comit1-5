package Model.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import Entity.KanjiTopic;
import Entity.TestTopicEntity;

public class TestTopicMapper implements RowMapper<TestTopicEntity>{

	@Override
	public TestTopicEntity mapRow(ResultSet rs) {
		try {
			TestTopicEntity tt=new TestTopicEntity();
			tt.setTest_id(rs.getInt("test_id"));
			tt.setTest_img(rs.getString("test_img"));
			tt.setTest_name(rs.getString("test_name"));
			return tt;
		} catch (SQLException e) {
			return null;
		}
	}

}
