package vn.gg.core.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.querydsl.core.types.EntityPath;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;

/**
 * Super repository for all resource. 
 * 
 * @author caltalys
 *
 * @param <T>
 * @param <ID>
 */
@NoRepositoryBean
@Transactional(readOnly=true)
public interface BaseRepository<T,ID extends Serializable> extends JpaRepository<T, ID>, QueryDslPredicateExecutor<T>{

	EntityPath<T> getPath();
	
	Page<T> findPage(@Param("predicate") Predicate predicate, Pageable pageable, OrderSpecifier<?>... orders);
	
	List<T> findAll(@Param("predicate") Predicate predicate, Pageable pageable, OrderSpecifier<?>... orders);
	
	T findById(@Param("id") Long id);
}
