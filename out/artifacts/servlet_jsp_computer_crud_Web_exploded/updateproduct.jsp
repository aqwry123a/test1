
<%@ page import="cn.javaweb.computer.entity.ProEntity.Product" %>
<%@page pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<html>
<head>
    <title>Update Product</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
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

        .form_table {
            width: 100%;
        }

        .form_table tr td {
            padding: 10px;
        }

        inputgri {
            padding: 8px;
            border: 1px solid #ccc;
            width: 100%;
            border-radius: 5px;
            box-sizing: border-box;
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

        h1 {
            font-size: 24px;
            margin-top: 0; /* 去除标题的默认顶部边距 */
        }

        #title a {
            text-decoration: none;
            color: #333;
        }

        .field-label {
            text-align: right;
        }

        .field-input {
            text-align: left;
        }
    </style>
</head>
<%
    Product product = (Product) request.getAttribute("product");
%>
<!-- 从请求中获取名为"product"的属性值，并将其转换为Product对象-->
<body>
<div id="wrap">
    <div id="content">
        <h1>修改产品</h1>
        <form action="updateProduct" method="post">
            <table class="form_table">
                <tr>
                    <td class="field-label">id:</td>
                    <td class="field-input">
                        <input type="text" name="id" value="<%=product.getId()%>"/>
                    </td>
                </tr>
                <tr>
                    <td class="field-label">名字</td>
                    <td class="field-input"><input type="text"  class="inputgri" name="name"/></td>
                </tr>
               <tr>
                    <td class="field-label">品牌</td>
                    <td class="field-input"><input type="text" name="brand" />
                    </td>
                </tr>
                <tr>
                    <td class="field-label">价格</td>
                    <td class="field-input"><input type="text" name="price" />
                    </td>
                </tr>
            </table>
            <p>
                <input type="submit" class="button" value="提交"/>
            </p>
        </form>
    </div>
</div>
</body>
</html>
