package com.sist.web.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.web.dao.TourRepository;
import com.sist.web.entity.TourEntity;
import com.sist.web.vo.TourVO;

@Service
public class TourServiceImpl implements TourService {
	@Autowired
	private TourRepository tDao;
	
	@Override
	public List<TourVO> tourListData(int start, int end) {
		// TODO Auto-generated method stub
		return tDao.tourListData(start, end);
	}

	@Override
	public TourEntity tourDetailData(int no) {
		// TODO Auto-generated method stub
		return tDao.findByNo(no);
	}

	@Override
	public int tourTotalPage() {
		// TODO Auto-generated method stub
		int count = (int)tDao.count();
		return (int)(Math.ceil(count / 12.0));
	}
}
