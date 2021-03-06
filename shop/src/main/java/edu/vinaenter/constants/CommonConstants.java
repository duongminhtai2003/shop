package edu.vinaenter.constants;

import static java.util.Arrays.asList;

import java.util.List;

public class CommonConstants {

    public static final String EMAIL_REGEX = "^[_\\w\\d-]+(\\.[_\\w\\d-]+)*@[\\w\\d-]+(\\.[\\w\\d-]+)*(\\.[\\w]{2,})$";

    public static final String PHONE_REGEX = "^[\\d]*$";

    public static final String WALLET_ERC20_REGEX = "^0x[A-Fa-f0-9]{40}$";
    
    public static final String BIRTHDAY_REGEX = "\\d{4}-\\d{2}-\\d{2}";

    public static final int DEFAULT_PAGING_SIZE = 3;

    public static final List<String> FIBRES = asList("4", "12", "24", "28", "72", "96", "120", "144", "192", "288", "432", "576", "customised");

    public static final String HOTLINE_REQUEST_PRODUCT_GROUP = "DUCT HOTL";

    public static final String DATE_FORMAT = "DD/MM/YYYY";

    public static final String FEASIBILITY_REQUEST_PRODUCT_GROUP = "DUCT";

    public static final Integer MAX_NUMBER_OF_RESULT = 9999;

    public static final String NO_PROJECT_FOUND = "28";

    public static final String NO_REQUEST_FOUND = "12";
    
    public static final String DIR_UPLOAD = "upload";
	
	public static final int SIZE =  100000;
	

    private CommonConstants() {
        throw new InstantiationError("Must not instantiate this class");
    }
    
    public static void main(String[] args) {
		System.out.println(BIRTHDAY_REGEX.matches("2019-01-11"));
	}
}
