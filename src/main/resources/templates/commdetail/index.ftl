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
        <div class="row clearfix">
            <div class="col-md-12 column">
                <div class="row clearfix">
                    <#--轮播图，已设计好-->
                    <div class="col-md-5 column">
                        <div class="carousel slide" id="carousel-675344">
                            <ol class="carousel-indicators">
                                <#list infoAndimg?keys as info>
                                    <#if info_index==0>
                                        <li class="active" data-slide-to="0" data-target="#carousel-675344">
                                        </li>
                                    <#else >
                                        <li data-slide-to="${info_index}" data-target="#carousel-675344">
                                        </li>
                                    </#if>
                                </#list>
                            </ol>
                            <div class="carousel-inner">
                                <#list infoAndimg?keys as info>
                                    <#if info_index==0>
                                        <div class="item active">
                                            <img alt="" style="width: 457px;height: 385px" src=${infoAndimg[info]} />
                                            <div class="carousel-caption">
                                                <h4>
                                                    ${info}
                                                </h4>
                                            </div>
                                        </div>
                                    <#else >
                                        <div class="item">
                                            <img alt="" style="width: 457px;height: 385px" src=${infoAndimg[info]} />
                                            <div class="carousel-caption">
                                                <h4>
                                                    ${info}
                                                </h4>
                                            </div>
                                        </div>
                                    </#if>
                                </#list>
                            </div> <a class="left carousel-control" href="#carousel-675344" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a> <a class="right carousel-control" href="#carousel-675344" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
                        </div>
                    </div>
                    <#--房产的详细信息-->
                    <div class="col-md-7 column">
                        <div class="list-group">
                            <a href="#" style="font-size: 17px" class="list-group-item active">${communityEntity.getCommunityName()}</a>
                            <div class="list-group-item">
                                        <span class="price">
                                        楼盘价格&nbsp;&nbsp;&nbsp;${communityEntity.getCommunityPriceinfo()!'售价待定'}
                                        </span>
                            </div>
                            <div class="list-group-item">
                                <h4 class="list-group-item-heading">
                                楼盘地址&nbsp;&nbsp;&nbsp;${communityEntity.getCommunityAddress()}
                                </h4>
                            </div>
                            <div class="list-group-item">
                                <span class="badge"></span>
                                        <#assign types=communityEntity.getCommunityHousetype()?split(" ")/>
                                        <#list types as oneType>
                                            <#if oneType_index gt 1>
                                            <span class="tag">${oneType}</span>
                                            <#else >
                                            <span class="tag1">${oneType}</span>
                                            </#if>
                                        </#list>
                            </div>
                            <div class="list-group-item">
                                <h4 class="list-group-item-heading" style="font-size: 14px">
                                ${communityEntity.getCommunityTypeandsize()!''}
                                </h4>
                            </div>
                            <div class="list-group-item">
                                <#if communityEntity.getCommunityPhone()!="">
                                <strong class="tel">${communityEntity.getCommunityPhone()?substring(0,communityEntity.getCommunityPhone()?length-1)}</strong>
                                <#else >
                                    <strong class="tel">400-603-2266</strong>
                                </#if>

                                <a class="detailbtn">免费通话</a>
                            </div>
                            <div class="list-group-item">
                               <a style="font-size: 16px;text-decoration:none">开盘时间:${houseInfos.getOpenTime()}&nbsp;&nbsp;&nbsp;交楼时间:${houseInfos.getCompleteTime()}</a>
                            </div>
                            <div class="list-group-item">
                                <a style="color:#656565;font-size:16px;text-decoration:none">建筑类型&nbsp;&nbsp;&nbsp;</a>
                                <a style="font-size: 16px;color:#333;text-decoration:none">${houseInfos.getBuildingType()}</a>
                            </div>
                        </div>
                    </div>
                </div>
                <h3 class="text-left" style="font-size: 25px">
                    用户评论
                </h3>
                <#list userComments as comment>
                    <li style="list-style: none" class="total-comment">
                    <div class="clearfix">
                        <div class="info-user">
                            <img width="38" height="38" src="https://pages.anjukestatic.com/xinfang/img/house/ugc/avatar70x70.png"/>
                            <span style="color: #333;font-size: 16px;padding: 0 8px 0 0;">${comment.getUsername()}</span>
                        </div>

                            <h4 class="rev-subtit all-text">${comment.getComment()}</h4>
                            <div class="tray-panel clearfix">
                                <span class="date">${comment.getCommentTime()}</span>
                                <div class="share-praise fr">
                                </div>
                            </div>
                    </div>
                    </li>
                </#list>
            </div>
        </div>
    </div>
</div>
</body>
</html>