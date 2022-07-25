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

package com.liferay.amf.service.impl;

import com.liferay.amf.model.Account;
import com.liferay.amf.service.base.AccountLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import org.osgi.service.component.annotations.Component;

import java.util.Date;


/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.liferay.amf.model.Account",
	service = AopService.class
)
public class AccountLocalServiceImpl extends AccountLocalServiceBaseImpl {

	@Override
	public Account createAccount(String firstname, String lastname, String emailAddress,
								 String accountName, String gender, Date birthday, String  password, int homePhone,
								 int mobilePhone, String address, String address2, String city, String statezip,
								 String securityQuestion, String securityAnswer, String acceptedTou) {


		// Generate primary key for the Account
		long accountId = counterLocalService.increment(Account.class.getName());

		// Create account

		Account account = createAccount(accountId);

		//populate fields
		account.setAccountId(accountId);
		account.setFirstName(firstname);
		account.setLastName(lastname);
		account.setEmailAddress(emailAddress);
		account.setAccountName(accountName);
		account.setGender(gender);
		account.setBirthday(birthday);
		account.setPassword(password);
		account.setHomePhone(homePhone);
		account.setMobilePhone(mobilePhone);
		account.setAddress(address);
		account.setAddress2(address2);
		account.setCity(city);
		account.setState(statezip);
		account.setSecurityQuestion(securityQuestion);
		account.setSecurityAnswer(securityAnswer);
		account.setAcceptedTou(acceptedTou);


		// Persistt Account to database

		return super.addAccount(account);
	}
	@Override
	public Account deleteAccount(long accountId) throws PortalException {

		Account account = deleteAccount(accountId);

		return accountPersistence.remove(account);
	}

	@Override
	public Account updateAccount(long accountId, String firstname, String lastname, String emailAddress,
								 String accountName, String gender, Date birthday, String  password, int homePhone,
								 int mobilePhone, String address, String address2, String city, String statezip,
								 String securityQuestion, String securityAnswer, String acceptedTou) throws PortalException {

		// Get the Account by Id

		Account account = getAccount(accountId);

		// Set updated fields and modification date

		account.setAccountId(accountId);
		account.setFirstName(firstname);
		account.setLastName(lastname);
		account.setEmailAddress(emailAddress);
		account.setAccountName(accountName);
		account.setGender(gender);
		account.setBirthday(birthday);
		account.setPassword(password);
		account.setHomePhone(homePhone);
		account.setMobilePhone(mobilePhone);
		account.setAddress(address);
		account.setAddress2(address2);
		account.setCity(city);
		account.setState(statezip);
		account.setSecurityQuestion(securityQuestion);
		account.setSecurityAnswer(securityAnswer);
		account.setAcceptedTou(acceptedTou);

		return accountPersistence.update(account);
	}

}