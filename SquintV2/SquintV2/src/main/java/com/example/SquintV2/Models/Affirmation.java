package main.java.com.example.SquintV2.Models;

import java.util.UUID;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;

@Table(value = "affirmation")
public class Affirmation{

    @PrimaryKeyColumn(name = "affirmation_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private UUID affirmation_id;

    @PrimaryKeyColumn(name = "user_id", ordinal = 1, type = PrimaryKeyType.CLUSTERED)
    private UUID user_id;

    public UUID getAffirmationId() {
        return this.affirmation_id;
    }

    public void setAffirmationId(UUID affirmation_id) {
        this.affirmation_id = affirmation_id;
    }

    public UUID getUserId() {
        return this.user_id;
    }

    public void setUserId(UUID user_id) {
        this.user_id = user_id;
    }
}