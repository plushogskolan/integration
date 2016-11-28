package se.coredev.model;

public final class Message {

	private final Long id;
	private final String content;

	public Message(Long id, String content) {
		this.id = id;
		this.content = content;
	}

	public Long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

}
