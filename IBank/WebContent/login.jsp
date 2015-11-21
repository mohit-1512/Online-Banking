<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

 <link href="scripts/bootstrap-3.2.0-dist/css/bootstrap.min.css" rel="stylesheet" />

<link href="css/style.css" rel="stylesheet" />
<link href="scripts/responsive-slider/css/responsive-slider-parallax.css" rel="stylesheet" />
<link href="scripts/Bootstrap Validator/css/bootstrapValidator.min.css" rel="stylesheet" />
 
<title>IBANK</title>
</head>
<style type="text/css">


</style>
<body>

<script type="text/javascript" src="scripts/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="scripts/bootstrap-3.2.0-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="scripts/Bootstrap Validator/js/bootstrapValidator.min.js"></script>

<div class="container-fluid">
	
	
	
	<div class="row" style="margin-top:100px;">
		<div class="col-sm-12 col-xs-12 text-center"><span class="logoText h1">IBANK</span></div>
	</div>

<div class="row row-centered">
	<div id="loginBox" class="box col-xs-12 col-sm-5 col-md-5 col-lg-4 col-centered" align="left">
		<form method="post" class="login_form form-horizontal col-md-12 col-lg-12" action="" style="padding-left:15px; padding-right:15px; padding-top:25px; padding-bottom: 0px;">
			
			
			<c:if test="${login_error ne null }">
				<div class="col-md-12 col-lg-12 alert alert-danger text-center">
				${login_error}
				</div>
			</c:if>
			
			<div class="form-group">
				<label for="usernameTxt" class="col-lg-3 col-md-3 control-label">User Id</label>
				<div class="col-lg-9 col-md-9"><input type="text" class=" form-control" placeholder="Enter your Username" name="useridTxt" /></div>
			</div>
			
			<div class="form-group">
				<label for="usernameTxt" class="col-lg-3 col-md-3 control-label">Password</label>
				<div class="col-lg-9 col-md-9"><input class="form-control" placeholder="Enter your Password" type="password" name="passwordTxt" /></div>
			</div>
								
			<div class="form-group">
				<label for="usernameTxt" class="col-lg-6 col-md-6 control-label"><a href="#" style="float:left; font-size: 12px;">Forgot Password ?</a></label>
				<div class="col-lg-6 col-md-6" align="right"><input class="btn btn-primary bg-blue" type="submit" value="Login" /></div>
			</div>
		</form>
		<script type="text/javascript">
		/* $(document).ready(function() {
			
			$('.login_form').bootstrapValidator({
				
				
			message: 'This value is not valid',
			feedbackIcons: {
			valid: 'glyphicon glyphicon-ok',
			invalid: 'glyphicon glyphicon-remove',
			validating: 'glyphicon glyphicon-refresh'
			},
			
			fields: {
				
			usernameTxt: {
				message: 'The username is not valid',
				validators: { 
				notEmpty: 
				{ 
					message: 'The username is required and cannot be empty' 
				}, 
					stringLength: 
					{ 
						min: 6, 
						max: 30, 
						message: 'The username must be more than 6 and less than 30 characters long' 
					}, 
					regexp: 
					{ 
						regexp: /^[a-zA-Z0-9_]+$/, 
						message: 'The username can only consist of alphabetical, number and underscore' } } }, email: { validators: { notEmpty: { message: 'The email is required and cannot be empty' }, emailAddress: { message: 'The input is not a valid email address' 
					} 
					} 
				},
				
				passwordTxt: {
					message: 'The Password is not valid',
					validators: { 
					notEmpty: 
					{ 
						message: 'The Password is required and cannot be empty' 
						}, 
						stringLength: 
						{ 
							min: 6, 
							max: 30, 
							message: 'The Password must be more than 6 and less than 30 characters long' 
						}, 
						regexp: 
						{ 
							regexp: /^[a-zA-Z0-9_]+$/, 
							message: 'The Password can only consist of alphabetical, number and underscore' } } }, email: { validators: { notEmpty: { message: 'The email is required and cannot be empty' }, emailAddress: { message: 'The input is not a valid email address' 
						} 
						} 
					}
				} 
			}); 
		}); */
			
		
		</script>
	</div>
</div>
</div>






</body>
</html>