package com.example.microservice.infrastructure.database;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("sessions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JpaSessionEntity {

    @Id
    @Column("id")
    private Long id;

    @Column("session_id")
    private String sessionId;
}
