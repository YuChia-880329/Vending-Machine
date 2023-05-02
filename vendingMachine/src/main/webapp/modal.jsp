<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<div class="modal fade" id="confirm_modal">
  	<div class="modal-dialog msg-modal-dialog">
    	<div class="modal-content msg-modal-content">
      		<div class="modal-header msg-modal-header">
        		<h4 class="modal-title">Confirm</h4>
        		<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      		</div>
      		<div class="modal-body msg-modal-body">
      			<p id="confirm_modal_msg"></p>
      		</div>
      		<div class="modal-footer msg-modal-footer">
        		<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">取消</button>
        		<button type="button" class="btn btn-primary" data-bs-dismiss="modal" id="confirm_modal_ok_btn">確認</button>
      		</div>
    	</div>
  	</div>
</div>


<div class="modal fade" id="alert_modal">
	<div class="modal-dialog msg-modal-dialog">
    	<div class="modal-content msg-modal-content">
      		<div class="modal-header msg-modal-header">
        		<h4 class="modal-title">Alert</h4>
        		<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      		</div>
      		<div class="modal-body msg-modal-body">
      			<p id="alert_modal_msg"></p>
      		</div>
      		<div class="modal-footer msg-modal-footer">
	  			<button type="button" class="btn btn-primary" data-bs-dismiss="modal">確認</button>
      		</div>
    	</div>
  	</div>
</div>