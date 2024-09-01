package pro.karagodin;

import java.util.LinkedHashMap;
import java.util.Map;

public record IdentityCardCode(String value, String description) {

	public static final Map<String, IdentityCardCode> cache = new LinkedHashMap<>();

	static {
		cache.put("RU01001", new IdentityCardCode("RU01001", "Паспорт гражданина РФ"));
		cache.put("RU08017", new IdentityCardCode("RU08017", "Вид на жительство РФ"));
		cache.put("XX01001", new IdentityCardCode("XX01001", "Национальный паспорт гражданина иностранного государства"));
		cache.put("AM01001", new IdentityCardCode("AM01001", "Паспорт гражданина Армении"));
		cache.put("KZ01001", new IdentityCardCode("KZ01001", "Паспорт гражданина Казахстана"));
		cache.put("KG01001", new IdentityCardCode("KZ01001", "Паспорт гражданина Кыргызстана"));
		cache.put("BY01001", new IdentityCardCode("KZ01001", "Паспорт гражданина Беларуси"));
	}

	@Override
	public String toString() {
		return description;
	}
}
