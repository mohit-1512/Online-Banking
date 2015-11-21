<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@include file="userHeader.jsp" %>
	
		<link href="css/style.css" rel="stylesheet"> 
		<link href="scripts/bootstrap-3.2.0-dist/css/bootstrap.min.css" rel="stylesheet" />
		

		<script type="text/javascript" src="scripts/jquery-2.1.1.min.js"></script>
    	<script type="text/javascript" src="scripts/bootstrap-3.2.0-dist/js/bootstrap.min.js"></script>
		
		<div class="container-fluid">
		
		<div class="row" style="margin-top:100px;">
			<div class="col-lg-12 col-md-9 text-center">
			   <span class="logoText h1">Change Password</span></div>
		</div>
		
		
			<form class="change_Password form-horizontal col-md-9 col-lg-12" action="" style="padding-left:15px; padding-right:15px; padding-top:25px; padding-bottom: 0px;">
		
				<div class="form-group">
					<label for="currPswdTxt" class="col-lg-3 col-md-3 control-label">Current Password</label>
		            <div class ="col-lg-3 col-md-3"> 
			         	<input type="text" class = "form-control" placeholder ="Enter Current Password" name="currPswdTxt"  />
			        </div>
			    </div>
				
				<div class="form-group">
					<label for="newPswdTxt" class="col-lg-3 col-md-3 control-label">New Password</label>
			        <div class ="col-lg-3 col-md-3"> 
			         	<input type="text" class = "form-control" placeholder ="Enter New Password" name="newPswdTxt"  />
			        </div>
			    </div>
				
				<div class="form-group">
					<label for="cnfrmPswdTxt" class="col-lg-3 col-md-3 control-label">Confirm New Password</label>
			        <div class ="col-lg-3 col-md-3"> 
			         	<input type="text" class = "form-control" placeholder ="Re-enter New Password" name="cnfrmPswdTxt"  />
			        </div>
			    </div>
						
				<div class="form-group">
					<label for="" class="col-lg-3 col-md-3 control-label"></label>
			        <div class ="col-lg-6 col-md-6"> 
			         	<input class="btn btn-primary bg-blue" type="submit" value="Change Password"  />
			        </div>
			    </div>
			    
			</form>
		</div>
		
		
		<script type="text/javascript" src="scripts/jquery-2.1.1.min.js"></script>
		<script type="text/javascript" src="scripts/bootstrap-3.2.0-dist/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="scripts/Bootstrap Validator/js/bootstrapValidator.min.js"></script>
		<script type="text/javascript" language="javascript"> 
		
		$(document).ready(function(){
			$('.change_Password').bootstrapValidator({
				
				message:'This is not valid',
				feedbackIcons:{
					valid: 'glyphicon glyphicon-ok',
					invalid: 'glyphicon glyphicon-remove',
					validating: 'glyphicon glyphicon-refresh'
				},
				
				
				fields:{				
				
					newPswdTxt:{

					validators: { 
						notEmpty: 
						{ 
							message: 'Password is required and cannot be empty' 
						}, 
						
						regexp:{ 
							regexp: /^([_A-Za-z0-9-]+){6,}$/, 
							message: 'Password should be 6 character long'}
		
					    },
					    
					    identical: {
	                        field: 'cnfrmPswdTxt',
	                        message: 'The password and its confirm are not the same'
	                    }
					    
				    },
				
				
				cnfrmPswdTxt:{

					validators: { 
						notEmpty: 
						{ 
							message: 'Password is required and cannot be empty' 
						}, 						
						regexp:{ 
							regexp: /^([_A-Za-z0-9-]+){6,}$/, 
							message: 'Password should be 6 character long'},
						identical: {
	                        field: 'newPswdTxt',
	                        message: 'The password and its confirm are not the same'
	                    }
		
					    },					    
					    
					    
				    }
				
				
					
				}
				
			});
		});	
		
		
		
</script> 
		
<%@include file="userFooter.jsp" %>	