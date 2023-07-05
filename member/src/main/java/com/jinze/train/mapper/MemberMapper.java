package com.jinze.train.mapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * Member表dao层
 * @author Jinze
 */
@Mapper
public interface MemberMapper {
    /***
     * 查询会员数量
     * @return int
     * @author jinze
    */
    int count();
}
