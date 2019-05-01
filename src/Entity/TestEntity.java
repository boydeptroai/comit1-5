package Entity;

public class TestEntity extends BaseEntity<TestEntity>{
	private Integer testps_id;
	private String question;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String optioncorrect;
	private String optionuselect;
	private Integer test_id;

	public TestEntity() {
		super();
	}

	public TestEntity(Integer testps_id, String question, String option1, String option2, String option3, String option4,
			String optioncorrect, String optionuselect, Integer test_id) {
		super();
		this.testps_id = testps_id;
		this.question = question;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.optioncorrect = optioncorrect;
		this.optionuselect = optionuselect;
		this.test_id = test_id;
	}

	public Integer getTestps_id() {
		return testps_id;
	}

	public void setTestps_id(Integer testps_id) {
		this.testps_id = testps_id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	public String getOptioncorrect() {
		return optioncorrect;
	}

	public void setOptioncorrect(String optioncorrect) {
		this.optioncorrect = optioncorrect;
	}

	public String getOptionuselect() {
		return optionuselect;
	}

	public void setOptionuselect(String optionuselect) {
		this.optionuselect = optionuselect;
	}

	public Integer getTest_id() {
		return test_id;
	}

	public void setTest_id(Integer test_id) {
		this.test_id = test_id;
	}
}
