package pro.karagodin;

import java.util.LinkedHashMap;
import java.util.Map;

public record EngineCode(String value, String description) {
	public static final Map<String, EngineCode> cache = new LinkedHashMap<>();

	static {
		cache.put("1", new EngineCode("1", "Бензиновый"));
		cache.put("2", new EngineCode("2", "Дизельный"));
		cache.put("3", new EngineCode("3", "Электрический"));
		cache.put("4", new EngineCode("4", "Гибридный на основе бензинового"));
		cache.put("5", new EngineCode("5", "Гибридный на основе дизельного"));
		cache.put("6", new EngineCode("6", "конв. для работы на газе"));
		cache.put("7", new EngineCode("7", "Иной"));
	}

	@Override
	public String toString() {
		return description;
	}
}
