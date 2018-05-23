<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>楼市快讯</title>
    <#include "../common/links.ftl">
</head>
<body>

    <div class="container">
    <#include "../common/nav.ftl">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <ul class="nav nav-tabs">
                <#list cityEntities as city>
                    <#if city.getCityId()==cityId>
                        <li class="active">
                            <a href="/EstateAnalysis/news/index?cityId=${city.getCityId()}">${city.getCityName()}</a>
                        </li>
                    <#else >
                        <li>
                            <a href="/EstateAnalysis/news/index?cityId=${city.getCityId()}">${city.getCityName()}</a>
                        </li>
                    </#if>
                </#list>
            </ul>
        </div>
    </div>

    <div class="col-md-12 column">
            <#list newsEntities.getContent() as news>
                <#if news_index%3==0>
                    <div class="row clearfix">
                </#if>
                   <div class="col-md-4 column">
                       <div class="row clearfix">
                           <div class="col-md-5 column">
                               <img alt="140x140" width="140" height="140" style="margin-top: 20px" src=${news.getNewsImage()} />
                               <span style="display: block; margin-top: 5px" class="label label-info">${news.getNewsTag()}</span>
                           </div>
                           <div class="col-md-7 column">
                               <h3>
                                   ${news.getNewsTitle()}
                               </h3>
                               <p>
                                   ${news.getNewsSummary()}
                               </p>
                               <p>
                                   <a class="btn" href="/EstateAnalysis/news/detail?newsId=${news.getNewsId()}">查看详情 »</a>
                               </p>
                           </div>
                       </div>
                   </div>
                <#if news_index%3==2>
                    </div>
                </#if>
            </#list>
    </div>
    </div>
    <ul class="pagination pull-right">
        <#if currentPage==1>
            <li class="disabled">
                <a href="/EstateAnalysis/news/index?cityId=${cityId}&page=${currentPage-1}">上一页</a>
            </li>
        <#else >
            <li>
                <a href="/EstateAnalysis/news/index?cityId=${cityId}&page=${currentPage-1}">上一页</a>
            </li>
        </#if>
        <#if currentPage-3 gt 1>
            <li>
                <a href="/EstateAnalysis/news/index?cityId=${cityId}&page=1">1</a>
            </li>
        <#if currentPage-4!=1>
            <li class="disabled">
                <a href="">...</a>
            </li>
        </#if>
        </#if>
        <#list (currentPage-3)..(currentPage+3) as index>
            <#if index gt 0&&index lte newsEntities.getTotalPages()>
                <#if index==currentPage>
                    <li class="disabled">
                        <a href="/EstateAnalysis/news/index?cityId=${cityId}&page=${index}">${index}</a>
                    </li>
                <#else>
                    <li>
                        <a href="/EstateAnalysis/news/index?cityId=${cityId}&page=${index}">${index}</a>
                    </li>
                </#if>

            </#if>
        </#list>
        <#if currentPage+3 lt newsEntities.getTotalPages()>
        <#if currentPage+4!=newsEntities.getTotalPages()>
             <li class="disabled">
                 <a href="">...</a>
             </li>
        </#if>
            <li>
                <a href="/EstateAnalysis/news/index?cityId=${cityId}&page=${newsEntities.getTotalPages()}">${newsEntities.getTotalPages()}</a>
            </li>
        </#if>
        <#if currentPage==newsEntities.getTotalPages()>
            <li class="disabled">
                <a href="#">下一页</a>
            </li>
        <#else >
            <li>
                <a href="/EstateAnalysis/news/index?cityId=${cityId}&page=${currentPage+1}">下一页</a>
            </li>
        </#if>
    </ul>
</body>
</html>