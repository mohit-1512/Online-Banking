<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

	<%@include file="userHeader.jsp" %>

		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link href="scripts/bootstrap-3.2.0-dist/css/bootstrap.min.css" rel="stylesheet" />
		<link href="css/style.css" rel="stylesheet" />
		<link href="scripts/responsive-slider/css/responsive-slider-parallax.css" rel="stylesheet" />
		<link href="scripts/Bootstrap Validator/css/bootstrapValidator.min.css" rel="stylesheet" />

		
		<script type="text/javascript" src="scripts/jquery-2.1.1.min.js"></script>
		<script type="text/javascript" src="scripts/bootstrap-3.2.0-dist/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="scripts/Bootstrap Validator/js/bootstrapValidator.min.js"></script>	
		<div class="container-fluid">
		
          
			<div class="row">
			<div class="col-md-6">
				<form class="ContactUsfrm form-horizontal" name="formContactUs" action="" method="get" onsubmit="return validateAll()" >
				
				  <div class="form-group">
				  	<label for="inputname" class="col-md-2 col-lg-2 control-label">*Name:</label>
				  	<div class="col-md-6 col-lg-6">
				      <input type="text" class="form-control" id="nid" name="NameTxt" placeholder="Name">
				    </div>
				  </div>
				  
				   <div class="form-group">
				  	<label for="inputemail" class="col-md-2 col-lg-2 control-label">*Email Id:</label>
				  	<div class="col-md-6 col-lg-6">
				      <input type="text" class="form-control" id="emailid" name="emailTxt" placeholder="Email">
				    </div>
				  </div>
				  
				   <div class="form-group">
				  	<label for="inputmob" class="col-md-2 col-lg-2 control-label">*Mobile Number:</label>
				  	<div class="col-md-6 col-lg-6">
				      <input type="text" class="form-control" id="mobid" name="mobTxt" placeholder="Mobile Number">
				    </div>
				  </div>
				  
				  
				  <div class="form-group">
				  	<label for="inputsub" class="col-md-2 col-lg-2 control-label">*Subject:</label>
				  	<div class="col-md-6 col-lg-6">
				      <input type="text" class="form-control" id="subjectid" name="subTxt">
				    </div>
				  </div>
				  
				  <div class="form-group">
				  	<label for="inputmsg" class="col-md-2 col-lg-2 control-label">*Message:</label>
				  	<div class="col-md-6 col-lg-6">
				      <textarea class="form-control" rows="3" name="msgTxt"></textarea>
				    </div>
				  </div>
				  
				 
				  
		
				  <div class="form-group">
				  	<div class="col-md-8 col-lg-8" align="center">
				  		<input type="submit" class="btn btn-primary" value="Submit" />
				  	</div>
				  </div>							 
				</form>
			
		
				
          </div>	
				
			<div class="col-md-6">
			<div class="sidebar-module">
						<p>IBANK<br>
						<em>Address:IBANK Corporate Office,Tower-14,</em>Cybercity,Magarpatta City,Pune-411013</p>
				<p>Email Address:<em>support@ibank.com</em>
				<p>Contact No:<em>020-25678907</em>
			
			</div>		 
			</class>
				
				<script type="text/javascript">
					$(document).ready(function() {
						
						$('.ContactUsfrm').bootstrapValidator({
							
							
						message: 'This value is not valid',
						feedbackIcons: {
						valid: 'glyphicon glyphicon-ok',
						invalid: 'glyphicon glyphicon-remove',
						validating: 'glyphicon glyphicon-refresh'
						},
						
						fields: {
							
						NameTxt: {
							message: 'The Name is not valid',
							validators: { 
								notEmpty:{ 
									message: 'The Name is required and cannot be empty' 
								}, 
								regexp:{ 
									regexp: /^[a-zA-Z]+$/, 
									message: 'The Name can only consist of alphabetical characters' 
								}
							} 
							}
						
						,emailTxt: {
							message: 'The Email is not valid',
							validators: { 
								notEmpty:{ 
									message: 'The Email is required and cannot be empty' 
								}, 
								emailAddress: {
									message: 'The input is not a valid email address' 
							
							},
							regexp:{
								regexp:/^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})/,
								message:'The email address shoould be valid'
							}
							} 
							}	
							
						,mobTxt: {
							message: 'The  Mobile Number is not valid',
							validators: { 
								notEmpty:{ 
									message: 'The Mobile Number is required and cannot be empty' 
								}, 
								regexp:{ 
									regexp: /^[0-9]{10}$/, 
									message: 'The Mobile Number can only consist of 10 Numbers' 
								}
							} 
							}
						
						
						
						
						
						,subTxt: {
							message: 'The subject is not valid',
							validators: { 
								notEmpty:
								
								
								{ 
									message: 'The subject is required and cannot be empty' 
								}
							} 
							}
							
					
							
						,msgTxt: {
							message: 'The message is not valid',
							validators: { 
								notEmpty:{ 
									message: 'The message is required and cannot be empty' 
								}
							} 
							}
							
					
					
							}
						
							} 
						); 
					});
						
						
				</script>
			</div>
		</div>

<%@include file="userFooter.jsp" %>	