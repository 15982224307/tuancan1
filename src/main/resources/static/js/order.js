
    // /清空提示信息
    $(function() {
        $(".deleteAll").on('click', function() {
            $('#my-confirm').modal({
                relatedTarget: this,
                onConfirm: function(options) {
                    alert("处理清空的事件");
                }
            });
        });
    });
    /*删除单个商品*/
    function deleteOne( d_name) {

        alert("传递参数进行删除");

    }
    /*查看点餐详情*/
    $(function () {
        $(".list-js").click(function () {
            $(".cart_info").slideToggle(200);

            if(($("#cover").css("display")) == "none"){
                $('#cover').css('display','block'); //显示遮罩层
                $("html,body").css("height","100%").css("overflow","hidden")

            }else{
                $('#cover').css('display','none'); //取消遮罩层
                $("html,body").css("height","100%").css("overflow","visible")
            }


        });
    });

    //tab切换
    $(function(){
        window.onload = function()
        {
            var $li = $('#tab li');
            var $ul = $('#content ul');
            $li.click(function(){
                var $this = $(this);
                var $t = $this.index();

                $li.removeClass();
                $this.addClass('current');
                //$ul.css('display','none');
               // $ul.eq($t).css('display','block');
            })
        }
    });

