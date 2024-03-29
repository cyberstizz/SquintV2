package com.example.SquintV2.Repositories;

import com.example.SquintV2.Models.Alarm;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface AlarmRepository extends CassandraRepository<Alarm, UUID>{
    List<Alarm> findByUserId(UUID userId);

}

