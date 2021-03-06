package cn.segema.cloud.system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import cn.segema.cloud.system.domain.Option;

@Repository
public interface OptionRepository extends PagingAndSortingRepository<Option, String>,JpaRepository<Option, String>,JpaSpecificationExecutor<Option>{
	
	
	 
	 @Query("SELECT o from Option o  where o.optionKey = ?1 ") 
	 public Option findByOptionKey(String optionKey); 
	 
	 
	 
//	 @Query("SELECT o FROM Option o") 
//	 public List<Option> findOptionList(); 
	 
	 @Query(value ="SELECT * FROM SYS_OPTION ",nativeQuery = true) 
	 public List<Option> findOptionList(); 
}
