package com.springboot.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {

	private List<Topic> topics = new ArrayList<Topic>(Arrays.asList(new Topic("java", "fullstack", "Spring framework "),
			new Topic("python", "python-full-stack", "djongo framework"), new Topic("devops", "devops", "dev+ops")));

	public List<Topic> getAllTopics() {
		return topics;
	}

	public Topic getOne(String id) {
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();

	}

	public void addTopic(Topic topic) {
		topics.add(topic);
	}

	public void updateTopic(Topic topic, String id) {
		for (int i = 0; i < topics.size(); i++) {
			Topic t = topics.get(i);
			System.out.println("each topic is " + t);
			// if both the id matches in the topics class and user request
			if (t.getId().equals(id)) {
				// update the topic class in that specific position
				topics.set(i, topic);

				System.out.println(i + "value");
				return;
			}

		}
	}

	public void deleteTopic(String id) {
		topics.removeIf(t -> t.getId().equals(id));
	}

}
