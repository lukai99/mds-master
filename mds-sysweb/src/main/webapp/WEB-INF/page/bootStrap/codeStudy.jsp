<%--
  Created by IntelliJ IDEA.
  User: T5S
  Date: 17-5-26
  Time: 上午7:08
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%--设置页面编码格式--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    <%--引入jstl表达式--%>
<%@ page isELIgnored="false" %>    <%--是否启用EL表达式--%>
<html>
<head>
    <jsp:include page="/common/publicTop.jsp"/>
    <title>代码</title>
</head>
<body>
<h2>代码</h2>
<p>Bootstrap 允许您以两种方式显示代码：
    第一种是  &lt;code&gt; 标签。如果您想要内联显示代码，那么您应该使用 &lt;code&gt; 标签。
        第二种是  &lt;pre&gt; 标签。如果代码需要被显示为一个独立的块元素或者代码有多行，那么您应该使用 &lt;pre&gt; 标签。
请确保当您使用  &lt;pre&gt;和  &lt;code&gt; 标签时，开始和结束标签使用了 unicode 变体： &lt; 和 &gt;。</p>
<div class="container" style="background-color: #dedef8; box-shadow:inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
    <p><code>&lt;header&gt;</code> 作为内联元素被包围。</p>
    <p>如果需要把代码显示为一个独立的块元素，请使用 &lt;pre&gt; 标签：</p>
    <pre>
        &lt;article&gt;
            &lt;h1&gt;Article Heading&lt;/h1&gt;
        &lt;/article&gt;
    </pre>
</div>
</body>
</html>