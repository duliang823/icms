var icmsLoginModule = angular.module("IcmsLoginModule", ['ui.bootstrap','ngAnimate']);


var storage = window.localStorage;

icmsLoginModule.controller('LoginCtrl',['$scope','$http','$state',function($scope,$http,$state){
	$scope.loginError={show:false};
	
	/************************************账号登陆************************************/
	$scope.login=function(){
		  $http({
            url: './userInfo/queryUserInfo.action',
            method: 'POST',
            data:'loginid='+$scope.UserInfo.loginid+'&password='+$scope.UserInfo.password,
            headers:{'Content-Type': 'application/x-www-form-urlencoded'}
          }).success(function(data){
            if(data){
            	//用户验证成功：
//            	console.log(data);
            	storage.clear();//清除用户的数据
            	storage.setItem("UserInfo",JSON.stringify(data));
            	storage.setItem("firstGetAllGoodsFlag",1);
            	$state.go("icmsmain");
//            	$location.path("/icmsmain");
            }else{
            	//用户验证失败
//            	console.log("账号或密码错误");
            	$scope.loginError.show=true;
            }
          }).error(function(data,status){
        	console.log(登陆失败);
          });
	};
	
}]);


icmsLoginModule.controller('RegisterCtrl',['$scope','$http','$timeout','$location',function($scope,$http,$timeout,$location){
	$scope.UserInfo = {};
	$scope.submitForm = function(){
		console.log($scope.UserInfo);
		if($scope.signUpForm.$valid){
			console.log("提交成功");
			$http({
	            url: './userInfo/registerUser.action',
	            method: 'POST',
	            data:'username='+$scope.UserInfo.username+'&loginid='+$scope.UserInfo.loginid+'&password='+$scope.UserInfo.password,
	            headers:{'Content-Type': 'application/x-www-form-urlencoded'}
	          }).success(function(data){
	        	  if(data == 'inexistence'){
	        		  $location.path("/registerok");
	        		  console.log("用户不存在，注册成功");
	        	  }else if(data == 'exist'){
	        		  console.log("用户存在，不能注册");
	        	  }
	          }).error(function(data,status){
	        	console.log("注册失败");
	          });
		}else{
			console.log("请检查您的信息");
		}
	};
	
	
	
	$scope.registerError={show:false};
	$scope.registerError={hide:false};
	var timeout;
	$scope.$watch('UserInfo.loginid',function(newValue,oldValue,scope){
		if (newValue !== oldValue){
			if($scope.signUpForm.loginid.$valid == true){
				if(timeout) $timeout.cancel(timeout);
				timeout = $timeout(function() {
					$http({
			            url: './userInfo/queryUserInfoByloginid.action',
			            method: 'POST',
			            data:'loginid='+$scope.UserInfo.loginid,
			            headers:{'Content-Type': 'application/x-www-form-urlencoded'}
			          }).success(function(data){
			        	  if(data){
			              	//该登录账号已被注册：
			              	/*console.log(data);
			              	console.log("该登录账号已被注册");*/
			              	$scope.registerError.show=true;
			              	$scope.registerError.hide=false;
			              }else{
			            	/*console.log("该登录账号可用");*/
			            	$scope.registerError.show=false;
			              	$scope.registerError.hide=true;
			              }
			        	  
			          }).error(function(data,status){
			        	
			          });
				}, 800);
			}else{
				$scope.registerError.show=false;
	          	$scope.registerError.hide=false;
			}
		}
	});
}]);

icmsLoginModule.directive('compare',function(){
	var o = {};
	o.strict='AE',
	o.scope={
			orgText:'=compare'
	}
	o.require = 'ngModel';
	o.link = function(sco, ele, att, con){
		con.$validators.compare = function(v){
			return v == sco.orgText;
		}
		
		sco.$watch('orgText',function(){
			con.$validate();
		})
	}
	return o;
});



var deleteUserInfos = new Array();

