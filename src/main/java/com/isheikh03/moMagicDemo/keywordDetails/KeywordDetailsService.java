package com.isheikh03.moMagicDemo.keywordDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KeywordDetailsService {
	
	@Autowired
	private KeywordDetailsRepository keywordDetailsRepository;
	
	public KeywordDetailsEntity findByKeyword(String keyword) {
		return keywordDetailsRepository.findByKeyword(keyword);
	}

}
