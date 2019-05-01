package Model.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import Entity.KanjiTopic;
import Entity.TestEntity;

public class TestMapper implements RowMapper<TestEntity>{

	@Override
	public TestEntity mapRow(ResultSet rs) {
		try {
			TestEntity t=new TestEntity();
			t.setTest_id(rs.getInt("test_id"));
			t.setTestps_id(rs.getInt("testps_id"));
			t.setOption1(rs.getString("option1"));
			t.setOption2(rs.getString("option2"));
			t.setOption3(rs.getString("option3"));
			t.setOption4(rs.getString("option4"));
			t.setOptioncorrect(rs.getString("optioncorrect"));
			t.setOptionuselect(rs.getString("optionuselect"));
			t.setQuestion(rs.getString("question"));
			return t;
		} catch (SQLException e) {
			return null;
		}
		// TODO Auto-generated method stub
		
	}
	}


