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
    <title>表格</title>
</head>
<body>
<h2>表格</h2>
<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <h4>基本的表格</h4>
            <table class="table">
                <tr class="active">
                    <td>1</td>
                    <td>2</td>
                    <td>3</td>
                </tr>
                <tr>
                    <td>4</td>
                    <td>5</td>
                    <td>6</td>
                </tr>
                <tr>
                    <td>7</td>
                    <td>8</td>
                    <td>9</td>
                </tr>
                <tr>
                    <td class="active">将悬停的颜色应用在行或者单元格上</td>
                    <td class="success">表示成功的操作</td>
                    <td class="info">表示信息变化的操作</td>
                </tr>
                <tr>
                    <td class="warning">表示一个警告的操作</td>
                    <td class="danger">表示一个危险的操作</td>
                    <td>9</td>
                </tr>
            </table>
        </div>
    </div>
    <div class="row">
        <h4>在 tbody 内添加斑马线形式的条纹 ( IE8 不支持)</h4>
        <table class="table table-striped">
            <tr>
                <td>1</td>
                <td>2</td>
                <td>3</td>
            </tr>
            <tr>
                <td>4</td>
                <td>5</td>
                <td>6</td>
            </tr>
            <tr>
                <td>7</td>
                <td>8</td>
                <td>9</td>
            </tr>
        </table>
    </div>
    <div class="row">
        <h4> 为所有表格的单元格添加边框</h4>
        <table class="table table-bordered">
            <tr>
                <td>1</td>
                <td>2</td>
                <td>3</td>
            </tr>
            <tr>
                <td>4</td>
                <td>5</td>
                <td>6</td>
            </tr>
            <tr>
                <td>7</td>
                <td>8</td>
                <td>9</td>
            </tr>
        </table>
    </div>
    <div class="row">
        <h4>在 tbody 内的任一行启用鼠标悬停状态</h4>
        <table class="table table-hover">
            <tr>
                <td>1</td>
                <td>2</td>
                <td>3</td>
            </tr>
            <tr>
                <td>4</td>
                <td>5</td>
                <td>6</td>
            </tr>
            <tr>
                <td>7</td>
                <td>8</td>
                <td>9</td>
            </tr>
        </table>
    </div>
    <div class="row">
        <h4>让表格更加紧凑</h4>
        <table class="table table-condensed">
            <tr>
                <td>1</td>
                <td>2</td>
                <td>3</td>
            </tr>
            <tr>
                <td>4</td>
                <td>5</td>
                <td>6</td>
            </tr>
            <tr>
                <td>7</td>
                <td>8</td>
                <td>9</td>
            </tr>
        </table>
    </div>
    <div class="tow">
        <h4>下表中所列出的上下文类允许您改变表格行或单个单元格的背景颜色。</h4>
        <table class="table">
            <caption>上下文表格布局</caption>
            <thead>
            <tr>
                <th>产品</th>
                <th>付款日期</th>
                <th>状态</th>
            </tr>
            </thead>
            <tbody>
            <tr class="active">
                <td>产品1</td>
                <td>23/11/2013</td>
                <td>待发货</td>
            </tr>
            <tr class="success">
                <td>产品2</td>
                <td>10/11/2013</td>
                <td>发货中</td>
            </tr>
            <tr  class="warning">
                <td>产品3</td>
                <td>20/10/2013</td>
                <td>待确认</td>
            </tr>
            <tr  class="danger">
                <td>产品4</td>
                <td>20/10/2013</td>
                <td>已退货</td>
            </tr>
            </tbody>
        </table>
    </div>
    <div class="row">
        <h4>响应式表格</h4>
        <p>通过把任意的 .table 包在 .table-responsive class 内，您可以让表格水平滚动以适应小型设备（小于 768px）。当在大于 768px 宽的大型设备上查看时，您将看不到任何的差别。</p>
        <div class="table-responsive">
            <table class="table">
                <caption>响应式表格布局</caption>
                <thead>
                <tr>
                    <th>产品</th>
                    <th>付款日期</th>
                    <th>状态</th></tr>
                </thead>
                <tbody>
                <tr>
                    <td>产品1</td>
                    <td>23/11/2013</td>
                    <td>待发货</td></tr>
                <tr>
                    <td>产品2</td>
                    <td>10/11/2013</td>
                    <td>发货中</td></tr>
                <tr>
                    <td>产品3</td>
                    <td>20/10/2013</td>
                    <td>待确认</td></tr>
                <tr>
                    <td>产品4</td>
                    <td>20/10/2013</td>
                    <td>已退货</td></tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>