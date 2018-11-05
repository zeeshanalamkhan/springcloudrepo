<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Insert title here</title>
<jsp:include page="hospital/hospBodyHeader.jsp"></jsp:include>
</head>
<script type="text/javascript">
  function deleteHosp(id){
	  alert(id);
	  alert("do you wants to delete the Hospital "+id);
	  var protocol = window.location.protocol;
	  var host = window.location.hostname;
	  var port=window.location.port;
	  var url = protocol+"://"+host+":"+port+"/hospital/deleteHosp/"+id;
	  alert(url);
	  
	 /*  document.forms[0].action="/hospital/deleteHosp/"+id;
	  document.forms[0].submit(); */
	  
	 // document.forms[0].submit=url;
	 window.location=url;
	 return false;
  }

</script>
<body>
	<!-- <section>
	<div class="card">
 	<h5 class="card-header">Hospitals List</h5>
    <a href="#" class="btn btn-primary">Add Hospital</a> | 
    <a href="#" class="btn btn-primary">Search Hospital</a>
  </div>
</section> -->
	

	<section class="container">

	<div class="row">
		<c:forEach items="${hospList}" var="hospBean">
			<div class="col-sm-6 col-md-4">
				<div class="thumbnail">
					<img alt="" src="" />
					<div class="caption">
						<p>Name:</p>
						<h1>${hospBean.name}</h1>
						<p>Email:</p>
						<h6>${hospBean.email}</h6>
						<p>Fax:</p>
						<h6>${hospBean.fax}</h6>
						<p>Phone:</p>
						<h6>${hospBean.phone}</h6>
						<p>Status:</p>
						<h6>${hospBean.status}</h6>
						<p>
							<a
								href="${pageContext.request.contextPath}/hospital/editHosp/${hospBean.hospId}"
								class="btn btn-primary" role="button">Edit</a>

							<%-- <a href="${pageContext.request.contextPath}/hospital/deleteHosp/${hospBean.hospId}" class="btn btn-danger" role="button">Delete</a></p> --%>
							<a href="" class="btn btn-danger"
								onclick="deleteHosp(${hospBean.hospId})" role="button">Delete</a>
						</p>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>

	</section>

</body>
</html>