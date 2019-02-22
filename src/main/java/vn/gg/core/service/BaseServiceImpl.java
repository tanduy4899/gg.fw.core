package vn.gg.core.service;

import java.time.LocalDateTime;

import javax.annotation.Nullable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.Expressions;

import vn.gg.core.domain.BaseEntity;
import vn.gg.core.domain.QBaseEntity;
import vn.gg.core.repository.BaseRepository;

@Service
@Transactional
public class BaseServiceImpl<T extends BaseEntity<T>, ID> implements BaseService<T> {

	BaseRepository<T, Long> repository;
	
	@Override
	public Page<T> findAll(@Nullable Predicate predicate, Pageable pageable, OrderSpecifier<?>... orders) {
		if (predicate == null) {
			predicate = QBaseEntity.baseEntity.deleted.isFalse();
		}

		if (orders == null || orders.length == 0) {
			return repository.findPage(predicate, pageable, new OrderSpecifier<>(Order.DESC,
					Expressions.dateTimePath(LocalDateTime.class, repository.getPath(), "ngaySua")));
		}

		return repository.findPage(predicate, pageable, orders);
	}

	@Override
	public Iterable<T> findAll(@Nullable Predicate predicate, OrderSpecifier<?>... orders) {
		if (predicate == null) {
			predicate = QBaseEntity.baseEntity.deleted.isFalse();
		}

		if (orders == null || orders.length == 0) {
			return repository.findAll(predicate, new OrderSpecifier<>(Order.DESC,
					Expressions.dateTimePath(LocalDateTime.class, repository.getPath(), "ngaySua")));
		}
		
		return repository.findAll(predicate, orders);
	}

	//@Autowired
	/*BaseRepository<T, Long> repository;
	
	public BaseServiceImpl() {
	}
	
	public BaseServiceImpl(BaseRepository<T, Long> repository) {
		this.repository = repository;
	}

	@Override
	public Page<T> findPage(Predicate predicate, Pageable pageable, OrderSpecifier<?>... orders) {

		if (predicate == null) {
			predicate = QBaseEntity.baseEntity.deleted.isFalse();
		}

		if (orders == null || orders.length == 0) {
			return repository.findPage(predicate, pageable, new OrderSpecifier<>(Order.DESC,
					Expressions.dateTimePath(LocalDateTime.class, repository.getEntityPath(), "ngaySua")));
		}

		return repository.findPage(predicate, pageable, orders);

	}

	@Override
	public List<T> findAll(Predicate predicate, Pageable pageable, OrderSpecifier<?>... orders) {
		
		if (predicate == null) {
			predicate = QBaseEntity.baseEntity.deleted.isFalse();
		}

		if (orders == null || orders.length == 0) {
			return repository.findAll(predicate, pageable, new OrderSpecifier<>(Order.DESC,
					Expressions.dateTimePath(LocalDateTime.class, repository.getEntityPath(), "ngaySua")));
		}
		
		return repository.findAll(predicate, pageable, orders);
	}*/

	/*@Override
	public T findOneById(Long id) {
		return repository.findOneById(id);
	}

	@Override
	public T save(T entity) {
		return repository.save(entity);
	}

	@Override
	public T update(Long id, T entity) {
		if(id.equals(entity.getId())) {
			boolean exist = existsById(id);
			if (exist) {
				return save(entity);
			}
		}
		return null;
	}

	@Override
	public void delete(Long id) {
		boolean exist = existsById(id);
		if (exist) {
			repository.delete(id);
		}
	}

	@Override
	public boolean existsById(Long id) {
		return repository.existsById(id);
	}*/

}
