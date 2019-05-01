package Entity;

public class MemberEntity extends BaseEntity<MemberEntity>{
	private Integer member_id;
	private String member_firstname;
	private String member_lastname;
	private String member_email;
	private String member_pass;
	private String member_img;
	private Integer category_id;
	private boolean member_status;

	public MemberEntity() {
		super();
	}

	public MemberEntity(Integer member_id, String member_firstname, String member_lastname, String member_email,
			String member_pass, String member_img, Integer category_id, boolean member_status) {
		super();
		this.member_id = member_id;
		this.member_firstname = member_firstname;
		this.member_lastname = member_lastname;
		this.member_email = member_email;
		this.member_pass = member_pass;
		this.member_img = member_img;
		this.category_id = category_id;
		this.member_status = member_status;
	}

	public Integer getMember_id() {
		return member_id;
	}

	public void setMember_id(Integer member_id) {
		this.member_id = member_id;
	}

	public String getMember_firstname() {
		return member_firstname;
	}

	public void setMember_firstname(String member_firstname) {
		this.member_firstname = member_firstname;
	}

	public String getMember_lastname() {
		return member_lastname;
	}

	public void setMember_lastname(String member_lastname) {
		this.member_lastname = member_lastname;
	}

	public String getMember_email() {
		return member_email;
	}

	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}

	public String getMember_pass() {
		return member_pass;
	}

	public void setMember_pass(String member_pass) {
		this.member_pass = member_pass;
	}

	public String getMember_img() {
		return member_img;
	}

	public void setMember_img(String member_img) {
		this.member_img = member_img;
	}

	public Integer getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}

	public boolean getMember_status() {
		return member_status;
	}

	public void setMember_status(boolean member_status) {
		this.member_status = member_status;
	}
}
