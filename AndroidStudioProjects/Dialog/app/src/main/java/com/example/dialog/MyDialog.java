package com.example.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class MyDialog extends Dialog implements View.OnClickListener {
    private String msg;
    private MyDialogBtnListener listener;
    public MyDialog(Context context, String msg){
        super(context);
        this.msg = msg;
    }

    public MyDialog(Context context, String msg, MyDialogBtnListener listener){
        super(context);
        this.msg=msg;
        this.listener=listener;
    }

    public interface MyDialogBtnListener{
        public void onClick(View view);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.my_dialog); //绑定对话框布局文件
        TextView tv_msg = findViewById(R.id.tv_msg);
        Button btn_ok = findViewById(R.id.btn_ok);
        Button btn_cancel=findViewById(R.id.btn_cancel);
        tv_msg.setText(msg);
        btn_ok.setOnClickListener(this);
        btn_cancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn_ok){
            listener.onClick(v);
        }
        dismiss();
    }

}
