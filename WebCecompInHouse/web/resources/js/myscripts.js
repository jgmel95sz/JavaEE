/* 
Este fragmento de codigo javascript se utiliza para que en la vista no me deje
ingresar un valor mayor a 20 y menos de 0, ni una letra
 */

/* 
este freagmento de codigo jquery se usa para la paginacion de las tablas a todas las
que tengas la clase "paginationTable"*/
 $(document).ready(function() {

     $('.paginationTable').DataTable( {
        paging: true,
        ordering: false,
        info: false
        
    }) ;

} );



/*$(document).ready(function() {
    $('#paginaTable').DataTable( {
        "paging": false,
        "ordering": false,
        "info": false,
        "scrollY": "200px",
        "scrollCollapse": true
        
    }) ;
} );
*/

function rangoNotas(obj){
    var salida;
    if (isNaN(obj.value) || obj.value < 0 || obj.value > 20) {
        obj.value = "";
        salida = obj.value ;
    }
    return salida;
}


/**/

function minPagos(obj){
    var salida;
    if (isNaN(obj.value) || obj.value < 2) {
        obj.value = "";
        salida = obj.value ;
    }
    return salida;
}



// funcion para validar el correo
function caracteresCorreoValido(email, div){
    console.log(email);
    //var email = $(email).val();
    var caract = new RegExp(/^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/);

    if (caract.test(email)===false){
        $(div).hide().removeClass('hide').slideDown('fast');

        return false;
    }else{
        $(div).hide().addClass('hide').slideDown('slow');
//        $(div).html('');
        return true;
    }
}



