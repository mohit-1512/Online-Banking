<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="adminHeader.jsp" %>

<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<a href="createUser.do">Create New User</a><br><br>
<a href="" data-toggle="modal" data-target="#myModal">Add accounts for Existing User</a>



<script type="text/javascript" language="javascript">
		
				$(document).ready(function(){
					<c:if test="${error_addExistingAcc ne null}">
					$('#myModal').modal('show');
					</c:if>
				});
		
</script> 



	

      	
	
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <form class="newAccFrm form-horizontal" name="formNewRegister" action="" method="post" >		 
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel">Existing User</h4>
      </div>
      <div class="modal-body">
      		<c:if test="${error_addExistingAcc ne null}">
									<div class="col-md-12 col-lg-12 alert alert-danger text-center">
											${error_addExistingAcc}
									</div>
			</c:if>
		<div class="row">
	       	
				
					 <div class="form-group">
					 
						  	<label for="inputExitingUser" class="col-md-2 col-lg-2 control-label">User ID:</label>
						  	<div class="col-md-6 col-lg-6">
						      <input type="text" class="form-control" id="existingUserid" name="existingUserTxt" placeholder="UserID">
						    </div>
					 </div>
				
		       		
	      </div>
      
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
       	<input type="submit" class="btn btn-primary" value="View Details/Add Account"/>
       	
      </div>
    </div>
  </div>
 </form>
</div>

<%@include file="adminFooter.jsp" %>