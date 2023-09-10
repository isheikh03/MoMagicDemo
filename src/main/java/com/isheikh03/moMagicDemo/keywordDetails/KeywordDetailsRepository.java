package com.isheikh03.moMagicDemo.keywordDetails;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.isheikh03.common.BaseRepository;

@Repository
@Transactional
public class KeywordDetailsRepository extends BaseRepository {
	
	public KeywordDetailsEntity findByKeyword(String keyword) {
		return super.baseFindOne("SELECT k FROM KeywordDetailsEntity k where k.keyword='"+keyword+"'", KeywordDetailsEntity.class);
	}

}
