package com.bizleap.collection.test;

import java.util.Random;
import com.bizleap.collection.BLList;
import com.bizleap.collection.impl.BLArrayListRefactor;

public class PoemChoosing {
	BLList<String> poemList= null;
	public String getPoem() {
						if(poemList==null) {
						poemList= new BLArrayListRefactor<String>();
						poemList.add("အမျက်ဖြေ အလင်္ကာ");
						poemList.add("သင်သေသွားသော်");
						poemList.add("ပိတောက်ပန်း");
						poemList.add("ပန်းပန်လျက်ပဲ");
						poemList.add("ဖိုးမောင်လာပြီ");
						poemList.add("ပျဥ်းမငုတ်တို");
						poemList.add("သူ့မှာတမ်း");
						poemList.add("သပြေညို ");
						poemList.add("ဗျောသံ");
						poemList.add("အလှကိုယ်စီ");
						poemList.add("ပြောလိုက်ပါဘိ ဟောပါဘိ ");
						poemList.add("သူ့လမ်းစဥ်");
						poemList.add("ပန်းခဲ့သည်ပဲ");
						poemList.add("မြက်ရိတ်သမား");
						poemList.add("နှင်းဆီပွင့်");
						poemList.add("ရေကျက်မ");
						poemList.add("လယ်စောင့်တဲ");
						poemList.add("ဆွမ်းအုပ်နီနီ");
						poemList.add("သပြေသီးကောက်");
						poemList.add("မသူဇာ ကိုသာဝိုက်");
						}
						String radomPoem=poemList.get(new Random().nextInt(poemList.size()));
				 return radomPoem;
	}
	public static void main(String[] args) {
		 PoemChoosing poemChoosing=new PoemChoosing();
		 poemChoosing.poemList.remove(poemChoosing.getPoem());
	}

}
