function num(e) {
    evt = e ? e : event;
    tcl = (window.Event) ? evt.which : evt.keyCode;
    if (tcl == 8 || tcl == 127 || tcl == 13) { return true; }
    return false;
}
function solonum(event) {
  if (event) {
    var charCode = (event.which) ? event.which : event.keyCode;
    if ((charCode < 48 || charCode > 57) &&  charCode!=8 && charCode!=9 && charCode!=37 && charCode!=14 && charCode!=39 && charCode!=35 && charCode!=36 && charCode!=46) 
       return false;
  }
  return true;
}
function numDecimal(e,field){
  key = e.keyCode ? e.keyCode : e.which
  // backspace
  if (key == 8) return true
    //otras teclas 
  if (key == 8 || key == 9 || key == 37 || key ==14 || key ==39 || key ==35 || key == 36) return true

  // 0-9
  if (key > 47 && key < 58) {
    if (field.value == "") return true
    regexp = /^((([0-9])(\.){,1})|20{,1})$/
    //regexp = /.[0-9]{1}$/
    return (regexp.test(field.value))
    
  }

  // .
  if (key == 46) {
    if (field.value == "") return false
    regexp = /^[0-9]+$/
    return regexp.test(field.value)
  }
  // other key
  return false
 
}
function mayus(e) {
    e.value = e.value.toUpperCase();
}

function abrirVentana(ServidorWF) {
    if ((ServidorWF==0)){ //Para desarrollo
        window.open("http://localhost/WebAdmision/faces/acceso.xhtml","Bienvenido", "menubar=no,toolbar=n0, directories=no");
    }else if((ServidorWF==1)){ //Para tester
        window.open("http://pruebas.uns.edu.pe/WebAdmision/faces/acceso.xhtml","Bienvenido", "menubar=no,toolbar=n0, directories=no");
    }else { //para Produccion    
        window.open("http://registro.uns.edu.pe/WebAdmision/faces/acceso.xhtml","Bienvenido", "menubar=no,toolbar=n0, directories=no");
    }
    var padre=window.open("","_parent", "menubar=no");
    padre.close();
}
function amplia(){
    window.moveTo(0,0);
    window.resizeTo(screen.availWidth, screen.availHeight);
}
function abrir(){
    x=window.open('pag','nombrepopup','status=no,scrollbars=no,menubar=no,width=800,height=545,top=20,left=0')
    var ventana = window.self;
    ventana.opener = window.parent.self;
    ventana.close();
}
function nobackbutton(){
   window.location.hash="no-back-button";
   window.location.hash="Again-No-back-button"; //chrome
   window.onhashchange=function(){window.location.hash="no-back-button";};	
}

function hideBackOnLastTab() {
    if($("ul.ui-wizard-step-titles>li").last()
             .is("ul.ui-wizard-step-titles>li.ui-state-highlight")) {
            $("div.ui-wizard-navbar>button.ui-wizard-nav-back").css("display", "none");
    }

}