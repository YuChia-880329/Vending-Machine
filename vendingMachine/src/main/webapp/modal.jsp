<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
	<div class="modal fade" id="confirmModal">
	  	<div class="modal-dialog msg-modal-dialog">
	    	<div class="modal-content msg-modal-content">
	      		<div class="modal-header msg-modal-header">
	        		<h4 class="modal-title">確認</h4>
	        		<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      		</div>
	      		<div class="modal-body msg-modal-body">
	      			<p id="confirmModal_msg"></p>
	      		</div>
	      		<div class="modal-footer msg-modal-footer">
	        		<button type="button" class="btn btn-secondary" data-bs-dismiss="modal" id="confirmModal_cancelBtn">取消</button>
	        		<button type="button" class="btn btn-primary" data-bs-dismiss="modal" id="confirmModal_okBtn">確認</button>
	      		</div>
	    	</div>
	  	</div>
	</div>
	
	
	<div class="modal fade" id="alertModal">
		<div class="modal-dialog msg-modal-dialog">
	    	<div class="modal-content msg-modal-content">
	      		<div class="modal-header msg-modal-header">
	        		<h4 class="modal-title">警告</h4>
	        		<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      		</div>
	      		<div class="modal-body msg-modal-body">
	      			<p id="alertModal_msg"></p>
	      		</div>
	      		<div class="modal-footer msg-modal-footer">
		  			<button type="button" class="btn btn-primary" data-bs-dismiss="modal" id="alertModal_okBtn">確認</button>
	      		</div>
	    	</div>
	  	</div>
	</div>