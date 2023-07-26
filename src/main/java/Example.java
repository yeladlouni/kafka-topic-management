import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.ListTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;

import java.util.*;

public class Example {
    public Example() {
        Properties props = new Properties();
        props.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");

        AdminClient admin = AdminClient.create(props);
        String TOPIC_NAME = "customers";
        Collection<String> TOPIC_LIST = Arrays.asList(TOPIC_NAME);
        int NUM_PARTITIONS = 1;
        short RF = 1;

        // List topics

        try {
            ListTopicsResult topics = admin.listTopics();
            topics.names().get().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Create a topic

        try {
            admin.createTopics(Collections.singleton(new NewTopic("topic1", NUM_PARTITIONS, RF)));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Example();
    }
}
