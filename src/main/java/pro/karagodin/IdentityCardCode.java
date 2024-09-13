package pro.karagodin;

import java.util.LinkedHashMap;
import java.util.Map;

public record IdentityCardCode(String value, String description) {

	public static final Map<String, IdentityCardCode> cache = new LinkedHashMap<>();

	static {
		cache.put("AM01001", new IdentityCardCode("AM01001", "паспорт гражданина Республики Армения"));
		cache.put("KZ01001", new IdentityCardCode("KZ01001", "паспорт гражданина Республики Казахстан"));
		cache.put("RU01001", new IdentityCardCode("RU01001", "паспорт гражданина Российской Федерации"));
		cache.put("BY01001", new IdentityCardCode("BY01001", "паспорт гражданина Республики Беларусь"));
		cache.put("AM99999", new IdentityCardCode("AM99999", "иной вид документа Республики Армения"));
		cache.put("BY08017", new IdentityCardCode("BY08017", "вид на жительство в Республике Беларусь"));
		cache.put("KZ08017", new IdentityCardCode("KZ08017", "вид на жительство иностранца в Республике Казахстан\n"));
		cache.put("KG08017", new IdentityCardCode("KG08017", "вид на жительство Кыргызской Республики"));
		cache.put("RU08017", new IdentityCardCode("RU08017", "вид на жительство Российской Федерации"));
		cache.put("KG01004", new IdentityCardCode("KG01004", "общегражданский паспорт гражданина Кыргызской Республики"));
		cache.put("KZ99999", new IdentityCardCode("KZ99999", "иной вид документа Республики Казахстан"));
		cache.put("BY99999", new IdentityCardCode("BY99999", "иной вид документа Республики Беларусь"));
		cache.put("XX01001", new IdentityCardCode("XX01001", "национальный паспорт гражданина иностранного государства"));
		cache.put("RU99999", new IdentityCardCode("RU99999", "иной вид документа Российской Федерации"));
	}

	@Override
	public String toString() {
		return description;
	}
}
