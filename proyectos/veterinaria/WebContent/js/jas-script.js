$(document).ready(function () {
	 
        $('.row').each(function(){

    		$(this).find('.span6').first().css('width', '354px');
        });
        
        
        var flagNew = true;
        
        $('#example a').click(function(event) {
        	
        	if($(this).html().indexOf('editar')!=-1){
        		event.preventDefault();
        		
        		flagNew = false;
        		$('#btnNew').trigger('click');
        		flagNew = true;
        		
        		$.ajax({
                    url: $(this).attr('href'),
                    success:  function (response) {
                            $(".modal-body").html(response);
                    }
            	 });
        		
        		
        	}	
        	
        });
        
        
        $('#btnNew').click(function(){
        	
        	if(flagNew)
        	{
        		
        		var urlRegister ='';
            	
            	switch($(this).attr('flag'))
            	{
            		case 'Prospecto':
            			urlRegister = 'verRegistroCliente.jsp';
            			break;
            		case 'Doctor':
            			urlRegister = 'verRegistroDoctor.jsp';
            			break;
            		
            	}
            	
            	
            	$.ajax({
                    url: urlRegister,
                    success:  function (response) {
                            $(".modal-body").html(response);
                    }
            	 });
        	}
        	
        	     	
        });
        
        

        
        
        if($('#txtFecha'))
        {
        	$("#txtFecha").datepicker({
        		dateFormat: 'dd/mm/yy',
        		beforeShow: function(input, inst)
        		{
        			inst.dpDiv.css({marginTop: -input.offsetHeight + 'px', marginLeft: input.offsetWidth + 'px'});
        		}
        	}); 
        	
        }
        
        
        
});