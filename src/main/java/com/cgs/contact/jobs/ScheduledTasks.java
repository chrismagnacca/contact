package com.cgs.contact.jobs;

import java.util.LinkedList;
import java.util.List;
import java.util.TimeZone;

import com.cgs.contact.components.NeighborhoodCache;
import com.socrata.api.Soda2Consumer;
import com.socrata.builders.SoqlQueryBuilder;
import com.socrata.exceptions.SodaError;
import com.socrata.model.soql.*;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class ScheduledTasks {
    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final GeometryFactory geometryFactory = new GeometryFactory();

    private static final Soda2Consumer consumer = Soda2Consumer
            .newConsumer("https://data.seattle.gov",
                    "chrismagnacca@gmail.com",
                    "",
                    "");


    @Scheduled(cron = "1 * * * * *")
    public void poll() {
        DateTime endDate = DateTime.now(DateTimeZone.forTimeZone(TimeZone.getTimeZone("America/Los_Angeles")));
        DateTime startDate = endDate.minusHours(1);
        DateTimeFormatter formatter = DateTimeFormat.forPattern("MM/dd/yyyy HH:mm:ss");

        SoqlQuery query = new SoqlQueryBuilder()
                .setWhereClause(new ConditionalExpression("datetime > \'" + startDate.toString(formatter) + "\' and datetime < \'" + endDate.toString() + "\'"))
                .addOrderByPhrase(new OrderByClause(SortOrder.Descending, "datetime"))
                .build();

        List<Event> events = new LinkedList<>();

        try {
            events = consumer.query("nvqc-w7eg", query, Event.LIST_TYPE);
        } catch (SodaError error) {
            log.info("error {} encountered at {}", error.toString(), new DateTime().toString(formatter));
        } catch (InterruptedException exception) {
            log.info("exception {} encountered at {}", exception.toString(), new DateTime().toString(formatter));
        }

        events.forEach((event) -> log.info(event.toString()));
        events.forEach((event) -> {
            NeighborhoodCache.neighborhoods.forEach((neighborhood) -> {
                Coordinate eventCoordinate = new Coordinate(event.getLongitude(), event.getLatitude());
                Geometry point = geometryFactory.createPoint(eventCoordinate);
                if(neighborhood.getGeometry().contains(point)) {
                    log.info(neighborhood.getProperties().getName());
                    log.info(event.address);
                }
            });
        });
        log.info("The time is now {}", new DateTime().toString(formatter));
    }
}