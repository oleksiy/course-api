package io.javabrains.springbootstarter.topic;

import java.util.Objects;

public class Topic {

    private String id;
    private String name;
    private String description;

    /**
     * Default constructor.
     * This constructor is necessary due to error encountered when posting a new topic
     * {
     *     "timestamp": 1579324808061,
     *     "status": 400,
     *     "error": "Bad Request",
     *     "exception": "org.springframework.http.converter.HttpMessageNotReadableException",
     *     "message": "JSON parse error: Can not construct instance of io.javabrains.springbootstarter.topic.Topic:
     *     no suitable constructor found, can not deserialize from Object value (missing default constructor or creator,
     *     or perhaps need to add/enable type information?);
     *     nested exception is com.fasterxml.jackson.databind.JsonMappingException:
     *     Can not construct instance of io.javabrains.springbootstarter.topic.Topic: no suitable constructor found,
     *     can not deserialize from Object value (missing default constructor or creator, or perhaps need to add/enable
     *     type information?)\n at [Source: java.io.PushbackInputStream@1444d389; line: 2, column: 5]",
     *     "path": "/topics"
     * }
     */
    public Topic() {
        this.id = "nothing";
        this.name = "nothing";
        this.description = "nothing";

    }

    public Topic(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Topic topic = (Topic) o;
        return getId().equals(topic.getId()) &&
                Objects.equals(getName(), topic.getName()) &&
                Objects.equals(getDescription(), topic.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDescription());
    }
}
