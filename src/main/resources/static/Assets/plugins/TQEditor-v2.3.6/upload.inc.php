<?php
/*************************************************
* 本单元写于 ：
* 作者     : 李腾秋
* E-Mail   : litqqs@163.com
* 版权所有 : 李腾秋
*************************************************/
/*************************************************
上传处理相关函数
例子:
require 'upload.inc.php';
$save_dir='./upload/'; 
$save_url='./upload/';
$file_field_name='file';
$max_size=1024*1024; 
$exts=''; 
echo json_encode(uploadFile($save_dir, $save_url, $file_field_name, $max_size,$exts));

*************************************************/
/**
* 处理上传文件
* 返值结构
* -error  出错代码,0表示成功
* -message   出错信息
* -url         保存后的网址
* -file        相对保存目录的文件路径
* -name        原始文件名
* -ext         上传文件的后缀小写形式,如".jpg"
* @param string $save_dir    保存文件目录
* @param string $save_url    目录的web访问网址
* @param string $file_field_name  表单名
* @param int $max_size    文件最大尺寸
* @param bool $auto_create_sub_dir 是否将自动建子目录来保存文件
* @param string $exts  允许后缀,多个后缀用分号";"隔开,"*"表示所有. 图片后缀例: "jpg;gif;png"
* @return array
*/
function uploadFile($save_dir, $save_url, $file_field_name='file', $max_size=0, $exts='*', $auto_create_sub_dir=true)
{
	$result=array();
	$result['error']=0;
	$result['message']='';
	$result['url']='';//上传后文件网址
	$result['file']='';//相对保存目录的文件路径
	$result['name']='';
	$result['ext']='';//上传文件的后缀小写形式,如".jpg"
	//$result['exec_js']='';

	if(!isset($_FILES[$file_field_name]['tmp_name']) || !is_uploaded_file($_FILES[$file_field_name]['tmp_name'])){
		$result['error']=1;
		$result['message']='失败:上传失败';
		return $result;
	}

	//检查大小
	if($max_size>0  && $_FILES[$file_field_name]['size']>$max_size){
		$result['error']=2;
		
		if($max_size>1048576)//1M
		{
			$size = round($max_size / 1048576,2) .'MB';
		}elseif($max_size>1024){
			$size = round($max_size / 1024,2) .'KB';
		}else{	
			$size = $max_size .'B';
		}

		$result['message']='失败:文件太大, 请上传小于 '.$size.' 的文件.';
		return $result;
	}

	$result['name'] = $_FILES[$file_field_name]['name'];
	$ext = $result['ext'] = '.'.strtolower(substr(strrchr($_FILES[$file_field_name]['name'],'.'),1));
	//文件后缀检查
	if($exts!='*.*' && $exts!='*'){
		$exts= explode(';',strtolower($exts));
		if(!in_array(substr($ext,1),$exts)){
			$result['error']=3;
			$result['message']='失败:请上传(*.'.implode(';*.',$exts).')格式文件';
			return $result;
		}
	}
	$p = $auto_create_sub_dir ? date('Ym/d/') :'';
	if(!is_dir($save_dir . $p) && !mkdir($save_dir . $p, 0755, true)){
		$result['error']=4;
		$result['message']='失败:建目录['.UPLOAD_DIR . $p.']失败';
		return $result;
	}

	$f = $p.time().$ext;
	while(is_file($save_dir.$f)){
		$f = $p.time().'_'.uniqid().$ext;
	}
	if(!move_uploaded_file($_FILES[$file_field_name]['tmp_name'], $save_dir.$f)){
		$result['error']=5;
		$result['message']='失败, 写入文件['.$save_dir.$f.']失败.';
		return $result;
	}

	$result['url'] = $save_url . $f;
	$result['file'] = $f;

	return $result;
}
//上传图片
function uploadImage($save_dir, $save_url, $file_field_name='file', $max_size=2097152, $exts='jpg;gif;png', $auto_create_sub_dir=true)
{
	$result=uploadFile($save_dir, $save_url, $file_field_name, $max_size, $exts, $auto_create_sub_dir);
	$result['width']=0;
	$result['height']=0;
	if($result['error']==0){
		$size_info = @getimagesize($save_dir.$result['file']);
		if(false==$size_info){
			return $result;
		}
		$result['width']=$size_info[0];
		$result['height']=$size_info[1];
		//list($width,$height,$type,$text)
	}
	return $result;
}
