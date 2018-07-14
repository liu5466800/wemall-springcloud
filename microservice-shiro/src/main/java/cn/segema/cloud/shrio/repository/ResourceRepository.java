package cn.segema.cloud.shrio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cn.segema.cloud.shrio.domain.Resource;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, String> {
	
	 
	 @Query("select r from Resource r where r.resourceName = ?1") 
	 List<Resource> findResourceByUserName(String userName); 
	 
	 @Query("select rs from Resource rs,User u,Role r,RoleResource rr,UserRole ur where u.userId = ?1 "
	 		+ " AND ur.user = u.userId AND rr.role = ur.role AND rr.resource = rs.resourceId") 
	 List<Resource> findResourceByUserId(String userId); 
	 
}
