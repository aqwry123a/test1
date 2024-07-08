<%@ page import="cn.javaweb.computer.entity.ProEntity.Product,java.util.List"
         pageEncoding="UTF-8"
         contentType="text/html; charset=utf-8"
%>
<html>
<head>
    <title>Product List</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <style>
        /* 模糊搜索部分样式 */
        form[action="searchProduct"] {
            margin-bottom: 20px;
        }
/*这是一个选择器，指定了特定类型和名称的输入元素。它选择了所有类型为"text"且名称为"keyword"的输入元素。*/
        input[type="text"][name="keyword"] {
            padding: 8px;
            width: 200px;
            border-radius: 5px;
            border: 1px solid #ccc;
            margin-right: 10px;
            font-size: 16px;
        }

        input[type="submit"][value="搜索"] {
            padding: 8px 20px;
            border-radius: 5px;
            border: none;
            background-color: #4CAF50;
            color: white;
            cursor: pointer;
            transition: background-color 0.3s ease;
            font-size: 16px;
        }

        input[type="submit"][value="搜索"]:hover {
            background-color: #45a049;
        }

        body {
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

        #wrap {
            margin-left: 200px;
            margin-top: 20px;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 5px;
        }

        #content {
            padding: 20px;
        }

        .table {
            width: 100%;
            border-collapse: collapse;
        }

        .table_header {
            background-color: #e0e0e0;
            font-weight: bold;
        }

        .table td, .table th {
            padding: 8px;
            border: 1px solid #ccc;
            text-align: left;
        }

        .row1 {
            background-color: #f9f9f9;
        }

        .button {
            padding: 10px 20px;
            border-radius: 5px;
            border: none;
            background-color: #4CAF50;
            color: white;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .button:hover {
            background-color: #45a049;
        }

        /* 将修改用户链接的背景颜色更改为 #1e9fff 蓝色 */
        .operation-links a:nth-child(2) {
            background-color: #1e9fff; /* 修改用户链接背景色 */
            border-radius: 3px;
            padding: 5px 10px;
            color: #fff;
            text-decoration: none;
            display: inline-block;
        }

        .operation-links a:nth-child(2):hover {
            background-color: #0f7be7; /* 修改用户链接悬停时的背景色 */
        }

        /* 将删除用户链接的背景颜色更改为 #ff5722 橙色 */
        .operation-links a:first-child {
            background-color: #ff5722; /* 删除用户链接背景色 */
            border-radius: 3px;
            padding: 5px 10px;
            color: #fff;
            text-decoration: none;
            display: inline-block;
        }

        .operation-links a:first-child:hover {
            background-color: #e64a19; /* 删除用户链接悬停时的背景色 */
        }
        /* 表格样式 */
        .table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        .table_header {
            background-color: #e0e0e0;
            font-weight: bold;
        }

        .table th {
            padding: 12px;
            border: 1px solid #ccc;
            text-align: left;
            font-size: 16px;
        }

        .table td {
            padding: 12px;
            border: 1px solid #ccc;
            text-align: left;
            font-size: 14px;
        }

        .row1 {
            background-color: #f9f9f9;
        }

        .operation-links a {
            border-radius: 3px;
            padding: 5px 10px;
            color: #fff;
            text-decoration: none;
            display: inline-block;
            font-size: 14px;
        }

        .operation-links a:first-child {
            margin-right: 5px;
        }

        .operation-links a:nth-child(2) {
            margin-right: 5px;
        }

        .operation-links a:nth-child(2) {
            background-color: #1e9fff;
        }

        .operation-links a:nth-child(2):hover {
            background-color: #0f7be7;
        }

        .operation-links a:first-child {
            background-color: #ff5722;
        }

        .operation-links a:first-child:hover {
            background-color: #e64a19;
        }

    </style>
</head>
<body>
<div id="sidebar">
    <div id="systemName">
        笔记本电脑销售管理系统
    </div>
    <a href="index.jsp" onclick="changeActive(this)">首页</a>
    <a href="./list1" onclick="changeActive(this)" class="active">产品管理</a>
    <a href="login.html" style="margin-right: auto">退出账户</a>

</div>

<div id="wrap">
    <div id="content">
        <h1>产品管理</h1>
        <form action="searchProduct" method="POST">
            <input type="text" name="keyword" placeholder="输入电脑名进行搜索"/>
            <input type="submit" value="搜索"/>
        </form>

        <table class="table">
            <tr class="table_header">
                <th>电脑编号</th>
                <th>电脑名称</th>
                <th>电脑价格</th>
                <th>电脑品牌</th>
               <th>修改</th>
            </tr>

            <%
                List<Product> products = (List<Product>) request.getAttribute("products");
                //从request中取到数据,
  // 在Java代码块中声明一个名为 products 的 List 对象，并通过 request.getAttribute("products") 从请求对象中获取名为 "products" 的属性。
                for (Product p: products) {
            %><!-- 遍历products，将每个product对象的信息取出 -->
            <tr >
                <td><%= p.getId() %>
                </td>
                <td><%= p.getName() %>
                </td>
                <td><%= p.getPrice() %>
                </td>
                <td><%= p.getBrand() %>
                </td>

                <td class="operation-links">
                    <a href="del1?id=<%= p.getId() %>" onclick="return confirm('Confirm delete <%= p.getName() %> ?')">删除电脑</a>
                    <a href="load1?id=<%= p.getId() %>">修改电脑</a>
                </td>
            </tr>
            <% } %>
        </table>
        <p>
            <input type="button" class="button" value="添加电脑" onclick="location='addpro.html'"/>
        </p>
    </div>
</div>
<script>
    function changeActive(element) {
        // 该函数接受一个参数element，表示要设置为活动状态的元素。
        //简单的JavaScript脚本，实现了在侧边栏中切换活动状态的功能
        var sidebarLinks = document.querySelectorAll('#sidebar a');
        // 循环遍历所有的侧边栏链接元素
        for (var i = 0; i < sidebarLinks.length; i++) {
            // 移除 'active' 类
            sidebarLinks[i].classList.remove('active');
        }
        // 为传入的参数元素添加 'active' 类，突显其为当前选定状态
        element.classList.add('active');
    }
</script>
</body>
</html>
