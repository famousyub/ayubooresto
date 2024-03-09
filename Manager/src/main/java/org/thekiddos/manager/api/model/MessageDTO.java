package org.thekiddos.manager.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageDTO {
    private String contents;
    private String sender;
    private String receiver;
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private LocalDateTime createdAt;
    private boolean seen;
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public boolean isSeen() {
		return seen;
	}
	public void setSeen(boolean seen) {
		this.seen = seen;
	}
	public MessageDTO(String contents, String sender, String receiver, LocalDateTime createdAt, boolean seen) {
		super();
		this.contents = contents;
		this.sender = sender;
		this.receiver = receiver;
		this.createdAt = createdAt;
		this.seen = seen;
	}
	public MessageDTO() {
		super();
	}
    
	
	
    
    
}
