package com.algaworks.algasensors.temperature.processing.common;

import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UUIDv7Test {

    @Test
    void sholdGenerateUUIDv7() {
        UUID uuid = IdGenerator.generateTimeBasedUUID();

        OffsetDateTime uuidDateTime = UUIDv7Utils.extractOffsetDateTime(uuid).truncatedTo(ChronoUnit.MINUTES);
        OffsetDateTime curretDateTime = OffsetDateTime.now().truncatedTo(ChronoUnit.MINUTES);

        assertThat(uuidDateTime).isEqualTo(curretDateTime);
    }

    @Test
    void sholdNullGenerateUUIDv7() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> UUIDv7Utils.extractOffsetDateTime(null)
        );

        assertThat(exception.getMessage()).isEqualTo("UUID não pode ser null");
    }
}
