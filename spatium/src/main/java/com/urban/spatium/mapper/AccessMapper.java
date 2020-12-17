package com.urban.spatium.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.urban.spatium.dto.Access;
import com.urban.spatium.dto.Browser4;

@Mapper
public interface AccessMapper {
	public List<Access> getAccessRecord();

	public int getTotalAccess();

	public List<Browser4> getBrowserTop4();

	public int getEtcAccess(String btop1, String btop2, String btop3, String btop4);

}