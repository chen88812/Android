package com.example.myhome;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class First extends Activity{
	  //声明组件变量
    EditText editID,editPW;
    TextView txtFP;
    Button btnLogin,btntu;
    //定义正确的用户信息
    String id="1169366641",pw="1234";
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
         editID=(EditText)this.findViewById(R.id.edtText1);
         editPW=(EditText)this.findViewById(R.id.edtText2);
         txtFP=(TextView)this.findViewById(R.id.tableView3);
         btnLogin=(Button)this.findViewById(R.id.button1);
         btntu=(Button)this.findViewById(R.id.button2);
         //实现超链接
         String text=txtFP.getText().toString();
         SpannableString sp=new SpannableString(text);
         //设置超链接
         sp.setSpan(new URLSpan("https://aq.qq.com/cn2/findpsw/pc/pc_find_pwd_input_a count?pw_type=0&aquin="),0,sp.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
         //对象设置给TextView
         txtFP.setText(sp);
         //设置TextView可跳转到相关页面
         txtFP.setMovementMethod(LinkMovementMethod.getInstance());
         //为按钮设置单击监听，并在onclick里实现
         btnLogin.setOnClickListener(new OnClickListener(){
         	@Override
         	public void onClick(View v){
         		if(editID.getText().toString().equals(id)&&editPW.getText().toString().equals(pw)){
                       Toast.makeText(First.this, "登陆成功！", Toast.LENGTH_SHORT).show(); 
                       Intent intent = new Intent(First.this, SecondActivity.class);             
                       startActivity(intent);
         		}else{
         			Toast.makeText(First.this, "对不起，您的输入有误，请重试！", Toast.LENGTH_SHORT).show();
         			//清空编辑框文本
         			editID.setText(null);
         			editPW.setText(null);
         			//获取焦点
         			editID.requestFocus();
         		}
     
         		}
         	}
         );
         btntu.setOnClickListener(new OnClickListener(){
          	@Override
          	public void onClick(View v){
          		finish();
          		}            		
          	}
         );        	
        
        }
    }
    
    
    
    
    
    
   