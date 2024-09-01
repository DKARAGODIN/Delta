package pro.karagodin;

import java.util.LinkedHashMap;
import java.util.Map;

public record TransportKind(String value, String description) {

	public static final Map<String, TransportKind> cache = new LinkedHashMap<>();

	static {
		cache.put("1", new TransportKind("1", "Легковой"));
		cache.put("2", new TransportKind("2", "Грузопассажирский"));
		cache.put("3", new TransportKind("3", "Прицеп (Полуприцеп)"));
		cache.put("4", new TransportKind("4", "Шасси"));
		cache.put("5", new TransportKind("5", "Автобус (Троллейбус)"));
		cache.put("6", new TransportKind("6", "Автобетоносмеситель"));
		cache.put("7", new TransportKind("7", "Специальное ТС"));
		cache.put("8", new TransportKind("8", "Фургон (Рефрижератор)"));
		cache.put("9", new TransportKind("9", "Автосамосвал"));
		cache.put("10", new TransportKind("10", "Седельный тягач"));
	}

	@Override
	public String toString() {
		return description;
	}
}
