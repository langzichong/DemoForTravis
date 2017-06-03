package org.springframework.samples.petclinic.login;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountUtils {

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
        Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean isValidEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
        return matcher.find();
    }


    public static boolean isValidPhoneNumber(String number) {
        PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();

        try {
            Phonenumber.PhoneNumber phoneNumber = phoneUtil.parse(number, "US");
            return true;
        } catch (NumberParseException e) {
            e.printStackTrace();
            return false;
        }

    }


    public static String parseAsCountryFormat(String number) {
        PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
        try {
            Phonenumber.PhoneNumber phoneNumber = phoneUtil.parse(number, "US");

            return phoneUtil.format(phoneNumber, PhoneNumberUtil.PhoneNumberFormat.NATIONAL);
        } catch (NumberParseException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String parseAsPlainNumber(String number) {
        PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
        try {
            Phonenumber.PhoneNumber phoneNumber = phoneUtil.parse(number, "US");

            return Long.toString(phoneNumber.getNationalNumber());
        } catch (NumberParseException e) {
            e.printStackTrace();
            return "";
        }
    }
}
