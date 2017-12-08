<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">
	function getStuByNowPage() {
		alert("进入Ajax之前");
		//列出所有的班级
		$.ajax({
			type : "post", 
			url : "xxx.do", 
			dataType : "json", 
			data : {nowPage:1},
			success : function(map) {
				alert(map);
				 alert(map.pageInf.pages);//共多少页
				alert(map.pageInf.hasNextPage);//是否有下一页
				var list = map.list; 
			},
			error : function(inf) {
				alert("Ajax请求失败！");
			}
		});
	}
</script>
</head>
<body>
	<div class="container" style="padding:20px">
        <button class="btn btn-primary" data-toggle="button" onclick="getStuByNowPage();">请点击</button>
    </div>
<div class="container">
        <!-- 6. 状态表格-->
        <table class="table  table-bordered table-hover text-center" >
            <thead align="center">
                <tr>
                    <th >id</th>
                    <th>name</th>
                    <th>sex</th>
                    <th colspan="2">操作</th>
                </tr>
            </thead>
            <tbody >
                <tr class="active">
                    <td>zhang</td>
                    <td>san</td>
                    <td>张三</td>
                    <td>删除</td>
                    <td>修改</td>
                </tr>
                <tr class="success">
                    <td>li</td>
                    <td>shi</td>
                    <td>李四</td>
                    <td>删除</td>
                    <td>修改</td>
                </tr>
                <tr class="warning">
                    <td>wang</td>
                    <td>wu</td>
                    <td>王五</td>
                     <td>删除</td>
                    <td>修改</td>
                </tr>
                <tr class="danger">
                    <td>zhao</td>
                    <td>liu</td>
                    <td>赵六</td>
                     <td>删除</td>
                    <td>修改</td>
                </tr>
                <tr>
                    <td class="success">sheng</td>
                    <td class="warning">li</td>
                    <td class="danger">孙李</td>
                     <td>删除</td>
                     <td>修改</td>
                </tr>
            </tbody>
        </table>
    </div>
    
	<!-- <button onclick="getStuByNowPage();">点我</button> -->
</div>	
	<div id="mydiv">
	</div>
</body>
</html>









