package cn.segema.cloud.wemall.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cn.segema.cloud.wemall.product.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
//	 @Query("select new cn.segema.cloud.system.vo.UserPersonalVO(u.userId,u.userName,u.nickName,p.personalId,p.personalName)"
//	 		+ " from User u,UserPersonal up,Personal p where u.userName = ?1 and u.userId=up.user and up.personal = p.personalId ") 
//	 public List<UserPersonalVO> findUserPersonalByUserName(String userName); 
	 
	 @Query("SELECT u from User u  where u.userName = ?1 ") 
	 public List<Product> findByUserName(String userName); 
}
