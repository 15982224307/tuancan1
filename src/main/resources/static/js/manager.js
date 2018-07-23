$(function(){
    var index = 10;
    $('.sidenav li').click(function(){
        if(index != $(this).index()){
            $(this).siblings('li').removeClass('now');
            $(this).addClass('now');
            index = $(this).index();
        }else{
            if($(this).hasClass("now")){
                $(this).removeClass('now');
            }else {
                $(this).addClass("now");
            }
        }
    });

    $('.erji li').click(function(){
        $(this).siblings('li').removeClass('now_li');
        $(this).addClass('now_li');
    });

    var main_h = $(window).height();
    $('.sidenav').css('height',main_h+'px');
})