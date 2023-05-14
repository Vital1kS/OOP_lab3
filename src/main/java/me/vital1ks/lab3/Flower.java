package me.vital1ks.lab3;

import lombok.Getter;
public class Flower {
	@Getter private String name; //Сорт цветка
	@Getter private String main_color; //Основной цвет
	@Getter private String family; //Род
	@Getter private float height;//Высота
	@Getter private float price;//Цена

	public Flower(String name, String main_color, String family, float height, float price) {
		this.name = name;
		this.main_color = main_color;
		this.family = family;
		this.height = height;
		this.price = price;
	}
	@Override
	public boolean equals(Object obj) {
		if(this==obj) return true;
		if(obj==null || getClass()!=obj.getClass()) return false;
		Flower flower = (Flower) obj;
		if(!name.equals(flower.name)) return false;
		if(!main_color.equals(flower.main_color)) return false;
		if(!family.equals(flower.family)) return false;
		if(height != flower.height) return false;
		return price == flower.price;
		
	}
	@Override
	public int hashCode() {
		int result = (int) ((int)price ^ ((int)price >>> 32));
        result = 31 * result + name.hashCode();
        result = 31 * result + main_color.hashCode();
        result = 31 * result + family.hashCode();
        result = 31 * result + (int) height;
        return result;
	}
}
