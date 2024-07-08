<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Fun Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
/**定义一个类名为"content"的样式content：**/
/**这是CSS选择器，表示该样式适用于具有"class='content'"的HTML元素**/

        .content {
            text-align: center;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
            animation: bounce 1s infinite alternate;
        }
/**这是关键帧动画的声明，表示将定义一个名为"bounce"的动画。transform向上移动10像素，向下移动10像素**/
        @keyframes bounce {
            from {
                transform: translateY(-10px);
            }
            to {
                transform: translateY(10px);
            }
        }
/**字体大小设置了元素底部的外边距为20像素**/
        .emoji {
            font-size: 48px;
            margin-bottom: 20px;
        }

        .message {
            font-size: 24px;
            color: #555;
        }
    </style>
</head>
<body>
<div class="content">
    <div class="emoji">😕</div>
    <a href="login.html">失败了，请重试</a>
</div>
</body>
</html>
