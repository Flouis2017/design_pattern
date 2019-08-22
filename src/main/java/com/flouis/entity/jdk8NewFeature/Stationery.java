package com.flouis.entity.jdk8NewFeature;

import com.google.common.collect.Lists;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Stationery {

	private String pen;
	private String notebook;

	public static List<Stationery> getDefaultList(Integer index){
		index = index == null ? 1 : index;
		List<Stationery> aList = Lists.newArrayList(
			new Stationery("钢笔", "红本"),
			new Stationery("铅笔", "本子")
		);
		List<Stationery> bList = Lists.newArrayList(
				new Stationery("中性笔", "蓝本")
		);
		List<Stationery> cList = Lists.newArrayList(
				new Stationery("彩笔", "黄本"),
				new Stationery("蜡笔", "绿本")
		);
		List<Stationery> list;
		switch (index){
			case 1:
				list = aList;
				break;
			case 2:
				list = bList;
				break;
			default:
				list = cList;
				break;
		}
		return list;
	}

}
