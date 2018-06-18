<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>猜你喜欢</title>
    <#include "../common/links.ftl">
</head>
<body>
    <div class="container">
    <#include "../common/nav.ftl">

    <div class="row clearfix">
        <#list commAndUnsort as twocomm>
            <div class="col-md-12 column">
                <div class="row clearfix">

                    <div class="col-md-8 column">
                        <div class="row clearfix">
                            <div class="col-md-4 column" style="width:230px; height:230px">
                                <img alt="140x140" style="object-fit: cover;width: 260px;height: 209px;" src="${twocomm.getLeft().getCommunityImage()}" class="img-thumbnail" />
                            </div>
                            <div class="col-md-8 column" style="margin-left: -30px" onclick="window.open('/EstateAnalysis/commdetail/index?communityid=${twocomm.getLeft().getCommunityId()}')">
                                <div class="list-group">
                                    <a href="#" style="font-size: 17px" class="list-group-item active">${twocomm.getLeft().getCommunityName()}</a>
                                    <div class="list-group-item">
                                        <span class="price">
                                            ${twocomm.getLeft().getCommunityPriceinfo()!'售价待定'}
                                        </span>
                                    </div>
                                    <div class="list-group-item">
                                        <h4 class="list-group-item-heading">
                                            ${twocomm.getLeft().getCommunityAddress()}
                                        </h4>
                                        <p class="list-group-item-text">

                                        </p>
                                    </div>
                                    <div class="list-group-item">
                                        <span class="badge"></span>
                                        <#assign types=twocomm.getLeft().getCommunityHousetype()?split(" ")/>
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
                                            ${twocomm.getLeft().getCommunityTypeandsize()!''}
                                        </h4>

                                    </div>

                                </div>
                            </div>

                        </div>
                    </div>
                    <div class="col-md-4 column">
                        <div class="row clearfix">
                            <div class="col-md-12 column" onclick="window.open('/EstateAnalysis/commdetail/index?communityid=${twocomm.getRight().getCommunityId()}')">
                                <h2>
                                    ${twocomm.getRight().getCommunityName()}
                                </h2>
                                <p>
                                    <img alt="140x140" style="object-fit: cover;width: 240px;height: 200px;" src="${twocomm.getRight().getCommunityImage()}" class="img-thumbnail" />
                                    <i class="discout-mark">优惠</i>
                                </p>
                                <p>
                                    <a class="btn" href="#">${twocomm.getRight().getCommunityPriceinfo()!'售价待定'}</a>
                                </p>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </#list>
    </div>


        <ul class="pagination pull-right">
        <#if currentPage==1>
            <li class="disabled">
                <a href="/EstateAnalysis/youlike/index?page=${currentPage-1}">上一页</a>
            </li>
        <#else >
            <li>
                <a href="/EstateAnalysis/youlike/index?&page=${currentPage-1}">上一页</a>
            </li>
        </#if>
        <#if currentPage-3 gt 1>
            <li>
                <a href="/EstateAnalysis/youlike/index?page=1">1</a>
            </li>
            <#if currentPage-4!=1>
            <li class="disabled">
                <a href="">...</a>
            </li>
            </#if>
        </#if>
        <#list (currentPage-3)..(currentPage+3) as index>
            <#if index gt 0&&index lte totalPage>
                <#if index==currentPage>
                    <li class="disabled">
                        <a href="/EstateAnalysis/youlike/index?page=${index}">${index}</a>
                    </li>
                <#else>
                    <li>
                        <a href="/EstateAnalysis/youlike/index?page=${index}">${index}</a>
                    </li>
                </#if>

            </#if>
        </#list>
        <#if currentPage+3 lt totalPage>
            <#if currentPage+4!=totalPage>
             <li class="disabled">
                 <a href="">...</a>
             </li>
            </#if>
            <li>
                <a href="/EstateAnalysis/youlike/index?page=${totalPage}">${totalPage}</a>
            </li>
        </#if>
        <#if currentPage==totalPage>
            <li class="disabled">
                <a href="#">下一页</a>
            </li>
        <#else >
            <li>
                <a href="/EstateAnalysis/youlike/index?page=${currentPage+1}">下一页</a>
            </li>
        </#if>
        </ul>

</div>
</body>
</html>