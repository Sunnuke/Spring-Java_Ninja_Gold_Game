<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
<style>
.square {
  padding: 30px 0px;
  text-align: center;
  height: 200px;
  width: 200px;
  background-color: lightgrey;
  border: 2px solid black;
}

.activity {
  resize: none;
  height: 200px;
  width: 97%;
  background-color: lightgrey;
  border: 2px solid black;
  overflow-y: scroll;
}
</style>
</head>
<body>
	<div class="container" style="margin-top: 10px";>
		<div class="row" style="margin-bottom: 30px;">
			<div class="col-md-4">
				<h1>Your Gold: <span style="background-color: lightgrey; border: 2px solid black; margin-left: 10px; padding: 0px 20px;"><c:out value="${gold}"/></span></h1>
			</div>
		</div>
		
		<div class="row" style="margin-bottom: 30px;">
			<div class="col-md-3">
            	<div class="square">
                	<h2>Farm</h2>
                    <p>(earns 10-20 gold)</p>
                    <form action="/farm" method="POST">
                      <input name="farm" type="hidden" value="1">
                      <button type="submit">Find Gold!</button>
                    </form>
                </div>
			</div>
			<div class="col-md-3">
            	<div class="square">
                	<h2>Cave</h2>
                    <p>(earns 5-10 gold)</p>
                    <form action="/cave" method="POST">
                      <input name="cave" type="hidden" value="2">
                      <button type="submit">Find Gold!</button>
                    </form>
                </div>
			</div>
			<div class="col-md-3">
            	<div class="square">
                	<h2>House</h2>
                    <p>(earns 2-5 gold)</p>
                    <form action="/house" method="POST">
                      <input name="house" type="hidden" value="3">
                      <button type="submit">Find Gold!</button>
                    </form>
                </div>
			</div>
			<div class="col-md-3">
            	<div class="square">
                	<h2>Casino!</h2>
                    <p>(earns/takes 0-50 gold)</p>
                    <form action="/casino" method="POST">
                      <input name="casino" type="hidden" value="4">
                      <button type="submit">Find Gold!</button>
                    </form>
                </div>
			</div>
		</div>
		
		<div class="row" style="margin-bottom: 30px;>
			<div class="col-md-4"">
				<h1>Activities:</h1>
		</div>
		
		<div class="row">
			<div class="col-md-4" style="width: 100%;">
         		<textarea class="activity"><c:out value="${activity}"/></textarea>
			</div>
		</div>
	</div>
</body>
</html>