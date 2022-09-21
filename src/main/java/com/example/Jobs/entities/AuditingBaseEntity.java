package com.example.Jobs.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.io.Serializable;
import java.time.LocalDateTime;


@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
abstract class AuditingBaseEntity<T> implements Serializable {
	private static final long serialVersionUID = -3124788683205549668L;

	protected abstract T getId();

	@Column(nullable = false, updatable = false)
	@CreatedDate
	protected LocalDateTime createdOn = LocalDateTime.now();

	@Column(nullable = false, updatable = false)
	@CreatedBy
	protected String createdBy;

	@LastModifiedDate
	protected LocalDateTime updatedOn = LocalDateTime.now();

	@Column(nullable = false)
	@LastModifiedBy
	protected String updatedBy;

	@Column(nullable = false)
	protected Boolean deleted = Boolean.FALSE;

	@Column(nullable = false)
	@Version
	protected int version;
}
