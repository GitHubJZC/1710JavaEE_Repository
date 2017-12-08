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
<script src="./js/stujs.js" ></script>
</head>
<body>
<div id="myDiv"></div>
	<ul class="pagination">
				<li>
					 <a id="firstPageA" href="javascript:return false;" style="opacity:0.5">首页</a>
				</li>
				<li>
					 <a id="previousPageA" href="javascript:return false;" style="opacity:0.5">上一页</a>
				</li>
				<li>
					 <a href="#">第<span id="mySpan">1</span>页</a>
				</li>
				<li>
					 <a id="nextPageA" href="javascript:nextPage();">下一页</a>
				</li>
				<li>
					 <a id="lastPageA" href="#">末页</a>
				</li>
	</ul>
	
	<div id="myDiv2"></div>
	总页数<input  id="totalPageInput" type="text" />
	<script type="text/javascript">
		//列出所有的班级
		$.ajax({
			type : "post", 
			url : "getTotalPage.do", 
			dataType : "text", 
			data : { },
			success : function(totalPage) {
				$("#totalPageInput").val(totalPage);
				showSelect($("#totalPageInput").val());
				
				$("select#mySelect").change(function(){
				    var nowPage = $(this).val();
				    showStuByNowPage(nowPage);
				});
			},
			error : function(inf) {
				alert("失败");
			}
		});
	</script>
</body>
</html>









