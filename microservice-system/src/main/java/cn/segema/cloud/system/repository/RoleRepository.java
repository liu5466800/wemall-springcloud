package cn.segema.cloud.system.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import cn.segema.cloud.system.domain.Role;
import cn.segema.cloud.system.domain.User;

@Repository
public interface RoleRepository extends PagingAndSortingRepository<Role, BigInteger>,JpaRepository<Role, BigInteger>,JpaSpecificationExecutor<Role> {
	
	 @Query("select r from Role r where r.roleName = ?1") 
	 List<Role> findByRoleName(String roleName); 
	 
	 
}
