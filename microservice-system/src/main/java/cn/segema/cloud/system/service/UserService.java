package cn.segema.cloud.system.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import cn.segema.cloud.system.domain.User;
import cn.segema.cloud.system.repository.UserRepository;

@Service
public class UserService {

	@Resource(name = "userRepository")
	private UserRepository userRepository;

	public List<User> getAll() {
		return (List<User>) userRepository.findAll();
	}

	public Page<User> findByPage(Pageable pageable, final Map<String, String> params) {

		Page<User> objPage = userRepository.findAll(new Specification<User>() {
			public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> lstPredicates = new ArrayList<Predicate>();
				if (params.get("userName") != null && (!"".equals(params.get("userName")))) {
					lstPredicates
							.add(cb.like(root.get("userName").as(String.class), "%" + params.get("userName") + "%"));
				}
				Predicate[] arrayPredicates = new Predicate[lstPredicates.size()];
				return cb.and(lstPredicates.toArray(arrayPredicates));
			}
		}, pageable);
		return objPage;
	}

}
