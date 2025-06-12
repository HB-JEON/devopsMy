package com.sist.web.service;

import java.util.List;

import com.sist.web.entity.TourEntity;
import com.sist.web.vo.TourVO;

public interface TourService {
	public List<TourVO> tourListData(int start, int end);
	public TourEntity tourDetailData(int no);
	public int tourTotalPage();
}
