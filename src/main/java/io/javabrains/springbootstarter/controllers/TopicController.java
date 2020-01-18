package io.javabrains.springbootstarter.controllers;

import io.javabrains.springbootstarter.topic.Topic;
import io.javabrains.springbootstarter.topic.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    @RequestMapping(method=RequestMethod.GET, value="/topics")
    public List<Topic> getAllTopics() {
        return topicService.getAllTopics();
    }

    @RequestMapping("topics/{topicKey}") //or just call it the same name and it will map the path variable automatically
    public Topic getTopic(@PathVariable("topicKey") String id) {
        return topicService.getTopic(id);
    }

    @RequestMapping(method = RequestMethod.POST, value="/topics")
    public void addTopic(@RequestBody Topic topic) {
        topicService.addTopic(topic);
    }

    @RequestMapping(method = RequestMethod.PUT, value="/topics/{id}")
    public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
        topicService.updateTopic(id, topic);
    }
}
