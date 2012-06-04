/*
 Copyright 2008 Wissen Systems. All rights reserved.
 Author: Prashant Kalkar on 7:45:37 PM
 */
package com.videotutoriales.juegosandroid.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.gsm.SmsMessage;
import android.widget.Toast;

/**
 * The class is called when SMS is received.
 * 
 * @author Prashant Kalkar
 * 
 * Create Date : Nov 23, 2008
 */
public class SMSReceiver extends BroadcastReceiver {

    /**
     * @see android.content.BroadcastReceiver#onReceive(android.content.Context, android.content.Intent)
     */
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();

        Object messages[] = (Object[]) bundle.get("pdus");
        SmsMessage smsMessage[] = new SmsMessage[messages.length];
        for (int n = 0; n < messages.length; n++) {
            smsMessage[n] = SmsMessage.createFromPdu((byte[]) messages[n]);
        }

        // show first message
        Toast toast;
        if(smsMessage[0].getMessageBody().toLowerCase().trim().equals("sos")){
	        toast = Toast.makeText(context, "["+ smsMessage[0].getMessageBody().toLowerCase().trim() +"] Vamos a ayudarte!!", Toast.LENGTH_LONG);
	        
        }
        else{
        	toast = Toast.makeText(context, "["+ smsMessage[0].getMessageBody().toLowerCase().trim() +"] No te he entendido", Toast.LENGTH_LONG);
        }
        
        toast.show();
    }
}
