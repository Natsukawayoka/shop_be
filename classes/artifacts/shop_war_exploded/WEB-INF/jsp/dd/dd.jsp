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
      <div class="layui-row">
        <form class="layui-form layui-col-md12 x-so" method="post" action="${ctx}/dd_dd.do">
          <input type="text" name="code"  placeholder="请输入订单号" autocomplete="off" class="layui-input" value="${Obj.code}">
          <button class="layui-btn" type="submit" lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
        </form>
      </div> 
      <table class="layui-table">
        <thead>
        
          <tr>
               <th width="90">订单编号</th>
				<th width="90">下单时间</th>
				<th width="100">购买数量</th>
				<th width="100">总价</th>
				<th width="90">下单人</th>
				<th width="90">商品名称</th>
				<th width="100">收货地址</th>
				<th width="100">订单状态</th>
				<th width="100">操作</th>
        </thead>
        <tbody>
        
          <c:forEach items="${pagers.datas}" var="data" varStatus="l">
               <tr>
	                    <td>${data.code}</td>
						<td>${data.createTime}</td>
						<td>${data.num}</td>
						<td>${data.price}</td>
						<td>${data.user.openId}</td>
						<td>${data.goods.title}</td>
						<td>${data.address}</td>
						<td>
						<!-- /订单状态 0 已支付待发货 1 已发货 2.申请退款 3 已退款 4 已收货 5 已评价 -->
						<c:if test="${data.status == 0}">待发货</c:if>
						<c:if test="${data.status == 1}">已发货</c:if>
						<c:if test="${data.status == 2}">申请退款</c:if>
						<c:if test="${data.status == 3}">已退款</c:if>
						<c:if test="${data.status == 4}">已收货</c:if>
						<c:if test="${data.status == 5}">已评价</c:if>
						</td>
	                    <td class="td-manage">
				              <c:if test="${data.status == 0}">
				                <a title=""  href="${ctx }/dd_fh.do?id=${data.id}">去发货</a>
				              </c:if>
				               <c:if test="${data.status == 2}">
				                   <a title=""  href="${ctx }/dd_tk.do?id=${data.id}">去退款</a>
				               </c:if>
                        </td>
                        
                      
	                </tr>
                  </c:forEach>
        </tbody>
      </table>
      <div class="page">
        <div>
          <div class="pagelist">
			<pg:pager  url="${ctx}/dd_dd.do" maxIndexPages="5" items="${pagers.total}"  maxPageItems="15" export="curPage=pageNumber" >
							<pg:last>  
								共${pagers.total}记录,共${pageNumber}页,  
							</pg:last>  
								当前第${curPage}页 
					        <pg:first>  
					    		<a href="${pageUrl}">首页</a>  
							</pg:first>  
							<pg:prev>  
					    		<a href="${pageUrl}">上一页</a>  
							</pg:prev>  
					       	<pg:pages>  
					        	<c:choose>  
					            	<c:when test="${curPage eq pageNumber}">  
					                	<font color="red">[${pageNumber }]</font>  
					            	</c:when>  
					            	<c:otherwise>  
					               		<a href="${pageUrl}">${pageNumber}</a>  
					            	</c:otherwise>  
					        	</c:choose>  
					    	</pg:pages>
					             
					        <pg:next>  
					    		<a href="${pageUrl}">下一页</a>  
							</pg:next>  
							<pg:last>  
								<c:choose>  
					            	<c:when test="${curPage eq pageNumber}">  
					                	<font color="red">尾页</font>  
					            	</c:when>  
					            	<c:otherwise>  
					               		<a href="${pageUrl}">尾页</a>  
					            	</c:otherwise>  
					        	</c:choose> 
					    		  
							</pg:last>
						</pg:pager>
					</div>
        </div>
      </div>

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

       /*用户-停用*/
      function member_stop(obj,id){
          layer.confirm('确认要停用吗？',function(index){

              if($(obj).attr('title')=='启用'){

                //发异步把用户状态进行更改
                $(obj).attr('title','停用')
                $(obj).find('i').html('&#xe62f;');

                $(obj).parents("tr").find(".td-status").find('span').addClass('layui-btn-disabled').html('已停用');
                layer.msg('已停用!',{icon: 5,time:1000});

              }else{
                $(obj).attr('title','启用')
                $(obj).find('i').html('&#xe601;');

                $(obj).parents("tr").find(".td-status").find('span').removeClass('layui-btn-disabled').html('已启用');
                layer.msg('已启用!',{icon: 5,time:1000});
              }
              
          });
      }

      /*用户-删除*/
      function member_del(obj,id){
          layer.confirm('确认要删除吗？',function(index){
              //发异步删除数据
              window.location.href =ctx+"/goods_delete.do?id="+id;
          });
      }



      function delAll (argument) {

        var data = tableCheck.getData();
  
        layer.confirm('确认要删除吗？'+data,function(index){
            //捉到所有被选中的，发异步进行删除
            layer.msg('删除成功', {icon: 1});
            $(".layui-form-checked").not('.header').parents('tr').remove();
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
      		window.location.href =ctx+"/goods_add.do";
      	});
      	
      });
      
      </script>
  </body>
</html>