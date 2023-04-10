<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<div class="modal fade" id="confirm_modal">
  	<div class="modal-dialog">
    	<div class="modal-content" style="background-color:#54B4D3">
      		<div class="modal-header" style="border-bottom:0">
        		<h4 class="modal-title">Confirm</h4>
        		<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      		</div>
      		<div class="modal-body">
      			<p id="confirm_modal_msg"></p>
      		</div>
      		<div class="modal-footer" style="border-top:0">
        		<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">取消</button>
        		<button type="button" class="btn btn-primary" data-bs-dismiss="modal" id="confirm_modal_ok_btn">確認</button>
      		</div>
    	</div>
  	</div>
</div>


<div class="modal fade" id="alert_modal">
	<div class="modal-dialog">
    	<div class="modal-content" style="background-color:#54B4D3">
      		<div class="modal-header" style="border-bottom:0">
        		<h4 class="modal-title">Alert</h4>
        		<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      		</div>
      		<div class="modal-body">
      			<p id="alert_modal_msg"></p>
      		</div>
      		<div class="modal-footer" style="border-top:0">
	  			<button type="button" class="btn btn-primary" data-bs-dismiss="modal" id="alert_modal_ok_btn">確認</button>
      		</div>
    	</div>
  	</div>
</div>