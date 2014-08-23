package com.nexters.data;

import java.util.HashMap;
import java.util.Map;

public class CodeMap {

	private static CodeMap instance = new CodeMap();

	// member.
	public static Map<String, String> map;

	private CodeMap() {
		map = new HashMap<String, String>();
		map.put("item_19", "보육시설,유아교육시설");
		map.put("item_20", "초,중학교");
		map.put("item_21", "고등학교");
		map.put("item_22", "대학교");
		map.put("item_23", "교과학원");
		map.put("item_24", "외국어학원");
		map.put("item_25", "피아노,태권도학원");
		map.put("item_26", "컴퓨터학원");
		map.put("item_27", "고시원");
		map.put("item_28", "독서실");
		map.put("item_29", "대형 종합소매업");
		map.put("item_30", "백화점");
		map.put("item_31", "슈퍼마켓");
		map.put("item_32", "체인화,편의점");
		map.put("item_33", "우체국,동사무소");
		map.put("item_34", "경찰서,지구대");
		map.put("item_35", "도서관");
		map.put("item_36", "병원");
		map.put("item_37", "금융기관");
		map.put("item_38", "주차장");
		map.put("item_39", "예술회관,소극장,영화관");
		map.put("item_40", "박물관,사적지\n미술관,문예회관");
		map.put("item_41", "동물원 식물원");
		map.put("item_42", "공원(실외)");
		map.put("item_43", "실내 체육시설");
		map.put("item_44", "한식당");
		map.put("item_45", "중식당");
		map.put("item_46", "일식당");
		map.put("item_47", "양식당");
		map.put("item_48", "외국식당");
		map.put("item_49", "제과점");
		map.put("item_50", "피자,햄버거,샌드위치");
		map.put("item_51", "치킨");
		map.put("item_52", "분식 김밥");
		map.put("item_53", "커피숍");
		map.put("item_54", "호프집, 민속주점");
		map.put("item_55", "그외 기타");
		map.put("age_00", "나이 ~10대");
		map.put("age_10", "나이 10대");
		map.put("age_20", "나이 20대");
		map.put("age_30", "나이 30대");
		map.put("age_40", "나이 40대");
		map.put("age_50", "나이 50대");
		map.put("age_60", "나이 60대");
		map.put("age_70", "나이 70대");
		map.put("age_80", "나이 80대~");
		map.put("area_01", "면적 ~6평");
		map.put("area_02", "면적 6~12평");
		map.put("area_03", "면적 12~18평");
		map.put("area_04", "면적 18~25평");
		map.put("area_05", "면적 25~30평");
		map.put("area_06", "면적 30~39평");
		map.put("area_07", "면적 39~49평");
		map.put("area_08", "면적 49~69평");
		map.put("area_09", "면적 69평~");
		map.put("art_museum", "등록미술관");
		map.put("ball_gym", "구기체육관");
		map.put("city_park", "도시공원");
		map.put("cun_cul_center", "지방문화원");
		map.put("dens", "인구밀도");
		map.put("driving_range", "골프연습장");
		map.put("edu_00", "학력 미취학");
		map.put("edu_01", "학력 초등학교");
		map.put("edu_02", "학력 중학교");
		map.put("edu_03", "학력 고등학교");
		map.put("edu_04", "학력 대학교");
		map.put("edu_05", "학력 석사이상");
		map.put("gen_f", "성별 여자");
		map.put("gen_m", "성별 남자");
		map.put("girl_for_pop", "여자외국인수");
		map.put("horseriding_course", "승마장");
		map.put("house_01", "다세대");
		map.put("house_02", "단독주택");
		map.put("house_03", "아파트");
		map.put("house_04", "연립주택");
		map.put("house_05", "영업용 건물 내 주택");
		map.put("ice_rink", "빙상경기장");
		map.put("literary_art_hall", "문예회관");
		map.put("man_for_pop", "남자외국인수");
		map.put("mineral_spring", "약수터");
		map.put("public_library", "공공도서관");
		map.put("roller_skating_rink", "인라인스케이트장");
		map.put("sports_park", "체육공원");
		map.put("swimming_pool", "수영장");
		map.put("tennis_court", "테니스장");
		map.put("tot_for_pop", "외국인 수");
		map.put("trail", "등산로");
		map.put("vacant_lot", "마을공터");
		map.put("yachting_course", "요트경기장");
		map.put("year_00", "1996~1999년 건축");
		map.put("year_01", "2000~2009년 건축");
		map.put("year_02", "2010년~ 건축");
		map.put("athletic_field", "종합운동장");

	}

	public static CodeMap getInstance() {
		return instance;
	}

}
