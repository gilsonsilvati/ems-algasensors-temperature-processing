package com.algaworks.algasensors.temperature.processing;

import org.springframework.util.Assert;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.Objects;
import java.util.UUID;

public class UUIDv7Utils {

    private UUIDv7Utils() {

    }

    public static OffsetDateTime extractOffsetDateTime(UUID uuid) {
        Assert.notNull(uuid, "UUID não pode ser null");

        Objects.requireNonNull(uuid, "UUID não pode ser nulo");

        long timestamp = uuid.getMostSignificantBits() >>> 16;

        return OffsetDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneId.systemDefault());
    }
}
