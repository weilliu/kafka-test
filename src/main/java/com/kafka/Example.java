package com.kafka;

import com.couchbase.kafka.CouchbaseKafkaConnector;
import com.couchbase.kafka.CouchbaseKafkaEnvironment;
import com.couchbase.kafka.DefaultCouchbaseKafkaEnvironment;

public class Example {
    public static void main(String[] args) {
        DefaultCouchbaseKafkaEnvironment.Builder builder =
                (DefaultCouchbaseKafkaEnvironment.Builder) DefaultCouchbaseKafkaEnvironment
                        .builder()
                        .kafkaFilterClass("com.kafka.SimpleFilter")
                        .kafkaValueSerializerClass("com.kafka.SimpleEncoder")
                        .kafkaTopic("default")
                        .kafkaZookeeperAddress("10.3.3.203:2181")
                        .couchbaseNodes("10.3.3.203:8091")
                        .couchbaseBucket("default")
                        .dcpEnabled(true);
        
        CouchbaseKafkaConnector connector = CouchbaseKafkaConnector.create(builder.build());
        connector.run();
    }
}