<%@page import="Entity.KanjiTopic"%>
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

    <title>Kanji study</title>
    <%-- 
 <link rel="stylesheet" type ="text/css"
     href="<c:url value='./Template/Admin/css/vendors/bootstrap/dist/css/bootstrap.min.css' />" />  --%>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <!-- Font Awesome -->
    <link href="<c:url value='./Template/Admin/css/vendors/font-awesome/css/font-awesome.min.css'/>" type="text/css"
        rel="stylesheet" />

    <!-- NProgress -->
    <link href="<c:url value='./Template/Admin/css/vendors/nprogress/nprogress.css'/>" type="text/css"
        rel="stylesheet" />

    <script type="text/javascript" src="./Template/Admin/ckeditor/ckeditor.js"></script>

    <!-- Custom Theme Style -->
    <link href="<c:url value='./Template/Admin/css/build/css/custom.min.css'/>" type="text/css" rel="stylesheet" />


    <link rel="stylesheet" href="./Template/Admin/List/css/font-awesome.min.css">
    <link rel="stylesheet" href="./Template/Admin/List/css/main.css">
    <link rel="stylesheet" href="./Template/Admin/List/style.css">
    <link rel="stylesheet" href="./Template/Admin/List/css/responsive.css">

    <!-- Pagiation -->

    <script src="./Template/Admin/Pagination/jquery.twbsPagination.js" type="text/javascript"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="./Template/Admin/css/vendors/jquery/dist/jquery.min.js"></script>

</head>

