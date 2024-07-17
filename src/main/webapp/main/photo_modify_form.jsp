<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- bootstrap 3 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- SweetAlert2사용설정  -->
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>

<style type="text/css">
  #box{
      width: 600px;
      margin: auto;
      margin-top: 50px;  
  }

  textarea {
	  width: 100%;
	  resize: none;
  }
  
  input[type='button']{
      width: 100px;
  }
  
  img{
      width: 200px;
  }

</style>


<script type="text/javascript">
   
   function send(f){
	   
	   //입력값 체크....
	   
	   /* 수정 할 내용 */
	   var name = f.name.value.trim();
	   var category = f.category.value.trim();
	   var min_player = f.min_player.value.trim();
	   var max_player = f.max_player.value.trim();
	   var playtime = f.playtime.value.trim();
	   var age = f.age.value.trim();
	   var year = f.year.value.trim();
	   var publisher = f.publisher.value.trim();
	   
	   if(name==''){
		   alert('게임 제목을 입력하세요');
		   f.name.value='';
		   f.name.focus();
		   return;
	   }
	   if(category==''){
		   alert('게임 장르를 입력하세요');
		   f.category.value='';
		   f.category.focus();
		   return;
	   }
	   if(min_player==''){
		   alert('최소 인원을 입력하세요');
		   f.min_player.value='';
		   f.min_player.focus();
		   return;
	   }
	   if(max_player==''){
		   alert('최대 인원을 입력하세요');
		   f.max_player.value='';
		   f.max_player.focus();
		   return;
	   }
	   if(playtime==''){
		   alert('플레이 시간을 입력하세요');
		   f.playtime.value='';
		   f.playtime.focus();
		   return;
	   }
	   if(age==''){
		   alert('연령을 입력하세요');
		   f.age.value='';
		   f.age.focus();
		   return;
	   }
	   if(year==''){
		   alert('출판년도를 입력하세요');
		   f.year.value='';
		   f.year.focus();
		   return;
	   }
	   if(publisher==''){
		   alert('출판사 입력하세요');
		   f.publisher.value='';
		   f.publisher.focus();
		   return;
	   }
	   
	   f.action = "modify.do"; //PhotoModifyAction
	   f.submit();
	   
   }
 
   /* Ajax 이용해 이미지 수정 과정  */
   function ajaxFileUpload() {
       // 업로드 버튼이 클릭되면 파일 찾기 창을 띄운다.
       $("#ajaxFile").click();		// id가 ajaxFile인 애를 클릭해라 
   }

   function ajaxFileChange() {
       // 파일이 선택되면 업로드를 진행한다.
       photo_upload();
   }

   function photo_upload() {

	   //파일선택->취소시    파일의 첫번쩨  없으면 함수 끝내라(취소하면 동작 실행하면 안되니까)
	   if( $("#ajaxFile")[0].files[0]==undefined)return;	 //[0]은 의미가 있는건X -> 문법적으로 필요
	
	   	   
	   var form = $("ajaxForm")[0];		// 폼에 대한 정보 얻어오기
	   
       var formData = new FormData(form);
       formData.append("game_idx", '${ vo.game_idx }');		//p_idx=5
       formData.append("photo", $("#ajaxFile")[0].files[0]);//photo=bmi.png

       $.ajax({
             url : "photo_upload.do", //PhotoUploadAction 만들기 -> 이미지 수정하기 위해 만드는 servlet
             type : "POST",
             data : formData,
             processData : false,
             contentType : false,
             dataType : 'json',
             success:function(res_data) {
            	 //res_data = {"p_filename":"aaa.jpb"}
                 
            	 //location.href=''; //자신의 페이지를 리로드(refresh)
            	 
            	 $("#my_img").attr("src","../images/" + res_data.img_filename);
            	 // $("#my_img").prop("src","../images/" + res_data.p_filename); <- 이거 써도 됨
            	 
             },
             error : function(err){
            	 alert(err.responseText);
             }
       });

   }
</script>



</head>
<body>

<!--파일업로드용 폼 -> 이게 못생겨서 기능은 얘가 하되 숨겨놓고 예쁜 버튼을 앞에 내세운 것이다-> 예쁜버튼= -->
<form enctype="multipart/form-data" id="ajaxForm" method="post">
    <input id="ajaxFile" type="file"  style="display:none;"  onChange="ajaxFileChange();" >
</form>

  
  
  
<form>

  <input type="hidden"  name="game_idx"  value="${ vo.game_idx }"> 

  <div id="box">
        <div class="panel panel-primary">
	      <div class="panel-heading"><h4>수정화면</h4></div>
	      <div class="panel-body">
	          <table class="table  table-striped">
	               <tr>
	                   <td colspan="2" align="center">
	                       <img src="../images/${ vo.img_filename }" id="my_img">
	                       <br>															<!-- 클릭하면 이 함수 호출 -->
	                       <input  class="btn  btn-info" type="button"  value="이미지편집"  onclick="ajaxFileUpload();">
	                       <!-- 과정 설명: 이미지편집 클릭-> ajaxFileUpload()호출->  $("#ajaxFile").click()에 의해 id가 ajaxFile인 애가 클릭됨->ajaxFileChange()에 의해  photo_upload 호출, 그 안의 내용 실행됨-->
	                   </td>
	               </tr>
	          
	               <tr>
	                  <th>제목</th>								  <!-- 기존 데이터 값 넣기 -->
	                  <td><input class="form-control" name="name"  value="${ vo.name }"></td>
	               </tr>
	               
	              <tr>
					<th>플레이 타임</th>
						<td>											 <!-- 기존 데이터 값 넣기 : textarea는 value 사용X -> 태그 사이에 넣어주기 -->
							<textarea class="form-control" name="playtime">${ vo.playtime }</textarea>
						</td>
				 </tr>
					<tr>
						<th>카테고리</th>
						<td>
							<textarea class="form-control" name="category" >${ vo.category }</textarea>
						</td>
					</tr>
					<tr>
						<th>최소 인원수</th>
						<td>
							<textarea class="form-control" name="min_player">${ vo.min_player }</textarea>
						</td>
					</tr>
					<tr>
						<th>최대 인원수</th>
						<td>
							<textarea class="form-control" name="max_player">${ vo.max_player }</textarea>
						</td>
					</tr>
					<tr>
						<th>연령</th>
						<td>
							<textarea class="form-control" name="age" >${ vo.age }</textarea>
						</td>
					</tr>
					<tr>
						<th>출시년도</th>
						<td>
							<textarea class="form-control" name="year">${ vo.year }</textarea>
						</td>
					</tr>
					<tr>
						<th>출판사</th>
						<td>
							<textarea class="form-control" name="publisher">${ vo.publisher }</textarea>
						</td>
					</tr>
	               
	               <tr>
	                   <td colspan="2" align="center">
	                       <input class="btn  btn-primary" type="button"  value="수정하기" 
	                              onclick="send(this.form);">
	                       <input class="btn  btn-success" type="button"  value="메인화면" 
	                              onclick="location.href='list.do'">
	                   </td>
	               </tr>
	               
	          </table>
	      </div>
	    </div>
  </div>
</form>


</body>
</html>