icmsLoginModule.controller('IcmsmainCtrl',['$scope','$http','$state','$interval','$filter','$modal',function($scope,$http,$state,$interval,$filter,$modal){
	
	$scope.UserInfo = JSON.parse(storage.getItem("UserInfo"));
	
	/****************************personal.html页面**************************************/
	/**personal.html:个人信息修改**/
	$scope.UpdateUserInfo = clone($scope.UserInfo);
	$scope.updateForm = function(){
		$http({
	        url: './userInfo/updateUserInfoByloginid.action',
	        method: 'POST',
	        data: $scope.UpdateUserInfo,
	        headers:{'Content-Type': 'application/json;charset=utf-8'}
	      }).success(function(data){
//	    	  console.log("用户信息修改成功");
//	    	  console.log(data);
	    	  storage.setItem("UserInfo",JSON.stringify(data));  //修改UserInfo的值
	    	  $modal.open({
	    		  templateUrl : 'updatePersonalModal',
	    	      controller : 'IcmsmainCtrl' //modal对应的Controller
	    	  });
	    	  
	      }).error(function(data,status){
	    	console.log("用户信息修改失败");
	      });
	};
	$scope.updateOk = function(){
		 location.reload();//刷新页面
	};
	
	/****************************userinfo.html页面**************************************/
	/**userinfo.html:表格数据显示**/
	$scope.userInfos={};
	$http({
		url:'./userInfo/findUserInfosList.action',
		method:'GET'
	}).success(function(data,header,config,status){
		//响应成功
//		$scope.userInfos = data;
		///数据源
		$scope.userInfos = data;
		$scope.showEdit = true;
		$scope.master = {};
		$scope.pagenow = 1;//当前页
		
		$scope.data = data;
		//分页总数
		$scope.pageSize = 10;
		$scope.pages = Math.ceil($scope.data.length / $scope.pageSize); //分页数
		$scope.newPages = $scope.pages > 5 ? 5 : $scope.pages;
		$scope.pageList = [];
		$scope.selPage = 1;
		//设置表格数据源(分页)
		$scope.setData = function () {
		$scope.userInfos = $scope.data.slice(($scope.pageSize * ($scope.selPage - 1)), ($scope.selPage * $scope.pageSize));//通过当前页数筛选出表格当前显示数据
		}
		$scope.userInfos = $scope.data.slice(0, $scope.pageSize);
		//分页要repeat的数组
		for (var i = 0; i < $scope.newPages; i++) {
		$scope.pageList.push(i + 1);
		}
		//打印当前选中页索引
		$scope.selectPage = function (page) {  
		$scope.pagenow = page;
		//不能小于1大于最大
		if (page < 1 || page > $scope.pages) return;
		//最多显示分页数5
		if (page > 2) {
		//因为只显示5个页数，大于2页开始分页转换
		var newpageList = [];
		for (var i = (page - 3) ; i < ((page + 2) > $scope.pages ? $scope.pages : (page + 2)) ; i++) {
		newpageList.push(i + 1);
		}
		$scope.pageList = newpageList;
		}
		$scope.selPage = page;
		$scope.setData();
		$scope.isActivePage(page);
//		console.log("选择的页：" + page);
		};
		//设置当前选中页样式
		$scope.isActivePage = function (page) {
		return $scope.selPage == page;
		};
		//上一页
		$scope.Previous = function () {
		$scope.selectPage($scope.selPage - 1);
		}
		//下一页
		$scope.Next = function () {
		$scope.selectPage($scope.selPage + 1);
		};
		
		
		
	}).error(function(data,header,config,status){
		//处理响应失败
	});
	//保存列表
	$scope.saveUserInfos = function(){
		
		//删除列表中被删除的用户信息
		var deleteFlag = 0;
		if(deleteUserInfos.length != 0){
			$http({
	            url: './userInfo/deleteUserInfosById.action',
	            method: 'POST',
	            data: deleteUserInfos,
	            headers:{'Content-Type': 'application/json;charset=utf-8'}
	          }).success(function(data){
	        	
//	        	console.log("删除用户列表成功");  
	          }).error(function(data,status){
	        	deleteFlag = 1; 
//	        	console.log("删除用户列表失败");
	          });
			deleteUserInfos=[]; //清空deleteUserInfos数组
		}
		
		//保存修改后的列表：
		$http({
            url: './userInfo/updateUserInfoList.action',
            method: 'POST',
            data: $scope.userInfos,
            headers:{'Content-Type': 'application/json;charset=utf-8'}
          }).success(function(data){
//        	console.log("修改用户列表成功");    
        	if(deleteFlag == 0){
//        		console.log("可以跳转");
        		$modal.open({
  	    		  templateUrl : 'updateUserInfosModal',
  	    	      controller : 'IcmsmainCtrl' //modal对应的Controller
  	    	  	});
        	}  
        	
          }).error(function(data,status){
        	  
//        	console.log("修改用户列表失败");
          });
		
	};
	
	
	/****************************icmsmain.html页面**************************************/
	/**icmsmain.html:图片轮播**/
	$scope.lunboImg = [];
     $scope.lunboImg.push({ id: 1, img: './img/img_icmsmain/icmsmain_carousel_1.jpg' });
     $scope.lunboImg.push({ id: 2, img: './img/img_icmsmain/icmsmain_carousel_2.jpg' });
     $scope.lunboImg.push({ id: 3, img: './img/img_icmsmain/icmsmain_carousel_3.jpg' });
     $scope.lunboImg.push({ id: 4, img: './img/img_icmsmain/icmsmain_carousel_4.jpg' });
     $scope.lunboImg.push({ id: 5, img: './img/img_icmsmain/icmsmain_carousel_5.jpg' });
     $scope.lunboImg.push({ id: 6, img: './img/img_icmsmain/icmsmain_carousel_6.jpg' });
     $scope.lunbo = { 
     	currentId:1
     };
     $scope.previousImg = function () {
         if ($scope.lunbo.currentId == 1) {
             $scope.lunbo.currentId = $scope.lunboImg.length;
         }
         else {
             $scope.lunbo.currentId--;
         }
     };
     $scope.nextImg = function () {
         if ($scope.lunbo.currentId == $scope.lunboImg.length) {
             $scope.lunbo.currentId = 1;
         }
         else {
             $scope.lunbo.currentId++;
         }
     };
     $interval(function () {
         if ($scope.lunbo.currentId == $scope.lunboImg.length) {
             $scope.lunbo.currentId = 1;
         }
         else {
             $scope.lunbo.currentId++;
         }
     }, 5000);
	
     /**icmsmain.html:退出**/
     $scope.logout = function(){
    	 storage.clear();//清除用户的数据
    	 $state.go("index");
     };
     
     
     /****************************business.html页面**************************************/
 	 /**business.html:图片轮播**/
     $scope.lunboImgBusiness = [];
     $scope.lunboImgBusiness.push({ id: 1, img: './img/img_business/business_ad_1.jpg' });
     $scope.lunboImgBusiness.push({ id: 2, img: './img/img_business/business_ad_2.jpg' });
     $scope.lunboImgBusiness.push({ id: 3, img: './img/img_business/business_ad_3.jpg' });
     $scope.lunboImgBusiness.push({ id: 4, img: './img/img_business/business_ad_4.jpg' });
     $scope.lunboImgBusiness.push({ id: 5, img: './img/img_business/business_ad_5.jpg' });
     $scope.lunboBusiness = { 
     	currentId:1
     };
     $scope.previousImgBusiness = function () {
         if ($scope.lunboBusiness.currentId == 1) {
             $scope.lunboBusiness.currentId = $scope.lunboImgBusiness.length;
         }
         else {
             $scope.lunboBusiness.currentId--;
         }
     };
     $scope.nextImgBusiness = function () {
         if ($scope.lunboBusiness.currentId == $scope.lunboImgBusiness.length) {
             $scope.lunboBusiness.currentId = 1;
         }
         else {
             $scope.lunboBusiness.currentId++;
         }
     };
     $interval(function () {
         if ($scope.lunboBusiness.currentId == $scope.lunboImgBusiness.length) {
             $scope.lunboBusiness.currentId = 1;
         }
         else {
             $scope.lunboBusiness.currentId++;
         }
     }, 5000);
     
     /**business.html:特价商品**/
     $scope.specialGoodsImg = [];  
     $scope.specialGoodsImg.push({ price:42.90, text: '清风卷纸 原木纯品 3层270段卫生纸*27', img: './img/img_business/specialGoods/specialGoods1.jpg' });
     $scope.specialGoodsImg.push({ price:1899.00, text: '联想 ZUK Z2 Pro手机尊享版 6G+128G', img: './img/img_business/specialGoods/specialGoods2.jpg' });
     $scope.specialGoodsImg.push({ price:988.00, text: '联想 PHAB2 Plus全网通手机平板', img: './img/img_business/specialGoods/specialGoods3.jpg' });
     $scope.specialGoodsImg.push({ price:4098.00, text: '联想（ThinkPad）轻薄系列E470c 14英寸', img: './img/img_business/specialGoods/specialGoods4.jpg' });
     $scope.specialGoodsImg.push({ price:49.80, text: '飘柔 Rejoice 净油顺爽微米净透洗发露', img: './img/img_business/specialGoods/specialGoods5.jpg' });
     $scope.specialGoodsImg.push({ price:49.80, text: '飘柔 Rejoice 净油顺爽微米净透洗发露', img: './img/img_business/specialGoods/specialGoods5.jpg' });
     
     
     /****************************tradeMarket.html页面**************************************/
     /**tradeMarket.html:搜索商品**/
     $scope.nowPageGoods={};
     if(JSON.parse(storage.getItem("nowPageGoods")) != null){
    	 $scope.nowPageGoods = JSON.parse(storage.getItem("nowPageGoods"));
     }
     
     $scope.goodsTotalPage = [];  //商品总页数
     $scope.goodsTotalPage = JSON.parse(storage.getItem("goodsTotalPage"));
     
     $scope.displayGoodsPage = new Array(); //要显示的页数
     if(JSON.parse(storage.getItem("displayGoodsPage")) != null){
    	 $scope.displayGoodsPage = JSON.parse(storage.getItem("displayGoodsPage"));
     }
     
     $scope.displayGoodsTotalPage = 0; //要显示的总页数
     $scope.displayGoodsTotalPage = storage.getItem("displayGoodsTotalPage");
     
	 $scope.goodsPageSize = 8; //商品每页显示的数量
	 
	 $scope.searchGoodsMessage; //商品搜索信息
	 $scope.searchGoodsMessage = storage.getItem("searchGoodsMessage");
	 
	 $scope.rankBygoodsPrice = 'ASC';
	 $scope.rankBygoodsPrice = storage.getItem("rankBygoodsPrice");
	 
	 $scope.rankBygoodsCollectionnum = 'DESC';
	 $scope.rankBygoodsCollectionnum = storage.getItem("rankBygoodsCollectionnum");
	 
	 $scope.goodsNowPage = 1;//当前的商品页数 
	 $scope.goodsNowPage = storage.getItem("goodsNowPage");
	 //查询商品信息
	 $scope.searchGoods = function (searchGoodsMessage,rankBygoodsPrice,rankBygoodsCollectionnum,goodsNowPage){
		 storage.setItem("searchGoodsMessage",searchGoodsMessage);
		 $scope.searchGoodsMessage = storage.getItem("searchGoodsMessage");
		 
		 storage.setItem("rankBygoodsPrice",rankBygoodsPrice);
		 $scope.rankBygoodsPrice = storage.getItem("rankBygoodsPrice");
		 
		 storage.setItem("rankBygoodsCollectionnum",rankBygoodsCollectionnum);
		 $scope.rankBygoodsCollectionnum = storage.getItem("rankBygoodsCollectionnum");
		 
		 
		 
		 if($scope.searchGoodsMessage != null && $scope.searchGoodsMessage != '' && $scope.searchGoodsMessage != 'null'){
			//上一页，下一页处理:
			 if(goodsNowPage == 'goodsPageSubtract'){
				 if($scope.goodsNowPage > 1){
					 goodsNowPage = parseInt($scope.goodsNowPage) - 1;
				 }else{
					 goodsNowPage = 1;
				 }
			 }else if(goodsNowPage == 'goodsPageAdd'){
				 if($scope.goodsTotalPage != null){
					 if($scope.goodsNowPage < $scope.goodsTotalPage.length){
						 goodsNowPage = parseInt($scope.goodsNowPage) + 1;
					 }else{
						 if($scope.goodsTotalPage.length != 0){
							 goodsNowPage = parseInt($scope.goodsTotalPage.length);
						 }else{
							 goodsNowPage = 1;
						 }
					 }
				 }else{
					 goodsNowPage = 1;
				 }
			 }
			 
			 storage.setItem("goodsNowPage",goodsNowPage);
			 $scope.goodsNowPage = storage.getItem("goodsNowPage");
			 
//			 console.log(
//					 " searchGoodsMessage="+$scope.searchGoodsMessage
//					 +" rankBygoodsPrice="+$scope.rankBygoodsPrice
//					 +" rankBygoodsCollectionnum="+$scope.rankBygoodsCollectionnum
//					 +" goodsNowPage="+goodsNowPage
//			 );
			 
			 
			 var searchGoodsAllMessage = 'searchGoodsMessage='+searchGoodsMessage
			 							+'&'+'rankBygoodsPrice='+rankBygoodsPrice
			 							+'&'+'rankBygoodsCollectionnum='+rankBygoodsCollectionnum
			 							+'&'+'goodsPageSize='+$scope.goodsPageSize
			 							+'&'+'goodsNowPage='+goodsNowPage;
			 $http({
	            url: './goods/searchGoodsByMessage.action',
	            method: 'POST',
	            data:searchGoodsAllMessage,
	            headers:{'Content-Type': 'application/x-www-form-urlencoded'}
			 }).success(function(data){
//	         	 console.log(data);	
				 if(data[1].length != 0){
	         		//存入总的页数：
					storage.setItem("displayGoodsTotalPage",(data[0]));   
					$scope.displayGoodsTotalPage = storage.getItem("displayGoodsTotalPage");
	         		$scope.goodsTotalPage = [];
	         		for(var goodsPage=1;goodsPage<(data[0]+1);goodsPage++){
	         			$scope.goodsTotalPage.push(goodsPage);
	         		}
	         		storage.setItem("goodsTotalPage",JSON.stringify($scope.goodsTotalPage));  
	         		$scope.goodsTotalPage = JSON.parse(storage.getItem("goodsTotalPage"));
	         		//将页码存入每页显示5页的$scope.displayGoodsPage中：
	         		$scope.displayGoodsPage = [];
	         		var goodsPage5 = new Array();
	         		var goodsPerPageSize = 5; //每页显示5个页码
	         		for(var v=0;v<$scope.goodsTotalPage.length;v++){
	         			goodsPage5.push($scope.goodsTotalPage[v]);
	         			//每页显示5个页码
	         			if((v+1)%goodsPerPageSize == 0){
//	         				goodsPage5.push($scope.goodsTotalPage[v+1]);
	         				$scope.displayGoodsPage.push(goodsPage5);
	         				goodsPage5 = [];
	         			}
	         		}
	         		if(goodsPage5.length != 0){
	         			$scope.displayGoodsPage.push(goodsPage5);
	         			goodsPage5 = [];
	         		}
	         		//在$scope.displayGoodsPage前n-1个内数组后面加一个页码:
	         		if($scope.displayGoodsPage.length > 1){
	         			for(var b=0;b<($scope.displayGoodsPage.length-1);b++){
	         				$scope.displayGoodsPage[b].push(goodsPerPageSize*(b+1)+1);
	         			}
	         		}
//	         		console.log($scope.displayGoodsPage);
	         		storage.setItem("displayGoodsPage",JSON.stringify($scope.displayGoodsPage));  
	         		$scope.displayGoodsPage = JSON.parse(storage.getItem("displayGoodsPage"));
	         		
	         		//存入当前页的商品：
	         		storage.setItem("nowPageGoods",JSON.stringify(data[1]));  
	         		$scope.nowPageGoods = JSON.parse(storage.getItem("nowPageGoods"));
	         	}else{
	         		console.log("没有要查找的商品");
	         		//需要清空页数和商品：
	         		$scope.goodsTotalPage = [];
	         		$scope.nowPageGoods = {};
	         		$scope.nowPageGoods.length = 0;
	         		localStorage.removeItem('nowPageGoods');
	         		localStorage.removeItem('goodsTotalPage');
	         	}
	         	
	         }).error(function(data,status){
	        	console.log("搜索商品信息失败"); 
	         });
		 }else{
			 console.log("商品搜索输入信息为空");
		 }
	 };
	 //按回车键搜索商品:
	 $scope.enterEventTosearchGoods = function(e,searchGoodsMessage) {
        var keycode = window.event?e.keyCode:e.which;
        if(keycode == 13){
        	 $scope.searchGoods(searchGoodsMessage,0,0,1);
        }
     };
     
     
     /**tradeMarket.html:获取当前商品信息**/
     $scope.presentGoods={};
     $scope.presentGoods = JSON.parse(storage.getItem("presentGoods"));
     
     $scope.goodscollectFlag=0;
     $scope.goodscollectFlag = storage.getItem("goodscollectFlag");
     $scope.getPresentGoods = function (goodsId) {
    	 //根据商品id查询商品信息
    	 $http({
            url: './goods/findGoodsById.action',
            method: 'POST',
            data:'id='+goodsId,
            headers:{'Content-Type': 'application/x-www-form-urlencoded'}
         }).success(function(data){
//        	console.log("根据商品id查询商品信息成功");
        	
        	storage.setItem("presentGoods",JSON.stringify(data));
        	$scope.presentGoods = JSON.parse(storage.getItem("presentGoods"));
        	
         }).error(function(data,status){
        	console.log("根据商品id查询商品信息失败"); 
         });
    	 
    	 $http({
    		 url: './goods/findGoodscollectListByUserid.action',
    		 method: 'POST',
    		 data:'id='+$scope.UserInfo.id,
    		 headers:{'Content-Type': 'application/x-www-form-urlencoded'}
    	 }).success(function(data){
    		 if(data == null || data == ''){
    			 storage.setItem("goodscollectFlag",0);
		         $scope.goodscollectFlag = storage.getItem("goodscollectFlag");
    		 }else{
    			 for(var i=0;i<data.length;i++){
        			 if(data[i].goodsid == goodsId){
        				 storage.setItem("goodscollectFlag",1);
        		         $scope.goodscollectFlag = storage.getItem("goodscollectFlag");
//        				 console.log("用户收藏了该商品");
        				 break;
        			 }else{
        				 storage.setItem("goodscollectFlag",0);
        		         $scope.goodscollectFlag = storage.getItem("goodscollectFlag");
        			 }
        		 }
    		 }
    	 }).error(function(data,status){
    		 console.log("根据用户id查询用户的商品收藏情况失败"); 
    	 });
     };
     
     
     
     
     /**goodsDisplay.html:收藏商品**/
//     $scope.thisGoodscollectState={};
     $scope.collectGoods = function (goodscollectState,presentGoodsId) {
    	 //将该商品的收藏状态放入thisGoodscollectState中
//    	 if(goodscollectState == 1){
//    		 $scope.thisGoodscollectState[presentGoodsId] = 1;
//    	 }else if(goodscollectState == 0){
//    		 $scope.thisGoodscollectState[presentGoodsId] = -1;
//    	 }
  	     
    	 storage.setItem("goodscollectFlag",goodscollectState);
         $scope.goodscollectFlag = storage.getItem("goodscollectFlag");
         //把该用户对于该商品的收藏的收藏状态存入数据库
         $http({
             url: './goods/collectGoods.action',
             method: 'POST',
             data:'goodscollectState='+goodscollectState+'&userid='+$scope.UserInfo.id+'&goodsid='+presentGoodsId,
             headers:{'Content-Type': 'application/x-www-form-urlencoded'}
           }).success(function(data){
        	   
           }).error(function(data,status){
   	    	console.log("失败");
   	      });
     };
     
}]);



