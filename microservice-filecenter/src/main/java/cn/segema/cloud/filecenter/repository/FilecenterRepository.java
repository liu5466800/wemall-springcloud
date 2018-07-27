package cn.segema.cloud.filecenter.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cn.segema.cloud.filecenter.domain.Filecenter;

@Repository
public interface FilecenterRepository extends JpaRepository<Filecenter, BigInteger> {
	
	
	 @Query("select r from Filecenter r where r.businessId = ?1") 
	 List<Filecenter> getfilesByBusinessId(BigInteger businessId); 
	 
	 @Query("select r from Filecenter r where r.businessId = ?1 and r.businessCode=?2") 
	 List<Filecenter> getfilesByBusinessIdAndCode(BigInteger businessId,String businessCode); 
}
