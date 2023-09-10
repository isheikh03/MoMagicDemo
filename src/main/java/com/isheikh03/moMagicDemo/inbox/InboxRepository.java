package com.isheikh03.moMagicDemo.inbox;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.isheikh03.common.BaseRepository;

@Repository
@Transactional
public class InboxRepository extends BaseRepository {
	
	public List<InboxEntity> findListByLimit(int limit) {
		return super.baseFindListByLimit(limit, "SELECT i FROM InboxEntity i where i.status='N'", InboxEntity.class);
	}
	
	public InboxEntity updateStatus(InboxEntity inboxEntity) {
		return super.baseUpdate(inboxEntity);
	}

}
