<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>购房助手</title>
    <#include "../common/links.ftl">
</head>
<body>
<div class="container">
    <#include "../common/nav.ftl">
    <div class="container">
        <div class="row clearfix" style="padding-bottom: 10px">
            <div class="col-md-12 column">
            <#--用户栏-->
                <ul class="nav nav-tabs">
                    <#if isinDetail==true>
                        <li class="active">
                            <a href="/EstateAnalysis/commdetail/index?communityid=${houseInfos.getHouseId()}">楼盘详情</a>
                        </li>
                        <li>
                            <a href="/EstateAnalysis/commdetail/housetype?communityid=${houseInfos.getHouseId()}">户型信息</a>
                        </li>
                    <#else>
                        <li>
                            <a href="/EstateAnalysis/commdetail/index?communityid=${houseInfos.getHouseId()}">楼盘详情</a>
                        </li>
                        <li class="active">
                            <a href="/EstateAnalysis/commdetail/housetype?communityid=${houseInfos.getHouseId()}">户型信息</a>
                        </li>
                    </#if>
                </ul>
            </div>
        </div>
        <#--户型列表-->
        <div class="row clearfix">
            <#if houseTypeInfos?size==0>
                <div class="hx-nodata-mod">
                    <p><span>该房产</span>的户型正在发布中...</p>
                    <p>请咨询售楼处免费电话<span class="tel-mod">400 056 0712</span>
                    </p>
                    <p>以便立即获得最新的户型信息！</p>
                </div>
                <#else >
                <a class="hxa" href="/EstateAnalysis/commdetail/housetype?communityid=${houseInfos.getHouseId()}&type=全部户型" style="text-decoration: none">全部户型(${allTypeSum})</a>
                <span class="hxsplit"></span>
                <#list houseTypeMap?keys as houseType>
                <a class="hxa" href="/EstateAnalysis/commdetail/housetype?communityid=${houseInfos.getHouseId()}&type=${houseType}" style="text-decoration: none">${houseType}(${houseTypeMap[houseType]?size})</a>
                <span class="hxsplit"></span>
                </#list>
            </#if>
        </div>
        <div class="row clearfix">
            <#list houseTypeInfos as houseType>
                <li class="hx-list">
                    <a>
                       <img src=${houseType.getTypeImageUrl()} alt="户型图"/>
                    </a>
                    <div class="type-name">
                        <div class="descrip desc-name">
                            <div class="desc-txt clearfix">
                                <span class="desc-k">${houseType.getTypeEng()}</span>
                                <span class="desc-v">${houseType.getTypeCn()}</span>
                            </div>
                            <#if houseType.getSaleStatus()==0>
                                <i class="comm-stat dsale">待售</i>
                            <#else >
                                <i class="comm-stat zsale">在售</i>
                            </#if>
                            <#if houseType.getHotStatus()==1>
                                <i class="comm-stat hot-sale">主推</i>
                            <#else >
                                <i class="comm-stat hot-sale">主推</i>
                            </#if>
                        </div>
                        <div class="descrip">
                            <span class="desc-k area-k">建筑面积：${houseType.getHouseArea()}㎡</span>
                        </div>
                    </div>
                </li>
            </#list>
        </div>
    </div>
</div>
</body>
</html>