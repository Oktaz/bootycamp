package net.oktaz.booty.hello;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

/**
 *
 */
@Configuration
public class ApplicationConfig extends AbstractMongoConfiguration {

    @Override
    protected String getDatabaseName() {
        return "boingo";
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient("127.0.0.1", 27017);
    }
}
