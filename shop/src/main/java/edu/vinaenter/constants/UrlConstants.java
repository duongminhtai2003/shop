package edu.vinaenter.constants;


public class UrlConstants {

    public static final String URL_CLAND_HOME = "/home";
    public static final String URL_CLAND_CAT = "/cat/{id}";
    public static final String URL_CLAND_POST = "/post/{id}";
    public static final String URL_CLAND_CONTACT = "/contact";
    
    public static final String URL_CLAND_HOME_PAGE = "/home/{page}";
    
    public static final String URL_ADMIN = "/admin";
    
    public static final String URL_ADMIN_INDEX = "/index";
    
//    =======================================================
    
    public static final String URL_ADMIN_CAT_INDEX = "/cat/index";
    
    public static final String URL_ADMIN_CAT_ADD = "/cat/add";

    public static final String URL_ADMIN_CAT_DEL = "/cat/del/{id}";

    public static final String URL_ADMIN_CAT_EDIT = "/cat/edit/{id}";
//  =======================================================
    
  public static final String URL_ADMIN_BILL_INDEX = "/bill/index";
  
  public static final String URL_ADMIN_BILL_ADD = "/bill/add";

  public static final String URL_ADMIN_BILL_DEL = "/bill/del/{id}";

  public static final String URL_ADMIN_BILL_EDIT = "/bill/edit/{id}";
//  =======================================================
    
  public static final String URL_ADMIN_PAY_INDEX = "/pay/index";
  
  public static final String URL_ADMIN_PAY_ADD = "/pay/add";

  public static final String URL_ADMIN_PAY_DEL = "/pay/del/{id}";

  public static final String URL_ADMIN_PAY_EDIT = "/pay/edit/{id}";
//  =======================================================
    
    
	  public static final String URL_ADMIN_USER_INDEX = "/user/index";
	  
	  public static final String URL_ADMIN_USER_ADD = "/user/add";
	
	  public static final String URL_ADMIN_USER_DEL = "/user/del/{id}";
	
	  public static final String URL_ADMIN_USER_EDIT = "/user/edit/{id}";
	//  =======================================================
	    
		  public static final String URL_ADMIN_PRICE_INDEX = "/price/index";
		  
		  public static final String URL_ADMIN_PRICE_ADD = "/price/add";
		
		  public static final String URL_ADMIN_PRICE_DEL = "/price/del/{id}";
		
		  public static final String URL_ADMIN_PRICE_EDIT = "/price/edit/{id}";
//    =======================================================
	    
    public static final String URL_ADMIN_PRODUCT_INDEX = "/product/index";
    public static final String URL_ADMIN_PRODUCT_INDEX_PAGE = "/product/index/{page}";
    
    public static final String URL_ADMIN_PRODUCT_SEARCH = "/product/search";
    public static final String URL_ADMIN_PRODUCT_SEARCH_PAGE = "/product/search/{name}";
    
    public static final String URL_ADMIN_PRODUCT_ADD = "/product/add";

    public static final String URL_ADMIN_PRODUCT_DEL = "/product/del/{id}";

    public static final String URL_ADMIN_PRODUCT_EDIT = "/product/edit/{id}";
    
//  =======================================================
    public static final String URL_AUTH = "/auth";
    public static final String URL_LOGIN = "/login";
    
    private UrlConstants() {
        throw new InstantiationError("Must not instantiate this class");
    }
}
