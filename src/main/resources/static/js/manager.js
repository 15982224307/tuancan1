$(function(){
    var index = 10;
    $('.sidenav li').click(function(){

        if($(this).parent().hasClass("erji")){
            index=100;
          //  return false;
        }else {
            if (index != $(this).index()) {
                $(this).siblings('li').removeClass('now');
                $(this).addClass('now');
                index = $(this).index();3

            } else {
                if ($(this).hasClass("now")) {
                    $(this).removeClass('now');
                } else {
                    $(this).addClass("now");
                }
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
/*新建会议页面*/
$(function(){
    //自适应屏幕宽度
    window.onresize=function(){ location=location };

    var main_h = $(window).height();
    $('.hy_list').css('height',main_h-45+'px');

    var main_w = $(window).width();
    $('.xjhy').css('width',main_w-40+'px');


    $(".tabBox .tabCont:first").css("display","block");
    $(".tabBox .tabNav li").click(function(){
        $(this).siblings("li").removeClass("now");
        $(this).addClass("now");
        $(this).parents(".tabBox").find(".tabCont").css("display","none");
        var i=$(this).index();
        $(this).parents(".tabBox").find(".tabCont:eq("+i+")").css("display","block");
    });

    $('.xial_m span').click(function(){
        $(this).parent('.xial_m').siblings('.xl_ctn').toggle();
    });
});