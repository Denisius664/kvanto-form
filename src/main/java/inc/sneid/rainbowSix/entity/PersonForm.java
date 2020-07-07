package inc.sneid.rainbowSix.entity;

import inc.sneid.rainbowSix.validation.FileSize;
import inc.sneid.rainbowSix.validation.FileType;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

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

	@NotNull
	private Kvantum kvantum;

	@NotNull
	@Min(value = 1)
	@Max(value = 2)
	private int shift;

	@NotNull
	@DateTimeFormat(pattern = "dd.MM.yy")
	private Date birthday;

	@NotNull
	@Pattern(regexp = "^(\\+7|8)[\\s\\-]?(\\d{3})[\\s\\-]?(\\d{3})[\\s\\-]?(\\d{2})[\\s\\-]?(\\d{2})",
			message = "Не правильный формат номера телефона")
	private String phone;

	@NotNull
	private String snils = "";

	@NotNull
	private String statement = "";

	@NotNull
	private String consent = "";

	@NotNull
	private String birthCertificate = "";

	@NotNull
	private String passportParent = "";

	@NotNull
	private String passport = "";

}
