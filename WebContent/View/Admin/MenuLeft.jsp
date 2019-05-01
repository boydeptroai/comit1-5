<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="col-md-3 left_col">
          <div class="left_col scroll-view" id="fixscroll">
            <div class="navbar nav_title" style="border: 0;">
              <a href="#" class="site_title"><i class=""></i> <span>Hán tự Kanji</span></a>
            </div>

            <div class="clearfix"></div>

            <!-- menu profile quick info -->
            <div class="profile clearfix">
              <div class="profile_pic">
                <img src="../../Template/Admin/images/img.jpg" alt="..." class="img-circle profile_img">
              </div>
              <div class="profile_info">
                <span>Welcome,</span>
                <h2>John Doe</h2>
              </div>
            </div>
            <!-- /menu profile quick info -->

            <br />

            <!-- sidebar menu -->
            <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
              <div class="menu_section">
                <h3>General</h3>
                <ul class="nav side-menu">
                  <li><a href="Home.html"><i class="fa fa-home"></i> Home </a></li>
                  <li><a><i class="fa fa-edit"></i> Học Kanji <span class="fa fa-chevron-down"></span></a>
                  <ul class="nav child_menu">
                      <li><a href="KanjiTopicController?service=getAll">Chủ đề</a></li>
                      <li><a href="KanjiWordNewsController">Kanji mới</a></li>
                  </ul>
                  </li>
               
                  <li><a href="#"><i class="fa fa-desktop"></i> Ql Thanh vien </a></li>
                  
                  <li><a href="#"><i class="fa fa-table"></i> QL luyen tap </a>
                  <ul class="nav child_menu">
                      <li><a href="FlCardTopiController">Chủ đề</a></li>
                      <li><a href="FlashCardController">Flash Card</a></li>
                  </ul>
                  </li>
                  
                  <li><a href="#"><i class="fa fa-bar-chart-o"></i> QL test </a>
                  <ul class="nav child_menu">
                      <li><a href="">Chủ đề</a></li>
                      <li><a href="TestTopicController">Bai test</a></li>
                  </ul>
                  </li>
               
                </ul>
              </div>
              <div class="menu_section">
                
              </div>

            </div>
            <!-- /sidebar menu -->

            <!-- /menu footer buttons -->
            <div class="sidebar-footer hidden-small">
              <a  data-placement="" style="height: 35px;">
                <span class="" ></span>
              </a>
              <a data-toggle="" data-placement=""style="height: 35px;" >
               
              </a>
              <a data-toggle="tooltip" data-placement="top" style="height: 35px;">
                
              </a>
              <a data-toggle="tooltip" data-placement="top" style="height: 35px;">
                
              </a>
            </div>
            <!-- /menu footer buttons -->
          </div>
        </div>

</body>
<!-- jQuery -->
  <!--   <script src="../../Template/Admin/css/vendors/jquery/dist/jquery.min.js"></script>
    Bootstrap
    <script src="../../Template/Admin/css/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
    FastClick
    <script src="../../Template/Admin/css/vendors/fastclick/lib/fastclick.js"></script>
    NProgress
    <script src="../../Template/Admin/css/vendors/nprogress/nprogress.js"></script>
    validator
    <script src="../../Template/Admin/css/vendors/validator/validator.js"></script>

    Custom Theme Scripts
    <script src="../../Template/Admin/css/build/js/custom.min.js"></script>
 -->
</html>