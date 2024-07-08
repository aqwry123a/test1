<%@ page import="cn.javaweb.computer.entity.UserEntity.Emp
,
                 java.util.List"
         pageEncoding="UTF-8"
         contentType="text/html; charset=utf-8"
%>
<html>
<head>
    <title>笔记本电脑销售管理系统 - 首页</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="referrer" content="no-referrer">
    <!--eferrer可以告诉你用户是从哪个页面url地址过来的，这样就可以用来统计用户的来源-->
    <style>
    body{
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f4f4f4;

    }

        #sidebar {
            width: 200px;
            position: fixed;
            left: 0;
            top: 0;
            height: 100%;
            background-color: #333;
            padding-top: 20px;
            color: #fff;
        }

        #sidebar a {
            display: block;
            padding: 10px 15px;
            text-decoration: none;
            color: #fff;
        }

        #sidebar a:hover {
            background-color: #444;
        }

        #sidebar a.active {
            /* 这里的样式是高亮显示的样式 */
            background-color: #16b777;
        }

        #systemName {
            padding: 10px 15px;
            text-align: center;
            font-size: 20px;
            font-weight: bold;
            color: #fff;
            background-color: #333;
            border-bottom: 1px solid #ccc;
        }

        .main-content {
            padding-top: 40px; /* 在内容区域顶部增加上边距 */
            padding-left: 350px;
        }

        .notification {
            background-color: #f8d7da;
            color: #721c24;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #f5c6cb;
            border-radius: 4px;
            margin-left: 220px; /* 调整公告栏距离导航栏的左侧距离 */
            margin-top: 20px; /* 调整公告栏距离顶部的距离 */
            padding-left: 15px;
            padding-right: 15px;
        }
/* 添加以下样式 */
        .notification strong {
            font-weight: bold;
        }
    </style>
</head>
<body>
<div id="sidebar">
    <div id="systemName">
        笔记本电脑销售管理系统
    </div>
    <a href="index.jsp" class="active">首页</a>
    <a href="list" onclick="loadUserManagement()">用户管理</a>
    <%----%>
    <a href="list1" onclick="loadUserManagement()">产品管理</a>
    <a href="login.html" style="margin-right: auto">退出账户</a>
</div>

<div id="wrap">
    <div id="content" class="main-content" align="center">
        <div class="header">
        <h2>欢迎登录笔记本电脑销售管理系统</h2>
    </div>
        <div class="notification">
            <p><strong>公告：</strong>笔记本电脑销售管理系统将于下周五进行系统维护。在此期间可能会出现一些暂时性的服务中断，请留意。
        </p>
    </div>
    <div id="dynamicContent" class="main-content hidden">
        <!-- 动态内容将加载到这里 -->
    </div>
</div>
<script>
    function loadUserManagement() {
        var xhttp = new XMLHttpRequest();
        //XMLHttpRequest对象的状态改变时执行以下代码
        xhttp.onreadystatechange = function () {
// 这是一个事件处理函数，当XMLHttpRequest对象的readyState属性发生变化时触发
            if (this.readyState === 4 && this.status === 200) {
             //应该是为每个 AJAX 任务调用该函数这是一个条件语句，
                // 用于检查Ajax请求是否成功。readyState为4表示请求已完成，而status为200表示服务器成功处理请求。
                // Ajax中文是异步JavaScript和xml,是一种使用现有技术集合，实现前后端交互，客户端给服务端发送消息以及接收响应
//这是一个条件语句，用于检查Ajax请求是否成功。readyState为4表示请求已完成，而status为200表示服务器成功处理请求。
                //readyState是XMLHttpRequest对象的一个属性，用来标识当前XMLHttpRequest对象处于什么状态
                // 将获取到的响应内容放入 id 为 dynamicContent 的 HTML 元素中
                //readyState 属性存有 XMLHttpRequest 的状态信息。
                document.getElementById("dynamicContent").innerHTML = this.responseText;
            }
        };
        xhttp.open("GET", "emplist.jsp", true);
        //XMLHttpRequest.open() 方法初始化一个新创建的请求，在这里，它指定了请求的类型为GET，请求的URL为"emplist.jsp"。异步请求true
        xhttp.send();
        //XMLHttpRequest 方法 send（） 将请求发送到服务器。这一行代码触发实际的Ajax请求，将请求发送到指定的URL
    }
</script>
</body>
</html>
