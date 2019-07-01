package com.example.myhome;

import java.io.IOException;





import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.view.View;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;

/**
 * Description:
 * <br/>website: <a href="http://www.crazyit.org">crazyit.org</a>
 * <br/>Copyright (C), 2001-2014, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class TextSwitcherTest extends Activity
{
	
	
	private MediaPlayer mMediaPlayer;
	
	TextSwitcher textSwitcher;
	String[] strs = new String[]
		{
			"      ʯ��ׯ����Ͻ���������������������硢�Ļ�����ʮ�����ĵ����������׷���Ļ���ַ��Ŀǰȫ�о��ڷ��ֵ������ƽԭ����������ַ�����Լ6000��7000�ꣻ���ֹŴ���ַ������̨��֤����6000����ǰ�л�����ʼ�����������ڴ˵أ�ս����ɽ���Ļ�����ʯ��ׯ��ʷ�Ļ������е���Ҫһ����Ҳ�Ǽ�޻��̨�����Ļ�֮����������Ŀ�ĻԻ��Ļ���"
			+ "����ʱ�ڣ�ʯ��ׯ������̫��ɽ��һֱ��������������׺��������ߵ���Ҫұ�����֮һ��"
			+ "   ��ұ�ӡ���˶�����������ʱ�����й���̡����̸��˲�����ʢ��ʱ�ڣ��㡢�Զ��ݵ��ڽ��Ļ����й��ڽ�ʷ��Ҳ������Ѥ��ƪ�¡����ݰ����£��ഫ�����ڶ������Ǻӱ�����ϵķ����Ժ��ʯ��ׯ�����Ļ�����Ϊ��Ե���ʷ�ɾ������ݰ����ţ��������繫�ϵ�"
			+ "���ͳ���ʽʯ���ŵı��棬��������������ʷ��ռ��ͻ���ĵ�λ�������Ϲ�ȷ��Ϊ���������Ļ��Ų�������ʱ��ʯ��ׯ�����Ļ�������κ�������������ʱ�ڣ�������������ŷ���ޡ������������������ͻ��Ⱥ��ʹ�ӱ��������涨�����������������㼣���ٽ�����һ�������á��Ļ��ķ��١� ",
			"      ��Ԫʱ��ʯ��ׯ���������ɾ͵Ĵ������Ǿ������ɽ��������¥�������Ȼһ�壬��շɼ���ǧ���֮�䣬״��ɺ磬�����ʽ���ɣ�������ΰ�վ�����ӳ����ʱ�Ͷ�����߳��Ľ�����������ѧ���衣"
			+ "�����������������������Ͼ���¬�±ڻ�����Щ�ڻ��̳в���չ���й��Ŵ��ڻ��Ĵ�ͳ�������ڹ�ͼ�����衢��ɫ���������͵ȷ��涼�ﵽ�ܸߵ�ˮƽ����ʱ����Ȼ��ѧ�ɹ�Ҳ�ǳ���˶��������ѧ�ҡ�ѧ����ұ����ѧ��Ԫѧ��������о������й��ĳ��ȴ������˵�����ã���־��13����������ѧ����߳ɾ͡�"
			+ "    20���ͳ��ڣ�ƽ����·���񾩹���·������̫��·����ʯ̫��·������޽������ڴ˽��㣬ʯ��ׯ���ǰ�������·���˽����𽥷�չ�����ġ�1925�꣬��������ʼ��ʯ��ׯ�У���������Ϊʯ���У���1947��11��12��ʯ��ׯ�н�ţ���Ϊȫ���������Ľϴ����֮һ����ʱ��ȫ���˿�19���д�С����27�ң���ҵ�ܲ�ֵ2000��Ԫ���ҡ�1948��5�£�1949��3�¼䣬���������й�������й������ž��ܲ����ڵأ�ë��ϯ���������ڴ�ָ���������������ս�ۣ��ٿ����������й��������߽����ȫ�ᡣ1968��ӱ�ʡʡ���ɱ���Ǩ��ʯ��ׯ�С� ",
			"      �ĸ￪�Ÿ�ʯ��ׯ�ṩ�˲�����ʾ��ô�ѭ���������ִ������еĻ�����ʯ��ׯ���价���򡢻���������Խ����λ�úͷḻ����Ȼ��Դ��������Դ���ƣ������˹�����㷺��ע��"
			+ "����������ʯ��ׯ�ĳ��л�����ʩ���跢չѸ�٣����й����������ƣ��γ������ᡢ���ݡ�������ʮ������ĳ��е�·�����֣�һ�������ͱ��µ��ִ��������;�������С���εض��𣬳�����ò�����˷��츲�صı仯������ʯ��ׯ�����ڣ���¥�������ֵ������������ĺӡ������һ���������У��غ�20�����԰�������ʻ�����������װ����ޱ������� ",
		
		};
	int curStr;
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.textmain);
		 playLocalFile();
		textSwitcher = (TextSwitcher) findViewById(R.id.textSwitcher);
		textSwitcher.setFactory(new ViewSwitcher.ViewFactory()
		{
			//����������ͼ
			public View makeView()
			{
				TextView tv = new TextView(TextSwitcherTest.this);
				tv.setTextSize(20);
				tv.setTextColor(Color.RED);
				return tv;
			}
		});
		// ����next������ʾ��һ���ַ���
		next(null);
	
		
		
	}
	// �¼���������������ʾ��һ���ַ���
	public void next(View source)
	{
		textSwitcher.setText(strs[curStr++ % strs.length]);  //��
	}
	
	
	
	private void playLocalFile() {
		mMediaPlayer = MediaPlayer.create(this, R.raw.shi);
		
	//���Ź���resĿ¼�µ�rawĿ¼�е������ļ�in_call_alarm
	try {
		mMediaPlayer.prepare();
		} catch (IllegalStateException e) {

		} catch (IOException e) {

		}
	mMediaPlayer.start();
	mMediaPlayer.setOnCompletionListener(new OnCompletionListener() {
	public void onCompletion(MediaPlayer mp) {
		
	//�����˽��Ų����߹ر�mMediaPlayer
		
	}
	} );
	}
	
	
		
	
}