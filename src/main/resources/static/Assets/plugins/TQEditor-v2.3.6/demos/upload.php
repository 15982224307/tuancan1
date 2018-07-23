<?php
/*
为了安全, 本示例不处理上传文件
图片上传接收文件接口, 建议使用UTF-8编码
输出JSON代码.

{url:'网址',  error:'出错代码, 成为时为0,非0表示出错',message:'出错提示信息, 为空时出错不提示', width:'宽度',height:'高度'}

*/
$result=array();
$result['url']='http://'.$_SERVER['HTTP_HOST'].$_SERVER['SCRIPT_NAME'].'/../../face/'.rand(1,50).'.gif';//time().'.jpg';//上传数据网址
$result['name']='';//原文件名,无后缀
$result['full_name']='';//原文件名,有后缀
$result['error']='0'; //出错代码, 成为时为0,非0表示出错, 图片不插入
$result['message']=''; //出错提示信息, 为空时出错不提示
$result['width']='100';//图片,Flash,flv,视频等的宽度
$result['height']='100';//图片,Flash,flv,视频等的高度

echo json_encode($result);
exit;

//-------------------------------------------------------------------
$result=array();
print_r($_FILES);
print_r($_POST);
