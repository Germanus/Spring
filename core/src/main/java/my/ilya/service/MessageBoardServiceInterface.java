package my.ilya.service;

import java.util.List;

import my.ilya.model.Message;

public interface MessageBoardServiceInterface {

	public List<Message> listMessages();
	public void postMessage(Message message);
	public void deleteMessage(Message message);
	public Message findMessageById(Long messageId);
	
}
