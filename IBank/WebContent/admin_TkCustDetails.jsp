<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@include file="adminHeader.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="row">
				<form class="newAccFrm form-horizontal" name="formNewRegister" action="" method="post" >
				
				
				<c:if test="${error_createUser ne null}">
					<div class="col-md-12 col-lg-12 alert alert-danger text-center">
						${error_createUser}
					</div>
				</c:if>
			
				  <div class="form-group">
				  	<label for="inputfname" class="col-md-2 col-lg-2 control-label">First Name:</label>
				  	<div class="col-md-6 col-lg-6">
				      <input type="text" class="form-control" id="fnid" name="fnTxt" placeholder="First Name">
				    </div>
				  </div>
				  
				  <div class="form-group">
				  	<label for="inputmdname" class="col-md-2 col-lg-2 control-label">Middle Name:</label>
				  	<div class="col-md-6 col-lg-6">
				      <input type="text" class="form-control" id="mdnid" name="mdnameTxt" placeholder="Middle Name">
				    </div>
				  </div>
				  
				  <div class="form-group">
				  	<label for="inputlname" class="col-md-2 col-lg-2 control-label">Last Name:</label>
				  	<div class="col-md-6 col-lg-6">
				      <input type="text" class="form-control" id="lnid" name="lnTxt" placeholder="Last Name">
				    </div>
				  </div>
				  
				  <div class="form-group">
				  	<label for="inputaddr" class="col-md-2 col-lg-2 control-label">Address:</label>
				  	<div class="col-md-6 col-lg-6">
				      <textarea class="form-control" rows="3" name="addTxtarea"></textarea>
				    </div>
				  </div>
				  
				  <div class="form-group">
				  	<label for="inputmob" class="col-md-2 col-lg-2 control-label">Mobile Number:</label>
				  	<div class="col-md-6 col-lg-6">
				      <input type="text" class="form-control" id="mobid" name="mobTxt" placeholder="Mobile Number">
				    </div>
				  </div>
				  
				  <div class="form-group">
				  	<label for="inputemail" class="col-md-2 col-lg-2 control-label">Email Id:</label>
				  	<div class="col-md-6 col-lg-6">
				      <input type="text" class="form-control" id="emailid" name="emailTxt" placeholder="Email">
				    </div>
				  </div>
				  
				  <div class="form-group">
				  	<label for="inputpan" class="col-md-2 col-lg-2 control-label">Permanent Account Number:</label>
				  	<div class="col-md-6 col-lg-6">
				      <input type="text" class="form-control" id="panid" name="panTxt" placeholder="PAN">
				    </div>
				  </div>
				  
				  <div class="form-group">
				  	<label for="inputpass" class="col-md-2 col-lg-2 control-label">Password:</label>
				  	<div class="col-md-6 col-lg-6">
				      <input type="password" class="form-control" id="passid" name="passTxt" placeholder="Password">
				    </div>
				  </div>
				  
				  <div class="form-group">
				  	<label for="inputconfirmPass" class="col-md-2 col-lg-2 control-label">Confirm Password:</label>
				  	<div class="col-md-6 col-lg-6">
				      <input type="password" class="form-control" id="confirmPassid" name="confirmPassTxt" placeholder="Confirm Password">
				    </div>
				  </div>
				  
				  <div class="form-group">
				  	<label for="inputTransPass" class="col-md-2 col-lg-2 control-label">Transaction Password:</label>
				  	<div class="col-md-6 col-lg-6">
				      <input type="password" class="form-control" id="transPassid" name="transPassTxt" placeholder="Transaction Password">
				    </div>
				  </div>
				  
				  <div class="form-group">
				  	<label for="inputconfirmPass" class="col-md-2 col-lg-2 control-label">Confirm Transaction Password:</label>
				  	<div class="col-md-6 col-lg-6">
				      <input type="password" class="form-control" id="confirmTransPassid" name="confirmTransPassTxt" placeholder="Confirm Transaction Password">
				    </div>
				  </div>
				  
				  <div class="form-group">
				  	<label for="inputsecques" class="col-md-2 col-lg-2 control-label">Secret Question:</label>
				  	<div class="col-md-6 col-lg-6">
				      <textarea class="form-control" rows="3" name="secquesTxtarea"></textarea>
				    </div>
				  </div>
				  
				  <div class="form-group">
				  	<label for="inputsecquesAns" class="col-md-2 col-lg-2 control-label">Answer:</label>
				  	<div class="col-md-6 col-lg-6">
				      <textarea class="form-control" rows="2" name="secquesAnsTxtarea"></textarea>
				    </div>
				  </div>
				  
				  <div class="form-group">
				  	<div class="col-md-8 col-lg-8" align="center">
				  		<input type="submit" class="btn btn-primary" value="Create User" />
				  	</div>
				  </div>							 
				</form>
				<!-- $('.newAccFrm').bootstrapValidator({ -->
				<script type="text/javascript">
					$(document).ready(function() {
						
						$('.newAccFrm').bootstrapValidator({
							
							
						message: 'This value is not valid',
						feedbackIcons: {
						valid: 'glyphicon glyphicon-ok',
						invalid: 'glyphicon glyphicon-remove',
						validating: 'glyphicon glyphicon-refresh'
						},
						
						fields: {
							
						fnTxt: {
							message: 'The First Name is not valid',
							validators: { 
								notEmpty:{ 
									message: 'The First Name is required and cannot be empty' 
								}, 
								regexp:{ 
									regexp: /^[a-zA-Z]+$/, 
									message: 'The First Name can only consist of alphabetical characters' 
								}
							} 
							}
						
						,mdnameTxt: {
							message: 'The Middle Name is not valid',
							validators: { 
								notEmpty:{ 
									message: 'The Middle Name is required and cannot be empty' 
								}, 
								regexp:{ 
									regexp: /^[a-zA-Z]+$/, 
									message: 'The Middle Name can only consist of alphabetical characters' 
								}
							} 
							}
							
						,lnTxt: {
							message: 'The  Last Name is not valid',
							validators: { 
								notEmpty:{ 
									message: 'The Last Name is required and cannot be empty' 
								},
								regexp:{ 
									regexp: /^[a-zA-Z]+$/, 
									message: 'The Last Name can only consist of alphabetical' 
								}
							} 
							}
							
						,addTxtarea: {
							message: 'The Address is not valid',
							validators: { 
								notEmpty:{ 
									message: 'The Address is required and cannot be empty' 
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
							
						,emailTxt: {
							message: 'The Email is not valid',
							validators: { 
								notEmpty:{ 
									message: 'The Email is required and cannot be empty' 
								}, 
								emailAddress: {
									message: 'The input is not a valid email address' 
								}
							} 
							}
						
						,panTxt: {
							message: 'The PAN is not valid',
							validators: { 
								notEmpty:{ 
									message: 'The PAN is required and cannot be empty' 
								}, 
								regexp:{ 
									regexp: /^[0-9A-Z]{10}$/, 
									message: 'The PAN can only consist of 10 alph-numeric characters' 
								}
							} 
							}
						
						,passTxt:{
							validators: { 
								notEmpty: 
								{ 
									message: 'Password is required and cannot be empty' 
								}, 							
								regexp:{ 
									regexp: /^([_A-Za-z0-9-]+){6,}$/, 
									message: 'Password should be 6 character long'}				
							    }							    
						    }
						
						,confirmPassTxt:{
							validators: { 
								notEmpty: 
								{ 
									message: 'Password is required and cannot be empty' 
								}, 						
								regexp:{ 
									regexp: /^([_A-Za-z0-9-]+){6,}$/, 
									message: 'Password should be 6 character long'
									}				
							    }
							
						    }
						
						,transPassTxt:{
							validators: { 
								notEmpty: 
								{ 
									message: 'Transaction Password is required and cannot be empty' 
								}, 							
								regexp:{ 
									regexp: /^([_A-Za-z0-9-]+){6,}$/, 
									message: 'Transaction Password should be 6 character long'
									}				
							    }							    
						    }
						
						,confirmTransPassTxt:{
							validators: { 
								notEmpty: 
								{ 
									message: 'Transaction Password is required and cannot be empty' 
								}, 						
								regexp:{ 
									regexp: /^([_A-Za-z0-9-]+){6,}$/, 
									message: 'Transaction Password should be 6 character long'
									}
												
							    }					    							    							    
						    }
						
						
						,secquesTxtarea: {
							message: 'The Secret Question is not valid',
							validators: { 
								notEmpty:{ 
									message: 'The Secret Question is required and cannot be empty' 
								}
							} 
							}
						,secquesAnsTxtarea: {
							message: 'The Answer is not valid',
							validators: { 
								notEmpty:{ 
									message: 'The Answer is required and cannot be empty' 
								}
							} 
							}
						
						
						,obalTxt: {
							message: 'The Opening Balance is not valid',
							validators: { 
								notEmpty:{ 
									message: 'The Opening Balance is required and cannot be empty' 
								}, 
								regexp:{ 
									regexp: /^[0-9]+$/, 
									message: 'The Opening Balance entered should be number' 
								}
							} 
							}
						
							} 
						}); 
					});
						
					
				</script>
			</div>		
					




<%@include file="adminFooter.jsp" %>