<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CommunityMain</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<!--부트스트랩-->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" ></script>

<!-- side_tap common -->
<link rel="stylesheet" href="/css/sideTab.css">

</head>


<body>


<div class="container">  
    <!-- 세로 탭 ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->
    <div class="d-flex align-items-start">
        <div class="nav flex-column nav-pills me-3" id="v-pills-tab" role="tablist" aria-orientation="vertical">
            <a href="#all-tab"><button class="nav-link active" id="v-pills-all-tab" data-bs-toggle="pill" data-bs-target="#v-pills-all" type="button" role="tab" aria-controls="v-pills-all" aria-selected="true">전체보기</button></a>
            <a href="#question-tab"><button class="nav-link " id="v-pills-question-tab" data-bs-toggle="pill" data-bs-target="#v-pills-question" type="button" role="tab" aria-controls="v-pills-question" aria-selected="false">궁금해요</button></a>
            <a href="#help-tab"><button class="nav-link" id="v-pills-help-tab" data-bs-toggle="pill" data-bs-target="#v-pills-help" type="button" role="tab" aria-controls="v-pills-help" aria-selected="false">도와주세요</button></a>
            <a href="#support-tab"><button class="nav-link" id="v-pills-support-tab" data-bs-toggle="pill" data-bs-target="#v-pills-support" type="button" role="tab" aria-controls="v-pills-support" aria-selected="false">도와드려요</button></a>
            <a href="#daily-tab"><button class="nav-link" id="v-pills-daily-tab" data-bs-toggle="pill" data-bs-target="#v-pills-daily" type="button" role="tab" aria-controls="v-pills-daily" aria-selected="false">일상</button></a>
        </div>

        
        <div class="tab-content" id="v-pills-tabContent" style="word-break:break-all; ">
            <!--전체보기 탭----------------------------------------------------------------->
            <div class="tab-pane fade show active" id="v-pills-all" role="tabpanel" aria-labelledby="v-pills-all-tab">
                <div class="row">
                    <div class="col-12">
                        전체보기
                    </div>

                </div>

            </div>

            <!--궁금해요 탭----------------------------------------------------------------->
            <div class="tab-pane fade" id="v-pills-question" role="tabpanel" aria-labelledby="v-pills-question-tab">궁금해요</div>

            <!--도와주세요 탭----------------------------------------------------------------->      
            <div class="tab-pane fade" id="v-pills-help" role="tabpanel" aria-labelledby="v-pills-help-tab">도와주세요</div>

            <!--도와드려요 탭----------------------------------------------------------------->
            <div class="tab-pane fade" id="v-pills-support" role="tabpanel" aria-labelledby="v-pills-support-tab">도와드려요</div>

            <!--일상 탭----------------------------------------------------------------->
            <div class="tab-pane fade" id="v-pills-daily" role="tabpanel" aria-labelledby="v-pills-daily-tab">일상</div>

        </div>

    </div>
    <!-------------------------------------------------------------------------------------------------------------------------세로 탭 -------------------------------------------------------->
</div>



<script>
  // window.location.href;
  // location.href;
  //  document.URL; 사이트 주소불러오는 방법들

  
  
  let siteUrl = window.location.href.split("#"); // #을 기준으로 사이트 주소를 나눠서 siteUrl  배열타입 변수에 저장   siteUrl[1]에 활성화 해야할 문자가 들어있음
  let tab1 = $("#v-pills-all-tab");
  let tab2 = $("#v-pills-question-tab");
  let tab3 = $("#v-pills-help-tab");
  let tab4 = $("#v-pills-support-tab");
  let tab5 = $("#v-pills-daily-tab");



  let tab1_contents = $("#v-pills-all");
  let tab2_contents = $("#v-pills-question");
  let tab3_contents = $("#v-pills-help");
  let tab4_contents = $("#v-pills-support");
  let tab5_contents = $("#v-pills-daily");

  if (siteUrl[1] == 'all-tab') {//전체보기 탭 활성화
    tab1.addClass('active');
    tab2.removeClass('active');
    tab3.removeClass('active');
    tab4.removeClass('active');
    tab5.removeClass('active');

    tab1_contents.addClass('show active');
    tab2_contents.removeClass('show active');
    tab3_contents.removeClass('show active');
    tab4_contents.removeClass('show active');
    tab5_contents.removeClass('show active');
  }
  else if (siteUrl[1] == 'question-tab') {//궁금해요 탭 활성화
    tab1.removeClass('active');
    tab2.addClass('active');
    tab3.removeClass('active');
    tab4.removeClass('active');
    tab5.removeClass('active');

    tab1_contents.removeClass('show active');
    tab2_contents.addClass('show active');
    tab3_contents.removeClass('show active');
    tab4_contents.removeClass('show active');
    tab5_contents.removeClass('show active');
  }
  else if (siteUrl[1] == 'help-tab') {//도와주세요 탭 활성화
    tab1.removeClass('active');
    tab2.removeClass('active');
    tab3.addClass('active');
    tab4.removeClass('active');
    tab5.removeClass('active');

    tab1_contents.removeClass('show active');
    tab2_contents.removeClass('show active');
    tab3_contents.addClass('show active');
    tab4_contents.removeClass('show active');
    tab5_contents.removeClass('show active');
  }
  else if (siteUrl[1] == 'support-tab') {//도와드려요 탭 활성화
    tab1.removeClass('active');
    tab2.removeClass('active');
    tab3.removeClass('active');
    tab4.addClass('active');
    tab5.removeClass('active');

    tab1_contents.removeClass('show active');
    tab2_contents.removeClass('show active');
    tab3_contents.removeClass('show active');
    tab4_contents.addClass('show active');
    tab5_contents.removeClass('show active');
  }
  else if (siteUrl[1] == 'daily-tab') {//일상 탭 활성화
    tab1.removeClass('active');
    tab2.removeClass('active');
    tab3.removeClass('active');
    tab4.removeClass('active');
    tab5.addClass('active');

    tab1_contents.removeClass('show active');
    tab2_contents.removeClass('show active');
    tab3_contents.removeClass('show active');
    tab4_contents.removeClass('show active');
    tab5_contents.addClass('show active');
  }

  // 부트스트랩 탭메뉴 버그 방지  
  tab1.on('click',function(){
    tab2.removeClass('active');
    tab3.removeClass('active');
    tab4.removeClass('active');
    tab5.removeClass('active');
  })
  tab2.on('click',function(){
    tab1.removeClass('active');
    tab3.removeClass('active');
    tab4.removeClass('active');
    tab5.removeClass('active');
  })
  tab3.on('click',function(){
    tab1.removeClass('active');
    tab2.removeClass('active');
    tab4.removeClass('active');
    tab5.removeClass('active');
  })
  tab4.on('click',function(){
    tab1.removeClass('active');
    tab2.removeClass('active');
    tab3.removeClass('active');
    tab5.removeClass('active');
  })
  tab5.on('click',function(){
    tab1.removeClass('active');
    tab2.removeClass('active');
    tab3.removeClass('active');
    tab4.removeClass('active');
  })
</script>
</body>

</html>