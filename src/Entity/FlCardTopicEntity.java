package Entity;

public class FlCardTopicEntity extends BaseEntity<FlCardTopicEntity>{
	private Integer flctopic_id;
	private String flctopic_name;
	private String flctopic_img;

	public FlCardTopicEntity() {
		super();
	}

	public FlCardTopicEntity(Integer flctopic_id, String flctopic_name, String flctopic_img) {
		super();
		this.flctopic_id = flctopic_id;
		this.flctopic_name = flctopic_name;
		this.flctopic_img = flctopic_img;
	}

	public Integer getFlctopic_id() {
		return flctopic_id;
	}

	public void setFlctopic_id(Integer flctopic_id) {
		this.flctopic_id = flctopic_id;
	}

	public String getFlctopic_name() {
		return flctopic_name;
	}

	public void setFlctopic_name(String flctopic_name) {
		this.flctopic_name = flctopic_name;
	}

	public String getFlctopic_img() {
		return flctopic_img;
	}

	public void setFlctopic_img(String flctopic_img) {
		this.flctopic_img = flctopic_img;
	}

}
