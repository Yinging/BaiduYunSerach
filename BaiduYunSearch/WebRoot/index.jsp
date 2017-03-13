<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>百度云盘搜索</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
</head>

<body onload="changeSelect()">
	<form method="post" action="" id="listform">
		<div class="panel admin-panel">
			<div class="panel-head">
				<strong class="icon-reorder"> <a href="index.jsp">百度云盘搜索</a></strong> 
			</div>
			<div class="padding border-bottom">
				<ul class="search" style="padding-left:10px;">
					<li>类型： <select name="b_Type" class="input" id="b_Type"
						onchange="changesearch()"
						style="width:120px; line-height:17px; display:inline-block">
							<option value="all" id="all">全部</option>
							<option value="sp" id="sp">视频</option>
							<option value="tp" id="tp">图片</option>
							<option value="yy" id="yy">音乐</option>
							<option value="wd" id="wd">文档</option>
							<option value="zz" id="zz">种子</option>
							<option value="apk" id="apk">APK</option>
							<option value="ios">IOS</option>
							<option value="rar">压缩包</option>
							<option value="fd">文件夹</option>
					</select>
					</li>
					<li><input type="text" placeholder="请输入搜索关键字" name="keywords"
						id="keywords" class="input"
						style="width:250px; line-height:17px;display:inline-block"
						value="${requestScope.keyWords}" onkeydown="searchEnter(event)" />
						<a href="javascript:void(0)"
						class="button border-main icon-search" onclick="changeSearch()">
							搜索</a> <input type="text" placeholder="请输入搜索关键字" name="keywords"
						id="keywords" class="input"
						style="width:250px; line-height:17px;display:inline-block;visibility:hidden"
						value="${requestScope.keyWords}" onkeydown="searchEnter(event)" />
					</li>
				</ul>
			</div>
			<div>
				<div style="float:left;width: 78%;">
					<table class="table table-hover text-center">
						<tr>共查询到：${fn:length(requestScope.searchList)}条数据</tr>
						<tr>
							<th style="text-align:left;width: 60%;">分享文件</th>
							<th style="width: 30%;">分享时间</th>
						</tr>
						<volist name="list" id="vo"> <!--对结果进行遍历--> <c:choose>
							<c:when test="${not empty requestScope.searchList}">
								<c:forEach var="emp" items="${requestScope.searchList }">
									<tr>
										<td style="text-align:left;"><a href="PanServlet?searchURL=${emp.searchURL }" target="_blank">${emp.searchStr }</a></td>
										<td>${emp.searchTime }</td>
									</tr>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<tr>
									<td colspan="11">未检索到信息</td>
								</tr>
							</c:otherwise>
						</c:choose>
					</table>
				</div>
				<div style="float:left;width: 22%;">
					<iframe width="100%" height="620" class="share_self" frameborder="0"
						scrolling="no"
						src="http://widget.weibo.com/weiboshow/index.php?language=&width=260&height=720&fansRow=2&ptype=1&speed=0&skin=1&isTitle=1&noborder=1&isWeibo=1&isFans=0&uid=5357487548&verifier=747e40f9&dpc=1"></iframe>
				</div>
			</div>
		</div>
	</form>
	<script type="text/javascript">
		//通过用户输入的值进行搜索搜索
		function changeSearch() {
			var strType = document.getElementById("b_Type");
			var keyWords = document.getElementById("keywords");
			if (keyWords.value == "") {
				alert("请输入关键字");
			} else {
				window.location.href = "SearchServlet?type=" + strType.value
						+ "&keywords=" + keyWords.value;
			}
		}
		function changeSelect() {
			var type = document.getElementById("b_Type");
			if ("${requestScope.type}" == "") {
				type.value = "all";
			} else {
				type.value = "${requestScope.type}";
			}
		}
		function searchEnter(e) {
			if (e.keyCode == 13) {
				var strType = document.getElementById("b_Type");
				var keyWords = document.getElementById("keywords");
				if (keyWords.value == "") {
					alert("请输入关键字");
				} else {
					window.location.href = "SearchServlet?type="
							+ strType.value + "&keywords=" + keyWords.value;
				}

			}
		}
	</script>
</body>

</html>