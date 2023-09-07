package com.isheikh03.moMagicDemo.inbox;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InboxService {
	
	@Autowired
	public InboxRepository inboxRepository;

	public List<InboxEntity> findListByLimit(int limit) {
		return inboxRepository.findListByLimit(limit);
	}
	public InboxEntity updateStatus(InboxEntity inboxEntity, String status) {
		inboxEntity.setStatus(status);
		return inboxRepository.updateStatus(inboxEntity);
	}

}
