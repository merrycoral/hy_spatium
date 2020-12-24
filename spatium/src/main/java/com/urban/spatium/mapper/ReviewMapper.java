package com.urban.spatium.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.urban.spatium.dto.Review;

@Mapper
public interface ReviewMapper {

	public List<Review> getAllReview();

	public List<Review> searchReview(String searchKey, String searchValue);

}
