<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="adminHeader.jsp" %>

<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>


<script type="text/javascript" language="javascript">
		
				$(document).ready(function(){
					<c:if test="${error_createAccount ne null}">
					$('#myModal').modal('show');
					</c:if>
				});
		
</script> 

<!-- Button trigger modal -->
<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
 	Add Account
</button>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
 <form class="newAccDetailsFrm form-horizontal" name="formNewAccRegister" action="" method="post">
  			
  
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel">Add New Account</h4>
      </div>
      <div class="modal-body">
	        <div class="row">
				<c:if test="${error_createAccount ne null}">
					<div class="col-md-12 col-lg-12 alert alert-danger text-center">
							${error_createAccount}
					</div>
				</c:if>
				  <div class="form-group">
				  	<label for="inputacctype" class="col-md-2 col-lg-2 control-label">Account type:</label>
				  	<div class="col-md-6 col-lg-6">
				      <select class="form-control" name="accTypeDDown">
				      	<option value="Current">Current</option>
						<option value="Saving">Saving</option>
				      </select>
				    </div>
				  </div>
				  
				  <div class="form-group">
				  	<label for="inputobal" class="col-md-2 col-lg-2 control-label">Opening Balance:</label>
				  	<div class="col-md-6 col-lg-6">
				      <input type="text" class="form-control" id="obalid" name="obalTxt" value=0 placeholder="Opening Balance in Rs">
				    </div>
				  </div>
				  
				  
				  
				  
				</form>
				<script type="text/javascript">
					$(document).ready(function() {
						
						$('.newAccDetailsFrm').bootstrapValidator({
						
						message: 'This value is not valid',
						feedbackIcons: {
						valid: 'glyphicon glyphicon-ok',
						invalid: 'glyphicon glyphicon-remove',
						validating: 'glyphicon glyphicon-refresh'
						},
						
						fields: {
							obalTxt: {
								
							
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
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <input type="submit" class="btn btn-primary" value="Generate Account Number" />
        
        
        
				  
      </div>
    </div>
  </div>
 </form>
</div>

<%@include file="adminFooter.jsp" %>	