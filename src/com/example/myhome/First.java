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
	  //�����������
    EditText editID,editPW;
    TextView txtFP;
    Button btnLogin,btntu;
    //������ȷ���û���Ϣ
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
         //ʵ�ֳ�����
         String text=txtFP.getText().toString();
         SpannableString sp=new SpannableString(text);
         //���ó�����
         sp.setSpan(new URLSpan("https://aq.qq.com/cn2/findpsw/pc/pc_find_pwd_input_a count?pw_type=0&aquin="),0,sp.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
         //�������ø�TextView
         txtFP.setText(sp);
         //����TextView����ת�����ҳ��
         txtFP.setMovementMethod(LinkMovementMethod.getInstance());
         //Ϊ��ť���õ�������������onclick��ʵ��
         btnLogin.setOnClickListener(new OnClickListener(){
         	@Override
         	public void onClick(View v){
         		if(editID.getText().toString().equals(id)&&editPW.getText().toString().equals(pw)){
                       Toast.makeText(First.this, "��½�ɹ���", Toast.LENGTH_SHORT).show(); 
                       Intent intent = new Intent(First.this, SecondActivity.class);             
                       startActivity(intent);
         		}else{
         			Toast.makeText(First.this, "�Բ��������������������ԣ�", Toast.LENGTH_SHORT).show();
         			//��ձ༭���ı�
         			editID.setText(null);
         			editPW.setText(null);
         			//��ȡ����
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
    
    
    
    
    
    
   