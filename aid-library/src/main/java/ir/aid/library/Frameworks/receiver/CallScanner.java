package ir.aid.library.Frameworks.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;

import java.util.Date;

/*
  این کلاس شماره را اسکن کرده و بر اساس وضعیت تلفن عمل میکند.
 */
public abstract class CallScanner extends BroadcastReceiver {

    private static int LAST_STATE = TelephonyManager.CALL_STATE_IDLE;
    private static boolean IS_INCOMING;
    private static String SAVED_NUMBER;
    private static Date CALL_START_TIME;

    @Override
    public void onReceive(Context context, Intent intent) {

        CALL_START_TIME = new Date();

        String action = "android.intent.action.NEW_OUTGOING_CALL";
        String extraPhoneNumber = "android.intent.extra.PHONE_NUMBER";

        if(action.equals(intent.getAction())){
            SAVED_NUMBER = intent.getExtras().getString(extraPhoneNumber);
        }
        else {

            String stateStr = intent.getExtras().getString(TelephonyManager.EXTRA_STATE);
            String number   = intent.getExtras().getString(TelephonyManager.EXTRA_INCOMING_NUMBER);

            int state = 0;

            if(TelephonyManager.EXTRA_STATE_IDLE.equals(stateStr)){
                state = TelephonyManager.CALL_STATE_IDLE;
            }
            else if(TelephonyManager.EXTRA_STATE_OFFHOOK.equals(stateStr)){
                state = TelephonyManager.CALL_STATE_OFFHOOK;
            }
            else if(TelephonyManager.EXTRA_STATE_RINGING.equals(stateStr)){
                state = TelephonyManager.CALL_STATE_RINGING;
            }

            onCallStateChanged(context , state , number);
        }
    }

    private void onCallStateChanged(Context context, int state, String number) {

        if(LAST_STATE == state){
            return;
        }

        switch(state){

            case TelephonyManager.CALL_STATE_RINGING:
                IS_INCOMING = true;
                SAVED_NUMBER = number;
                onIncomingCallStarted(context , SAVED_NUMBER , CALL_START_TIME);
                break;

            case TelephonyManager.CALL_STATE_OFFHOOK:

                if(LAST_STATE != TelephonyManager.CALL_STATE_RINGING){
                    IS_INCOMING = false;
                    SAVED_NUMBER = number;
                    onOutgoingCallStarted(context , SAVED_NUMBER , CALL_START_TIME);
                }
                else {
                    IS_INCOMING = true;
                    SAVED_NUMBER = number;
                    onIncomingCallAnswered(context , SAVED_NUMBER , CALL_START_TIME);
                }

                break;

            case TelephonyManager.CALL_STATE_IDLE:

                if(LAST_STATE == TelephonyManager.CALL_STATE_RINGING){
                    onMissedCall(context , SAVED_NUMBER , CALL_START_TIME);
                }
                else if(IS_INCOMING){
                    onIncomingCallEnded(context , SAVED_NUMBER , CALL_START_TIME);
                }
                else {
                    onOutgoingCallEnded(context , SAVED_NUMBER , CALL_START_TIME);
                }

                break;

            default: break;
        }

        LAST_STATE = state;
    }

    protected abstract void onIncomingCallStarted(Context context , String number , Date callStartTime);

    protected abstract void onIncomingCallAnswered(Context context, String number, Date callStartTime);

    protected abstract void onIncomingCallEnded(Context context, String number, Date callStartTime);

    protected abstract void onMissedCall(Context context, String number, Date callStartTime);

    protected abstract void onOutgoingCallStarted(Context context, String number, Date callStartTime);

    protected abstract void onOutgoingCallEnded(Context context, String number, Date callStartTime);

}
