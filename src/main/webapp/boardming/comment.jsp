<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="image/favicon.ico" type="image/x-icon">
<title>우리들의 보드게임 세상 보드밍</title>
  <link rel="stylesheet" href="../css/comment.css">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<!-- slick  -->
<script src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script> 
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css" />
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick-theme.css" />
<script type="text/javascript">  

$(document).ready(function() {
    // quickmenu의 이미지의 top 위치가 얼마인지 담기
    var top = parseInt($("#quickmenu img").css("top"));
    //console.log(top);
    
    // 상단 메인 메뉴 관리
    $("li.mainmenu ul").hide(); // 하위메뉴 숨기기
    $("li.mainmenu").hover(function(){
        $("ul",this).slideDown(300);
    }, function(){
        $("ul",this).slideUp(300);
    });
    
	// 카테고리 박스 함수
    $("li#header-category ul").hide(); // 하위메뉴 숨기기
   
   $("li#header-category").hover(function(){
       $("ul",this).show(0);
   }, function(){
       $("ul",this).hide(0);
   }); 
});

</script>

<script type="text/javascript">
function imgChange(img) {
    document.getElementById('a1').src = img.src;
}

</script>

<script type="text/javascript">



	// 댓글 달기전 로그인 확인
	function comment_insert(f){
		
			
		//로그인 여부 체크 (로그인이 안되어 있으면)
		if ("${ empty user }" == "true") { // session으로 검색
				
			if (confirm("댓글 작성은 로그인 후 이용 가능합니다. \n로그인 하시겠습니까?") == false) { //아니요 누르면 종료
				return;
			}
			//로그인폼 이동
			location.href="../member/login_form.do"; 
			
			return;
		}
			//로그인이 된 경우 -> 게시판 작성 이동
			//location.href="postlist.do;
			
		if(alert("댓글을 등록 하시겠습니까?") == false) return;	
		
			
		f.action = "commentinsert.do";
		f.submit();
			//c_idx=&mem_idx=&mem_nickname=&cmt_comment=
	}
	
</script>

<script type="text/javascript">

	function comment_showupdate(f){

		const comment = f.cmt_idx;
		
		let cmt_comment =  $("#cmt-comment"+f.cmt_idx.value);
		let comment_text = cmt_comment.text();
		
		console.log(cmt_comment.text());
		// p태그 ""주기
		$("#cmt-comment"+f.cmt_idx.value).text("");
		// p태그 밑에 input태그 추가
		cmt_comment.append($("<div class='update-box'><input type='text' class='update-text' name='cmt_content' id='cmt_up' value='"+comment_text+"'></div>"));
		
		
		cmt_comment.append($("<div class='comment-btn'><button id='update_cmt_btn' class='btn btn-insert'>수정하기</button></div>"));
		
		$("#update_cmt_btn").click(function() {
			
			f.action="commentupdate.do";
			f.submit();
		});
	}
	
</script>
	

<script type="text/javascript">

	function comment_del(f){
		
		let cmt_idx = f.cmt_idx.value;
		console.log(cmt_idx);
		
		if (confirm("정말 삭제 하시겠습니까?") == false) {
			return;
		}
		
		f.action = "commentdelete.do";
		f.submit();
		
	}

</script>	
	
	
	
	


