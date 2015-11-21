<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

	<%@include file="userHeader.jsp" %>



 
 
 
		<div class="row">
		
		   <div id="fundTransferBox" class="row center-block" align="left">
				<form class="fund_transfer form-horizontal col-md-9 col-lg-12" action="" style="padding-left:15px; padding-right:15px; padding-top:25px; padding-bottom: 0px;">
					<div class="form-group">
						<label for="" class="col-lg-3 col-md-3 control-label"> Payee  </label>
						
						<div class ="col-lg-2 col-md-2"> 
						 	<select class="form-control">
						 		  <option>1</option>
  								  <option>2</option>
  								  <option>3</option>
  								  <option>4</option>
  								  <option>5</option>
                            </select>
						 	
						
			<!--<input type="text" class = "form-control" placeholder ="Enter payee" name="payeeTxt"  /> -->	
						</div>
						 
						 
					</div>
					
					
					
					<div class="form-group">
						<label for="" class="colg-lg-3 col-md-3 control-label"> From Account </label>
						
						<div class="colg-lg-5 col-md-5">
							 <select class="form-control">
						 		  <option>1</option>
  								  <option>2</option>
  								  <option>3</option>
  								  <option>4</option>
  								  <option>5</option>
                            </select>
							
							
			<!-- <input type ="text" class="form-control" placeholder="From Account" name="fromAccountTxt"/>						    -->
						
						</div>
					    	
					</div>
					
					
					
					<div class="form-group">
						<label for="AmountTxt" class="colg-lg-3 col-md-3 control-label" > Amount</label>
						
						<div class="colg-lg-2 col-md-2">
							<input type ="text" class="form-control" placeholder="Enter Amount" name="AmountTxt"/>
						</div>
						
					</div>		
					
										
					
					<div class="form-group" >
						
							<div class="col-lg-5 col-md-5" align="right">
							    <input class="btn btn-primary bg-blue" type="submit" value="Transfer" /> 
							</div>
					</div>
				</form> 
		   </div>
			
	    </div>
		 
	 
	
		
		
	
		
		<script type="text/javascript" language="javascript"> 
	
$(document).ready(function() {
			
			$('.fund_transfer').bootstrapValidator({
				
				
			message: 'This value is not valid',
			feedbackIcons: {
			valid: 'glyphicon glyphicon-ok',
			invalid: 'glyphicon glyphicon-remove',
			validating: 'glyphicon glyphicon-refresh'
			},
			
			fields: {
				
				AmountTxt: {
			
				validators: { 
					notEmpty: 
					{ 
						message: 'Amount cannot be empty' 
					}, 
					regexp: 
					{ 
						regexp: /^[0-9.]+$/, 
						message: 'The amount can only consist of number ' } } } 
				} 
			}); 
		});
				
		</script>
		
<%@include file="userFooter.jsp" %>	
		