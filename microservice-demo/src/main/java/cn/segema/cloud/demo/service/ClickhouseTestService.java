package cn.segema.cloud.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.segema.cloud.demo.repository.ClickhouseRepository;

@Service
public class ClickhouseTestService<T> {
	
	 @Autowired
	 private ClickhouseRepository clickhouseRepository;
	
	 public List<T> findList(){
		 
		 String sql = "select * from code_province";
		 
		 clickhouseRepository.exeDruidSql(sql);
		 
		 
		 clickhouseRepository.exeSql(sql);
		 return null;
	 }
	
	 public T findById(Integer id){
		 return null;
	 }
	 
	 public T save(T entity){
		 return null;
	 }
	 
	 public T update(T entity){
		 return null;
	 }
	 
	 public void deleteById(Integer id){
		 
	 }
	 
}
