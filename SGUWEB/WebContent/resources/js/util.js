







function getCookie(cname) {
    	    var name = cname + "=";
    	    var ca = document.cookie.split(';');
    	    for(var i = 0; i < ca.length ; i++) {
    	        var c = ca[i];
    	        while (c.charAt(0)==' ') {
    	            c = c.substring(1);
    	        }
    	        if (c.indexOf(name) == 0) {
    	            return c.substring(name.length,c.length);
    	        }
    	    }
    	    return "";
 }
 

 function soloNumeros(e){
    
                         
                            var key = window.Event ? e.which : e.keyCode;
                         
                            return ((key >= 48 &&  key <= 57) || (key === 8) || (e.keyCode === 37) || (e.keyCode === 39) || (e.keyCode === 16) || (e.keyCode === 9) );
                    }
                    
                    
                    
                    
 function soloNumerosExecpcion(e, exepcion){
                         
                            var key = window.Event ? e.which : e.keyCode;                            
                            lista=exepcion.split("-");                         
                          
                            for (i=0;i<=lista.length-1;i++){
                                if(String.fromCharCode(key)===lista[i]){
                                    return true;
                                }
                            }
                            return ((key >= 48 &&  key <= 57) || (key === 8) || (e.keyCode === 37) || (e.keyCode === 39) || (e.keyCode === 16) || (e.keyCode === 9));
 }
 
 function notificacion(msg,speed,fadeSpeed,type){
	    $('.notify').remove();
		if (typeof fade != "undefined"){
		clearTimeout(fade);
		}
		$('body').append('<div class="notify '+type+'" style="display:none;position:fixed;right:10px"><p>'+msg+'</p></div>');	
		notifyHeight = $('.notify').outerHeight();
		$('.notify').css('top',-notifyHeight).animate({top:10,opacity:'toggle'},speed);	
		fade = setTimeout(function(){
		
			$('.notify').animate({top:notifyHeight+10,opacity:'toggle'}, speed);
		
		}, fadeSpeed);
	}
 
 
 
 var bandera=false;
 var idGeneral;

 function confirmacion(obj,cadena){
     idGeneral=obj;
     if(bandera){
         $(".modal-fondo").remove();
         $(".modal").remove();
         bandera=false;
         return true;
     }else{
        if(! $('.modal-fondo').hasClass("modal-fondo")){
            $('body').append('<div class="modal-fondo"  /> ');
             $('body').append('<div class="modal" ><div class="modal-titulo" > INTRANET  </div><div class="modal-cuerpo"> <div class="column modal-icono"><i class="fa fa-exclamation "  /></div><div class="column modal-texto"><span>' +cadena+'</span></div></div><hr/><div class="modal-botonera"><a  class="positivo"  onclick="valida(true)" >Si</a> <a class="negativo" onclick="valida(false)" > No</a></div>  </div>');
             }else{
             $(".modal-fondo").remove();
             $(".modal").remove();
        }                    
         
         return false;
     }
     
 }
 
 function valida(estado){
     bandera=estado;           
     $(idGeneral).click();            
 }
 
 
 
 
 
 
 PrimeFaces.locales['es'] = {
	        closeText: 'Cerrar',
	        prevText: 'Anterior',
	        nextText: 'Siguiente',
	        monthNames: ['Enero','Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
	        monthNamesShort: ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun','Jul','Ago','Sep','Oct','Nov','Dic'],
	        dayNames: ['Domingo','Lunes','Martes','Miércoles','Jueves','Viernes','Sábado'],
	        dayNamesShort: ['Dom','Lun', 'Mar', 'Mie', 'Jue', 'Vie', 'Sab'],
	        dayNamesMin: ['D','L','M','X','J','V','S'],
	        weekHeader: 'Semana',
	        firstDay: 1,
	        isRTL: false,
	        showMonthAfterYear: false,
	        yearSuffix: '',
	        timeOnlyTitle: 'Sólo hora',
	        timeText: 'Tiempo',
	        hourText: 'Hora',
	        minuteText: 'Minuto',
	        secondText: 'Segundo',
	        currentText: 'Fecha actual',
	        ampm: false,
	        month: 'Mes',
	        week: 'Semana',
	        day: 'Día',
	        allDayText : 'Todo el día',
	        MONTHS: ['Enero','Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
 			MONTHS_SHORT: ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun','Jul','Ago','Sep','Oct','Nov','Dic'],
 			DAYS: ['Domingo','Lunes','Martes','Miércoles','Jueves','Viernes','Sábado'],
 			DAYS_SHORT: ['Dom','Lun', 'Mar', 'Mie', 'Jue', 'Vie', 'Sab'],
	};
