package cn.segema.cloud.system.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cn.segema.cloud.system.domain.User;
import cn.segema.cloud.system.vo.UserPersonalVO;
import cn.segema.cloud.system.vo.UserVO;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, BigInteger>,JpaRepository<User, BigInteger> ,JpaSpecificationExecutor<User>{
	
//	 @Query("select new cn.segema.cloud.system.vo.UserPersonalVO(u.userId,u.userName,u.nickName,p.personalId,p.personalName)"
//	 		+ " from User u,UserPersonal up,Personal p where u.userName = ?1 and u.userId=up.user and up.personal = p.personalId ") 
//	public List<UserPersonalVO> findUserPersonalByUserName(String userName); 
	
	 @Query("SELECT u from User u  where u.userName = ?1 ") 
	public List<UserPersonalVO> findUserPersonalByUserName(String userName); 
	 
	 @Query("SELECT u from User u  where u.userName = ?1 ") 
	 public List<User> findByUserName(String userName); 
	 
	 @Query("SELECT u from User u  where u.nickName = ?1 ") 
	 public List<User> findByNickName(String nickName); 
	 
	 @Query("SELECT u from User u") 
	 public List<User> findAllUser(); 
	 
	 @Query(value = "SELECT * FROM sys_user WHERE if(:#{#user.userName}!=null,user_name = :#{#user.userName},1=1) and if(:#{#user.gender}!=null,gender = :#{#user.gender},1=1) ",
			    countQuery = "SELECT count(*) FROM sys_user WHERE if(:#{#user.userName}!=null,user_name = :#{#user.userName},1=1) and if(:#{#user.gender}!=null,gender = :#{#user.gender},1=1) ",
			    nativeQuery = true)
	 public	Page<User> findByPage(@Param("user") UserVO user, Pageable pageable);
}
