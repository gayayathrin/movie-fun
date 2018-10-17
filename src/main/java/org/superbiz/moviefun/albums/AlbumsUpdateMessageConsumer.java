package org.superbiz.moviefun.albums;

import org.springframework.messaging.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.sql.DataSource;

@Configuration
@EnableAsync
@EnableScheduling
public class AlbumsUpdateMessageConsumer {

    private final AlbumsUpdater albumsUpdater;
    private final Logger logger = LoggerFactory.getLogger(getClass());

    public AlbumsUpdateMessageConsumer(AlbumsUpdater albumsUpdater) {

        this.albumsUpdater = albumsUpdater;
    }

    public void consume(Message<?> message){
        try{
            logger.debug("starting albums update");
            albumsUpdater.update();
            logger.debug("Finished albums update");
        } catch(Throwable e){
            logger.error("Error while updating albums", e);
        }
    }
}
