package com.sist.web.entity;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

/*
	NO           NOT NULL NUMBER        
	CONTENT_ID            NUMBER        
	CONTENT_TYPE NOT NULL NUMBER        
	TITLE        NOT NULL VARCHAR2(300) 
	ADDR         NOT NULL VARCHAR2(300) 
	AREACODE              NUMBER        
	SIGUNGUCODE           NUMBER        
	IMG                   VARCHAR2(500) 
	CAT1         NOT NULL VARCHAR2(200) 
	CAT2         NOT NULL VARCHAR2(200) 
	CAT3         NOT NULL VARCHAR2(500) 
	MAPX                  NUMBER(10,6)  
	MAPY                  NUMBER(10,6)  
	OVERVIEW              CLOB      
 */
@Entity(name = "tour")
@Data
@DynamicUpdate
public class TourEntity {
	@Id
	private int no;
	private String title, addr, img, cat1, cat2, cat3, overview;
	private int content_id, content_type, areacode, sigungucode;
	private double mapx, mapy;
}