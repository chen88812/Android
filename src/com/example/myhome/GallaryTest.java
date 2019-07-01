package com.example.myhome;

import android.app.Activity;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Gallery.LayoutParams;

/**
 * Description:
 * <br/>site: <a href="http://www.crazyit.org">crazyit.org</a>
 * <br/>Copyright (C), 2001-2014, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */
public class GallaryTest extends Activity
{
	int[] imageIds = new int[]
	{
		R.drawable.a, R.drawable.b,
		R.drawable.c, R.drawable.d, R.drawable.e,
		R.drawable.f, R.drawable.g, R.drawable.h,
		R.drawable.i, R.drawable.g, R.drawable.k,
		R.drawable.l,R.drawable.m,R.drawable.z };
	
	Gallery gallery;
	ImageView imageView;
	//@Override����д�ķ����ı�־��
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		gallery = (Gallery) findViewById(R.id.gallery);
		// ��ȡ��ʾͼƬ��ImageView����
		imageView = (ImageView) findViewById(R.id.imageView);
		// ����һ��BaseAdapter���󣬸ö������ṩGallery����ʾ���б���
		BaseAdapter adapter = new BaseAdapter()
		{
			@Override
			public int getCount()
			{
				return imageIds.length;
			}

			@Override
			public Object getItem(int position)
			{
				return position;
			}

			@Override
			public long getItemId(int position)
			{
				return position;
			}

			// �÷����ķ��ص�View���Ǵ�����ÿ���б���
			@Override
			public View getView(int position, View convertView, ViewGroup parent)
			{
				// ����һ��ImageView
				ImageView imageView = new ImageView(GallaryTest.this);
				imageView.setImageResource(imageIds[position]);
				// ����ImageView����������
				imageView.setScaleType(ImageView.ScaleType.FIT_XY);
				// ΪimageView���ò��ֲ���
				imageView.setLayoutParams(new Gallery.LayoutParams(75, 100));
				TypedArray typedArray = obtainStyledAttributes(
						R.styleable.Gallery);//��ȡ��Դ,��attr.xml��
				imageView.setBackgroundResource(typedArray.getResourceId(
						R.styleable.Gallery_android_galleryItemBackground, 0));
				return imageView;
			}
		};
		gallery.setAdapter(adapter);//������������ÿ���б���͵����
		gallery.setOnItemSelectedListener(new OnItemSelectedListener()
		{
			// ��Galleryѡ������ı�ʱ�����÷���
			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id)
			{
				imageView.setImageResource(imageIds[position]);
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent)
			{
			}
		});
	}
}