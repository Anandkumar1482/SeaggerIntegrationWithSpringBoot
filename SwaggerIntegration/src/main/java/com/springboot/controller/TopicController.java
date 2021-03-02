package com.springboot.controller;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("API")
public class TopicController {

	@Autowired
	private TopicService topicService;

	@RequestMapping(method = RequestMethod.GET, value = "/getAllTopics") 
	public List<Topic> getTopics() {
		return topicService.getAllTopics();

	}

	@RequestMapping(method = RequestMethod.GET, value = "/getAllTopics/{id}")
	public Topic getSingleTopic(@PathVariable String id) {

		return topicService.getOne(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/getAllTopics")
	public void create(@RequestBody Topic topic) {
		topicService.addTopic(topic);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/getAllTopics/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
		topicService.updateTopic(topic, id);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/getAllTopics/{id}")
	public void delete(@PathVariable String id) {
		topicService.deleteTopic(id);
	}

}
