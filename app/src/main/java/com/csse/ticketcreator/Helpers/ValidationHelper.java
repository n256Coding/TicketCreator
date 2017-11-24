package com.csse.ticketcreator.Helpers;

import android.widget.EditText;

import java.util.Calendar;

/**
 * This is a helper class to validate all user inputs given to fragments
 *
 * @author Nishan
 * @version 1.4
 */

public class ValidationHelper {
    /**
     * This method will validate user inputs at PersonalInformationFragment and Show input fields
     * highlighted if values of field not meets the validation condition.
     *
     * @param txtFname EditText field of first Name
     * @param txtLname EditText field of Last Name
     * @param txtContactNo EditText field of Contact Number
     * @param txtNicNo EditText field of NIC Number
     * @return If user inputs are blanks in any field, return false. Else return true
     */
    public static boolean validatePersonalInfo(EditText txtFname, EditText txtLname,
                                            EditText txtContactNo, EditText txtNicNo) {
        boolean isValid = true;
        if (txtFname.getText().toString().isEmpty()) {
            txtFname.setError("Please fill the first name.");
            isValid = false;
        }
        if (txtLname.getText().toString().trim().isEmpty()) {
            txtLname.setError("Please fill the last name.");
            isValid = false;
        }
        if (txtContactNo.getText().toString().trim().isEmpty()) {
            txtContactNo.setError("Please fill your contact number.");
            isValid = false;
        } else if (!ValidationHelper.validateContactNumber(txtContactNo.getText().toString().trim())) {
            txtContactNo.setError("Please fill contact number in correct format.");
            isValid = false;
        }
        if (txtNicNo.getText().toString().trim().isEmpty()) {
            txtNicNo.setError("Please fill your NIC Number.");
            isValid = false;
        } else if (!ValidationHelper.validateNicNumber(txtNicNo.getText().toString().trim())) {
            txtNicNo.setError("Please fill your NIC in correct format");
            isValid = false;
        }
        return isValid;
    }

    /**
     * This method will validate credit card information.
     *
     * @param txtCardHolder EditText field of credit card holder's name
     * @param txtCardNo EditText field of credit card number
     * @param txtExpiryDate EditText field of expiry date of credit card
     * @param txtCcv EditText field of credit card's CCV number
     * @return if user inputs are blank, return false. Else return true
     */
    public static boolean validateCardInfo(EditText txtCardHolder, EditText txtCardNo,
                                           EditText txtExpiryDate, EditText txtCcv){
        boolean isValid = true;
        if(txtCardHolder.getText().toString().trim().isEmpty()){
            txtCardHolder.setError("Please enter name of owner of card");
            isValid = false;
        }
        if(txtCardNo.getText().toString().trim().isEmpty()){
            txtCardNo.setError("Please enter credit card number.");
            isValid = false;
        }
        if(txtExpiryDate.getText().toString().trim().isEmpty()){
            txtExpiryDate.setError("Please enter expiry date of the card.");
            isValid = false;
        }
        else if(!ValidationHelper.validateCredCardExpireDate(txtExpiryDate.getText().toString().trim())){
            txtExpiryDate.setError("Please enter expiry date in correct format.");
            isValid = false;
        }
        if(txtCcv.getText().toString().trim().isEmpty()){
            txtCcv.setError("Please enter CCV number of credit card.");
            isValid = false;
        }
        else if(!ValidationHelper.validateCcv(txtCcv.getText().toString().trim())){
            txtCcv.setError("CCV is a 3 digit number.");
        }
        return isValid;
    }

    /**
     * This method is used to validate the contact number of user
     *
     * @param number the contact number to be checked
     * @return if number meets the validation criteria, then it will return true, else false
     */
    public static boolean validateContactNumber(String number) {
        if (number.matches("^[0-9]{10}$")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method is used to validate NIC number of the user
     *
     * @param number the NIC number of the user
     * @return if number meets the validation criteria, then it will return true, else false
     */
    public static boolean validateNicNumber(String number) {
        if (number.matches("^[0-9]{9}(V|X|v|x)$")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method is used to validate expiry date of credit card
     *
     * @param keyword string value of credit card expiry date which user enter
     * @return if string meets the validation criteria, then it will return true, else false
     */
    public static boolean validateCredCardExpireDate(String keyword){
        if(keyword.matches("^[0-9]{2}/[0-9]{4}$")){
            int date = Integer.parseInt(keyword.substring(0, 2));
            int year = Integer.parseInt(keyword.substring(3, 7));
            int currentYear = Calendar.getInstance().get(Calendar.YEAR);
            if((date > 0 && date < 13) && (year >= currentYear && year < 3000)){
                return true;
            }
        }
        return false;
    }

    /**
     * Validate CCV number is correct or not
     *
     * @param number string of CCV Number
     * @return if validation criteria is meet, return true. Else false
     */
    public static boolean validateCcv(String number){
        if(number.matches("^[0-9]{3}$")){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * General method to check if a specific string contains a numeric value or not
     *
     * @param keyword string value to check
     * @return if keyword is numeric, return true, Else false
     */
    public static boolean isNumeric(String keyword){
        if(keyword.matches("^[0-9]*$")){
            return true;
        }
        else{
            return false;
        }
    }

}