/**icmsmain.html:等级显示过滤器**/
icmsLoginModule.filter('administratorFilter',function(){
	return function(item){
		if(item == 1){
			return '管理员';
		}else{
			return '普通用户';
		}
	};
});

/**tradeMarket.html:商品名字长度显示过滤器**/
icmsLoginModule.filter('goodsDetailLength',function(){
	return function(detail,displayLen){
		var detailLength = 0;
		for (var i=0; i<detail.length; i++) {    
	        if (detail.charCodeAt(i)>127 || detail.charCodeAt(i)==94) {    
	        	detailLength += 2;    
	         } else {    
	        	detailLength ++;    
	         }    
	     }    
		if(detailLength > displayLen){
			var str_length = 0;
	        var str_len = 0;
	        str_cut = new String();
	        var str_len = detail.length;
			for (var i = 0; i < str_len; i++) {
	            var a = detail.charAt(i);
	            str_length++;
	            if (escape(a).length > 4) {
	                //中文字符的长度经编码之后大于4  
	                str_length++;
	            }
	            str_cut = str_cut.concat(a);
	            if (str_length > (displayLen-2)) {
	                str_cut = str_cut.concat("...");
	                break;
	            }
	        }
			return str_cut;  
		}else{
			return detail;
		}
	};
});

