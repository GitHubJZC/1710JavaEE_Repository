
	$(document).ready(function(){
		firstPage();//显示第一页
	});
	function showSelect() {
		var totalPage = $("#totalPageInput").val();		
		var opt="<select id='mySelect'>";
		for(var i=1; i<=totalPage; i++) {
			opt += "<option value='"+i+"'>第"+i+"页</option>";
		}
		opt += "</select>";
		$("#myDiv2").html(opt);
	}
	function getStuByNowPage(nowPage) {
		$.ajax({
			type : "post", 
			url : "getStuByNowPage.do", 
			dataType : "json", 
			data : {nowPage:nowPage},
			success : function(stuList) {
				var inf = "<table class='table'><thead><tr><th>id</th><th>name</th><th>sex</th></tr></thead><tbody>";
				var stu;
				for(var i=0; i<stuList.length; i++) {
					stu = stuList[i];
					inf += "<tr><th>"+stu.id+"</th><th>"+stu.name+"</th><th>"+stu.sex+"</th></tr>";
				}
				inf += "</tbody></table>";
				$("#myDiv").html(inf);
				$("#mySpan").text(nowPage);
			},
			error : function(inf) {
				alert("失败eee");
			}
		});
	}



	function showStuByNowPage(nowPage) {
		var totalPage = $("#totalPageInput").val();//总页数
		if(nowPage==1) {//第一页
			closeFirstPageAndPreviousPage();//关闭首页和上一页
			recoverNextPageAndLastPage();//恢复下一页和末页
		}else if(nowPage>1 &&nowPage<totalPage) {//中间页
			recoverNextPageAndLastPage();//恢复下一页和末页
			recoverFirstPageAndPreviousPage();//恢复上一页和首页
		}else if(nowPage==totalPage) {//最后页
			closeNextPageAndLastPage();//关闭下一页和末页
			recoverFirstPageAndPreviousPage();//恢复首页上一页
		}
		//显示当前页
		getStuByNowPage(nowPage);
	}


	//<!-- 下一页 -->

	function nextPage() {
		var nowPage = parseInt($("#mySpan").text()) + 1;
		showStuByNowPage(nowPage);
	}

	//<!-- 上一页 -->

	function previousPage() {
		var nowPage = parseInt($("#mySpan").text()) - 1;
		showStuByNowPage(nowPage);
	}

//<!-- 首页 -->

	function firstPage() {
		var nowPage=1;
		showStuByNowPage(nowPage);
	}

//<!-- 末页 -->

	function lastPage() {
		var nowPage=$("#totalPageInput").val();//得到末页
		showStuByNowPage(nowPage); 
	}



	//<!-- 恢复下一页和末页 -->
	function recoverNextPageAndLastPage() {
		$("#nextPageA").attr("href","javascript:nextPage();");
		$("#nextPageA").css("opacity","1");
		$("#lastPageA").attr("href","javascript:lastPage();");
		$("#lastPageA").css("opacity","1");
	}
	//<!-- 关闭下一页和末页 -->
	function closeNextPageAndLastPage() {
		$("#nextPageA").attr("href","javascript:return false;");
		$("#nextPageA").css("opacity","0.5");
		$("#lastPageA").attr("href","javascript:return false;");
		$("#lastPageA").css("opacity","0.5");
	}
	//<!-- 恢复上一页和首页 -->
	function recoverFirstPageAndPreviousPage() {
		$("#firstPageA").attr("href","javascript:firstPage();");
		$("#firstPageA").css("opacity","1");
		$("#previousPageA").attr("href","javascript:previousPage();");
		$("#previousPageA").css("opacity","1");
	}
	//<!-- 关闭上一页和首页 -->
	function closeFirstPageAndPreviousPage() {
		$("#firstPageA").attr("href","javascript:return false;");
		$("#firstPageA").css("opacity","0.5");
		$("#previousPageA").attr("href","javascript:return false;");
		$("#previousPageA").css("opacity","0.5");
	}

	
