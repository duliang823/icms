var icmsApp = angular.module('icmsApp', [
    'ui.router', 'ngGrid','ngAnimate', 'IcmsLoginModule'
]);

/**
 * 由于整个应用都会和路由打交道，所以这里把$state和$stateParams这两个对象放到$rootScope上，方便其它地方引用和注入。
 * 这里的run方法只会在angular启动的时候运行一次。
 * @param  {[type]} $rootScope
 * @param  {[type]} $state
 * @param  {[type]} $stateParams
 * @return {[type]}
 */
icmsApp.run(function($rootScope, $state, $stateParams) {
    $rootScope.$state = $state;
    $rootScope.$stateParams = $stateParams;
});


/**
 * 配置路由。
 * 注意这里采用的是ui-router这个路由，而不是ng原生的路由。
 * ng原生的路由不能支持嵌套视图，所以这里必须使用ui-router。
 * @param  {[type]} $stateProvider
 * @param  {[type]} $urlRouterProvider
 * @return {[type]}
 */
icmsApp.config(function($stateProvider, $urlRouterProvider) {
	$urlRouterProvider.otherwise('/index');
    $stateProvider
    .state('index', {
        url: '/index',
        templateUrl: 'tpls/loginForm.html'
    })
     .state('register', {
    	 url: '/register',
    	 templateUrl: 'tpls/register.html'
     })
     .state('registerok', {
    	 url: '/registerok',
    	 templateUrl: 'tpls/registerok.html'
     })
     
     
    /* .state('icmsmain', {
            url: '/icmsmain',
            views: {
            	'': {
            		templateUrl: 'tpls/icmsmain.html'
                },
                'Page1@icmsmain': {
                    templateUrl: "tpls/content/Page1.html"
                },
                'Page2@icmsmain': {
                    templateUrl: "tpls/content/Page2.html"
                },
                'Page3@icmsmain': {
                	templateUrl: "tpls/content/Page3.html"
                }
            }
     })
     */
    
     
     .state("icmsmain", {
         url:"/icmsmain",
         templateUrl: "tpls/icmsmain.html"
     })
     .state("icmsmain.facility", {
         url:"/facility",
         templateUrl: "tpls/content/facility.html"
     })
     .state("icmsmain.notice", {
    	 url:"/notice",
    	 templateUrl: "tpls/content/notice.html"
     })
     .state("icmsmain.property", {
    	 url:"/property",
    	 templateUrl: "tpls/content/property.html"
     })
     .state("icmsmain.userinfo", {
    	 url:"/userinfo",
    	 templateUrl: "tpls/content/userinfo.html"
     })
     .state("icmsmain.personal", {
    	 url:"/personal",
    	 templateUrl: "tpls/content/personal.html"
     })
     .state("icmsmain.business", {
         url:"/business",
         templateUrl: "tpls/content/business.html"
     })
	      .state("icmsmain.business.tradeMarket", {
	    	 url:"/tradeMarket",
	    	 templateUrl: "tpls/content/business/tradeMarket.html"
	     })
		     .state("icmsmain.business.tradeMarket.goodsDisplay", {
		    	 url:"/goodsDisplay",
		    	 templateUrl: "tpls/content/business/goodsDisplay.html"
		     })
	     .state("icmsmain.business.housekeeping", {
	    	 url:"/housekeeping",
	    	 templateUrl: "tpls/content/business/housekeeping.html"
	     })
     
     /*.state("icmsmain.Page2.Page2-1", {
         url:"/Page2-1",
         templateUrl: "tpls/content/page2/Page2-1.html"
     })
     .state("icmsmain.Page2.Page2-2", {
    	 url:"/Page2-2",
    	 templateUrl: "tpls/content/page2/Page2-2.html"
     })
     .state("icmsmain.Page2.Page2-3", {
    	 url:"/Page2-3",
    	 templateUrl: "tpls/content/page2/Page2-3.html"
     })*/
     
     
     
});