/**tradeMarket.html:计算显示当前页的第几页**/
icmsLoginModule.filter('calculateDisplayPagePage',function(){
	return function(goodsNowPage,goodsPerPageSize){
		return parseInt(parseInt(goodsNowPage-1)/goodsPerPageSize);
	};
});

/**userinfo.html：username编辑指令**/
icmsLoginModule.directive("edit",function($document){
  return{
    restrict: 'AE',
    require: 'ngModel',
    link: function(scope,element,attrs,ngModel){
       element.bind("click",function(){
    	   
       var ids = new Array();
       ids[0] = "txt_username_" +ngModel.$modelValue.id;
       ids[1] = "txt_email_" +ngModel.$modelValue.id;
       ids[2] = "txt_phonenumber_" +ngModel.$modelValue.id;
       ids[3] = "txt_age_" +ngModel.$modelValue.id;
       ids[4] = "txt_sex1_" +ngModel.$modelValue.id;
       ids[5] = "txt_sex2_" +ngModel.$modelValue.id;
       ids[6] = "txt_blocknum_" +ngModel.$modelValue.id;
       ids[7] = "txt_unitnum_" +ngModel.$modelValue.id;
       ids[8] = "txt_housenum_" +ngModel.$modelValue.id;
       
       for(var i=0;i<ids.length;i++){
    	   var id = ids[i];
    	   if((i == 4) || (i == 5)){
    		   scope.$apply(function(){
  		         angular.copy(ngModel.$modelValue,scope.master);
  		       })
  		       var obj = $("#"+id);
  		       obj.removeClass("inactive");
  		       obj.addClass("active");
  		       obj.removeAttr("disabled");
  		       scope.$apply(function(){
  		         scope.showEdit = false;
  		       });
    	   }else{
    		   scope.$apply(function(){
		         angular.copy(ngModel.$modelValue,scope.master);
		       })
		       var obj = $("#"+id);
		       obj.removeClass("inactive");
		       obj.addClass("active");
		       obj.removeAttr("readOnly");
		       scope.$apply(function(){
		         scope.showEdit = false;
		       });
    	   }
       }
    	   
      });
    }
  }
});
/**userinfo.html：更新指令**/
icmsLoginModule.directive("update",function($document){
  return{
    restrict: 'AE',
    require: 'ngModel',
    link: function(scope,element,attrs,ngModel){
      element.bind("click",function(){
    	  var ids = new Array();
          ids[0] = "txt_username_" +ngModel.$modelValue.id;
          ids[1] = "txt_email_" +ngModel.$modelValue.id;
          ids[2] = "txt_phonenumber_" +ngModel.$modelValue.id;
          ids[3] = "txt_age_" +ngModel.$modelValue.id;
          ids[4] = "txt_sex1_" +ngModel.$modelValue.id;
          ids[5] = "txt_sex2_" +ngModel.$modelValue.id;
          ids[6] = "txt_blocknum_" +ngModel.$modelValue.id;
          ids[7] = "txt_unitnum_" +ngModel.$modelValue.id;
          ids[8] = "txt_housenum_" +ngModel.$modelValue.id;
          
          for(var i=0;i<ids.length;i++){
       	   var id = ids[i];
       	   if((i == 4) || (i == 5)){
	       		var obj = $("#"+id);
	            obj.removeClass("active");
	            obj.addClass("inactive");
	            obj.attr("disabled","disabled");
	             scope.$apply(function(){
	              scope.showEdit = true;
	            });
       	   }else{
	       		var obj = $("#"+id);
	            obj.removeClass("active");
	            obj.addClass("inactive");
	            obj.attr("readOnly",true);
	             scope.$apply(function(){
	              scope.showEdit = true;
	            });
       	   }
          }
      })
    }
  }
});
/**userinfo.html：取消指令**/
icmsLoginModule.directive("cancel",function($document){
  return{
    restrict: 'AE',
    require: 'ngModel',
    link: function(scope,element,attrs,ngModel){
      element.bind("click",function(){
         scope.$apply(function(){
           angular.copy(scope.master,ngModel.$modelValue);
           //console.log(ngModel.$modelValue);
         })
         
         var ids = new Array();
         ids[0] = "txt_username_" +ngModel.$modelValue.id;
         ids[1] = "txt_email_" +ngModel.$modelValue.id;
         ids[2] = "txt_phonenumber_" +ngModel.$modelValue.id;
         ids[3] = "txt_age_" +ngModel.$modelValue.id;
         ids[4] = "txt_sex1_" +ngModel.$modelValue.id;
         ids[5] = "txt_sex2_" +ngModel.$modelValue.id;
         ids[6] = "txt_blocknum_" +ngModel.$modelValue.id;
         ids[7] = "txt_unitnum_" +ngModel.$modelValue.id;
         ids[8] = "txt_housenum_" +ngModel.$modelValue.id;
         
         for(var i=0;i<ids.length;i++){
      	   var id = ids[i];
      	   if((i == 4) || (i == 5)){
      		 var obj = $("#"+id);
             obj.removeClass("active");
             obj.addClass("inactive");
             obj.attr("disabled","disabled");
              scope.$apply(function(){
               scope.showEdit = true;
             })
      	   }else{
      		 var obj = $("#"+id);
             obj.removeClass("active");
             obj.addClass("inactive");
             obj.prop("readOnly",true);
              scope.$apply(function(){
               scope.showEdit = true;
             })
      	   }
         }
         
      })
    }
  }
});
/**userinfo.html：删除指令**/
icmsLoginModule.directive("delete",function($document){
  return{
    restrict:'AE',
    require: 'ngModel',
    link:function(scope, element, attrs,ngModel){
      element.bind("click",function(){
        var id = ngModel.$modelValue.id;
        
//        alert("delete item where employee id:=" + id);
        scope.$apply(function(){
          for(var i=0; i<scope.userInfos.length; i++){
            if(scope.userInfos[i].id==id){
//               console.log(scope.userInfos[i])
               deleteUserInfos.push(scope.userInfos[i]);
               scope.userInfos.splice(i,1);
            }
          }
//          console.log(scope.userInfos);
        })
      })
    }
  }
});



//克隆对象的函数
function clone(obj) {
	var o;
	if (typeof obj == "object") {
		if (obj === null) {
			o = null;
		} else {
			if (obj instanceof Array) {
				o = [];
				for (var i = 0, len = obj.length; i < len; i++) {
					o.push(clone(obj[i]));
				}
			} else {
				o = {};
				for (var j in obj) {
					o[j] = clone(obj[j]);
				}
			}
		}
	} else {
		o = obj;
	}
	return o;
}



