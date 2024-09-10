package pro.karagodin;

import java.util.LinkedHashMap;
import java.util.Map;

public record IdentityCardCode(String value, String description) {

	public static final Map<String, IdentityCardCode> cache = new LinkedHashMap<>();

	static {
		cache.put("RU01001", new IdentityCardCode("RU01001", "паспорт гражданина Российской Федерации"));
		cache.put("RU08017", new IdentityCardCode("RU08017", "вид на жительство Россиийской Федерации"));
		cache.put("XX01001", new IdentityCardCode("XX01001", "национальный паспорт гражданина иностранного государства"));
		cache.put("AM01001", new IdentityCardCode("AM01001", "паспорт гражданина Республики Армения"));
		cache.put("KZ01001", new IdentityCardCode("KZ01001", "паспорт гражданина Республики Казахстан"));
		cache.put("KG01004", new IdentityCardCode("KG01004", "общегражданский паспорт гражданина Кыргызской Республики"));
		cache.put("BY01001", new IdentityCardCode("BY01001", "паспорт гражданина Республики Беларусь"));
	}

	@Override
	public String toString() {
		return description;
	}
}
