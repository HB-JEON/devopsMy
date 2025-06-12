package com.sist.web.dao;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sist.web.entity.TourEntity;
import com.sist.web.vo.TourVO;

@Repository
public interface TourRepository extends JpaRepository<TourEntity, Integer> {
	@Query(value = "SELECT no, title, addr, img, areacode, num "
			+ "FROM (SELECT no, title, addr, img, areacode, rownum as num "
			+ "FROM (SELECT no, title, addr, img, areacode "
			+ "FROM tour ORDER BY no ASC)) "
			+ "WHERE num BETWEEN :start AND :end", nativeQuery = true)
	public List<TourVO> tourListData(@Param("start") int start, @Param("end") int end);
	
	public TourEntity findByNo(@Param("no") int no);
}
