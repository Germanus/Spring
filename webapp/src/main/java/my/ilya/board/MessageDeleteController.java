package my.ilya.board;

import my.ilya.model.Message;
import my.ilya.service.impl.MessageBoardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/pages/board/messageDelete*")
public class MessageDeleteController {

	private MessageBoardService messageBoardService;
	
	@Autowired
	public MessageDeleteController(MessageBoardService messageBoardService){
		this.messageBoardService = messageBoardService;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String messageDelete(@RequestParam(required = true, value="messageId") Long messageId, Model model){
		Message message = messageBoardService.findMessageById(messageId);
		messageBoardService.deleteMessage(message);
		model.addAttribute("messages", messageBoardService.listMessages());
		return "redirect:messageList";
	}	

	
}