</head>
<body>

	
	<!-- Content 부분 (상세, 서브 페이지 내용 넣기) -->
	
	<div class="img-box">
		<img class="commu-img" src="../boardming/image/ming1.png">
	</div>
	
	
    
    <div class="commu-box">
	<div class="c-btn">
		<input type="button" class="btn" value="목록으로 이동" onclick="location.href='sublist.do'">
	</div>
      <div class="t-box">
        <table class="t-commu">
            <tr>
                <th>제목</th>
                <td colspan="3">${ commu.c_title }</td>
                
                <th>카테고리</th>
                <td>${ commu.c_category }</td>
            </tr>
            
            <tr>
                <th>작성자</th>
                <td>${ commu.mem_nickname }</td>
                
                <th>등록일</th>
                <td >${ fn:substring(commu.c_regdate,0,16) }</td>
                
                <th>조회수</th>
                <td>${ commu.c_inCount }</td>
            </tr>
            
            <tr>
                <th class="content-con">내용</th>
                <td colspan="6" class="content-cell">${ commu.c_content }</td>
            </tr>
        </table>
        </div>
      <div>
      <!----------------------------------------------------------------------------------->
    	  
    	<div class="comment-list">
    		<div class="c-div">댓글목록</div>
    	</div>
    	<c:forEach var="vo" items="${ requestScope.commentList }">
        <div class="comments">
				    	  
          <div class="comment-update">
        	<span class="comment-reply">${ vo.mem_nickname}</span>
        	<span class="comment-reply">&nbsp; │ &nbsp;</span>
        	<span class="comment-date">${ fn:substring(vo.cmt_regdate,0,16) }</span>
          </div>
          <form>
            <p class="comment-content" id="cmt-comment${ vo.cmt_idx }">${ vo.cmt_content }</p>
	         <div class="c-btn">
	         <c:if test="${ user.mem_idx eq vo.mem_idx }">
		        <input type="hidden" name="cmt_idx" value="${ vo.cmt_idx }">
		        <input type="hidden" name="c_idx" value="${ commu.c_idx }">
   				<input type="button" class="btn btn-insert" value="수정" onclick="comment_showupdate(this.form)">
   		  </form>
		   		  
		   		  <form>
		   		  		<input type="hidden" name="cmt_idx" value="${ vo.cmt_idx }">
				        <input type="hidden" name="c_idx" value="${ commu.c_idx }">
		   			 <input type="button" class="btn btn-del" value="삭제" onclick="comment_del(this.form)">
	         </c:if>
		    	  </form>
	    	  </div>
    	  
        </div>
        </c:forEach>

      <!----------------------------------------------------------------------------------->
        
        <form class="fo">
      		  <input type="hidden" name="c_idx" value="${ commu.c_idx }">
      		  <input type="hidden" name="mem_idx" value="${ user.mem_idx }">
      		  <input type="hidden" name="mem_nickname" value="${ user.mem_nickname }">
        <div class="comment-input">
            <textarea placeholder="댓글을 입력하세요" name="cmt_content"></textarea>
        </div>
        <div class="comment-btn">
            <button onclick="comment_insert(this.form); return false;">댓글등록</button>
     	</div>
     	</form>
     </div>
   </div>
  	
	
	
	<!-- footer start -->
    <div id="footer">
    	<div class="footer1">
	        <span><br>&nbsp;&nbsp;&emsp;&emsp;<a href="header2.html">
	                <img id="footerlogo" src="image/logo.png">
	            </a><br></span>
	        <span>&emsp;&emsp;&emsp;&nbsp;<a href="#">커뮤니티 규칙</a>&emsp; | &emsp;
	        							  <a href="#">서비스 약관/정책</a>&emsp;  |&emsp;
	        							  <a href="#">개인정보취급방침</a>&emsp;  |&emsp; 
	        							  <a href="#">청소년보호정책</a>&emsp;  |&emsp;
	        							  <a href="#">공지사항</a>&emsp;  |  &emsp;
	        							  <a href="#">광고센터</a><br></span>
	        <span>&emsp;&emsp;&emsp;&nbsp;회사명 : 보드밍&ensp; |&ensp;
	         서울특별시 관악구 남부순환로 1820, 에그옐로우 7층&ensp; | &ensp;
	         등록번호 : 123-45-67890&ensp; | &ensp;
	         대표자명 : 박정환&ensp; |&ensp;
	         고개지원 : klkcpc@globalit.com<br></span>
	        <span>&emsp;&emsp;&emsp;&nbsp;위 내용에 대한 저작권 및 법적 책임은 자료제공사 또는 글쓴이에 있으며 보드밍의 입장과 다를 수 있습니다.<br></span>
	        <span>&emsp;&emsp;&emsp;&nbsp;ⓒ BOARDMING. ALL RIGHTS RESERVED.</span>
        </div>
        <div class="footer2">
        	<span><br><br><br>TEL : 02-123-4567<br></span>
        	<span>AM 09:30 ~ PM 06:20<br></span>
        	<span>주말, 공휴일 휴무<br></span>
        </div>
    </div>
    <!-- footer end -->
</body>
</html>