<div class="modal" id="login-modal">
    <a class="close" data-dismiss="modal">×</a>
    <h1>登录</h1>

    <p>用户登录：</p>
    <form class="login-form clearfix" method="post" action="/EstateAnalysis/user/login">
        <div class="form-arrow"></div>
        <input name="username" type="text" placeholder="用户名：">
        <!--<input name="email" type="text" placeholder="邮箱：">-->
        <input name="password" type="password" placeholder="密码：">
        <input type="submit" name="type" class="button-blue login" value="登录">
        <input type="hidden" name="return-url" value="">
        <div class="clearfix"></div>
        <label class="remember"><input name="remember" type="checkbox" checked/>下次自动登录 </label>
        <a class="forgot">忘记密码？</a>

    </form>
</div>
<div class="modal" id="signup-modal">
                        <a class="close" data-dismiss="modal">×</a>
                        <h1>注册</h1>
                        <p>用户注册：</p>
                        <form class="signup-form clearfix" method="post" action="/EstateAnalysis/user/register">
                            <p class="error"></p>
                            <input name="username" type="text" placeholder="用户名：">
                            <input name="password" type="password" placeholder="密码：">
                            <input name="password1" type="password" placeholder="确认密码：">
                            <input name="city" type="text" placeholder="期待城市：">
                            <input name="salary" type="text" placeholder="个人薪资：">
                            <input name="Hprice" type="text" placeholder="期待房产均价：">
                            <div class="clearfix"></div>
                            <input type="submit" name="type" class="button-blue reg" value="注册" data-action="regist">
                        </form>
                    </div>
<div class="row clearfix">
    <div class="col-md-12 column">
        <h3 class="text-center text-info">
            欢迎来到购房助手
        </h3>
        <nav class="navbar navbar-default navbar-static-top" role="navigation">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button> <li class="navbar-brand" style="list-style: none" href="#">购房助手</li>
            </div>

            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a  href="/EstateAnalysis/index/index">楼盘</a>
                    </li>
                    <li>
                        <a href="/EstateAnalysis/news/index">楼讯</a>
                    </li>
                    <li>
                        <a href="/EstateAnalysis/youlike/index">猜你喜欢</a>
                    </li>
                </ul>
                <form class="navbar-form navbar-left" role="search">
                    <div class="form-group">
                        <input type="text" class="form-control" />
                    </div> <button type="submit" class="btn btn-default">查找</button>
                </form>
                <ul style="padding-right: 30px" class="nav navbar-nav navbar-right">
                    <#if userName??>
                        <li>
                            <a>欢迎您:${userName}</a>
                        </li>
                        <#else >
                        <li>
                            <a class="btn01" data-toggle="modal" href="#login-modal">登录</a>
                        </li>
                        <li>
                            <a class="btn02" data-toggle="modal" href="#signup-modal">注册</a>
                        </li>
                    </#if>

                </ul>
            </div>

        </nav>
    </div>
</div>
