<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-cn">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
</head>

<body onload="judgeLoad('${requestScope.judgeLoad }')">
	<form method="post" action="" id="listform">
		<div class="panel admin-panel">
			<div class="panel-head">
				<strong class="icon-reorder"> 皮肤列表</strong>
			</div>
			<div class="padding border-bottom">
				<ul class="search" style="padding-left:10px;">
					<li>英雄选择</li>
					<li><select name="selValue" id="selValue" class="input"
						style="width:200px; line-height:17px;" onchange="selValueSearch()">
							<option value="">请选择英雄</option>
							<c:forEach var="emps" items="${requestScope.heroName }">
								<option value="${emps}">${emps}</option>
							</c:forEach>
					</select></li>
					<li><input type="text" placeholder="请输入搜索关键字" name="keywords"
						id="keywords" class="input"
						style="width:250px; line-height:17px;display:inline-block" /> <a
						href="javascript:void(0)" class="button border-main icon-search"
						onclick="changeSearch()"> 搜索</a></li>
				</ul>
			</div>
			<table class="table table-hover text-center">
				<tr>
					<th width="100" style="text-align:left; padding-left:20px;">ID</th>
					<th width="10%">英雄名</th>
					<th>皮肤名</th>
					<th>属性</th>
					<th width="10%">更新时间</th>
					<th width="310">操作</th>
				</tr>
				<volist name="list" id="vo">
				<!--进行所有英雄角色的判定--> <c:choose>
					<c:when test="${not empty requestScope.hsiList}">
						<c:forEach var="emp" items="${requestScope.hsiList }">
							<tr>
								<td style="text-align:left; padding-left:20px;"><input
									type="checkbox" name="id[]" value="" />1</td>
								<td>${emp.hero_Name }</td>
								<td>${emp.skip_Name }</td>
								<td><font color="#00CC99">${emp.load_Info }</font></td>
								<td>${emp.updata_Time }</td>
								<td>
									<div class="button-group">
										<a class="button border-main" onclick="return addSkip()"  href="SkipLoad_Servlet?skipName=${emp.skip_Name }&heroName=${emp.hero_Name }"><span
											class="icon-edit"></span> 加载</a> 
											<!-- <a class="button border-red"
											href="removeskip.html" onclick="return del('天天')"><span
											class="icon-trash-o"></span> 移除</a> -->
									</div>
								</td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="11">请输入正确的英雄选择</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</table>
		</div>
	</form>
	<script type="text/javascript">
		//通过用户输入的值进行搜索搜索
		function changeSearch() {
			var name = document.getElementById("keywords");
			window.location.href="SkipList_Servlet?flag=keys&value="+name.value;
		}
		//通过用户选择的英雄进行搜索
		function selValueSearch() {
			var name = document.getElementById("selValue");
			window.location.href="SkipList_Servlet?flag=name&value="+name.value;
		}
		function addSkip(){
			return true;
		}
		function del(args1) {
			if (args1 == "天天") {
				alert(args1);
			}
			return false;
		}
		function judgeLoad(str){
			if(str=="已安装"){
				alert("皮肤安装成功");
			}
		}
	</script>
</body>

</html>