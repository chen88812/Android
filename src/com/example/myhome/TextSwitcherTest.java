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
			"      石家庄市所辖区域，是人类文明开发较早、文化底蕴十分深厚的地区。市区白佛口文化遗址是目前全市境内发现的最早的平原地区人类遗址，距今约6000—7000年；新乐古代遗址“伏羲台”证明了6000多年前中华人文始祖伏羲氏曾活动于此地；战国中山国文化，是石家庄历史文化脉络中的重要一环，也是继藁城台西商文化之后令世界瞩目的辉煌文化。"
			+ "两汉时期，石家庄西部的太行山区一直是制造兵器、铠甲和生产工具的重要冶金基地之一。"
			+ "   “冶河”因此而得名；汉唐时期是中国佛教、道教复兴并走向鼎盛的时期，恒、赵二州的宗教文化在中国宗教史上也留下了绚丽篇章。赵州柏林寺，相传创建于东汉，是河北最古老的佛教寺院；石家庄隋唐文化中最为光辉的历史成就是赵州安济桥，它是世界公认的"
			+ "大型敞肩式石拱桥的鼻祖，在世界桥梁建筑史上占有突出的地位，被联合国确认为世界人类文化遗产；隋唐时期石家庄籍的文化名人有魏征和李吉甫；北宋时期，富弼、韩琦、欧阳修、沈括、苏轼等名宦贤宦先后奉使河北，都在真定府（今正定）留下足迹，促进了这一地区经济、文化的繁荣。 ",
			"      金元时期石家庄建筑艺术成就的代表作是井陉苍岩山福庆寺桥楼殿，桥与殿浑然一体，凌空飞架于千丈深涧之间，状如飞虹，设计形式奇巧，建筑雄伟险峻，反映出当时劳动人民高超的建筑技术和美学造诣。"
			+ "在艺术创作领域，著名的有上京毗卢寺壁画。这些壁画继承并发展了中国古代壁画的传统技法，在构图、线描、用色和人物造型等方面都达到很高的水平。此时的自然科学成果也非常丰硕。著名数学家、学者李冶在数学天元学术方面的研究，对中国的初等代数起到了奠基作用，标志着13世纪世界数学的最高成就。"
			+ "    20世纪初期，平汉铁路（今京广铁路）和正太铁路（今石太铁路）相继修建，并在此交汇，石家庄就是伴随着铁路的兴建而逐渐发展起来的。1925年，这座城市始称石家庄市（后曾改名为石门市）。1947年11月12日石家庄市解放，成为全国解放最早的较大城市之一。当时，全市人口19万，有大小工厂27家，工业总产值2000万元左右。1948年5月－1949年3月间，西柏坡是中共中央和中国人民解放军总部所在地，毛主席、党中央在此指挥了震惊中外的三大战役，召开了著名的中国共产党七届二中全会。1968年河北省省会由保定迁至石家庄市。 ",
			"      改革开放给石家庄提供了参与国际经济大循环、建成现代化大都市的机遇。石家庄以其环京津、环渤海的优越地理位置和丰富的自然资源、人文资源优势，引起了国内外广泛关注。"
			+ "近几年来，石家庄的城市基础设施建设发展迅速，城市功能日趋完善，形成了三横、六纵、二环、十二放射的城市道路网络格局，一在批造型别致的现代化建筑和居民生活小区拔地而起，城市面貌发生了翻天覆地的变化。如今的石家庄市区内，高楼林立，街道宽阔，“民心河”像玉带一样环城绕市，沿河20多个公园，像朵朵鲜花把这座城市装点的无比美丽。 ",
		
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
			//设置文字视图
			public View makeView()
			{
				TextView tv = new TextView(TextSwitcherTest.this);
				tv.setTextSize(20);
				tv.setTextColor(Color.RED);
				return tv;
			}
		});
		// 调用next方法显示下一个字符串
		next(null);
	
		
		
	}
	// 事件处理函数，控制显示下一个字符串
	public void next(View source)
	{
		textSwitcher.setText(strs[curStr++ % strs.length]);  //①
	}
	
	
	
	private void playLocalFile() {
		mMediaPlayer = MediaPlayer.create(this, R.raw.shi);
		
	//播放工程res目录下的raw目录中的音乐文件in_call_alarm
	try {
		mMediaPlayer.prepare();
		} catch (IllegalStateException e) {

		} catch (IOException e) {

		}
	mMediaPlayer.start();
	mMediaPlayer.setOnCompletionListener(new OnCompletionListener() {
	public void onCompletion(MediaPlayer mp) {
		
	//播完了接着播或者关闭mMediaPlayer
		
	}
	} );
	}
	
	
		
	
}