package org.thekiddos.manager.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.thekiddos.manager.bot.Commands;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Table( name = "telegram_users" )
public class TelegramUser {
    @Id @NonNull
    private Integer id;

    private String lastCommand = Commands.NOTHING;
    private String email;
    private Integer verificationCode;
    private boolean isVerified = false;
	public TelegramUser(@NonNull Integer id, String lastCommand, String email, Integer verificationCode,
			boolean isVerified) {
		super();
		this.id = id;
		this.lastCommand = lastCommand;
		this.email = email;
		this.verificationCode = verificationCode;
		this.isVerified = isVerified;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLastCommand() {
		return lastCommand;
	}
	public void setLastCommand(String lastCommand) {
		this.lastCommand = lastCommand;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getVerificationCode() {
		return verificationCode;
	}
	public void setVerificationCode(Integer verificationCode) {
		this.verificationCode = verificationCode;
	}
	public boolean isVerified() {
		return isVerified;
	}
	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}
	
	public TelegramUser() {
		super();
	}
	public TelegramUser(String lastCommand, String email, Integer verificationCode, boolean isVerified) {
		super();
		this.lastCommand = lastCommand;
		this.email = email;
		this.verificationCode = verificationCode;
		this.isVerified = isVerified;
	}
	public TelegramUser(@NonNull Integer id) {
		super();
		this.id = id;
	}

    
    
}
