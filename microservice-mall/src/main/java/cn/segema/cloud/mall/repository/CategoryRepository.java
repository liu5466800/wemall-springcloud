package cn.segema.cloud.mall.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import cn.segema.cloud.mall.domain.Category;

@Repository
public interface CategoryRepository extends PagingAndSortingRepository<Category, BigInteger>,JpaRepository<Category, BigInteger> ,JpaSpecificationExecutor<Category> {
	
	
//	 @Query("select new cn.segema.cloud.demo.vo.DemoUserPersonalVO(u.userId,u.userName,u.nickName,p.personalId,p.personalName)"
//	 		+ " from DemoUser u,DemoUserPersonal up,DemoPersonal p where u.userName = ?1 and u.userId=up.user and up.personal = p.personalId ") 
//	 public List<DemoUserPersonalVO> findUserPersonalByUserName(String userName); 
	 
	 
}
