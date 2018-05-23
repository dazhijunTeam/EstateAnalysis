<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${newsEntity.getNewsTitle()}</title>
    <#include "../common/links.ftl">
</head>
<body>
    <div class="container">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <h2>
                    ${newsEntity.getNewsSummary()}
                </h2>
                <p>
                    ${newsEntity.getNewsContent()}
                </p>
                <p>
                    <a class="btn" href="#">${newsEntity.newsAuthor}</a>
                </p>
            </div>
        </div>
    </div>
</body>
</html>