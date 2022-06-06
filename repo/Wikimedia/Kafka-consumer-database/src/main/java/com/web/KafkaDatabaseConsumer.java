package com.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.web.entity.WikimediaData;
import com.web.repository.WikimediaDataRepository;

@Service
public class KafkaDatabaseConsumer {

	private static final Logger LOGGER=LoggerFactory.getLogger(KafkaDatabaseConsumer.class);

	@Autowired
	private WikimediaDataRepository dataRepository;

	@Autowired
	private WikimediaData wikimediaData;
	



	@KafkaListener(topics = "wikimedia_recentchange",groupId = "myGroup")
	public void consume(String eventMessage) {
		LOGGER.info(String.format("Event Message recieved -> %s",eventMessage));
//	WikimediaData wikimediaData=new WikimediaData();
	wikimediaData.setWikiEventData(eventMessage);
	dataRepository.save(wikimediaData);
	}
}
