/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ValidJava.utils;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
/**
 *
 * @author MSI
 */
public class sms {
    public static final String ACCOUNT_SID = "AC34bc3d599e57e137c358449e16767f94";
    public static final String AUTH_TOKEN = "5f98641d319fe45313095facdbf1627c";

    public static void sendSMS(String num, String msg) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(new PhoneNumber(num),new PhoneNumber("+14842635354"), msg).create();

        System.out.println(message.getSid());

    }
}
