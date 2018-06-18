package com.dazhijunteam.estate.repository.mapper;

import com.dazhijunteam.estate.dataobject.CommunityEntity;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface CommunityMapper {
    @Select("<script>SELECT * from community WHERE community_districtid in " +
            "<foreach item='CityEntity' collection='list' open='(' close=')' separator=','>#{CityEntity}</foreach> " +
            "and (" +
            "(community_avprice&gt;#{lowPrice} AND community_avprice&lt;#{highPrice}) " +
            "OR community_totalprice &lt; #{totalPrice}" +
            ")</script>")
    @Results({
            @Result(column = "community_id", property = "communityId"),
            @Result(column = "community_name", property = "communityName"),
            @Result(column = "community_address", property = "communityAddress"),
            @Result(column = "community_districtid", property = "communityDistrictid"),
            @Result(column = "community_typeandsize", property = "communityTypeandsize"),
            @Result(column = "community_phone", property = "communityPhone"),
            @Result(column = "community_avprice", property = "communityAvprice"),
            @Result(column = "community_priceinfo", property = "communityPriceinfo"),
            @Result(column = "community_housetype", property = "communityHousetype"),
            @Result(column = "community_totalprice", property = "communityTotalprice"),
            @Result(column = "community_image", property = "communityImage"),
            @Result(column = "community_infourl", property = "communityInfourl"),
            @Result(column = "community_lowprice", property = "communityLowprice")
    })
    public List<CommunityEntity> findByYouLike(Map<String,Object> map);
    //Pageable pageable, Integer lowPrice, Integer highPrice, Integer lowTotalPrice
}
