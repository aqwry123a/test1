<%@ page import="cn.javaweb.computer.entity.UserEntity.Emp" %>
<%@page pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<html>
<head>
    <title>Update Emp</title>
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

        .inputgri {
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
    Emp emp = (Emp) request.getAttribute("emp");
%>
<body>
<div id="wrap">
    <div id="content">
        <h1>修改用户</h1>
        <form action="update" method="post">
            <table class="form_table">
                <tr>
                    <td class="field-label">id:</td>
                    <td class="field-input"><%=emp.getId()%><input type="hidden" name="id" value="<%=emp.getId()%>"/>
                    </td>
                </tr>
                <tr>
                    <td class="field-label">姓名</td>
                    <td class="field-input"><input type="text" class="inputgri" name="name" value="<%=emp.getName()%>"/>
                    </td>
                </tr>
                <tr>
                    <td class="field-label">余额</td>
                    <td class="field-input"><input type="text" class="inputgri" name="salary"
                                                   value="<%=emp.getSalary()%>"/></td>
                </tr>
                <tr>
                    <td class="field-label">职位</td>
                    <td class="field-input"><input type="text" class="inputgri" name="job" value="<%=emp.getJob()%>"/>
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
