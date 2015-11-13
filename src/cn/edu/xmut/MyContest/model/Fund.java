package cn.edu.xmut.MyContest.model;

public class Fund implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Double spend;
	private Double total;
	private String eventId;
	private String note;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Double getSpend() {
		return spend;
	}

	public void setSpend(Double spend) {
		this.spend = spend;
	}
	
	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}	
}
