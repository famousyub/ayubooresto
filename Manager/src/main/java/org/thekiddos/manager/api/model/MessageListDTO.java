package org.thekiddos.manager.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class MessageListDTO {
    private boolean isManagerOnline;
    private List<MessageDTO> messages;

    public MessageListDTO( List<MessageDTO> messages ) {
        isManagerOnline = false;
        this.messages = messages;
    }

	public boolean isManagerOnline() {
		return isManagerOnline;
	}

	public void setManagerOnline(boolean isManagerOnline) {
		this.isManagerOnline = isManagerOnline;
	}

	public List<MessageDTO> getMessages() {
		return messages;
	}

	public void setMessages(List<MessageDTO> messages) {
		this.messages = messages;
	}

	public MessageListDTO(boolean isManagerOnline, List<MessageDTO> messages) {
		super();
		this.isManagerOnline = isManagerOnline;
		this.messages = messages;
	}
    
    
}
