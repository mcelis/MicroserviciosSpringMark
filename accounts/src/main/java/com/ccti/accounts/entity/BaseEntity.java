package com.ccti.accounts.entity;

import com.ccti.accounts.audit.AuditorAwareImpl;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@Setter
@Getter
@ToString
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

    @CreatedDate
    @Column(name = "created_at",updatable = false)
    private LocalDateTime created_at;

    @CreatedBy
    @Column(name = "created_by",updatable = false)
    private String created_by;

    @LastModifiedDate
    @Column(name = "updated_at",insertable = false)
    private LocalDateTime updated_at;

    @LastModifiedBy
    @Column(name = "updated_by",insertable = false)
    private String updated_by;
}