<body class="nav-md">
    <div class="container body">
        <div class="main_container">
            <!--Begin-Menuleft -->
            <jsp:include page="../MenuLeft.jsp" />
            <!-- End-Menuleft -->
            <!--Begin header  -->
            <jsp:include page="../HeaderAdmin.jsp" />
            <!--End Header    -->
            <!-- page content -->
            <div class="right_col" role="main">
                <div class="">
                    <div class="page-title">
                        <div class="title_left">
                            <h3>
                                Kanji<small> Just add class <strong>footer_fixed</strong></small>
                            </h3>
                        </div>
                    </div>
                    <div class="clearfix"></div>
                    <div class="row">
                        <!--   Begin content -->
                        <div class="product-status mg-tb-15">
                            <div class="container-fluid">
                                <div class="row">
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                        <div class="product-status-wrap">
                                            <h4>Kanji mới</h4>			
                                            </br>                        
                                            <form action="topicControll" method="get">
                                                <input type="hidden" name="pageid" value="1"> Số bản
                                                ghi: <input type="text" name="row" required="required"
                                                    style="height: 27px;"> <input type="submit" value="ok"> <input
                                                    type="hidden" name="service" value="viewpage" />
                                            </form>
                                             <button class="btn btn-primary " style="margin-left: 90%;" type="button"
                                                data-toggle="modal" data-target="#myModal">
                                                Thêm</button> 
                                              
                                            <div class="x_content">
                                                <%=request.getAttribute("id") != null ? request.getAttribute("id") : ""%>
                                                
                                                <form action="KanjiTopicController" method="post" >
                                                    <table id="datatable-checkbox"
                                                        class="table table-striped table-bordered bulk_action">
                                                        <tr>
                                                            <th><input type="checkbox" id="check-all" class="flat"
                                                                    style="width: 25px; height: 25px;"></th>
                                                            <th>ID ảnh</th>
                                                            <th>Ảnh từ mới</th>
                                                            <th>Ảnh ý nghĩa </th>
                                                            <th>Tên </th>
                                                            <th>Chỉnh sửa</th>
                                                        </tr>
                                                        <c:forEach items="${kjTopic.resultList}" var="list">
                                                            <tr>
                                                                <td><input type="checkbox" id="check-all" class="flat"
                                                                        name="checked"
                                                                        value="${list.topic_id}"
                                                                        style="width: 20px; height: 20px;"></td>

                                                                <td>${list.topic_id}</td>
                                                                <td>${list.topic_name}</td>
                                                                <td><img alt="" src="./imagetopic/${list.topic_img}">
                                                                </td>
                                                                <td>${list.topic_guide}</td>

                                                                <td><a href="KanjiTopicController?topicid=${list.topic_id}&service=deleteone&maxPageItem=${kjTopic.maxPageItem}&page=${kjTopic.page}"
                                                                        class="fa fa-trash-o" aria-hidden="true"
                                                                        title="Trash"
                                                                        onclick="return(confirm('Vui lòng xác nhận'))"
                                                                        style="width: 40%; height: 40px; line-height: 40px; left: 20px;"></a>

                                                                    <a href="KanjiTopicController?topicid=${list.topic_id}&service=edit&maxPageItem=${kjTopic.maxPageItem}&page=${kjTopic.page}"
                                                                        class="fa fa-pencil-square-o" aria-hidden="true"
                                                                        title="Edit"
                                                                        style="width: 45%; height: 40px; line-height: 40px;"
                                                                        id="edit1"></a>
                                                                </td>
                                                            </tr>
                                                        </c:forEach>
                                                    </table>
                                                    <input type="hidden" name="service" value="deletegrouptopic" />
                                                    <input type="hidden" value=""  name="page" class="page" id="demo"/>
                                                    <input type="hidden" value="" id="maxPageItems" name="maxPageItem" />
                                                    
                                                    <input type="submit" value="DELETE" />
                                                </form>
                                            </div>
                                            <!-- phantrang -->
                                            <form action="KanjiTopicController" method="get" id="getItem">
                                                <%=request.getAttribute("kjTopic")%>
                                                <ul class="pagination" id="pagination"></ul>
                                                <input type="hidden" value="" id="page" name="page" class="pages"/>
                                                <input type="hidden" value="" id="maxPageItem" name="maxPageItem" class="maxPageItems" />
                                            </form>
                                            <!-- endphantrang -->
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!--End content  -->
                    </div>
                </div>
                <!-- Modal insert -->
                <div class="modal fade" id="myModal" role="dialog" id="modal">
                    <div class="modal-dialog modal-lg">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                <h4 class="modal-title">Modal Header</h4>
                                
                            </div>
                            <form action="UpLoadImg" method="post" enctype="multipart/form-data" class="form-horizontal"
                                style="margin-top: 20px;">
                                <div class="row form-group">
										<div class="col col-md-3">
											<label for="text-input" class=" form-control-label">Chuyên
												mục</label>
										</div>
										<div class="col-12 col-md-9">
											<select name="select" id="select" class="form-control">
												<option value="0">Please select</option>
												<option value="1">Option #1</option>
												<option value="2">Option #2</option>
												<option value="3">Option #3</option>
											</select>
										</div>
									</div>
                                <div class="row form-group" style="margin-top: 30px;">
                                    <div class="col col-md-3">
                                        <label for="file-input" class=" form-control-label">Chọn File</label>
                                    </div>
                                    <div class="col-12 col-md-9">
                                        <input type="file" id="file-input" name="nameimg"
                                            class="form-control-file" />
                                    </div>
                                </div>
                               
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                    <button type="submit" class="btn btn-primary btn-sm" id="save">
                                        Thêm mới</button>
                                        <input type="hidden" name="service" value="addnew"/>
                                        <input type="hidden" value="khong"  name="idtopic" />
                                        <input type="hidden" value=""  name="page" class="pages" "/>
                                        <input type="hidden" value=""  name="maxPageItem" class="maxPageItems" />                             
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                
                <!-- Modal update -->
                <div class="modal fade" role="dialog" id="modaledit">
                    <div class="modal-dialog modal-lg">
                        <div class="modal-content">
                            <div class="modal-header">  
                                <h4 class="modal-title">Modal Header</h4>
							<p style="visibility: hidden" id="test"><%=session.getAttribute("kjTopicEdit") %></p>	
                            </div>
                            <form action="UpLoadImg" method="post" enctype="multipart/form-data" class="form-horizontal"
                                style="margin-top: 20px;">
                                <div class="row form-group" style="margin-top: 20px;">
                                    <div class="col col-md-3">
                                        <label for="text-input" class=" form-control-label">Tiêu
                                            đề bài viết</label>
                                    </div>
                                    <div class="col-12 col-md-9">
                                        <input type="title" id="title" name="title"
                                            placeholder="Tên tiêu đề" class="form-control" value="${kjTopicEdit.getTopic_name()}"/>
                                    </div>
                                </div>
                                <div class="row form-group" style="margin-top: 30px;">
                                    <div class="col col-md-3">
                                        <label for="file-input" class=" form-control-label">File
                                            ảnh</label>
                                    </div>
                                    <div class="col-12 col-md-9">
                                        <input type="file" id="file-input" name="nameimg"
                                            class="form-control-file" />
                                    </div>
                                </div>
                                <div class="row form-group" style="margin-top: 30px;">
                                    <div class="col col-md-3">
                                        <label for="file-input" class=" form-control-label">Nội
                                            dung</label>
                                    </div>
                                    <div class="col-12 col-md-9">
                                        <div class="form-group">
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <td><textarea class="ckeditor" name="content" cols="80"
                                                            rows="10">${kjTopicEdit.getTopic_guide()}</textarea>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <a href="KanjiTopicController?service=clearSession&maxPageItem=${kjTopic.maxPageItem}&page=${kjTopic.page}"class="btn btn-default"  >Dong</a>
                                    <button type="submit" class="btn btn-primary btn-sm" class="edit">
                                        Cap Nhap</button>
                                        <input type="hidden" name="service" value="edit"/>
                                        <input type="hidden" value="${kjTopicEdit.getTopic_id()}"  name="idtopic" id="id"/>
                                        <input type="hidden" value=""  name="page" class="pages" />
                                        <input type="hidden" value=""  name="maxPageItem" class="maxPageItems" />
                                        
                                </div>
                            </form>
                        </div>
                    </div>
                </div>

            </div>
            <!-- /page content -->

            <!-- /page content -->

            <!--Begin Footer  -->
            <jsp:include page="../FooterAdmin.jsp" />
            <!--End Footer  -->
        </div>
    </div>

    <script type="text/javascript">
        var currentPage = ${ kjTopic.page};
        
        var totalPages = ${ kjTopic.totalPage };
        var limit = 3;
        $('.pages').val(currentPage);
        $('.maxPageItems').val(limit);
        $(function () {
            window.pagObj = $('#pagination').twbsPagination({
                totalPages: totalPages,
                visiblePages: 3,
                startPage: currentPage,
                onPageClick: function (event, page) {
                    if (currentPage != page) {
                        $('#maxPageItem').val(limit);
                        $('#page').val(page);
                        $('#getItem').submit();
                    }
                }
            });
        });
        
        $('#save').submit(function (e) {
            e.preventDefault();
            // submission stuff
            $('#modal').modal('hide');
            return false;
        });
        $('#edit').submit(function (e) {
            e.preventDefault();
            // submission stuff
            $('#modal').modal('hide');
            return false;
        });
var id=$('#id').val();
console.log('id la: '+id);
  		var dataold= $('#test').text();
         $(document).ready(function(){
     		var test= $('#test').text();
     		console.log('test: '+test);
     		 if(test != 'null'){
     			console.log('check null');
                 $('#modaledit').modal('show'); 


     		} else{
     			console.log('check not null');	

     		}
              
          });
        
        
      	
    </script>

</body>
<!-- jQuery -->
<script src="./Template/Admin/css/vendors/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="./Template/Admin/css/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- FastClick -->
<script src="./Template/Admin/css/vendors/fastclick/lib/fastclick.js"></script>
<!-- NProgress -->
<script src="./Template/Admin/css/vendors/nprogress/nprogress.js"></script>
<!-- validator -->
<script src="./Template/Admin/css/vendors/validator/validator.js"></script>
<script src="./Template/Admin/Pagination/jquery.twbsPagination.js" type="text/javascript"></script>

<!-- Custom Theme Scripts -->
<script src="./Template/Admin/css/build/js/custom.min.js"></script>

</html>