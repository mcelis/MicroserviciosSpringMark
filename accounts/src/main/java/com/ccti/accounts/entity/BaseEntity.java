package com.ccti.accounts.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@MappedSuperclass
@Setter
@Getter
@ToString
public class BaseEntity {
    @Column(name = "created_at",updatable = false)
    private LocalDateTime created_at;
    @Column(name = "created_by",updatable = false)
    private String created_by;
    @Column(name = "updated_at",insertable = false)
    private LocalDateTime updated_at;
    @Column(name = "updated_by",insertable = false)
    private String updated_by;
}
