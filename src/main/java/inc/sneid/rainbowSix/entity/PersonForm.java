package inc.sneid.rainbowSix.entity;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Lob;
import javax.validation.constraints.*;

@Data
public class PersonForm {
	//TODO Поля: e-mail, направление на зачисление, в какую смену вам удобно ходить, ФИО ребенка, Дата рождения ребенка, ФИО родителя, номер телефона родителя и ребенка, файлы: снилс ребенка и паспорт родителя и ребенка
	public enum Kvantum{
		PROMBRO("Промробо"), VR("VR"), HIGH_TECH("Хай-тэк"), BIO("Био"),
		PROMDESIGN("Промдизайн"), IT("IT");

		private String displayValue;
		Kvantum(String displayValue){
			this.displayValue = displayValue;
		}

		public String getDisplayValue() {
			return displayValue;
		}
	}

	@Pattern(regexp = "^([А-Я][а-я]*)(\\s[А-Я][а-я]*)(\\s[А-Я][а-я]*)?([\\s\\-][А-Я][а-я]*)?$", message = "Не правильно")
	@NotNull
	private String fullName;

	@NotNull
	@Pattern(regexp = "\\w+@\\w+\\.\\w+", message = "Не верно")
	private String email;

	private Kvantum kvantum;

}
