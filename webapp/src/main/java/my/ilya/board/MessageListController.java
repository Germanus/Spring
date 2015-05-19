package my.ilya.board;

import java.util.Collections;
import java.util.List;

import my.ilya.model.Message;
import my.ilya.service.impl.MessageBoardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/messageList*")
public class MessageListController {

	private MessageBoardService messageBoardService;
	
	@Autowired
	public MessageListController(MessageBoardService messageBoardService){
		this.messageBoardService = messageBoardService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String generateList(Model model){
		List<Message> messages = Collections.emptyList();
		messages = messageBoardService.listMessages();
		model.addAttribute("messages", messages);
		return "messageList";
	}
	
}
