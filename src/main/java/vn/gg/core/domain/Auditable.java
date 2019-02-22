package vn.gg.core.domain;

import java.time.LocalDateTime;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable<U >{

	@CreatedDate
	private LocalDateTime ngayTao;
	
	@LastModifiedDate
	private LocalDateTime ngaySua;
	
	@CreatedBy
	private U nguoiTao;
	
	@LastModifiedBy
	private U nguoiSua;
	
}
