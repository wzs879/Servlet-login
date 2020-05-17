<!doctype html>
<%@ page language="java" import="java.util.*" contentType="text/html;charset=UTF-8"%>
<html>
<head>
<meta charset="utf-8">
<title>登录</title>
<style>
.bg {
    position: fixed;
    left: 0;
    right: 0;
    top: 0;
    bottom: 0;
    background: url("baidu.jpg") no-repeat;
    background-size: cover;
*background: 0 0
}
.bg img {
    display: none;
*display: block;
    width: 100%;
    height: 100%
}
.logo {
    position: fixed;
    left: 70px;
    top: 60px;
    width: 124.4px;
    height: 40px
}
.logo img {
    width: 100%;
    height: 100%
}
.text {
    position: fixed;
    left: 195px;
    top: 270px;
    color: #fff
}
.text h3 {
    font-size: 54px;
    letter-spacing: 0;
    font-weight: 700
}
.text p {
    font-size: 30px;
    letter-spacing: 3.81px;
    font-weight: 270
}

.trunk{
    position: absolute;
    left: 939px;
    top: 50%;
    margin-top: -259px;
    width: 480px;
    height: 518px;
    background: rgba(255,255,255,.9);
    border-radius: 12px;
    overflow: hidden;
}
#welcome h3 {
	display: block;
    font-weight: bold;
    color: #000;
    padding-bottom: 0px;
    width: 441px;
    height: 52px;
    font-size: 36px;
    padding-left: 40px;   
}
p {
    display: block;
    width: 441px;
    height: 19.2px;
    font-size: 14px;
    color: #9B9B9B;
    padding-left: 40px;
    margin-bottom: 40px;
    margin-top: -45px;
}
p a {
    color: #2e58ff;
    cursor: pointer;
}
label {
    display: block;
    color: #333;
    font-size: 14px;
    float: left;
    width: 82px;
    height: 40px;
    text-align: right;
    line-height: 40px;
    margin-right: 15px;
    font-weight: 200px;
    margin-bottom: 20px;
}
#register{
    margin-bottom: 20px;
    position: relative;
    clear: both;
    zoom: 1;
    margin: 0;
    padding: 0px;
}
.in {
    padding: 11px 10px;
    max-height: 40px;
    background: #fff;
    border: 1px solid #E0E0E0;
    border-radius: 4px;
    font-size: 14px;
    width: 321px;
    color: #000;
}
input {
    display: block;
    position: relative;
    float: right;
    height: 16px;
}
.pushbutton {
    height: 40px;
    font-weight: 400;
    float: right;
    margin-top: -60px;
    margin-right: 10px;
    width: 126px;
    border-radius: 4px;
    background: #fff;
    border: 1px solid #E0E0E0;
    font-size: 12px;
    color: #333;
    letter-spacing: 0;
    text-align: center;
    line-height: 24px;
}
.load{
    background: #BDCEFC;
    border-radius: 25px;
    width: 399px;
    float: left;
    margin-top: 20px;
    display: block;
    height: 50px;
    font-size: 16px;
    font-weight: 700;
    cursor: pointer;
    color: #fff;
   
}
.check {
    display: block;
    position: relative;
    float: left;
    height: 16px;
    padding: 11px 10px;
    max-height: 40px;
    background: #fff;
    border: 1px solid #E0E0E0;
    border-radius: 4px;
    font-size: 14px;
    width: 184px;
    margin-right: 9px;
}
.agree .ment {
    margin-bottom: 20px;
    margin-left: 41px;
    width: 399px;
    text-align: center;
}
.OPT {
    position: relative;
    float: left;
    vertical-align: middle;
    font-size: 100%;
    height: 12.8;
    top: 20px;
    left: -410px;
    margin-top: 80px;
    padding: 0;
    background-color: initial;
    cursor: default;
    box-sizing: border-box;
    border: initial;
    text-rendering: auto;
}
#first {
    color: #666;
    width: 60px;
    height: 13.6px;
    font-size: 12px;
    padding-left: 20px;
    margin-bottom: 5px;
    cursor: default;
    text-align: center;
}
#contract {
    cursor: default;
    color: #2E58FF;
    text-decoration: none;
    font-size: 12px;
}
#j{
	color: #666;
	cursor: default;
    text-decoration: none;
    font-size: 12px;
}
.footer {
    position: fixed;
    left: 70px;
    bottom: 57px;
    font-size: 14px;
    color: #fff
}
.footer .help a {
    text-decoration: none;
    color: #fff;
    cursor: pointer
}
.footer .help .help-text {
    filter: alpha(opacity=80);
    opacity: .8
}
.footer .help .help-text:hover {
    opacity: 1;
    filter: alpha(opacity=100)
}
.footer .help .line {
    display: inline-block;
    width: 2px;
    height: 12px;
    filter: alpha(opacity=78);
    opacity: .78;
    margin: 0 12px 0 13px;
    background: #fff;
    position: relative;
    top: 1px
}
</style>
</head>
<body>

  <div class="bg"> <img  src="reg_bg_min.jpg" > </div>   

 <!-- -- <div class="logo"> <img src="baidu.png"> </div>-->
<div class="text">
  <h3>用科技</h3>
  <p>让复杂的世界更简单</p>
</div>
<div class="footer"> <span class="help"> <a class="help-text" href=" " target="_blank">百度</a> <span class="line"></span> </span> <span class="copyright">2020&nbsp;&copy;Baidu</span> </div>
<div class="trunk">
  <div id="welcome">
    <h3>欢迎登录?</h3>
  </div>
  <p>已有账号?<a herf="">登录</a></p>
  <form id="loadForm" action="/servlet_02/servlet_02" method="post">
    <p id="register" style="display: ;">
      <label>用户名</label>
      <input type="text" name="uname" id="uname" value placeholder="请输入账号" class="in"  /><div id="divName"></div>
    </p>
    <span id="msg" style="color: red"></span>
    <p id="register" style="display: ;">
      <label>密 码</label>
      <input type="password" name="upwd" id="upwd" value placeholder="请输入密码" class="in" /><div id="divPass"></div>
    </p>
   
    <p >
      <input type="button" onclick="checkForm()" value="登录" class="load"><br/>
    </p><br/>
    
  </form>
</div>
</body>
<script type="text/javascript" src="/servlet_02/static/js/jquery-3.5.1.min.js"></script>
	<script type="text/javascript" charset="utf-8">
function nameText(){
var name= document.getElementById("uname");
var divID= document.getElementById("divName");
 divID.innerHTML="";
if(name.value==""){
divID.innerHTML="用户名不能为空！";
return false;
}
}
function numberText(){
var num= document.getElementById("number");
var divN= document.getElementById("divNum");
divN.innerHTML="";
if(num.value==""){
divN.innerHTML="密码不能为空!";
return false;
}
}
function passText(){
var pass= document.getElementById("upwd");
var divIP= document.getElementById("divPass");
divIP.innerHTML="";
if(pass.value==""){
divIP.innerHTML="密码不能为空!";
return false;
}
}

function checkForm(){
	var uname=$("#uname").val();
	var upwd=$("#upwd").val();
	if(uname==null || uname=="")
		{
		$("#msg").html("*用户名不能为空！");
		return;
		}
	if(upwd==null || upwd=="")
	{
	$("#msg").html("*密码不能为空!");
	return;
	}
	$("#loadForm").submit();
}
</script>
</html>