package io.javabrains.springbootstarter.topic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TopicService {

    Logger logger = LoggerFactory.getLogger(TopicService.class);
    private List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("spring", "Spring Framework", "Spring Framework Description"),
            new Topic("java", "Core Java", "Core Java Description"),
            new Topic("javascript", "JavaScript", "JS Description")
    ));

    public List<Topic> getAllTopics() {
        return topics;
    }

    public Topic getTopic(String id) {
        Topic topic;
        try {
            topic = topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        } catch (NoSuchElementException e) {
            logger.warn(e.getMessage());
            logger.warn("Could not find {} topic from ", id);
            topic = new Topic("nothing", "nothing", StringUtils.capitalize(id) + " Topic Does Not Exist.");
        }
        return topic;
    }

    public void addTopic(Topic topic) {
        //TODO: Implement a constraint to not add duplicate topics
        topics.add(topic);
    }
}
