package vn.gg.core.service;

import javax.annotation.Nullable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;

import vn.gg.core.domain.BaseEntity;

public interface BaseService<T extends BaseEntity<T>> {
	
	Page<T> findAll(@Nullable Predicate predicate, Pageable pageable, OrderSpecifier<?>... orders);
	
	Iterable<T> findAll(@Nullable Predicate predicate, OrderSpecifier<?>... orders);
	
	/*Page<T> findPage(Predicate predicate, Pageable pageable, OrderSpecifier<?>... orders);
	
	List<T> findAll(Predicate predicate, Pageable pageable, OrderSpecifier<?>... orders);
	
	T findOneById(Long id);

	boolean existsById(Long id);
	
	T save(T entity);

	T update(Long id, T entity) ;

	void delete(Long id);*/
	
}
