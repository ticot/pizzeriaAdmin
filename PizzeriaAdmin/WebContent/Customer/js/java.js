$(document).ready(function() {
  
    var cutCount = 1;
  
    $("#more p").each(function (i) {
        i++;
        if(i == cutCount) {
            $(this).append(' <a href="javascript:void(1)" onclick="$(\'#more p\').show(); $(this).hide()"><br><br>Näytä lisää</b>')   
        }
        if(i > cutCount) {
           $(this).hide() ;
        }
    });
    
});
