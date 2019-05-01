package Entity;

public class KanjiTopic extends BaseEntity<KanjiTopic>{
	private Integer topic_id;
	private String topic_name;
	private String topic_img;
	private String topic_guide;

	public KanjiTopic() {
		super();
	}

	public KanjiTopic(Integer topic_id, String topic_name, String topic_img, String topic_guide) {
		super();
		this.topic_id = topic_id;
		this.topic_name = topic_name;
		this.topic_img = topic_img;
		this.topic_guide = topic_guide;
	}

	public Integer getTopic_id() {
		return topic_id;
	}

	public void setTopic_id(Integer topic_id) {
		this.topic_id = topic_id;
	}

	public String getTopic_name() {
		return topic_name;
	}

	public void setTopic_name(String topic_name) {
		this.topic_name = topic_name;
	}

	public String getTopic_img() {
		return topic_img;
	}

	public void setTopic_img(String topic_img) {
		this.topic_img = topic_img;
	}

	public String getTopic_guide() {
		return topic_guide;
	}

	public void setTopic_guide(String topic_guide) {
		this.topic_guide = topic_guide;
	}

}
