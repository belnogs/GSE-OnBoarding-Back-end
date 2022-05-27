package com.liferay.amf.dto.v1_0;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.liferay.petra.function.UnsafeSupplier;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.util.ObjectMapperUtil;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.annotation.Generated;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author me
 * @generated
 */
@Generated("")
@GraphQLName(
	description = "A sample api of Acme Movie Fanatics (AMF).",
	value = "Account"
)
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "Account")
public class Account implements Serializable {

	public static Account toDTO(String json) {
		return ObjectMapperUtil.readValue(Account.class, json);
	}

	public static Account unsafeToDTO(String json) {
		return ObjectMapperUtil.unsafeReadValue(Account.class, json);
	}

	@Schema(description = "The adress home.")
	public String getAdress1() {
		return adress1;
	}

	public void setAdress1(String adress1) {
		this.adress1 = adress1;
	}

	@JsonIgnore
	public void setAdress1(
		UnsafeSupplier<String, Exception> adress1UnsafeSupplier) {

		try {
			adress1 = adress1UnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "The adress home.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String adress1;

	@Schema(description = "The alternative adress.")
	public String getAdress2() {
		return adress2;
	}

	public void setAdress2(String adress2) {
		this.adress2 = adress2;
	}

	@JsonIgnore
	public void setAdress2(
		UnsafeSupplier<String, Exception> adress2UnsafeSupplier) {

		try {
			adress2 = adress2UnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "The alternative adress.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String adress2;

	@Schema(description = "The birthday day.")
	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	@JsonIgnore
	public void setBirthday(
		UnsafeSupplier<String, Exception> birthdayUnsafeSupplier) {

		try {
			birthday = birthdayUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "The birthday day.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String birthday;

	@Schema(description = "The zip code.")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@JsonIgnore
	public void setCity(UnsafeSupplier<String, Exception> cityUnsafeSupplier) {
		try {
			city = cityUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "The zip code.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String city;

	@Schema(description = "The password.")
	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@JsonIgnore
	public void setConfirmPassword(
		UnsafeSupplier<String, Exception> confirmPasswordUnsafeSupplier) {

		try {
			confirmPassword = confirmPasswordUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "The password.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String confirmPassword;

	@Schema(description = "The e-mail adress.")
	public String getEmailAdress() {
		return emailAdress;
	}

	public void setEmailAdress(String emailAdress) {
		this.emailAdress = emailAdress;
	}

	@JsonIgnore
	public void setEmailAdress(
		UnsafeSupplier<String, Exception> emailAdressUnsafeSupplier) {

		try {
			emailAdress = emailAdressUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "The e-mail adress.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String emailAdress;

	@Schema(description = "The first name.")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@JsonIgnore
	public void setFirstName(
		UnsafeSupplier<String, Exception> firstNameUnsafeSupplier) {

		try {
			firstName = firstNameUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "The first name.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String firstName;

	@Schema(description = "The genre.")
	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@JsonIgnore
	public void setGenre(
		UnsafeSupplier<String, Exception> genreUnsafeSupplier) {

		try {
			genre = genreUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "The genre.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String genre;

	@Schema(description = "The home phone.")
	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	@JsonIgnore
	public void setHomePhone(
		UnsafeSupplier<String, Exception> homePhoneUnsafeSupplier) {

		try {
			homePhone = homePhoneUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "The home phone.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String homePhone;

	@Schema(description = "The last name.")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@JsonIgnore
	public void setLastName(
		UnsafeSupplier<String, Exception> lastNameUnsafeSupplier) {

		try {
			lastName = lastNameUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "The last name.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String lastName;

	@Schema(description = "The mobile phone.")
	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	@JsonIgnore
	public void setMobilePhone(
		UnsafeSupplier<String, Exception> mobilePhoneUnsafeSupplier) {

		try {
			mobilePhone = mobilePhoneUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "The mobile phone.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String mobilePhone;

	@Schema(description = "The password.")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@JsonIgnore
	public void setPassword(
		UnsafeSupplier<String, Exception> passwordUnsafeSupplier) {

		try {
			password = passwordUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "The password.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String password;

	@Schema(description = "The security answer.")
	public String getSecurityAnswer() {
		return securityAnswer;
	}

	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}

	@JsonIgnore
	public void setSecurityAnswer(
		UnsafeSupplier<String, Exception> securityAnswerUnsafeSupplier) {

		try {
			securityAnswer = securityAnswerUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "The security answer.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String securityAnswer;

	@Schema(
		description = "Must choose one of the following What is your mother's maiden nae? What is the make of you first car? What is your high school mascot? Who is your favorite actor?"
	)
	public String getSecurityQuestion() {
		return securityQuestion;
	}

	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}

	@JsonIgnore
	public void setSecurityQuestion(
		UnsafeSupplier<String, Exception> securityQuestionUnsafeSupplier) {

		try {
			securityQuestion = securityQuestionUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(
		description = "Must choose one of the following What is your mother's maiden nae? What is the make of you first car? What is your high school mascot? Who is your favorite actor?"
	)
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String securityQuestion;

	@Schema(description = "The state.")
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@JsonIgnore
	public void setState(
		UnsafeSupplier<String, Exception> stateUnsafeSupplier) {

		try {
			state = stateUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "The state.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String state;

	@Schema(description = "The terms of use.")
	public String getTermsOfUse() {
		return termsOfUse;
	}

	public void setTermsOfUse(String termsOfUse) {
		this.termsOfUse = termsOfUse;
	}

	@JsonIgnore
	public void setTermsOfUse(
		UnsafeSupplier<String, Exception> termsOfUseUnsafeSupplier) {

		try {
			termsOfUse = termsOfUseUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "The terms of use.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String termsOfUse;

	@Schema(description = "The username.")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@JsonIgnore
	public void setUserName(
		UnsafeSupplier<String, Exception> userNameUnsafeSupplier) {

		try {
			userName = userNameUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "The username.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String userName;

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Account)) {
			return false;
		}

		Account account = (Account)object;

		return Objects.equals(toString(), account.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		StringBundler sb = new StringBundler();

		sb.append("{");

		if (adress1 != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"adress1\": ");

			sb.append("\"");

			sb.append(_escape(adress1));

			sb.append("\"");
		}

		if (adress2 != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"adress2\": ");

			sb.append("\"");

			sb.append(_escape(adress2));

			sb.append("\"");
		}

		if (birthday != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"birthday\": ");

			sb.append("\"");

			sb.append(_escape(birthday));

			sb.append("\"");
		}

		if (city != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"city\": ");

			sb.append("\"");

			sb.append(_escape(city));

			sb.append("\"");
		}

		if (confirmPassword != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"confirmPassword\": ");

			sb.append("\"");

			sb.append(_escape(confirmPassword));

			sb.append("\"");
		}

		if (emailAdress != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"emailAdress\": ");

			sb.append("\"");

			sb.append(_escape(emailAdress));

			sb.append("\"");
		}

		if (firstName != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"firstName\": ");

			sb.append("\"");

			sb.append(_escape(firstName));

			sb.append("\"");
		}

		if (genre != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"genre\": ");

			sb.append("\"");

			sb.append(_escape(genre));

			sb.append("\"");
		}

		if (homePhone != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"homePhone\": ");

			sb.append("\"");

			sb.append(_escape(homePhone));

			sb.append("\"");
		}

		if (lastName != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"lastName\": ");

			sb.append("\"");

			sb.append(_escape(lastName));

			sb.append("\"");
		}

		if (mobilePhone != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"mobilePhone\": ");

			sb.append("\"");

			sb.append(_escape(mobilePhone));

			sb.append("\"");
		}

		if (password != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"password\": ");

			sb.append("\"");

			sb.append(_escape(password));

			sb.append("\"");
		}

		if (securityAnswer != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"securityAnswer\": ");

			sb.append("\"");

			sb.append(_escape(securityAnswer));

			sb.append("\"");
		}

		if (securityQuestion != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"securityQuestion\": ");

			sb.append("\"");

			sb.append(_escape(securityQuestion));

			sb.append("\"");
		}

		if (state != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"state\": ");

			sb.append("\"");

			sb.append(_escape(state));

			sb.append("\"");
		}

		if (termsOfUse != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"termsOfUse\": ");

			sb.append("\"");

			sb.append(_escape(termsOfUse));

			sb.append("\"");
		}

		if (userName != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"userName\": ");

			sb.append("\"");

			sb.append(_escape(userName));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	@Schema(
		accessMode = Schema.AccessMode.READ_ONLY,
		defaultValue = "com.liferay.amf.dto.v1_0.Account", name = "x-class-name"
	)
	public String xClassName;

	private static String _escape(Object object) {
		return StringUtil.replace(
			String.valueOf(object), _JSON_ESCAPE_STRINGS[0],
			_JSON_ESCAPE_STRINGS[1]);
	}

	private static boolean _isArray(Object value) {
		if (value == null) {
			return false;
		}

		Class<?> clazz = value.getClass();

		return clazz.isArray();
	}

	private static String _toJSON(Map<String, ?> map) {
		StringBuilder sb = new StringBuilder("{");

		@SuppressWarnings("unchecked")
		Set set = map.entrySet();

		@SuppressWarnings("unchecked")
		Iterator<Map.Entry<String, ?>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, ?> entry = iterator.next();

			sb.append("\"");
			sb.append(_escape(entry.getKey()));
			sb.append("\": ");

			Object value = entry.getValue();

			if (_isArray(value)) {
				sb.append("[");

				Object[] valueArray = (Object[])value;

				for (int i = 0; i < valueArray.length; i++) {
					if (valueArray[i] instanceof String) {
						sb.append("\"");
						sb.append(valueArray[i]);
						sb.append("\"");
					}
					else {
						sb.append(valueArray[i]);
					}

					if ((i + 1) < valueArray.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			}
			else if (value instanceof Map) {
				sb.append(_toJSON((Map<String, ?>)value));
			}
			else if (value instanceof String) {
				sb.append("\"");
				sb.append(_escape(value));
				sb.append("\"");
			}
			else {
				sb.append(value);
			}

			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}

		sb.append("}");

		return sb.toString();
	}

	private static final String[][] _JSON_ESCAPE_STRINGS = {
		{"\\", "\"", "\b", "\f", "\n", "\r", "\t"},
		{"\\\\", "\\\"", "\\b", "\\f", "\\n", "\\r", "\\t"}
	};

}