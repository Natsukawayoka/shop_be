<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>登录</title>  
     <link type="text/css" rel="stylesheet" href="${ctx}/resource/ml/css/style.css">
     
    <link rel="stylesheet" href="${ctx}/resource/css/font.css">
	<link rel="stylesheet" href="${ctx}/resource/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="${ctx}/resource/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${ctx}/resource/js/xadmin.js"></script>
</head>
<body>
    <div class="x-nav">
      <span class="layui-breadcrumb">
        <a>
      </span>
      <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
    </div>
    <div class="x-body">
      <xblock>
       <button class="layui-btn" id="add"><i class="layui-icon"></i>添加</button>
      </xblock> 
      <table class="layui-table">
        <thead>
          <tr>
           <th>缩略图</th>
           <th>名称</th>
           <th>操作</th>
        </thead>
        <tbody>
        
          <c:forEach items="${pagers}" var="data" varStatus="l">
	                  <tr>
	                    <td>
	                    <img alt="" src="${data.cpUrl}" style="width: 150px;height: 80px;">
	                    </td>
	                    <td>${data.name}</td>
	                   <td class="td-manage">
				              <a title="编辑"  href="${ctx }/pp_update.do?id=${data.id}&lbId=${lbId}">
				                <i class="layui-icon">&#xe642;</i>
				              </a>
				              <a title="删除" onclick="member_del(this,${data.id})" href="javascript:;">
				                <i class="layui-icon">&#xe640;</i>
				              </a>
            </td>
	                </tr>
                  </c:forEach>
        </tbody>
      </table>
   

    </div>
    <script>
    
      layui.use('laydate', function(){
        var laydate = layui.laydate;
        
        //执行一个laydate实例
        laydate.render({
          elem: '#start' //指定元素
        });

        //执行一个laydate实例
        laydate.render({
          elem: '#end' //指定元素
        });
      });

      /*用户-删除*/
      function member_del(obj,id){
          layer.confirm('确认要删除吗？',function(index){
              //发异步删除数据
              window.location.href=ctx+"/pp_delete.do?id="+id+"&lbId="+${lbId};
          });
      }
    </script>
    <script>var _hmt = _hmt || []; (function() {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
      })();</script>
      
      <script type="text/javascript">
      
      $(function(){
      	
      	$("#add").click(function(){
      		window.location.href =ctx+"/pp_add.do?lbId=${lbId}";
      	});
      	
      });
      
      </script>
  </body>
</html>