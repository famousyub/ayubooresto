package org.thekiddos.manager.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
public class Message {
    @Id @GeneratedValue( strategy = GenerationType.AUTO )
    private Long id;

    @NonNull
    private String contents;

    // I may need to use these as a foreign keys and use classes for them in the future when things gets more complex but it will do for now
    @NonNull
    private String sender;
    @NonNull
    private String receiver;

    @NonNull @Column(name = "created_at")
    private LocalDateTime createdAt;
    @NonNull
    private boolean seen;

    public void setSeen() {
        seen = true;
    }

    @Override
    public boolean equals( Object o ) {
        if ( this == o ) return true;
        if ( o == null || getClass() != o.getClass() ) return false;
        Message message = (Message) o;
        return id.equals( message.id );
    }

    @Override
    public int hashCode() {
        return Objects.hash( id );
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Message(Long id, @NonNull String contents, @NonNull String sender, @NonNull String receiver,
			@NonNull LocalDateTime createdAt, @NonNull boolean seen) {
		super();
		this.id = id;
		this.contents = contents;
		this.sender = sender;
		this.receiver = receiver;
		this.createdAt = createdAt;
		this.seen = seen;
	}

	public Message() {
		super();
	}

	public Message(@NonNull String contents, @NonNull String sender, @NonNull String receiver,
			@NonNull LocalDateTime createdAt, @NonNull boolean seen) {
		super();
		this.contents = contents;
		this.sender = sender;
		this.receiver = receiver;
		this.createdAt = createdAt;
		this.seen = seen;
	}
    
	
    
}
