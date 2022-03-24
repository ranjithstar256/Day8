package ran.am.day8;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        lisms(context,intent);
        if ("android.intent.action.BOOT_COMPLETED".equals(intent.getAction())) {
            Toast.makeText(context, "hi", Toast.LENGTH_SHORT).show();

            Log.i("Myrecr123", "onReceive: restarted");
        }

    }

    public void lisms(Context context, Intent intent){
        Bundle bundle = intent.getExtras();

        String msg_from;
        SmsMessage[] msgs = null;
        if (bundle!=null){

            try {
                Object[] p = (Object[]) bundle.get("pdus");
                msgs= new SmsMessage[p.length];
                for (int i = 0 ; i<msgs.length;i++){

                    msgs[i]=SmsMessage.createFromPdu((byte[]) p[i]);

                    msg_from=msgs[i].getOriginatingAddress();
                    String msgBody = msgs[i].getMessageBody();
                    Toast.makeText(context, msg_from+"\n"+msgBody, Toast.LENGTH_SHORT).show();

                    Intent in = new Intent(context,MainActivity.class);
                    in.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    in.putExtra("helo",msgBody);
                    context.startActivity(in);

                    String otp = msgBody.substring(0,4);
                    Toast.makeText(context, ""+otp, Toast.LENGTH_SHORT).show();

                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}