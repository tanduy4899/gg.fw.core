package vn.gg.core.domain.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import vn.gg.core.domain.BaseEntity;

public abstract class BaseDto<T extends BaseEntity<T>> implements Serializable{

	private static final long serialVersionUID = -8077574882086058585L;
	protected T entity;
	
	public BaseDto() {
		super();
	}
	
	public BaseDto(T entity) {
		this.entity = entity;
	}

	public abstract void updateEntity(@NotNull T entity);
	
	public abstract void setData(@NotNull T entity);

	public void setData() {
		if(entity!=null) {
			setData(entity);
		}
	}
}
