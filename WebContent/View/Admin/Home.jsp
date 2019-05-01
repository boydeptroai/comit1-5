<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Kanji study </title>

    <!-- Bootstrap -->
    
    <link rel="stylesheet" type ="text/css"
     href="<c:url value='./Template/Admin/css/vendors/bootstrap/dist/css/bootstrap.min.css' />" />
    <!-- Font Awesome -->
    <link href="<c:url value='./Template/Admin/css/vendors/font-awesome/css/font-awesome.min.css'/>" type ="text/css"
     rel="stylesheet"/>
    
    <!-- NProgress -->
    <link href="<c:url value='./Template/Admin/css/vendors/nprogress/nprogress.css'/>" type ="text/css"
     rel="stylesheet"/>
    
    <script type="text/javascript" src="./Template/Admin/ckeditor/ckeditor.js"></script>
    
    <!-- Custom Theme Style -->
    <link href="<c:url value='./Template/Admin/css/build/css/custom.min.css'/>" type ="text/css"
     rel="stylesheet"/>
    
  </head>

  <body class="nav-md">
    <div class="container body">
      <div class="main_container">
      										<!--Begin-Menuleft -->
        
        <jsp:include page="MenuLeft.jsp"/>
        									<!-- End-Menuleft -->

       										<!--Begin header  -->
         <jsp:include page="HeaderAdmin.jsp"/> 
        									<!--End Header    -->

        
         <!-- page content -->
        <div class="right_col" role="main">
          <div class="">
             <div class="clearfix"></div> 
              <div class="row">  
              <a href="KanjiTopicController?service=getAll"> aaaa</a>  
                <!--    content -->                                    
              </div> 
          </div>
        </div>
        <!-- /page content -->

       										<!--Begin Footer  -->
         <jsp:include page="FooterAdmin.jsp"/> 
        									<!--End Footer  -->
      </div>		
    </div>

  
    <script src=" <c:url value='./Template/Admin/css/vendors/jquery/dist/jquery.min.js' />"></script>
    <script src=" <c:url value='./Template/Admin/css/vendors/bootstrap/dist/js/bootstrap.min.js' />"></script> 
    <script src=" <c:url value='./Template/Admin/css/vendors/fastclick/lib/fastclick.js' />"></script> 
    <script src=" <c:url value='./Template/Admin/css/vendors/nprogress/nprogress.js' />"></script> 
    <script src=" <c:url value='./Template/Admin/css/vendors/validator/validator.js' />"></script> 
    <script src=" <c:url value='./Template/Admin/css/build/js/custom.min.js' />"></script> 
  </body>
  
  
</html>