/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.amf.model.impl;

import com.liferay.amf.model.Account;
import com.liferay.amf.model.AccountModel;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Blob;
import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the Account service. Represents a row in the &quot;AMF_Account&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>AccountModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link AccountImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AccountImpl
 * @generated
 */
@JSON(strict = true)
public class AccountModelImpl
	extends BaseModelImpl<Account> implements AccountModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a account model instance should use the <code>Account</code> interface instead.
	 */
	public static final String TABLE_NAME = "AMF_Account";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"accountId", Types.VARCHAR},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"firstName", Types.VARCHAR}, {"lastName", Types.VARCHAR},
		{"accountName", Types.VARCHAR}, {"emailAddress", Types.VARCHAR},
		{"gender", Types.VARCHAR}, {"birthday", Types.TIMESTAMP},
		{"password_", Types.VARCHAR}, {"homePhone", Types.VARCHAR},
		{"mobilePhone", Types.VARCHAR}, {"address", Types.VARCHAR},
		{"address2", Types.VARCHAR}, {"city", Types.VARCHAR},
		{"state_", Types.VARCHAR}, {"zip", Types.VARCHAR},
		{"securityQuestion", Types.VARCHAR}, {"securityAnswer", Types.VARCHAR},
		{"acceptedTou", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("accountId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("firstName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("lastName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("accountName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("emailAddress", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("gender", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("birthday", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("password_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("homePhone", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("mobilePhone", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("address", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("address2", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("city", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("state_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("zip", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("securityQuestion", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("securityAnswer", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("acceptedTou", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table AMF_Account (uuid_ VARCHAR(75) null,accountId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,firstName VARCHAR(75) null,lastName VARCHAR(75) null,accountName VARCHAR(75) null,emailAddress VARCHAR(75) null,gender VARCHAR(75) null,birthday DATE null,password_ VARCHAR(75) null,homePhone VARCHAR(75) null,mobilePhone VARCHAR(75) null,address VARCHAR(75) null,address2 VARCHAR(75) null,city VARCHAR(75) null,state_ VARCHAR(75) null,zip VARCHAR(75) null,securityQuestion VARCHAR(75) null,securityAnswer VARCHAR(75) null,acceptedTou VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP = "drop table AMF_Account";

	public static final String ORDER_BY_JPQL =
		" ORDER BY account.firstName ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY AMF_Account.firstName ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long GROUPID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long FIRSTNAME_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	public AccountModelImpl() {
	}

	@Override
	public String getPrimaryKey() {
		return _accountId;
	}

	@Override
	public void setPrimaryKey(String primaryKey) {
		setAccountId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _accountId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return Account.class;
	}

	@Override
	public String getModelClassName() {
		return Account.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Account, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Account, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Account, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Account)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Account, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Account, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(Account)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Account, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Account, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, Account>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			Account.class.getClassLoader(), Account.class, ModelWrapper.class);

		try {
			Constructor<Account> constructor =
				(Constructor<Account>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<Account, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Account, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Account, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Account, Object>>();
		Map<String, BiConsumer<Account, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Account, ?>>();

		attributeGetterFunctions.put("uuid", Account::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<Account, String>)Account::setUuid);
		attributeGetterFunctions.put("accountId", Account::getAccountId);
		attributeSetterBiConsumers.put(
			"accountId", (BiConsumer<Account, String>)Account::setAccountId);
		attributeGetterFunctions.put("groupId", Account::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId", (BiConsumer<Account, Long>)Account::setGroupId);
		attributeGetterFunctions.put("companyId", Account::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId", (BiConsumer<Account, Long>)Account::setCompanyId);
		attributeGetterFunctions.put("userId", Account::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<Account, Long>)Account::setUserId);
		attributeGetterFunctions.put("userName", Account::getUserName);
		attributeSetterBiConsumers.put(
			"userName", (BiConsumer<Account, String>)Account::setUserName);
		attributeGetterFunctions.put("createDate", Account::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate", (BiConsumer<Account, Date>)Account::setCreateDate);
		attributeGetterFunctions.put("modifiedDate", Account::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<Account, Date>)Account::setModifiedDate);
		attributeGetterFunctions.put("firstName", Account::getFirstName);
		attributeSetterBiConsumers.put(
			"firstName", (BiConsumer<Account, String>)Account::setFirstName);
		attributeGetterFunctions.put("lastName", Account::getLastName);
		attributeSetterBiConsumers.put(
			"lastName", (BiConsumer<Account, String>)Account::setLastName);
		attributeGetterFunctions.put("accountName", Account::getAccountName);
		attributeSetterBiConsumers.put(
			"accountName",
			(BiConsumer<Account, String>)Account::setAccountName);
		attributeGetterFunctions.put("emailAddress", Account::getEmailAddress);
		attributeSetterBiConsumers.put(
			"emailAddress",
			(BiConsumer<Account, String>)Account::setEmailAddress);
		attributeGetterFunctions.put("gender", Account::getGender);
		attributeSetterBiConsumers.put(
			"gender", (BiConsumer<Account, String>)Account::setGender);
		attributeGetterFunctions.put("birthday", Account::getBirthday);
		attributeSetterBiConsumers.put(
			"birthday", (BiConsumer<Account, Date>)Account::setBirthday);
		attributeGetterFunctions.put("password", Account::getPassword);
		attributeSetterBiConsumers.put(
			"password", (BiConsumer<Account, String>)Account::setPassword);
		attributeGetterFunctions.put("homePhone", Account::getHomePhone);
		attributeSetterBiConsumers.put(
			"homePhone", (BiConsumer<Account, String>)Account::setHomePhone);
		attributeGetterFunctions.put("mobilePhone", Account::getMobilePhone);
		attributeSetterBiConsumers.put(
			"mobilePhone",
			(BiConsumer<Account, String>)Account::setMobilePhone);
		attributeGetterFunctions.put("address", Account::getAddress);
		attributeSetterBiConsumers.put(
			"address", (BiConsumer<Account, String>)Account::setAddress);
		attributeGetterFunctions.put("address2", Account::getAddress2);
		attributeSetterBiConsumers.put(
			"address2", (BiConsumer<Account, String>)Account::setAddress2);
		attributeGetterFunctions.put("city", Account::getCity);
		attributeSetterBiConsumers.put(
			"city", (BiConsumer<Account, String>)Account::setCity);
		attributeGetterFunctions.put("state", Account::getState);
		attributeSetterBiConsumers.put(
			"state", (BiConsumer<Account, String>)Account::setState);
		attributeGetterFunctions.put("zip", Account::getZip);
		attributeSetterBiConsumers.put(
			"zip", (BiConsumer<Account, String>)Account::setZip);
		attributeGetterFunctions.put(
			"securityQuestion", Account::getSecurityQuestion);
		attributeSetterBiConsumers.put(
			"securityQuestion",
			(BiConsumer<Account, String>)Account::setSecurityQuestion);
		attributeGetterFunctions.put(
			"securityAnswer", Account::getSecurityAnswer);
		attributeSetterBiConsumers.put(
			"securityAnswer",
			(BiConsumer<Account, String>)Account::setSecurityAnswer);
		attributeGetterFunctions.put("acceptedTou", Account::getAcceptedTou);
		attributeSetterBiConsumers.put(
			"acceptedTou",
			(BiConsumer<Account, String>)Account::setAcceptedTou);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_uuid = uuid;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalUuid() {
		return getColumnOriginalValue("uuid_");
	}

	@JSON
	@Override
	public String getAccountId() {
		if (_accountId == null) {
			return "";
		}
		else {
			return _accountId;
		}
	}

	@Override
	public void setAccountId(String accountId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_accountId = accountId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_groupId = groupId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalGroupId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("groupId"));
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_companyId = companyId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalCompanyId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("companyId"));
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public String getFirstName() {
		if (_firstName == null) {
			return "";
		}
		else {
			return _firstName;
		}
	}

	@Override
	public void setFirstName(String firstName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_firstName = firstName;
	}

	@JSON
	@Override
	public String getLastName() {
		if (_lastName == null) {
			return "";
		}
		else {
			return _lastName;
		}
	}

	@Override
	public void setLastName(String lastName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_lastName = lastName;
	}

	@JSON
	@Override
	public String getAccountName() {
		if (_accountName == null) {
			return "";
		}
		else {
			return _accountName;
		}
	}

	@Override
	public void setAccountName(String accountName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_accountName = accountName;
	}

	@JSON
	@Override
	public String getEmailAddress() {
		if (_emailAddress == null) {
			return "";
		}
		else {
			return _emailAddress;
		}
	}

	@Override
	public void setEmailAddress(String emailAddress) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_emailAddress = emailAddress;
	}

	@JSON
	@Override
	public String getGender() {
		if (_gender == null) {
			return "";
		}
		else {
			return _gender;
		}
	}

	@Override
	public void setGender(String gender) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_gender = gender;
	}

	@JSON
	@Override
	public Date getBirthday() {
		return _birthday;
	}

	@Override
	public void setBirthday(Date birthday) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_birthday = birthday;
	}

	@JSON
	@Override
	public String getPassword() {
		if (_password == null) {
			return "";
		}
		else {
			return _password;
		}
	}

	@Override
	public void setPassword(String password) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_password = password;
	}

	@JSON
	@Override
	public String getHomePhone() {
		if (_homePhone == null) {
			return "";
		}
		else {
			return _homePhone;
		}
	}

	@Override
	public void setHomePhone(String homePhone) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_homePhone = homePhone;
	}

	@JSON
	@Override
	public String getMobilePhone() {
		if (_mobilePhone == null) {
			return "";
		}
		else {
			return _mobilePhone;
		}
	}

	@Override
	public void setMobilePhone(String mobilePhone) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_mobilePhone = mobilePhone;
	}

	@JSON
	@Override
	public String getAddress() {
		if (_address == null) {
			return "";
		}
		else {
			return _address;
		}
	}

	@Override
	public void setAddress(String address) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_address = address;
	}

	@JSON
	@Override
	public String getAddress2() {
		if (_address2 == null) {
			return "";
		}
		else {
			return _address2;
		}
	}

	@Override
	public void setAddress2(String address2) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_address2 = address2;
	}

	@JSON
	@Override
	public String getCity() {
		if (_city == null) {
			return "";
		}
		else {
			return _city;
		}
	}

	@Override
	public void setCity(String city) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_city = city;
	}

	@JSON
	@Override
	public String getState() {
		if (_state == null) {
			return "";
		}
		else {
			return _state;
		}
	}

	@Override
	public void setState(String state) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_state = state;
	}

	@JSON
	@Override
	public String getZip() {
		if (_zip == null) {
			return "";
		}
		else {
			return _zip;
		}
	}

	@Override
	public void setZip(String zip) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_zip = zip;
	}

	@JSON
	@Override
	public String getSecurityQuestion() {
		if (_securityQuestion == null) {
			return "";
		}
		else {
			return _securityQuestion;
		}
	}

	@Override
	public void setSecurityQuestion(String securityQuestion) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_securityQuestion = securityQuestion;
	}

	@JSON
	@Override
	public String getSecurityAnswer() {
		if (_securityAnswer == null) {
			return "";
		}
		else {
			return _securityAnswer;
		}
	}

	@Override
	public void setSecurityAnswer(String securityAnswer) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_securityAnswer = securityAnswer;
	}

	@JSON
	@Override
	public String getAcceptedTou() {
		if (_acceptedTou == null) {
			return "";
		}
		else {
			return _acceptedTou;
		}
	}

	@Override
	public void setAcceptedTou(String acceptedTou) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_acceptedTou = acceptedTou;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(Account.class.getName()));
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (!Objects.equals(
					entry.getValue(), getColumnValue(entry.getKey()))) {

				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public Account toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Account>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		AccountImpl accountImpl = new AccountImpl();

		accountImpl.setUuid(getUuid());
		accountImpl.setAccountId(getAccountId());
		accountImpl.setGroupId(getGroupId());
		accountImpl.setCompanyId(getCompanyId());
		accountImpl.setUserId(getUserId());
		accountImpl.setUserName(getUserName());
		accountImpl.setCreateDate(getCreateDate());
		accountImpl.setModifiedDate(getModifiedDate());
		accountImpl.setFirstName(getFirstName());
		accountImpl.setLastName(getLastName());
		accountImpl.setAccountName(getAccountName());
		accountImpl.setEmailAddress(getEmailAddress());
		accountImpl.setGender(getGender());
		accountImpl.setBirthday(getBirthday());
		accountImpl.setPassword(getPassword());
		accountImpl.setHomePhone(getHomePhone());
		accountImpl.setMobilePhone(getMobilePhone());
		accountImpl.setAddress(getAddress());
		accountImpl.setAddress2(getAddress2());
		accountImpl.setCity(getCity());
		accountImpl.setState(getState());
		accountImpl.setZip(getZip());
		accountImpl.setSecurityQuestion(getSecurityQuestion());
		accountImpl.setSecurityAnswer(getSecurityAnswer());
		accountImpl.setAcceptedTou(getAcceptedTou());

		accountImpl.resetOriginalValues();

		return accountImpl;
	}

	@Override
	public Account cloneWithOriginalValues() {
		AccountImpl accountImpl = new AccountImpl();

		accountImpl.setUuid(this.<String>getColumnOriginalValue("uuid_"));
		accountImpl.setAccountId(
			this.<String>getColumnOriginalValue("accountId"));
		accountImpl.setGroupId(this.<Long>getColumnOriginalValue("groupId"));
		accountImpl.setCompanyId(
			this.<Long>getColumnOriginalValue("companyId"));
		accountImpl.setUserId(this.<Long>getColumnOriginalValue("userId"));
		accountImpl.setUserName(
			this.<String>getColumnOriginalValue("userName"));
		accountImpl.setCreateDate(
			this.<Date>getColumnOriginalValue("createDate"));
		accountImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modifiedDate"));
		accountImpl.setFirstName(
			this.<String>getColumnOriginalValue("firstName"));
		accountImpl.setLastName(
			this.<String>getColumnOriginalValue("lastName"));
		accountImpl.setAccountName(
			this.<String>getColumnOriginalValue("accountName"));
		accountImpl.setEmailAddress(
			this.<String>getColumnOriginalValue("emailAddress"));
		accountImpl.setGender(this.<String>getColumnOriginalValue("gender"));
		accountImpl.setBirthday(this.<Date>getColumnOriginalValue("birthday"));
		accountImpl.setPassword(
			this.<String>getColumnOriginalValue("password_"));
		accountImpl.setHomePhone(
			this.<String>getColumnOriginalValue("homePhone"));
		accountImpl.setMobilePhone(
			this.<String>getColumnOriginalValue("mobilePhone"));
		accountImpl.setAddress(this.<String>getColumnOriginalValue("address"));
		accountImpl.setAddress2(
			this.<String>getColumnOriginalValue("address2"));
		accountImpl.setCity(this.<String>getColumnOriginalValue("city"));
		accountImpl.setState(this.<String>getColumnOriginalValue("state_"));
		accountImpl.setZip(this.<String>getColumnOriginalValue("zip"));
		accountImpl.setSecurityQuestion(
			this.<String>getColumnOriginalValue("securityQuestion"));
		accountImpl.setSecurityAnswer(
			this.<String>getColumnOriginalValue("securityAnswer"));
		accountImpl.setAcceptedTou(
			this.<String>getColumnOriginalValue("acceptedTou"));

		return accountImpl;
	}

	@Override
	public int compareTo(Account account) {
		int value = 0;

		value = getFirstName().compareTo(account.getFirstName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Account)) {
			return false;
		}

		Account account = (Account)object;

		String primaryKey = account.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_setModifiedDate = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<Account> toCacheModel() {
		AccountCacheModel accountCacheModel = new AccountCacheModel();

		accountCacheModel.uuid = getUuid();

		String uuid = accountCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			accountCacheModel.uuid = null;
		}

		accountCacheModel.accountId = getAccountId();

		String accountId = accountCacheModel.accountId;

		if ((accountId != null) && (accountId.length() == 0)) {
			accountCacheModel.accountId = null;
		}

		accountCacheModel.groupId = getGroupId();

		accountCacheModel.companyId = getCompanyId();

		accountCacheModel.userId = getUserId();

		accountCacheModel.userName = getUserName();

		String userName = accountCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			accountCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			accountCacheModel.createDate = createDate.getTime();
		}
		else {
			accountCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			accountCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			accountCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		accountCacheModel.firstName = getFirstName();

		String firstName = accountCacheModel.firstName;

		if ((firstName != null) && (firstName.length() == 0)) {
			accountCacheModel.firstName = null;
		}

		accountCacheModel.lastName = getLastName();

		String lastName = accountCacheModel.lastName;

		if ((lastName != null) && (lastName.length() == 0)) {
			accountCacheModel.lastName = null;
		}

		accountCacheModel.accountName = getAccountName();

		String accountName = accountCacheModel.accountName;

		if ((accountName != null) && (accountName.length() == 0)) {
			accountCacheModel.accountName = null;
		}

		accountCacheModel.emailAddress = getEmailAddress();

		String emailAddress = accountCacheModel.emailAddress;

		if ((emailAddress != null) && (emailAddress.length() == 0)) {
			accountCacheModel.emailAddress = null;
		}

		accountCacheModel.gender = getGender();

		String gender = accountCacheModel.gender;

		if ((gender != null) && (gender.length() == 0)) {
			accountCacheModel.gender = null;
		}

		Date birthday = getBirthday();

		if (birthday != null) {
			accountCacheModel.birthday = birthday.getTime();
		}
		else {
			accountCacheModel.birthday = Long.MIN_VALUE;
		}

		accountCacheModel.password = getPassword();

		String password = accountCacheModel.password;

		if ((password != null) && (password.length() == 0)) {
			accountCacheModel.password = null;
		}

		accountCacheModel.homePhone = getHomePhone();

		String homePhone = accountCacheModel.homePhone;

		if ((homePhone != null) && (homePhone.length() == 0)) {
			accountCacheModel.homePhone = null;
		}

		accountCacheModel.mobilePhone = getMobilePhone();

		String mobilePhone = accountCacheModel.mobilePhone;

		if ((mobilePhone != null) && (mobilePhone.length() == 0)) {
			accountCacheModel.mobilePhone = null;
		}

		accountCacheModel.address = getAddress();

		String address = accountCacheModel.address;

		if ((address != null) && (address.length() == 0)) {
			accountCacheModel.address = null;
		}

		accountCacheModel.address2 = getAddress2();

		String address2 = accountCacheModel.address2;

		if ((address2 != null) && (address2.length() == 0)) {
			accountCacheModel.address2 = null;
		}

		accountCacheModel.city = getCity();

		String city = accountCacheModel.city;

		if ((city != null) && (city.length() == 0)) {
			accountCacheModel.city = null;
		}

		accountCacheModel.state = getState();

		String state = accountCacheModel.state;

		if ((state != null) && (state.length() == 0)) {
			accountCacheModel.state = null;
		}

		accountCacheModel.zip = getZip();

		String zip = accountCacheModel.zip;

		if ((zip != null) && (zip.length() == 0)) {
			accountCacheModel.zip = null;
		}

		accountCacheModel.securityQuestion = getSecurityQuestion();

		String securityQuestion = accountCacheModel.securityQuestion;

		if ((securityQuestion != null) && (securityQuestion.length() == 0)) {
			accountCacheModel.securityQuestion = null;
		}

		accountCacheModel.securityAnswer = getSecurityAnswer();

		String securityAnswer = accountCacheModel.securityAnswer;

		if ((securityAnswer != null) && (securityAnswer.length() == 0)) {
			accountCacheModel.securityAnswer = null;
		}

		accountCacheModel.acceptedTou = getAcceptedTou();

		String acceptedTou = accountCacheModel.acceptedTou;

		if ((acceptedTou != null) && (acceptedTou.length() == 0)) {
			accountCacheModel.acceptedTou = null;
		}

		return accountCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Account, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Account, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Account, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((Account)this);

			if (value == null) {
				sb.append("null");
			}
			else if (value instanceof Blob || value instanceof Date ||
					 value instanceof Map || value instanceof String) {

				sb.append(
					"\"" + StringUtil.replace(value.toString(), "\"", "'") +
						"\"");
			}
			else {
				sb.append(value);
			}

			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<Account, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Account, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Account, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Account)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, Account>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private String _uuid;
	private String _accountId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _firstName;
	private String _lastName;
	private String _accountName;
	private String _emailAddress;
	private String _gender;
	private Date _birthday;
	private String _password;
	private String _homePhone;
	private String _mobilePhone;
	private String _address;
	private String _address2;
	private String _city;
	private String _state;
	private String _zip;
	private String _securityQuestion;
	private String _securityAnswer;
	private String _acceptedTou;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<Account, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((Account)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("uuid_", _uuid);
		_columnOriginalValues.put("accountId", _accountId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("firstName", _firstName);
		_columnOriginalValues.put("lastName", _lastName);
		_columnOriginalValues.put("accountName", _accountName);
		_columnOriginalValues.put("emailAddress", _emailAddress);
		_columnOriginalValues.put("gender", _gender);
		_columnOriginalValues.put("birthday", _birthday);
		_columnOriginalValues.put("password_", _password);
		_columnOriginalValues.put("homePhone", _homePhone);
		_columnOriginalValues.put("mobilePhone", _mobilePhone);
		_columnOriginalValues.put("address", _address);
		_columnOriginalValues.put("address2", _address2);
		_columnOriginalValues.put("city", _city);
		_columnOriginalValues.put("state_", _state);
		_columnOriginalValues.put("zip", _zip);
		_columnOriginalValues.put("securityQuestion", _securityQuestion);
		_columnOriginalValues.put("securityAnswer", _securityAnswer);
		_columnOriginalValues.put("acceptedTou", _acceptedTou);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");
		attributeNames.put("password_", "password");
		attributeNames.put("state_", "state");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("uuid_", 1L);

		columnBitmasks.put("accountId", 2L);

		columnBitmasks.put("groupId", 4L);

		columnBitmasks.put("companyId", 8L);

		columnBitmasks.put("userId", 16L);

		columnBitmasks.put("userName", 32L);

		columnBitmasks.put("createDate", 64L);

		columnBitmasks.put("modifiedDate", 128L);

		columnBitmasks.put("firstName", 256L);

		columnBitmasks.put("lastName", 512L);

		columnBitmasks.put("accountName", 1024L);

		columnBitmasks.put("emailAddress", 2048L);

		columnBitmasks.put("gender", 4096L);

		columnBitmasks.put("birthday", 8192L);

		columnBitmasks.put("password_", 16384L);

		columnBitmasks.put("homePhone", 32768L);

		columnBitmasks.put("mobilePhone", 65536L);

		columnBitmasks.put("address", 131072L);

		columnBitmasks.put("address2", 262144L);

		columnBitmasks.put("city", 524288L);

		columnBitmasks.put("state_", 1048576L);

		columnBitmasks.put("zip", 2097152L);

		columnBitmasks.put("securityQuestion", 4194304L);

		columnBitmasks.put("securityAnswer", 8388608L);

		columnBitmasks.put("acceptedTou", 16777216L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private Account _escapedModel;

}