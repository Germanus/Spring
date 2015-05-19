package my.ilya.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import my.ilya.model.Message;
import my.ilya.service.MessageBoardServiceInterface;

public class MessageBoardService implements MessageBoardServiceInterface {

	private Map<Long, Message> messages = new LinkedHashMap<Long, Message>();
	
	@Override
	public List<Message> listMessages() {
		Message m = new Message();
		m.setAuthor("Ilya");
		m.setBody("Body");
		m.setId(0l);
		m.setTitle("title");
		messages.put(0L, m);
		return new ArrayList<Message>(messages.values());
	}

	@Override
	public synchronized void postMessage(Message message) {
		message.setId(System.currentTimeMillis());
		messages.put(message.getId(), message);
	}

	@Override
	public synchronized void deleteMessage(Message message) {
		messages.remove(message.getId());
	}

	@Override
	public Message findMessageById(Long messageId) {
		return messages.get(messageId);
	}

}
